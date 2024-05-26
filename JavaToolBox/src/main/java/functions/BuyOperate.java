package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyOperate {
    private String url1 = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\things.db";  // 商品数据库连接 URL
    private String url2 = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\history.db";  // 历史记录数据库连接 URL
    private String url3 = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\cart.db";  // 购物车数据库连接 URL

    public void checkoutCartItem(int uid, int thing_id, int quantity) {
        try (Connection conn = DriverManager.getConnection(url1);
             Connection connhis = DriverManager.getConnection(url2);
             Connection conncart = DriverManager.getConnection(url3)) {
            conn.setAutoCommit(false);  // 开始事务

            // 1. 检查库存是否足够
            try (PreparedStatement pstmt = conn.prepareStatement("SELECT amount, money FROM products WHERE thing_id = ?")) {
                pstmt.setInt(1, thing_id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int stock = rs.getInt("amount");
                        double price = rs.getDouble("money");
                        if (stock >= quantity) {
                            // 2. 更新库存
                            updateProductStock(conn, thing_id, quantity);
                            // 3. 添加到购买历史记录
                            addToPurchaseHistory(connhis, uid, thing_id, quantity, price);
                            // 4. 从购物车中移除已结算的商品
                            removeFromCart(conncart, uid, thing_id, quantity);
                            // 计算总金额
                            double totalCost = price * quantity;
                            // 提交事务
                            conn.commit();
                            System.out.println("结算成功，总金额: $" + totalCost);
                        } else {
                            System.out.println("库存不足，无法结算");
                            conn.rollback();  // 库存不足，回滚事务
                        }
                    } else {
                        System.out.println("商品不存在");
                        conn.rollback();  // 商品不存在，回滚事务
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void updateProductStock(Connection conn, int thing_id, int quantity) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("UPDATE products SET amount = amount - ? WHERE thing_id = ?")) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, thing_id);
            pstmt.executeUpdate();
        }
    }

    private void addToPurchaseHistory(Connection conn, int uid, int thing_id, int quantity, double price) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO purchase_history(uid, thing_id, amount, purchase_price) VALUES(?,?,?,?)")) {
            pstmt.setInt(1, uid);
            pstmt.setInt(2, thing_id);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, price);
            pstmt.executeUpdate();
        }
    }

    private void removeFromCart(Connection conn, int uid, int thing_id, int quantity) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement("DELETE FROM shopping_cart WHERE uid = ? AND thing_id = ? AND amount = ?")) {
            pstmt.setInt(1, uid);
            pstmt.setInt(2, thing_id);
            pstmt.setInt(3, quantity);
            pstmt.executeUpdate();
        }
    }
}
