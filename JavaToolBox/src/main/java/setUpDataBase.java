
import org.sqlite.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class setUpDataBase {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\user.db";


        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                try (Statement stmt = conn.createStatement()) {
                    // 执行 SQL 语句
                    String sql = "CREATE TABLE IF NOT EXISTS users (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "username TEXT NOT NULL UNIQUE," +
                            "password TEXT NOT NULL," +
                            "fullname TEXT NOT NULL," +
                            "phone TEXT," +
                            "is_admin INTEGER DEFAULT 0 CHECK (is_admin IN (0, 1))" +
                            ");";
                    stmt.execute(sql);
                    System.out.println("表已成功创建");
                }
            }
        } catch (Exception e) {
            System.out.println("数据库操作出错");
            e.printStackTrace();
        }
    }
}
