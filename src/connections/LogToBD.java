package connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogToBD {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Connect cn = new Connect();
    
    public LoginData login(String user, String pass) {
        LoginData ld = new LoginData();
        String query = 
                "select * from usuario where nombre = ? and contrasenia = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                ld.setUsername(rs.getString("nombre"));
                ld.setPassword(rs.getString("contrasenia"));
            } else {
                System.out.println("usuario o contraseña incorrectos");
            }
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
        return ld;
    }
}
