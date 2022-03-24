/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import service.IUsuarioService;
import service.UsuarioServiceImpl;

/**
 *
 * @author labtw04
 */
public class GuardarCrearUsuarioServlet extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IUsuarioService service = new UsuarioServiceImpl();
        
        Usuario usuario = new Usuario();
        
        //usuario.setCodigo(Integer.parseInt(request.getParameter("idUsuario")));
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setNombreusuario(request.getParameter("nombreusuario"));
        usuario.setContraseña(request.getParameter("contraseña"));
        
        service.crearRegistro(usuario);
        response.sendRedirect("ListarUsuarioServlet"); 
        
        
    }

    
}
