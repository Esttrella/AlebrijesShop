/*
 Autor: Leonel Alexis García Juárez
 Fecha de creación:16 de Marzo 2022
 Fecha de Actualización: 16 de Marzo de 2022
 Descripción: clase implementadora de service
 */
package service;

import entity.Usuario;
import java.util.List;
import model.IUsuarioModel;
import model.UsuarioModelImpl;

public class UsuarioServiceImpl implements IUsuarioService{

    IUsuarioModel modelo=new UsuarioModelImpl();
    
    @Override
    public void crearRegistro(Usuario usuario) {
        modelo.crearRegistro(usuario);
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        modelo.actualizarRegistro(usuario);
    }

    @Override
    public void eliminarRegistro(int idUsuario) {
        modelo.eliminarRegistro(idUsuario);
    }

    @Override
    public List<Usuario> ObtenerRegistros() {
        return modelo.ObtenerRegistros();
    }

    @Override
    public Usuario ObtenerRegistro(int idUsuario) {
        return modelo.ObtenerRegistro(idUsuario);
    }
}
