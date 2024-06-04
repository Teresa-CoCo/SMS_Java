package functions;

import java.sql.*;

public class isAdmin {
    public static boolean isAdmin(String username) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\user.db";  // 数据库连接 URL

        String sql = "SELECT * FROM users WHERE username = ? AND is_admin = 1";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
