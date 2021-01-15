package utez.edu.mx.empleados.servicios.generales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection crearConexion() throws SQLException {
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }catch (Exception e){
            System.out.println(e);
        }
        con = DriverManager.getConnection("jdbc:mysql://localhost/empleados?user=root&password=&allowPublicKeyRetrieval=true&useSSL=false");
        return  con;
    }

    public static void main(String[] args) throws SQLException {
        Conexion c = new Conexion();
        System.out.println(c.crearConexion());
    }
}
