package functions;

import java.sql.*;

public class ThingOperate {
    private static final String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\things.db";
    public static void addProduct(String thing_name, int amount, double money) {
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
    public static void deleteProduct(String thing_name) {
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
    public static void updateProductAmount(String thing_name, int newAmount) {
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
    public int getProductID(String thing_name) {
        String sql = "SELECT thing_id FROM products WHERE thing_name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, thing_name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("thing_id");
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }
    public static void getThingName(int thing_id) {
        String sql = "SELECT thing_name FROM products WHERE thing_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, thing_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getString("thing_name")+",");
            } else {
                System.out.println("没有找到指定的商品");
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
                System.out.println("商品ID: " + rs.getInt("thing_id"));
                System.out.println("商品名: " + rs.getString("thing_name"));
                System.out.println("数量: " + rs.getInt("amount"));
                System.out.println("价格: $" + rs.getDouble("money"));
            } else {
                System.out.println("没有找到指定的商品");
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static String findAndReturnProductByName(String thing_name) {
        String sql = "SELECT * FROM products WHERE thing_name = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, thing_name);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String returnThing ="商品ID: " + rs.getInt("thing_id")+ "商品名: " + rs.getString("thing_name") +"数量: " + rs.getInt("amount")+ "价格: $" + rs.getDouble("money");
                return returnThing;
            } else {
                System.out.println("没有找到指定的商品");
            }
        } catch (SQLException e) {
            System.out.println("数据库操作出错: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
