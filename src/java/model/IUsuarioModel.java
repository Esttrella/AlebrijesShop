/*
 Autor: Leonel Alexis García Juárez
 Fecha de creación:11 de Marzo 2022
 Fecha de Actualización: 11 de Marzo de 2022
 Descripción: Interface de usuario
 */
package model;

import entity.Usuario;
import java.util.List;

public interface IUsuarioModel {

    public void crearRegistro(Usuario usuario);

    public void actualizarRegistro(Usuario usuario);

    public void eliminarRegistro(int idUsuario);

    public List<Usuario> ObtenerRegistros();

    public Usuario ObtenerRegistro(int idUsuario);

}
