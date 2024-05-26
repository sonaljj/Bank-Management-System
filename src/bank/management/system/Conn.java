package bank.management.system;
import java.sql.*;

// Connection code
public class Conn {
    Connection connection;
    Statement statement;
    public Conn (){
        try
        {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3308/banksystem", "username", "password");
            statement = connection.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
