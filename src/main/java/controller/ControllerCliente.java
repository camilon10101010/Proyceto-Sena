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
import models.Cliente;
import models.Cita;

/**
 *
 * @author Camilo
 */
@WebServlet(name = "ControllerCliente", urlPatterns = {"/ControllerCliente"})
public class ControllerCliente extends HttpServlet {
        Cliente objCliente = new Cliente();
        Cita objCita = new Cita();
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
                String numeroDocumento = request.getParameter("numeroDocumento");
                String tipoDocumento = request.getParameter("tipoDocumento");
                String nombreCliente = request.getParameter("nombreCliente");
                String apellidoCliente = request.getParameter("apellidoCliente");
                String emailCliente = request.getParameter("emailCliente");
                String telefonoCliente = request.getParameter("telefonoCliente");
                String direccionCliente = request.getParameter("direccionCliente");
                String passwordCliente = request.getParameter("passwordCliente");
                objCliente.setNumeroDocumento(numeroDocumento);
                objCliente.setTipoDocumento(tipoDocumento);
                objCliente.setNombreCliente(nombreCliente);
                objCliente.setApellidoCliente(apellidoCliente);
                objCliente.setEmailCliente(emailCliente);
                objCliente.setTelefonoCliente(telefonoCliente);
                objCliente.setDireccionCliente(direccionCliente);
                objCliente.setPasswordCliente(passwordCliente);
                
                try {
                        objCliente.insertarCliente();

                        String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('CLIENTE INSERTADO CORRECTAMENTE!!!'); "+
                                    "window.location.href='views/jefe/menu.jsp'; "+
                                    "</script> </body> </html>";
                        out.println(mensaje);
                    
                    
                } catch (Exception error) {
                    System.out.println("Error controlador: "+error);
                }
            }
            
            //REGISTRAR
            if(accion.equals("Registrar")){
                String numeroDocumento = request.getParameter("numeroDocumento");
                String tipoDocumento = request.getParameter("tipoDocumento");
                String nombreCliente = request.getParameter("nombreCliente");
                String apellidoCliente = request.getParameter("apellidoCliente");
                String emailCliente = request.getParameter("emailCliente");
                String telefonoCliente = request.getParameter("telefonoCliente");
                String direccionCliente = request.getParameter("direccionCliente");
                String passwordCliente = request.getParameter("passwordCliente");
                objCliente.setNumeroDocumento(numeroDocumento);
                objCliente.setTipoDocumento(tipoDocumento);
                objCliente.setNombreCliente(nombreCliente);
                objCliente.setApellidoCliente(apellidoCliente);
                objCliente.setEmailCliente(emailCliente);
                objCliente.setTelefonoCliente(telefonoCliente);
                objCliente.setDireccionCliente(direccionCliente);
                objCliente.setPasswordCliente(passwordCliente);
                
                try{
                        objCliente.registrarCliente();

                        String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('SE HA REGISTRADO CORRECTAMENTE!!!'); "+
                                    "window.location.href='views/login.jsp'; "+
                                    "</script> </body> </html>";
                        out.println(mensaje);
                    
                } catch (Exception error) {
                    System.out.println("Error controlador: "+error);
                }
        }
            
            //ACTUALIZAR
            else if(accion.equals("Actualizar")){
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                String numeroDocumento = request.getParameter("numeroDocumento");
                String tipoDocumento = request.getParameter("tipoDocumento");
                String nombreCliente = request.getParameter("nombreCliente");
                String apellidoCliente = request.getParameter("apellidoCliente");
                String emailCliente = request.getParameter("emailCliente");
                String telefonoCliente = request.getParameter("telefonoCliente");
                String direccionCliente = request.getParameter("direccionCliente");
                String passwordCliente = request.getParameter("passwordCliente");
                objCliente.setIdCliente(idCliente);
                objCliente.setNumeroDocumento(numeroDocumento);
                objCliente.setTipoDocumento(tipoDocumento);
                objCliente.setNombreCliente(nombreCliente);
                objCliente.setApellidoCliente(apellidoCliente);
                objCliente.setEmailCliente(emailCliente);
                objCliente.setTelefonoCliente(telefonoCliente);
                objCliente.setDireccionCliente(direccionCliente);
                objCliente.setPasswordCliente(passwordCliente);
                
                objCliente.actualizarCliente();
                
                String mensaje="<html> <body>"+
                               "<script type='text/javascript'>"+
                               "window.location.href='views/login.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
                
            }
        //ELIMINAR
            else if(accion.equals("Eliminar")){
                int idCliente = Integer.parseInt(request.getParameter("idCliente"));
                objCliente.setIdCliente(idCliente);
                
                objCliente.eliminarCliente();
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/cliente/listCliente0.jsp'; "+
                                "</script> </body> </html>";
                out.println(mensaje);
        }
    }
}   
        //LISTAR
            public ArrayList listar(){
                try{
                    ResultSet consulta = objCliente.listarCliente();
                    ArrayList <Cliente> listaClientes = new ArrayList<>();
                    
                while(consulta.next()){
                    objCliente = new Cliente();
                    objCliente.setIdCliente(consulta.getInt(1));
                    objCliente.setNumeroDocumento(consulta.getString(2));
                    objCliente.setTipoDocumento(consulta.getString(3)); 
                    objCliente.setNombreCliente(consulta.getString(4));
                    objCliente.setApellidoCliente(consulta.getString(5));
                    objCliente.setEmailCliente(consulta.getString(6));
                    objCliente.setTelefonoCliente(consulta.getString(7));
                    objCliente.setDireccionCliente(consulta.getString(8));
                    listaClientes.add(objCliente);
                } 
                return listaClientes;
            }
             catch(Exception error) {
                 System.out.println("ERROR: "+error);
            }
            return null;
        }
        
            //CONSULTAR CLIENTE POR NUMERO DE DOCUMENTO
            public ArrayList consultanumeroDocumento(int idCliente){
                try{
                    objCliente.setIdCliente(idCliente);
                    ResultSet consulta = objCliente.consultanumeroDocumento();
                    ArrayList<Cliente> listaCliente = new ArrayList<>();
                    while(consulta.next()){
                        objCliente = new Cliente();
                        objCliente.setIdCliente(consulta.getInt(1));
                        objCliente.setNumeroDocumento(consulta.getString(2));
                        objCliente.setTipoDocumento(consulta.getString(3)); 
                        objCliente.setNombreCliente(consulta.getString(4));
                        objCliente.setApellidoCliente(consulta.getString(5));
                        objCliente.setEmailCliente(consulta.getString(6));
                        objCliente.setTelefonoCliente(consulta.getString(7));
                        objCliente.setDireccionCliente(consulta.getString(8));
                        objCliente.setPasswordCliente(consulta.getString(9));
                        listaCliente.add(objCliente);
                    }
                        return listaCliente;
                }
                    catch (Exception error){
                        System.out.println("ERROR" +error);
                    }
                    return null;
            }
            
            //LISTAR DATOS DEL EMPLEADO
            public ArrayList listaXemplado(int idUsuario){
                try {
                    objCita.setIdUsuario(idUsuario);
                    ResultSet consultaC = objCita.listarCitaEmpleado();
                    ArrayList <Cita> listaXemplado = new ArrayList<>();
                    
                    while (consultaC.next()) {
                        objCita = new Cita();
                        objCita.setIdCita(consultaC.getInt(1));
                        objCita.setInformacionProblema(consultaC.getString(2));
                        objCita.setFechaCita(consultaC.getString(3));
                        objCita.setHoraCita(consultaC.getString(4));
                        objCita.setEstadoCita(consultaC.getString(5));
                        objCita.setIdClienteFK(consultaC.getString(6));
                        objCita.setIdUsuarioFK(consultaC.getString(7));
                        objCliente.setIdCliente(consultaC.getInt(8));
                        objCliente.setNombreCliente(consultaC.getString(11));
                        objCliente.setApellidoCliente(consultaC.getString(12));
                        objCliente.setTelefonoCliente(consultaC.getString(14));
                        objCliente.setApellidoCliente(consultaC.getString(15));
                        
                       
                        listaXemplado.add(objCita);
                    }
                    return  listaXemplado;
                }
                 catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                return  null;
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