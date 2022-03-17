/* 
 Autor: Leonel Alexis García Juárez
 Fecha de creación:17 de Marzo 2022
 Fecha de Actualización: 17 de Marzo de 2022
 Descripción: 
*/

package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EliminarUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("Text/html");
        PrintWriter out=response.getWriter();
        out.println("<h1>Servlet</h1>");
    }
}
