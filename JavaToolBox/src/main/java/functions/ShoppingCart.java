package functions;

import java.sql.*;

public class ShoppingCart {
    public final static String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\cart.db";  // 数据库连接 URL

    public static void addToCart(int uid, int thing_id, int quantity) {
        String sql = "INSERT INTO shopping_cart(uid, thing_id, amount) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, uid);
            pstmt.setInt(2, thing_id);
            pstmt.setInt(3, quantity);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("商品已添加到购物车");
            } else {
                System.out.println("商品添加失败");
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void removeFromCart(int uid, int thing_id) {
        String sql = "DELETE FROM shopping_cart WHERE uid = ? AND thing_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, uid);
            pstmt.setInt(2, thing_id);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("商品已从购物车中删除");
            } else {
                System.out.println("删除商品失败");
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void updateCartItem(int uid, int thing_id, int newQuantity) {
        String sql = "UPDATE shopping_cart SET amount = ? WHERE uid = ? AND thing_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, uid);
            pstmt.setInt(3, thing_id);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("购物车中的商品数量已更新");
            } else {
                System.out.println("更新商品数量失败");
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void viewCart(int uid) {
        String sql = "SELECT thing_id, amount FROM shopping_cart WHERE uid = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, uid);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int thing_id = rs.getInt("thing_id");
                    int amount = rs.getInt("amount");
                    System.out.println("商品名称: ");
                    ThingOperate.getThingName(thing_id);
                    System.out.println("商品 ID: " + thing_id + ", 数量: " + amount);
                }
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static int getCartAmount(int uid, int thing_id) {
        String sql = "SELECT amount FROM shopping_cart WHERE uid = ? AND thing_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, uid);
            pstmt.setInt(2, thing_id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("amount");
                } else {
                    return 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败或者操作出错: " + e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }
}
