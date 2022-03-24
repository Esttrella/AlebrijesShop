
package model;

import entity.Usuario;
import java.util.List;

/* 
    
    Author : Estrella
    Fecha creacion : 08 marzo 2022
    Fecha Actualizacion : 09 marzo 2022
    Descripcion: interface

*/
public interface IUsuarioModel {
    public  void crearRegistro(Usuario usuario);
    
    public  void actualizarRegistro(Usuario usuario);
    
    public Usuario obtenerRegistro(int codigo) ;
    
    public  List <Usuario> obtenerRegistros();
    
    public  void eliminarRegistro(int codigo);
    
}
