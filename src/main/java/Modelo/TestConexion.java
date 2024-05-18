package Modelo;

import Config.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {
    public static void main(String[] args) {
        // Instanciamos la clase de conexión
        Conexion conexion = new Conexion();
        
        // Declaramos los recursos de la base de datos
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establecemos la conexión con la base de datos
            con = conexion.Conexion();

            // Creamos un objeto Statement
            stmt = con.createStatement();

            // Ejecutamos una consulta SQL
            rs = stmt.executeQuery("SELECT * FROM empleado");

            // Procesamos los resultados de la consulta
            while (rs.next()) {
                int id = rs.getInt("IdEmpleado");
                String user = rs.getString("User");
                String dni = rs.getString("Dni");
                String nombres = rs.getString("Nombres");
                
                // Imprimimos los resultados
                System.out.println("ID: " + id + ", User: " + user + ", DNI: " + dni + ", Nombres: " + nombres);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerramos los recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
