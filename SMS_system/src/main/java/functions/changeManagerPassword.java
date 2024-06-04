package functions;//用于用户登陆后重置密码，或超级管理员修改其他用户密码
import java.sql.*;
public class changeManagerPassword {
    public static void changePassword(String username ,String newPassword, boolean isAdmin){
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\user.db";  // 数据库连接 URL
        String sql = "UPDATE users SET password = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);
            if (isAdmin) {
                int affectedRows = pstmt.executeUpdate(); // 执行更新

                if (affectedRows > 0) {
                    System.out.println("密码更新成功");
                } else {
                    System.out.println("未找到用户或密码未更改");
                }
            }
            else{
                System.out.println("当前用户不是管理员，无权修改密码");
            }
        } catch (Exception e) {
            System.out.println("数据库操作出错");
            e.printStackTrace();
        }
    }
}
