
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class setUpCartDataBase {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:src/main/java/cart.db";


        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                try (Statement stmt = conn.createStatement()) {
                    String sql = "CREATE TABLE IF NOT EXISTS cart (" +
                            "uid INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "thing_id Integer NOT NULL UNIQUE," +
                            "amount Integer NOT NULL" +
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
