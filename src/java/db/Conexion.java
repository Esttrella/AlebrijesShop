/*
 Autor: Leonel Alexis García Juárez
 Fecha de creación:07 de Marzo 2022
 Fecha de Actualización: 08 de Marzo de 2022
 Descripción: Ejemplifica el la clase usuario 
 */

package db;

import java.sql.Connection;

public class Conexion {
    final private Connection connection;
    final private String url;
    final private String user;
    final private String pwd;


    public Conexion(Connection connection, String url, String user, String pwd) {
        this.connection = connection;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
    }
    
    public Connection Conectar() {
        return connection;
    }

    
    public Connection Desconectar() {
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
    }
    
    public static void main(String[] args) {
    
    }
    
}
