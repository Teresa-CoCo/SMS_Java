package functions;

import java.sql.*;

public class registrator {
    public static void register(String username, String password, String fullname, String phone) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\user.db";  // 数据库连接 URL
        String sql = "INSERT INTO users(username, password, fullname, phone, is_admin) VALUES(?,?,?,?,0)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, fullname);
            pstmt.setString(4, phone);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("用户注册成功");

            } else {
                System.out.println("注册失败");

            }

        } catch (SQLException e) {
            System.out.println("数据库连接失败: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
