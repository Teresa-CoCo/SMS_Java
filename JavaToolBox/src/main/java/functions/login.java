package functions;

import java.sql.*;

public class login {
    public static boolean login(String username, String password) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\user.db";  // 数据库连接 URL

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

}
