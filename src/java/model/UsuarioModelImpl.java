package model;

import entity.Usuario;
import java.util.List;
import java.sql.*;
import db.*;
import entity.Producto;
import java.util.ArrayList;

/* 
    
    Author : Estrella
    Fecha creacion : 09 marzo 2022
    Fecha Actualizacion : 14 marzo 2022
    Descripcion: Clase que implementa la interface

 */
public class UsuarioModelImpl implements IUsuarioModel {

    private Conexion conexion;
    private Connection connection;

    @Override
    public void crearRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();
            String sql = "insert into usuario(nombre,sexo,edad,nombre_usuario,contraseña) values(?,?,?,?,?);";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getSexo());
            ps.setInt(3, usuario.getEdad());
            ps.setString(4, usuario.getNombre_usuario());
            ps.setString(5, usuario.getContraseña());
            ps.executeUpdate();
            System.out.println("Se agrego correctamente");
        } catch (Exception ex) {

        }

    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();
            String sql = "Update usuario set  nombre=?,sexo=?, edad=?,nombre_usuario=?, contraseña=? where codigo=" + usuario.getCodigo() + ";";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getSexo());
            ps.setInt(3, usuario.getEdad());
            ps.setString(4, usuario.getNombre_usuario());
            ps.setString(5, usuario.getContraseña());
            ps.executeUpdate();
            System.out.println("Actualizado correctamente");
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    
     public Usuario obtenerRegistro(int codigo) {
        Usuario usuarios = null;
        try {
            ResultSet resultSet;
            usuarios = new Usuario();
            conexion = new Conexion();
            conexion.conectar();
           connection = conexion.getConexion();
            String sql = "SELECT * FROM usuario WHERE codigo="+codigo;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                //ps.setInt(1, codigo);
                resultSet = ps.executeQuery();                
                while (resultSet.next()) {
                    usuarios.setNombre(resultSet.getString(2));
                    usuarios.setEdad(resultSet.getInt(3));
                    usuarios.setSexo(resultSet.getString(4));
                    usuarios.setNombre_usuario(resultSet.getString(5));
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
    public List<Usuario> obtenerRegistros() {
        List<Usuario> lista = null;
        try {
            ResultSet rs;
            lista = new ArrayList<>();
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();

            String sql = "select *from Usuario;";
            try ( PreparedStatement ps = connection.prepareStatement(sql)) {
                rs = ps.executeQuery();

                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setCodigo(rs.getString(1));
                    user.setNombre(rs.getString(2));
                    user.setSexo(rs.getString(3));
                    user.setEdad(rs.getInt(4));
                    user.setNombre_usuario(rs.getString(5));
                    user.setContraseña(rs.getString(6));
                    lista.add(user);
                }
            }

            conexion.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public void eliminarRegistro(int cod) {
        try {
            conexion = new Conexion();
            conexion.conectar();
            connection = conexion.getConexion();
            String sql = "delete from usuario where codigo=" + cod;
            Statement ps = connection.createStatement();

            ps.executeUpdate(sql);
            System.out.println("Eliminado correctamente");
        } catch (Exception ex) {

        }

    }

    public static void main(String[] args) {
        UsuarioModelImpl usr = new UsuarioModelImpl();
        Usuario user = new Usuario();
        
        user.setNombre("Estrellaaa");
        user.setSexo("M");
        user.setEdad(21);
        user.setNombre_usuario("Est1234");
        user.setContraseña("12345");
        usr.crearRegistro(user);
//        user.setCodigo("1");
//        user.setSexo("M");
        usr.actualizarRegistro(user);

//        usr.eliminarRegistro("1");
        List<Usuario> lista = new ArrayList<Usuario>();
        lista = usr.obtenerRegistros();

        for (Usuario us : lista) {
            System.out.println(us.getCodigo());
            System.out.println(us.getNombre());
            System.out.println(us.getSexo());
            System.out.println(us.getEdad());
            System.out.println(us.getNombre_usuario());
            System.out.println(us.getContraseña());
        }

    }

}
