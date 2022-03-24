/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Usuario;
import java.util.List;

/**
 *
 * @author labtw04
 */
public interface IUsuarioService {
    public void crearRegistro(Usuario usuario);

    public void actualizarRegistro(Usuario usuario);

    public List<Usuario> obtenerRegistros();

    public Usuario obtenerRegistro(int codigo);

    public void eliminarRegistro(int codigo);
}
