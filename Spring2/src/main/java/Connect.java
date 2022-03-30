import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connectToDatabase() throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/spring_crud_sql";
        String username = "root";
        String password = "topsecretpassword";
        return DriverManager.getConnection(connectionUrl, username, password);
    }
}
