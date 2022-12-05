/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.usuario;
import models.Cliente;

/**
 *
 * @author julia
 */
@WebServlet(name = "ControllerLogin", urlPatterns = {"/ControllerLogin"})
public class ControllerLogin extends HttpServlet {
    usuario objLogin = new usuario();
    Cliente objCliLo = new Cliente();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("btnAccion");
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
//Login Usuario ----------------------------------------------------------------------------------------------------------
            if(accion.equals("Ingresar")){
                String contrasenaUsuario = request.getParameter("contrasenaUsuario");
                String correoUsuario = request.getParameter("correoUsuario");
                
                objLogin.setContrasenaUsuario(contrasenaUsuario);
                objLogin.setCorreoUsuario(correoUsuario);
          
                try {
                    
                    ResultSet usuarioSet = objLogin.login();
                    int idUsuario = 0;
                    int usuario = 0; 
                    while(usuarioSet.next()){
                        idUsuario++; 
                        usuario = usuarioSet.getInt(1); 
                    }
                    request.getSession().setAttribute("usuarioF", usuario);
                     if(correoUsuario.equals("Andres@gmail.com")){
                            if(idUsuario > 0){
                                String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "window.location.href='views/jefe/menu.jsp'; "+
                                    "</script> </body> </html>";
                                out.println(mensaje);
                            } else{
                                String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('CORREO O CONTRASEÑA INCORRECTO'); "+
                                    "window.location.href='views/loginUsuario.jsp'; "+
                                    "</script> </body> </html>";
                                out.println(mensaje);
                            }
                    } else if(correoUsuario.equals("Daniela@gmail.com")){
                            if(idUsuario > 0){
                            String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/secretaria/menu.jsp'; "+
                                "</script> </body> </html>";
                            out.println(mensaje);
                            } else{
                                String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('CORREO O CONTRASEÑA INCORRECTO'); "+
                                    "window.location.href='views/loginUsuario.jsp'; "+
                                    "</script> </body> </html>";
                                out.println(mensaje);
                            }
                    } else if (idUsuario > 0) {
                             String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/empleado/menu.jsp'; "+
                                "</script> </body> </html>";
                            out.println(mensaje);
                            System.out.println(idUsuario);
                    } else {
                            String mensaje="<html> <body>"+
                                        "<script type='text/javascript'>"+
                                        "alert('CORREO O CONTRASEÑA INCORRECTO'); "+
                                        "window.location.href='views/loginUsuario.jsp'; "+
                                        "</script> </body> </html>";
                            out.println(mensaje);
                        }
                     
                } catch (Exception error) {
                    System.out.println("Error controlador: "+error);
                }    
            }
         
// login cliente --------------------------------------------------------------------------------------------------------           
            if (accion.equals("loginCliente")) {
                String passwordCliente = request.getParameter("passwordCliente");
                String numeroDocumento = request.getParameter("numeroDocumento");
                
                objCliLo.setPasswordCliente(passwordCliente);
                objCliLo.setNumeroDocumento(numeroDocumento);
            } try {
                ResultSet clienteSet = objCliLo.loginCliente();
                    int idCliente = 0;
                    int cliente = 0;
                    while(clienteSet.next()){
                        idCliente++; 
                        cliente = clienteSet.getInt(1);
                    request.getSession().setAttribute("clienteF", cliente);
                    }
                    if (idCliente > 0) {
                        String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/cliente/menu.jsp'; "+
                                "</script> </body> </html>";
                                out.println(mensaje);
                                System.out.println(idCliente);
                        }else {
                            String mensaje="<html> <body>"+
                                        "<script type='text/javascript'>"+
                                        "alert('CORREO O CONTRASEÑA INCORRECTO'); "+
                                        "window.location.href='views/login.jsp'; "+
                                        "</script> </body> </html>";
                            out.println(mensaje);
                        }
            } catch (Exception e) {
                System.out.println("Error controlador: "+e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}

