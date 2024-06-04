
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class setUpThingsDataBase {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\prime\\IdeaProjects\\untitled\\src\\main\\java\\things.db";


        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                try (Statement stmt = conn.createStatement()) {
                    // 执行 SQL 语句
                    String sql ="CREATE TABLE IF NOT EXISTS shopping_history (" +
                            "    record_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "    username TEXT NOT NULL," +
                            "    product_id INTEGER NOT NULL," +
                            "    quantity INTEGER NOT NULL," +
                            "    purchase_price REAL NOT NULL," +
                            "    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
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
