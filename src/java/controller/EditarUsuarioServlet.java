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
import service.IUsuarioService.*;

/**
 *
 * @author labtw04
 */
public class EditarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        IUsuarioService service = new UsuarioServiceImpl();
        Usuario usuario = new Usuario();
        usuario = service.obtenerRegistro(idUsuario);

        out.println("<link rel ='stylesheet' href='" + request.getContextPath() + "/resources/css/estilo1.css'>");
        out.println("<div class=\"container\" style=\"max-width: 850px; min-width: 600px;\">");
        out.println("<div class=\"card\">");
        out.println("<h2 class=\"card-header text-center\">Registro Usuario</h2>");
        out.println("<div class=\"card-body\">");

        out.println("<form action='GuardarEditarUsuarioServlet' method='Get'>");

        out.println("<div class=\"form-group\">");
        out.println("<legend>Datos del usuario</legend>");
        
        out.println("<input type='hidden' name='idUsuario' value='" + usuario.getCodigo() + "'>");
        
        out.println("<label>Nombre</label>");
        out.println("<input type='text' name='nombre' value='" + usuario.getNombre() + "'>");
        out.println("<label>Nombre Usuario</label>");
        out.println("<input type='text' name='nombreusuario' value='" + usuario.getNombreusuario() + "'>");
        out.println("<label for=\"Pass1\">Contraseña:</label>");
        out.println("<input type='password' class=\"form-control\" name='contraseña' value='" + usuario.getContraseña() + "'>");
        out.println("  </div>");

        out.println("<div class=\"form-group\">");
        out.println("<legend>Datos Personales</legend>");
        out.println("<label>Sexo</label>");
        out.println("<input type='text' name='sexo' value='" + usuario.getSexo() + "'>");
        out.println("<label for=\"tentacles\">Edad:</label>");
        out.println("<input type='text' name='edad' value='" + usuario.getEdad() + "'>");
        out.println("</div>");
        //out.println("<input type=\"submit\" class=\"btn btn-success\" id=\"boton\" value=\"Enviar\">");
        out.println("<input type='submit' class='btn btn-success' id='boton' value='Guardar' >");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
    }
}

