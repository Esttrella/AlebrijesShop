/*
 Autor: Leonel Alexis García Juárez
 Fecha de creación:11 de Marzo 2022
 Fecha de Actualización: 15 de Marzo de 2022
 Descripción: Clase implementadora
 */
package model;

import db.Conexion;
import entity.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModelImpl implements IUsuarioModel {

    private Conexion conexion;
    private Connection connection;

    @Override
    public void crearRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();

            connection = conexion.getConection();
            String sql = "Insert into usuarios (codigo,nombre,sexo,edad, nombreusuario, contraseña) values(?,?, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, usuario.getCodigo());

            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getSexo());
            ps.setInt(4, usuario.getEdad());
            ps.setString(5, usuario.getNombreUsuario());
            ps.setString(6, usuario.getContraseña());
            ps.executeUpdate();
            System.out.println("Correcto");
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConection();
            String sql = "Update usuarios set NombreUsuario=?, contraseña=?, nombre=?, sexo=?, edad=? where codigo=" + usuario.getCodigo() + ";";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getSexo());
            ps.setInt(5, usuario.getEdad());
            ps.executeUpdate();
            System.out.println("Correcto");
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(int idUsuario) {
        try {
            conexion = new Conexion();
            conexion.Conectar();

            connection = conexion.getConection();
            String sql = "Delete from usuarios where codigo=" + idUsuario + ";";
            Statement s = connection.createStatement();
            int rs = s.executeUpdate(sql);
            System.out.println("Correcto");
            conexion.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Usuario> ObtenerRegistros() {
        List<Usuario> lista = null;
        try {
            ResultSet rs;
            lista = new ArrayList<>();
            conexion = new Conexion();
            conexion.Conectar();
            connection = conexion.getConection();
            String sql = "select *from usuarios;";
            try ( PreparedStatement ps = connection.prepareStatement(sql)) {
                rs = ps.executeQuery();
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setCodigo(rs.getInt(1));
                    user.setNombre(rs.getString(2));
                    user.setSexo(rs.getString(3));
                    user.setEdad(rs.getInt(4));
                    user.setNombreUsuario(rs.getString(5));
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
    public Usuario ObtenerRegistro(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) {

//        Usuario usr = new Usuario();
//        u.setCodigo(2);
//        u.setNombreUsuario("leoxis");
//        u.setContraseña("0101");
//        u.setNombre("Leonel");
//        u.setSexo("Masculino");
//        u.setEdad(20);
        UsuarioModelImpl m = new UsuarioModelImpl();
//        m.crearRegistro(u);
//        Usuario a = new Usuario();
//        a.setNombreUsuario("aaaaaaaa");
//        a.setContraseña("0101");
//        a.setNombre("Alex");
//        a.setSexo("Masculino");
//        a.setEdad(20);
//        a.setCodigo(11);
List<Usuario> lista = new ArrayList<Usuario>();
        lista = m.ObtenerRegistros();
        for (Usuario us : lista) {
            System.out.println(us.getCodigo());
            System.out.println(us.getNombre());
            System.out.println(us.getSexo());
            System.out.println(us.getEdad());
            System.out.println(us.getNombreUsuario());
            System.out.println(us.getContraseña());
        }
}
}