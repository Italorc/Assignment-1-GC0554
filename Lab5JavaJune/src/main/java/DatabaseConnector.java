import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/testDB";
    private static final String USER ="root";
    private static final String PASS = "Secuela.122";

    public Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
