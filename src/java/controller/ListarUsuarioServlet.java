/*
 Autor: Leonel Alexis García Juárez
 Fecha de creación:16 de Marzo 2022
 Fecha de Actualización: 16 de Marzo de 2022
 Descripción: Servlet
 */
package controller;

import entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import service.IUsuarioService;
import service.UsuarioServiceImpl;

public class ListarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel ='stylesheet' href='"+request.getContextPath()+"/resources/css/estilo.css'>");
        out.println("</head>");
        out.println("<h1> Servlet </h1>");
        out.println("<table border= 1px solid black>");
        out.println("<tr>");
        out.println("<th>Código</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Sexo</th>");
        out.println("<th>Edad</th>");
        out.println("<th>NombreUsuario</th>");
        out.println("<th>Contraseña</th>");
        out.println("</tr>");
        IUsuarioService service = new UsuarioServiceImpl();
        List<Usuario> listaUsuario = service.ObtenerRegistros();
        out.println("<tbody>");
        for (Usuario usuario : listaUsuario) {
            out.println("<td>" + usuario.getCodigo() + "</td>");
            out.println("<td>" + usuario.getNombre() + "</td>");
            out.println("<td>" + usuario.getSexo() + "</td>");
            out.println("<td>" + usuario.getEdad() + "</td>");
            out.println("<td>" + usuario.getNombreUsuario() + "</td>");
            out.println("<td>" + usuario.getContraseña() + "</td>");
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
