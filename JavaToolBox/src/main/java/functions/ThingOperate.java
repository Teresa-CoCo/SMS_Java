package functions;

import java.sql.*;

public class ThingOperate {
    private static final String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\things.db";
    public void addProduct(String thing_name, int amount, double money) {
        String sql = "INSERT INTO products(thing_name, amount, money) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, thing_name);
            pstmt.setInt(2, amount);
            pstmt.setDouble(3, money);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("商品已成功添加到数据库");
            } else {
                System.out.println("添加商品失败");
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void deleteProduct(String thing_name) {
        String sql = "DELETE FROM products WHERE thing_name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, thing_name);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("商品已从数据库中删除");
            } else {
                System.out.println("删除商品失败，可能找不到指定商品");
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void updateProductAmount(String thing_name, int newAmount) {
        String sql = "UPDATE products SET amount = ? WHERE thing_name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newAmount);
            pstmt.setString(2, thing_name);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("商品库存已更新");
            } else {
                System.out.println("更新库存失败，可能找不到指定商品");
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void findAndPrintProductByName(String thing_name) {
        String sql = "SELECT * FROM products WHERE thing_name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, thing_name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Thing ID: " + rs.getInt("thing_id"));
                System.out.println("Thing Name: " + rs.getString("thing_name"));
                System.out.println("Amount: " + rs.getInt("amount"));
                System.out.println("Price: $" + rs.getDouble("money"));
            } else {
                System.out.println("没有找到指定的商品");
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }


}
