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
    public static int stock = 0;

    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BD_Papeleria", "root", "JESUSdaniel444");
            st = con.createStatement();
            ps = con.prepareStatement("select * from usuarios");
            rs = st.executeQuery("select * from usuarios");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public int Buscar_id(String Nombre) {
        try {
            ps = con.prepareStatement("Select id from usuarios WHERE NOMBRE_CREDENCIAL = ?");
            ps.setString(1, Nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            System.out.println("hola que onda");
            System.err.print(e);
        }
        return 0;
    }
    
    public boolean Buscar_Codigo(Long codigo) {
        try {
            ps = con.prepareStatement("Select ID_PRODUCTO FROM PRODUCTOS WHERE ID_PRODUCTO = ?");
            ps.setLong(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("hola que onda");
            System.err.print(e);
        }
        return false;
    }
    
    public int Verificar_cantidad_producto (long codigo){
        try {
            ps = con.prepareStatement("CALL VERIFICAR_CANTIDAD (?)");
            ps.setLong(1, codigo);
            rs = ps.executeQuery();
            int cantidad = 0;
            while (rs.next()) {
                cantidad = rs.getInt("Stock");
                return cantidad;
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return -1;
    }
    
    public void Retirar_Cantidad(long codigo, int cantidad) {
        try {
            ps = con.prepareStatement("CALL RETIRAR_CANTIDAD (?,?)");
            ps.setLong(1, codigo);
            ps.setInt(2, cantidad);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    public void Regresar_Cantidad(long codigo, int cantidad) {
        try {
            ps = con.prepareStatement("CALL REGRESAR_CANTIDAD (?,?)");
            ps.setLong(1, codigo);
            ps.setInt(2, cantidad);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    public long Codigo_producto (String nombre) {
        try {
            ps = con.prepareStatement("CALL Nombre_producto_codigo (?)");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()){
                return rs.getLong("ID_PRODUCTO");
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return 0;
    }
    
    public int Insertar_venta (int id_usuario, double total) {
        try {
            ps = con.prepareStatement("CALL REGISTRAR_VENTA (?,?)");
            ps.setInt(1, id_usuario);
            ps.setDouble(2, total);
            ps.execute();
            rs = ps.getResultSet();
            if (rs.next()){
                int ultimoID = rs.getInt("UltimoID");
                return ultimoID;
            }   
        } catch (Exception e) {
            System.err.print(e);
        }
        return -1;
    }
    
    public void Insertar_especificacion_venta (int id_venta, long id_producto, int cantidad) {
        try {
            ps = con.prepareStatement("CALL REGISTRAR_ESPECIFICACIONES_VENTA (?,?,?)");
            ps.setInt(1, id_venta);
            ps.setLong(2, id_producto);
            ps.setInt(3, cantidad);
            ps.executeUpdate();
            //return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        //return false;
    }
    
    /*public boolean verificar_cantidad(String Nombre, int total) {
        try {
            ps = con.prepareStatement("Select cantidad from producto WHERE NOMBRE = ?");
            ps.setString(1, Nombre);
            rs = ps.executeQuery();
            int cantidad = 0;
            while (rs.next()) {
                cantidad = rs.getInt("cantidad");
            }
            stock = cantidad;
            if (total <= cantidad){
                int restante = cantidad-total;
                retirar_cantidad(Nombre, restante);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }
    
    public void retirar_cantidad(String Nombre, int total) {
        try {
            ps = con.prepareStatement("update producto set cantidad = ? WHERE NOMBRE = ?");
            ps.setInt(1, total);
            ps.setString(2, Nombre);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.print(e);
        }
    }*/

    public String[] Busca_Info(long codigo) {
        String arreglo[] = new String[3];
        try {
            ps = con.prepareStatement("CALL Info_especifica_producto (?) ");
            ps.setLong(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                arreglo[0] = rs.getString("NOMBRE");
                arreglo[2] = rs.getDouble("PRECIO") + "";
                return arreglo;
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return arreglo;
    }
    
    public void Activar_Usuario(int id) {
        try {
            ps = con.prepareStatement("CALL ACTIVAR_USUARIO (?)");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    //Buscar un usuario en la bd
    public String [] Inicio_Sesion(String Nombre, String Contraseña) {
        String DATOS_USUARIO [] = new String [3];
        try {
            ps = con.prepareStatement("CALL Buscar_Usuario (?,?)");
            ps.setString(1, Nombre);
            ps.setString(2, Contraseña);
            rs = ps.executeQuery();
            while (rs.next()) {
                DATOS_USUARIO [0] = rs.getInt("ID") + "";
                DATOS_USUARIO [1] = rs.getString("CARGO");
                DATOS_USUARIO [2] = rs.getString("NOMBRES");
                return DATOS_USUARIO;
            }
        } catch (Exception e) {
            System.out.println("hola");
            System.err.print(e);
        }
        return DATOS_USUARIO;
    }

    public boolean Ingresar_Usuario(String Nombres, String Apellidos, String Nombre_Credencial, String Contraseña, String cargo) {
        try {
            ps = con.prepareStatement("CALL INSERTAR_USUARIO(?,?,?,?,?,?)");
            ps.setString(1, Nombres);
            ps.setString(2, Apellidos);
            ps.setString(3, Nombre_Credencial);
            ps.setString(4, Contraseña);
            ps.setString(5, cargo);
            ps.setInt(6, 0);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }

    public boolean Ingresar_Producto(long codigo, String Nombre, String marca, int cantidad, double precio) {
        try {
            ps = con.prepareStatement("CALL INSERTAR_PRODUCTO (?,?,?,?,?)");
            ps.setLong(1, codigo);
            ps.setString(2, Nombre);
            ps.setString(3, marca);
            ps.setInt(4, cantidad);
            ps.setDouble(5, precio);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }

    public boolean Actualizar_Usuario(int ID, String nombre, String apellidos, String nombre_credencial, String contraseña, String cargo) {
        try {
            ps = con.prepareStatement("CALL ACTUALIZAR_USUARIO(?,?,?,?,?,?)");
            ps.setInt(1, ID);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, nombre_credencial);
            ps.setString(5, contraseña);
            ps.setString(6, cargo);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }

    public boolean Eliminar_Usuario(int ID) {
        try {
            ps = con.prepareStatement("CALL BORRAR_USUARIO (?)");
            ps.setInt(1, ID);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }

    public boolean Eliminar_Producto(long id) {
        try {
            ps = con.prepareStatement("CALL ELIMINAR_PRODUCTO(?)");
            ps.setLong(1, id);
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
            ps = con.prepareStatement("Select NOMBREs from usuarios");
            rs = ps.executeQuery();
            while (rs.next()) {
                Nombre.add(rs.getString("NOMBREs"));
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
            ps = con.prepareStatement("Select NOMBRE from productos order by NOMBRE ASC");
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

    public Vector Nombre_Proveedor() {
        Vector<String> Nombre = new Vector<String>();
        try {
            ps = con.prepareStatement("Select marca from proveedores order by marca ASC");
            rs = ps.executeQuery();
            while (rs.next()) {
                Nombre.add(rs.getString("marca"));
            }
            return Nombre;
        } catch (Exception e) {
            System.err.print(e);
        }
        return Nombre;
    }
    
    public DefaultTableModel Info_usuario(String nombre, DefaultTableModel modelo) {
        try {
            String arreglo[] = new String[6];
            ps = con.prepareStatement("CALL Buscar_Usuario_Especifico(?)");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                arreglo[0] = rs.getString("ID");
                arreglo[1] = rs.getString("NOMBRES");
                arreglo[2] = rs.getString("APELLIDOS");
                arreglo[3] = rs.getString("NOMBRE_CREDENCIAL");
                arreglo[4] = rs.getString("CONTRASEÑA_CREDENCIAL");
                arreglo[5] = rs.getString("CARGO");
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
            String arreglo[] = new String[6];
            rs = st.executeQuery("CALL INFO_GENERAL_USUARIO()");
            while (rs.next()) {
                arreglo[0] = rs.getString("ID");
                arreglo[1] = rs.getString("NOMBRES");
                arreglo[2] = rs.getString("APELLIDOS");
                arreglo[3] = rs.getString("NOMBRE_CREDENCIAL");
                arreglo[4] = rs.getString("CONTRASEÑA_CREDENCIAL");
                arreglo[5] = rs.getString("CARGO");
                modelo.addRow(arreglo);
            }
            return modelo;
        } catch (Exception e) {
            System.out.println("pendejo");
            System.err.print(e);
        }
        return modelo;
    }

    public DefaultTableModel Info_todos_inventario(DefaultTableModel modelo) {
        try {
            String arreglo[] = new String[5];
            rs = st.executeQuery("CALL Info_general_inventario()");
            while (rs.next()) {
                arreglo[0] = rs.getString("Id_producto");
                arreglo[1] = rs.getString("Nombre");
                arreglo[2] = rs.getString("Marca");
                arreglo[3] = rs.getInt("Stock") + "";
                arreglo[4] = rs.getInt("Precio") + "";
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
            String arreglo[] = new String[5];
            ps = con.prepareStatement("CALL Info_especifica_inventario(?)");
            ps.setString(1, Nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                arreglo[0] = rs.getString("Id_producto");
                arreglo[1] = rs.getString("Nombre");
                arreglo[2] = rs.getString("Marca");
                arreglo[3] = rs.getInt("Stock") + "";
                arreglo[4] = rs.getInt("Precio") + "";
                modelo.addRow(arreglo);
            }
            return modelo;
        } catch (Exception e) {
            System.err.print(e);
        }
        return modelo;
    }
    
    public DefaultTableModel Info_especifica_producto(long codigo, DefaultTableModel modelo) {
        try {
            String arreglo[] = new String[2];
            ps = con.prepareStatement("CALL Info_especifica_producto(?)");
            ps.setLong(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                arreglo[0] = rs.getString("Nombre");
                arreglo[1] = rs.getInt("Precio") + "";
                modelo.addRow(arreglo);
            }
            return modelo;
        } catch (Exception e) {
            System.err.print(e);
        }
        return modelo;
    }

    public boolean Actualizar_Producto(long Id_P, String Nombre, String Marca, int Cantidad, double Precio) {
        try {
            ps = con.prepareStatement("CALL ACTUALIZAR_PRODUCTO (?,?,?,?,?)");
            ps.setLong(1,Id_P);
            ps.setString(2, Nombre);
            ps.setString(3, Marca);
            ps.setInt(4, Cantidad);
            ps.setDouble(5, Precio);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.print(e);
        }
        return false;
    }
}
