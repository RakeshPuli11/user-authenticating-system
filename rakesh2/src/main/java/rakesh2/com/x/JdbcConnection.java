package rakesh2.com.x;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
    public static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/meme", "root", "MySql@2157");
        return con;
    }
}
