/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class EliminarUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        IUsuarioService service = new UsuarioServiceImpl();
        service.eliminarRegistro(idUsuario);
        response.sendRedirect("ListarUsuarioServlet");   
    }
}



