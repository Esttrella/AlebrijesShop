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
import java.util.List;
import service.IUsuarioService;
import service.UsuarioServiceImpl;

/**
 *
 * @author labtw04
 */
public class ListarUsuarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");

        out.println("<link rel ='stylesheet' href='" + request.getContextPath() + "/resources/css/estilo.css'>");

        out.println("<script type='text/javascript' src='./javascript.js\'></script>");

        out.println("</head>");

        out.println("<body>");
        out.println("<h1> Servlet </h1>");
        out.println("<table>\n"
                + "  <tr>\n"
                + "    <th>Codigo</th>\n"
                + "    <th>Nombre</th>\n"
                + "    <th>Edad</th>\n"
                + "    <th>Sexo</th>\n"
                + "    <th>NombreUsuario</th>\n"
                + "    <th>Editar</th>\n"
                + "    <th>Eliminar</th>\n"
                + "  </tr>");

        IUsuarioService service = new UsuarioServiceImpl();
        List<Usuario> listaUsuario = service.obtenerRegistros();
        out.println("<tbody>");

        for (Usuario usuario : listaUsuario) {
            out.println("<tr>");
            out.println("<td>" + usuario.getCodigo() + "</td>");
            out.println("<td>" + usuario.getNombre() + "</td>");
            out.println("<td>" + usuario.getEdad() + "</td>");
            out.println("<td>" + usuario.getSexo() + "</td>");
            out.println("<td>" + usuario.getNombreusuario() + "</td>");

            out.println("<td><a href='EditarUsuarioServlet?idsuario=" +usuario.getCodigo() + "'>Editar</a></td>");
            
            out.println("<td><a href='EliminarUsuarioServlet?idUsuario=" + usuario.getCodigo() + "'    onclick=\"return confirm('Estás seguro que deseas eliminar el registro?');\" >Eliminar</a></td>");

            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table>");
        
        out.println("<div class=\"center\">");
        out.println("<button>Crear</button>");
        out.println("</div>");
        
        out.println("</body>");

        out.println("</html>");

    }

}
