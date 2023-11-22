package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    
    public Connection getConnection() {
        Connection con;
        try {
            String db = "jdbc:mysql://localhost:3306/mypaper";
            con = DriverManager.getConnection(db,"root","1234");
            return con;
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return null;
    }
}
