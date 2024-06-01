package functions;

import java.sql.*;

public class login {
    private static final String url = "jdbc:sqlite:src/main/java/user.db";
    public static boolean login(String username, String password) {
          // 数据库连接 URL

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        //引入两个占位符，在后面填充

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
    public static Integer getID(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

}
