/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Usuario;
import java.util.List;
import model.IUsuarioModel;
import model.UsuarioModelImpl;



public class UsuarioServiceImpl implements IUsuarioService{
    
    IUsuarioModel modelo = new UsuarioModelImpl(); 

    @Override
    public void crearRegistro(Usuario usuario) {
        modelo.crearRegistro(usuario);
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
           modelo.actualizarRegistro(usuario);
    }

    @Override
    public List<Usuario> obtenerRegistros() {
        return modelo.obtenerRegistros();
    }

    @Override
    public Usuario obtenerRegistro(int codigo) {
        return modelo.obtenerRegistro(codigo);
    }

    @Override
    public void eliminarRegistro(int codigo) {
       modelo.eliminarRegistro(codigo);
    }
    
}
