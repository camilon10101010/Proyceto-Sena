/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.usuario;

/**
 *
 * @author julia
 */
@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {
    usuario objUsuario = new usuario();
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
                       
            //INSERTAR
            if(accion.equals("Insertar")){
                String contrasenaUsuario = request.getParameter("contrasenaUsuario");
                String correoUsuario = request.getParameter("correoUsuario");
                String numeroDocumentoU = request.getParameter("numeroDocumentoU");
                String tipoDocumentoU = request.getParameter("tipoDocumentoU");
                String nombreUsuario = request.getParameter("nombreUsuario");
                String apellidoUsuario = request.getParameter("apellidoUsuario");
                String telefonoUsuario = request.getParameter("telefonoUsuario");
                String direccionUsuario = request.getParameter("direccionUsuario");
                String estadoUsuario = request.getParameter("estadoUsuario");
                objUsuario.setContrasenaUsuario(contrasenaUsuario);
                objUsuario.setCorreoUsuario(correoUsuario);
                objUsuario.setNumeroDocumentoU(numeroDocumentoU);
                objUsuario.setTipoDocumentoU(tipoDocumentoU);
                objUsuario.setNombreUsuario(nombreUsuario);
                objUsuario.setApellidoUsuario(apellidoUsuario);
                objUsuario.setTelefonoUsuario(telefonoUsuario);
                objUsuario.setDireccionUsuario(direccionUsuario);
                
                
                try {
                    objUsuario.insertarUsario();

                        String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('USUARIO INSERTADO CORRECTAMENTE!!!'); "+
                                    "window.location.href='views/jefe/listarUsuario.jsp'; "+
                                    "</script> </body> </html>";
                        out.println(mensaje);
                } catch (Exception e) {
                    System.out.println("Error controlador: "+e);
                }
                   
                
            }
            
            
            //ACTUALIZAR
            else if(accion.equals("Actualizar")){
                
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario")); 
                String tipoUsuario = request.getParameter("tipoUsuario");
                String contrasenaUsuario = request.getParameter("contrasenaUsuario");
                String correoUsuario = request.getParameter("correoUsuario");
                String numeroDocumentoU = request.getParameter("numeroDocumentoU");
                String tipoDocumentoU = request.getParameter("tipoDocumentoU");
                String nombreUsuario = request.getParameter("nombreUsuario");
                String apellidoUsuario = request.getParameter("apellidoUsuario");
                String telefonoUsuario = request.getParameter("telefonoUsuario");
                String direccionUsuario = request.getParameter("direccionUsuario");
                String estadoUsuario = request.getParameter("estadoUsuario");
                
                objUsuario.setIdUsuario(idUsuario);
                objUsuario.setTipoUsuario(tipoUsuario);
                objUsuario.setContrasenaUsuario(contrasenaUsuario);
                objUsuario.setCorreoUsuario(correoUsuario);
                objUsuario.setNumeroDocumentoU(numeroDocumentoU);
                objUsuario.setTipoDocumentoU(tipoDocumentoU);
                objUsuario.setNombreUsuario(nombreUsuario);
                objUsuario.setApellidoUsuario(apellidoUsuario);
                objUsuario.setTelefonoUsuario(telefonoUsuario);
                objUsuario.setDireccionUsuario(direccionUsuario);
               
                
                objUsuario.actualizarUsuario();
               
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/jefe/listarUsuario.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
                
            }
            
             //ACTUALIZAR DATOS EMPLEADO
            else if(accion.equals("Actualizar2")){
                
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario")); 
                String tipoUsuario = request.getParameter("tipoUsuario");
                String contrasenaUsuario = request.getParameter("contrasenaUsuario");
                String correoUsuario = request.getParameter("correoUsuario");
                String numeroDocumentoU = request.getParameter("numeroDocumentoU");
                String tipoDocumentoU = request.getParameter("tipoDocumentoU");
                String nombreUsuario = request.getParameter("nombreUsuario");
                String apellidoUsuario = request.getParameter("apellidoUsuario");
                String telefonoUsuario = request.getParameter("telefonoUsuario");
                String direccionUsuario = request.getParameter("direccionUsuario");
                String estadoUsuario = request.getParameter("estadoUsuario");
                
                objUsuario.setIdUsuario(idUsuario);
                objUsuario.setTipoUsuario(tipoUsuario);
                objUsuario.setContrasenaUsuario(contrasenaUsuario);
                objUsuario.setCorreoUsuario(correoUsuario);
                objUsuario.setNumeroDocumentoU(numeroDocumentoU);
                objUsuario.setTipoDocumentoU(tipoDocumentoU);
                objUsuario.setNombreUsuario(nombreUsuario);
                objUsuario.setApellidoUsuario(apellidoUsuario);
                objUsuario.setTelefonoUsuario(telefonoUsuario);
                objUsuario.setDireccionUsuario(direccionUsuario);
               
                
                objUsuario.actualizarUsuario();
               
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "alert('NECESITA INICIAR SESIÒN DE NUEVO'); "+
                                "window.location.href='views/loginUsuario.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
                
            }
            
    //ELIMINAR
            else if(accion.equals("Eliminar")){
                int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                objUsuario.setIdUsuario(idUsuario);
                
                objUsuario.eliminarUsuario();
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/jefe/listarUsuario.jsp'; "+
                                "</script> </body> </html>";
                out.println(mensaje);
            }
        }
    }
    
     //Listar
    public ArrayList listar(){
        try{
            ResultSet consulta = objUsuario.listarUsuario();
            ArrayList <usuario> listaUsuario = new ArrayList<>();
            
            while(consulta.next()){
                objUsuario = new usuario();
                objUsuario.setIdUsuario(consulta.getInt(1));
                objUsuario.setTipoUsuario(consulta.getString(2));
                objUsuario.setContrasenaUsuario(consulta.getString(3));
                objUsuario.setCorreoUsuario(consulta.getString(4));
                objUsuario.setNumeroDocumentoU(consulta.getString(5));                
                objUsuario.setTipoDocumentoU(consulta.getString(6));
                objUsuario.setNombreUsuario(consulta.getString(7));
                objUsuario.setApellidoUsuario(consulta.getString(8));
                objUsuario.setTelefonoUsuario(consulta.getString(9));
                objUsuario.setDireccionUsuario(consulta.getString(10));               
               


                listaUsuario.add(objUsuario);
            }
            return listaUsuario;
        }
        catch(Exception error){
            System.out.println("ERROR: "+error);
        }
        return null;
    }
    
    //CONSULTAR USUARIO X ID
            public ArrayList consultaXId(int idUsuario){
                try{
                    objUsuario.setIdUsuario(idUsuario);
                    ResultSet consulta = objUsuario.consultaXId();
                    ArrayList<usuario> listausuario = new ArrayList<>();
                    while(consulta.next()){
                        objUsuario = new usuario();
                        objUsuario.setIdUsuario(consulta.getInt(1));
                        objUsuario.setTipoUsuario(consulta.getString(2));
                        objUsuario.setContrasenaUsuario(consulta.getString(3));
                        objUsuario.setCorreoUsuario(consulta.getString(4));
                        objUsuario.setNumeroDocumentoU(consulta.getString(5));                
                        objUsuario.setTipoDocumentoU(consulta.getString(6));
                        objUsuario.setNombreUsuario(consulta.getString(7));
                        objUsuario.setApellidoUsuario(consulta.getString(8));
                        objUsuario.setTelefonoUsuario(consulta.getString(9));
                        objUsuario.setDireccionUsuario(consulta.getString(10));               
                        listausuario.add(objUsuario);
                    }
                        return listausuario;
                }
                    catch (Exception error){
                        System.out.println("ERROR" +error);
                    }
                    return null;
            }
            
            public ArrayList listarEmpleado(){
                try{
                    ResultSet consulta = objUsuario.listarEmpleado();
                    ArrayList <usuario> listaEmpleado = new ArrayList<>();

                    while(consulta.next()){
                        objUsuario = new usuario();
                        objUsuario.setIdUsuario(consulta.getInt(1));
                        objUsuario.setNombreUsuario(consulta.getString(7));
                        objUsuario.setApellidoUsuario(consulta.getString(8));
                        objUsuario.setTelefonoUsuario(consulta.getString(9));

                        listaEmpleado.add(objUsuario);
                    }
                    return listaEmpleado;
                    }
                    catch(Exception error){
                        System.out.println("ERROR: "+error);
                    }
                    return null;
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