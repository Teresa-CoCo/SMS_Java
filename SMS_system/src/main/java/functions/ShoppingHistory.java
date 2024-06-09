package functions;

import java.sql.*;

public class ShoppingHistory {
    public static void addPurchaseRecord(String username, int product_id, int quantity, double purchase_price) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\history.db";  // 数据库连接 URL

        String sql = "INSERT INTO purchase_history(username, product_id, quantity, purchase_price, purchase_date) VALUES(?,?,?,?, CURRENT_TIMESTAMP)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setInt(2, product_id);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, purchase_price);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("购物记录添加成功");
            } else {
                System.out.println("购物记录添加失败");
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void printUserShoppingHistory(String username) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\history.db";  // 数据库连接 URL

        String sql = "SELECT * FROM purchase_history WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("订单号: " + rs.getInt("record_id"));
                System.out.println("商品ID: " + rs.getInt("product_id"));
                System.out.println("数量: " + rs.getInt("amount"));
                System.out.println("付款金额: " + rs.getDouble("purchase_price"));
                System.out.println("付款日期: " + rs.getString("purchase_date"));
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void printRecordShoppingHistory(String record_id) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\history.db";  // 数据库连接 URL

        String sql = "SELECT * FROM purchase_history WHERE record_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, record_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("用户名: " + rs.getInt("username"));
                System.out.println("商品ID: " + rs.getInt("product_id"));
                System.out.println("数量: " + rs.getInt("amount"));
                System.out.println("付款价格: " + rs.getDouble("purchase_price"));
                System.out.println("付款时间: " + rs.getString("purchase_date"));
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static String printReturnShoppingHistory(String record_id) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\history.db";  // 数据库连接 URL

        String sql = "SELECT * FROM purchase_history WHERE record_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, record_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                return "用户名: " + rs.getInt("username")+"\n商品ID: " + rs.getInt("product_id")+"\n数量: " + rs.getInt("amount")+"\n付款价格: " + rs.getDouble("purchase_price")+"\n付款时间: " + rs.getString("purchase_date");
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public static int getHistoryCount(String username) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\history.db";  // 数据库连接 URL

        String sql = "SELECT * FROM purchase_history WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            int count = 0;
            while (rs.next()) {
                count++;
            }
            return count;
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
}
