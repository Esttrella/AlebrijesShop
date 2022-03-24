package model;


/* 
    
    Author : Estrella
    Fecha creacion : 09 marzo 2022
    Fecha Actualizacion : 14 marzo 2022
    Descripcion: Clase que implementa la interface

 */
import db.Conexion;
import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author labtw04
 */
public class UsuarioModelImpl implements IUsuarioModel {

    Conexion c = new Conexion();
    private Conexion conexion;
    private Connection connection;

    
    @Override
    public void crearRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();
            String sql = "INSERT INTO usuario(nombre,edad,sexo,nombreusuario,contraseña) values(?,?,?,?,?)";
            //String sql = "INSERT INTO usuarios(nombre,sexo,edad) values(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
           
            
            ps.setString(1, usuario.getNombre());
            ps.setInt(2, usuario.getEdad());
            ps.setString(3, usuario.getSexo());
            ps.setString(4, usuario.getNombreusuario());
            ps.setString(5, usuario.getContraseña());
            ps.executeUpdate();
            System.out.println("Datos insertados correctamente");
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    
    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();
            String sql = "UPDATE usuario SET nombre=?,edad=?,sexo=?,nombreusuario=?,contraseña=? WHERE codigo=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                
                statement.setString(1, usuario.getNombre());
                statement.setInt(2, usuario.getEdad());
                statement.setString(3, usuario.getSexo());
                statement.setString(4, usuario.getNombreusuario());
                statement.setString(5, usuario.getContraseña());   
                statement.setInt(6, usuario.getCodigo());
                System.out.println(""+usuario.getContraseña());
                System.out.println("usuario "+usuario.getCodigo());
                statement.executeUpdate();
                System.out.println("Datos actualizados correctamente");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al actualizar el registro " + e.getMessage());
        }
    }

    
    @Override
    public List<Usuario> obtenerRegistros() {
        List<Usuario> users = new ArrayList<Usuario>();
        try {
            ResultSet resultSet;
            
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();
            String sql = "SELECT * FROM usuario";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    Usuario usuarios = new Usuario();
                    usuarios.setCodigo(resultSet.getInt(1));
                    usuarios.setNombre(resultSet.getString(2));
                    usuarios.setEdad(resultSet.getInt(3));
                    usuarios.setSexo(resultSet.getString(4));
                    usuarios.setNombreusuario(resultSet.getString(5));
                    usuarios.setContraseña(resultSet.getString(6));
                    users.add(usuarios);
                    System.out.println("Datos obtenidos correcatmente");
                }
                conexion.desconectar();
            }
        } catch (Exception e) {
            System.out.println("Error al obtener registros " + e.getMessage());
        }
        return users;
    }

    
    @Override
    public Usuario obtenerRegistro(int codigo) {
        Usuario usuarios = null;
        try {
            ResultSet resultSet;
            usuarios = new Usuario();
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();
            String sql = "SELECT * FROM usuario WHERE codigo=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, codigo);
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    usuarios.setCodigo(resultSet.getInt(1));
                    usuarios.setNombre(resultSet.getString(2));
                    usuarios.setEdad(resultSet.getInt(3));
                    usuarios.setSexo(resultSet.getString(4));
                    usuarios.setNombreusuario(resultSet.getString(5));
                    usuarios.setContraseña(resultSet.getString(6));
                    
                    System.out.println("Datos del registro obtenidos con exito");
                }
            }
            conexion.desconectar();

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return usuarios;
    }

    
    @Override
    public void eliminarRegistro(int codigo) {
        try {
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();
            String sql = "DELETE FROM usuario WHERE codigo=?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, codigo);
                System.out.println("Datos eliminados correctamente");
                ps.executeUpdate();
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("Error al eliminar el registo " + e.getMessage());
        }
    }

    
    public static void main(String[] args) throws SQLException {
        UsuarioModelImpl user = new UsuarioModelImpl();
        Usuario usuario = new Usuario();
        
        usuario.setCodigo(20);
        usuario.setNombre("iiii");
        usuario.setEdad(20);
        usuario.setSexo("M");
        usuario.setNombreusuario("ooo");
        usuario.setContraseña("eee");
        
        //user.crearRegistro(usuario);

        user.actualizarRegistro(usuario);
        
         //user.eliminarRegistro(3);
        
        //user.obtenerRegistros();
        
        //user.obtenerRegistro(2);
    }

}
