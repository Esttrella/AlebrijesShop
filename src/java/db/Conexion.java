/*
 Autor: Leonel Alexis García Juárez
 Fecha de creación:07 de Marzo 2022
 Fecha de Actualización: 08 de Marzo de 2022
 Descripción: Ejemplifica el la clase usuario 
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    Connection conection;
    final private String url;
    final private String user;
    final private String pwd;
    final private String bd = "dbAlebrijes";
    Connection conexion;
    public Conexion() {
        this.url = "localhost";
        this.user = "postgres";
        this.pwd = "leoxis";
    }

    public Connection Conectar() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://" + url + "/" + bd, user, pwd);
            System.out.println("conexión establecida");

        } catch (Exception ex) {

            System.out.println("Error al conectar:" + ex.getMessage());
        }
        return conexion;
    }

    public void desconectar() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }


public Connection getConection() {
        return conexion;
    }

    public static void consultar(Connection con) {
        try {
            Statement s = con.createStatement();
            String sql = "select *from producto";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getObject("nombre"));
                System.out.println(rs.getObject("precio"));
            }
        } catch (Exception ex) {

        }
    }

    public static void main(String[] args) throws SQLException {
        String bd = "dbAlebrijes";
        Conexion c = new Conexion();
        c.Conectar();

        
    }

}
