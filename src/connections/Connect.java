package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Connect {

    static Connection con;
    static PreparedStatement ps;
    static Statement st;
    static ResultSet rs;

    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypaper", "root", "1234");
            st = con.createStatement();
            ps = con.prepareStatement("select * from usuario");
            rs = st.executeQuery("select * from usuario");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public int Buscar_id(String Nombre) {
        try {
            ps = con.prepareStatement("Select id from usuario WHERE NOMBRE = ?");
            ps.setString(1, Nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return 0;
    }
    
    public boolean Inicio_Sesion(String Nombre, String Contraseña) {
        try {
            ps = con.prepareStatement("Select * from usuario where NOMBRE = ? and CONTRASEÑA = ?");
            ps.setString(1, Nombre);
            ps.setString(2, Contraseña);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }

    public boolean Ingresar_Usuario(String Nombre, String Contraseña) {
        try {
            ps = con.prepareStatement("INSERT INTO USUARIO VALUES (?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, Nombre);
            ps.setString(3, Contraseña);
            ps.setInt(4, 0);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }
    
    public boolean Ingresar_Producto(String Nombre, int id_proveedor, int cantidad, double precio) {
        try {
            ps = con.prepareStatement("INSERT INTO PRODUCTO VALUES (?,?,?,?,?)");
            ps.setInt(1, 0);
            ps.setString(2, Nombre);
            ps.setInt(3, id_proveedor);
            ps.setInt(4, cantidad);
            ps.setDouble(5, precio);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }
    
    public boolean Actualizar_Usuario(String Nombre, String Contraseña, int ID) {
        try {
            ps = con.prepareStatement("UPDATE USUARIO SET NOMBRE = ?, CONTRASEÑA = ? WHERE ID = ?");
            ps.setString(1, Nombre);
            ps.setString(2, Contraseña);
            ps.setInt(3, ID);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }
    
    public boolean Eliminar_Usuario(int ID) {
        try {
            ps = con.prepareStatement("DELETE FROM USUARIO WHERE ID = ?");
            ps.setInt(1, ID);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }
    
    public boolean Eliminar_Producto(String Nombre) {
        try {
            ps = con.prepareStatement("DELETE FROM PRODUCTO WHERE Nombre = ?");
            ps.setString(1, Nombre);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }

    public Vector Nombre_usuarios() {
        Vector<String> Nombre = new Vector<String>();
        try {
            ps = con.prepareStatement("Select NOMBRE from usuario");
            rs = ps.executeQuery();
            while (rs.next()) {
                Nombre.add(rs.getString("NOMBRE"));
            }
            return Nombre;
        } catch (Exception e) {
            System.err.print(e);
        }
        return Nombre;
    }

    public Vector Nombre_producto() {
        Vector<String> Nombre = new Vector<String>();
        try {
            ps = con.prepareStatement("Select NOMBRE from producto");
            rs = ps.executeQuery();
            while (rs.next()) {
                Nombre.add(rs.getString("NOMBRE"));
            }
            return Nombre;
        } catch (Exception e) {
            System.err.print(e);
        }
        return Nombre;
    }
    
    public DefaultTableModel Info_usuario(String Nombre, DefaultTableModel modelo) {
        try {
            String arreglo[] = new String[2];
            ps = con.prepareStatement("Select NOMBRE, CONTRASEÑA from usuario WHERE NOMBRE = ?");
            ps.setString(1, Nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                arreglo[0] = rs.getString("NOMBRE");
                arreglo[1] = rs.getString("CONTRASEÑA");
                modelo.addRow(arreglo);
            }
            return modelo;
        } catch (Exception e) {
            System.err.print(e);
        }
        return modelo;
    }
    
    public DefaultTableModel Info_todos_usuarios(DefaultTableModel modelo) {
        try {
            String arreglo[] = new String[2];
            rs = st.executeQuery("Select NOMBRE, CONTRASEÑA from usuario");
            while (rs.next()) {
                arreglo[0] = rs.getString("NOMBRE");
                arreglo[1] = rs.getString("CONTRASEÑA");
                modelo.addRow(arreglo);
            }
            return modelo;
        } catch (Exception e) {
            System.err.print(e);
        }
        return modelo;
    }
    
    public DefaultTableModel Info_todos_inventario(DefaultTableModel modelo) {
        try {
            String arreglo[] = new String[4];
            rs = st.executeQuery("Select NOMBRE, ID_PROVEEDOR, CANTIDAD, PRECIO from producto");
            while (rs.next()) {
                arreglo[0] = rs.getString("NOMBRE");
                arreglo[1] = rs.getInt("ID_PROVEEDOR") + "";
                arreglo[2] = rs.getInt("CANTIDAD") + "";
                arreglo[3] = rs.getInt("PRECIO") + "";
                modelo.addRow(arreglo);
            }
            return modelo;
        } catch (Exception e) {
            System.err.print(e);
        }
        return modelo;
    }
    
    
    public DefaultTableModel Info_inventario(String Nombre, DefaultTableModel modelo) {
        try {
            String arreglo[] = new String[4];
            ps = con.prepareStatement("Select NOMBRE, ID_PROVEEDOR, CANTIDAD, PRECIO from PRODUCTO WHERE NOMBRE = ?");
            ps.setString(1, Nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                arreglo[0] = rs.getString("NOMBRE");
                arreglo[1] = rs.getInt("ID_PROVEEDOR") + "";
                arreglo[2] = rs.getInt("CANTIDAD") + "";
                arreglo[3] = rs.getInt("PRECIO") + "";
                modelo.addRow(arreglo);
            }
            return modelo;
        } catch (Exception e) {
            System.err.print(e);
        }
        return modelo;
    }
    public boolean Actualizar_Producto(String Nombre, int ID_Proveedor, int Cantidad, double Precio) {
        try {
            ps = con.prepareStatement("UPDATE PRODUCTO SET NOMBRE = ?, ID_PROVEEDOR = ?, CANTIDAD = ?, PRECIO = ? WHERE NOMBRE = ?");
            ps.setString(1, Nombre);
            ps.setInt(2, ID_Proveedor);
            ps.setInt(3, Cantidad);
            ps.setDouble(4, Precio);
            ps.setString(5, Nombre);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }
}
