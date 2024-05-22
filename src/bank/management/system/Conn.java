package bank.management.system;
import java.sql.*;

// Connection code
public class Conn {
    Connection connection;
    Statement statement;
    public Conn (){
        try
        {
            // Retrieve database connection parameters from environment variables
            String url = System.getenv("DB_URL");
            String username = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3308/banksystem", "root", "mysql@28");
            statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
