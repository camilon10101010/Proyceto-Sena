/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cita;
import models.Cliente;

/**
 *
 * @author Camilo
 */
@WebServlet(name = "ControllerCita", urlPatterns = {"/ControllerCita"})
public class ControllerCita extends HttpServlet {
    Cita objCita = new Cita();
    Cliente objCliente = new Cliente();

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
            /* TODO output your page here. You may use following sample code. */
            System.out.println(accion);
            // INSERTAR
            if (accion.equals("Insertar")) {
                String fechaCita = request.getParameter("fechaCita");
                String horaCita = request.getParameter("horaCita");
                String estadoCita = request.getParameter("estadoCita");
                String informacionProblema = request.getParameter("informacionProblema");
                objCita.setFechaCita(fechaCita);
                objCita.setHoraCita(horaCita);
                objCita.setEstadoCita(estadoCita);
                objCita.setInformacionProblema(informacionProblema);
                try {
                    objCita.insertarCita();
                    

                        String mensaje="<html> <body>"+
                                    "<script type='text/javascript'>"+
                                    "alert('CITA AGENDADA CORRECTAMENTE!!!'); "+
                                    "window.location.href='index.jsp'; "+
                                    "</script> </body> </html>";
                        out.println(mensaje);
                
                } catch (Exception error) {
                    System.out.println("Error controlador: "+error);
                }
            }
            
            //ACTUALIZAR PARA CLIENTES
            else if(accion.equals("Escoger")){
                int idCita = Integer.parseInt(request.getParameter("idCita"));
                String fechaCita = request.getParameter("fechaCita");
                String horaCita = request.getParameter("horaCita");
                String informacionProblema = request.getParameter("informacionProblema");
                String idClienteFK = request.getParameter("idClienteFK");
                objCita.setIdCita(idCita);
                objCita.setFechaCita(fechaCita);
                objCita.setHoraCita(horaCita);
                objCita.setInformacionProblema(informacionProblema);
                objCita.setIdClienteFK(idClienteFK);
                objCita.escogerCitaCliente();
                
                
                String mensaje="<html> <body>"+
                               "<script type='text/javascript'>"+
                               "alert('CITA AGENDADA CORRECTAMENTE!!'); "+
                               "window.location.href='views/cliente/menu.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
            }
            
            //ACTUALIZAR PARA USUARIOS
            else if(accion.equals("Actualizar2")){
                int idCita = Integer.parseInt(request.getParameter("idCita"));
                String fechaCita = request.getParameter("fechaCita");
                String horaCita = request.getParameter("horaCita");
                String informacionProblema = request.getParameter("informacionProblema");
                objCita.setIdCita(idCita);
                objCita.setFechaCita(fechaCita);
                objCita.setHoraCita(horaCita);
                objCita.setInformacionProblema(informacionProblema);
                objCita.actualizarCita();
                
                String mensaje="<html> <body>"+
                               "<script type='text/javascript'>"+
                               "alert('CITA ACTUALIZADA CORRECTAMENTE!!'); "+
                               "window.location.href='views/jefe/listarCita.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
            }
            
             //ASIGNAR CITA 
            else if(accion.equals("Asignar")){
                int idCita = Integer.parseInt(request.getParameter("idCita"));
                String idUsuarioFK = request.getParameter("idUsuarioFK");
                String fechaCita = request.getParameter("fechaCita");
                String horaCita = request.getParameter("horaCita");
                String informacionProblema = request.getParameter("informacionProblema");
                objCita.setIdCita(idCita);
                objCita.setIdUsuarioFK(idUsuarioFK);
                objCita.setFechaCita(fechaCita);
                objCita.setHoraCita(horaCita);
                objCita.setInformacionProblema(informacionProblema);
                objCita.asignarCita();
                
                String mensaje="<html> <body>"+
                               "<script type='text/javascript'>"+
                               "alert('CITA ASIGNADA CORRECTAMENTE!!'); "+
                               "window.location.href='views/jefe/listarCita.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
            }
            
            //CAMBIAR ESTADO
            else if(accion.equals("Cambiar")){
                int idCita = Integer.parseInt(request.getParameter("idCita"));
                String estadoCita = request.getParameter("estadoCita");
                objCita.setIdCita(idCita);
                objCita.setEstadoCita(estadoCita);
                objCita.cambiarEstado();
                
                String mensaje="<html> <body>"+
                               "<script type='text/javascript'>"+
                               "alert('EL ESTADO SE CAMBIO CORRECTAMENTE!!'); "+
                               "window.location.href='views/empleado/listaCitaxEmpleado.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
            }
            
            //CANCELAR CITA DESDE CLIENTE
            else if(accion.equals("Cancelar")){
                int idCita = Integer.parseInt(request.getParameter("idCita"));
                objCita.setIdCita(idCita);
                objCita.cancelarCita();
                
                String mensaje="<html> <body>"+
                               "<script type='text/javascript'>"+
                               "alert('LA CITA SE CANCELO CORRECTAMENTE!!'); "+
                               "window.location.href='views/cliente/listaCitaxCliente.jsp'; "+
                            "</script> </body> </html>";
                out.println(mensaje);
                
            }
            
         
            
            //CREAR AGENDA
            
            if(accion.equals("1")){
                Cita agendaCita =  new Cita();   
                agendaCita.crearAgenda();
                
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/jefe/listarCita.jsp'; "+
                                "</script> </body> </html>";
                out.println(mensaje);
                
            }
               //ELIMINAR
            else if(accion.equals("Eliminar")){
                int idCita = Integer.parseInt(request.getParameter("idCita"));
                objCita.setIdCita(idCita);
                
                objCita.eliminarCita();
                String mensaje="<html> <body>"+
                                "<script type='text/javascript'>"+
                                "window.location.href='views/cliente/listarCita.jsp'; "+
                                "</script> </body> </html>";
                out.println(mensaje);
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
    
       //LISTAR
            public ArrayList listar(){
                
                try{
                   
                    ResultSet consulta = objCita.listarCita();
                    ArrayList <Cita> listaCita = new ArrayList<>(); 
                    
                while(consulta.next()){
                    objCita = new Cita();
                    objCita.setIdCita(consulta.getInt(1));
                    objCita.setInformacionProblema(consulta.getString(2));
                    objCita.setFechaCita(consulta.getString(3));
                    objCita.setHoraCita(consulta.getString(4));
                    objCita.setEstadoCita(consulta.getString(5));
                    objCita.setIdClienteFK(consulta.getString(6));
                    objCita.setIdUsuarioFK(consulta.getString(7));
                    listaCita.add(objCita);
                } 
                return listaCita;
            }
             catch(Exception error) {
                 System.out.println("ERROR: "+error);
            }
            return null;
        }
            
                 //LISTARXDIA
            public ArrayList listarXDia(String fecha){
                
                try{
                   objCita.setFechaCita(fecha);
                    ResultSet consulta = objCita.listarXDia();
                    ArrayList <Cita> listaXDia = new ArrayList<>(); 
                    
                while(consulta.next()){
                    objCita = new Cita();
                    objCita.setIdCita(consulta.getInt(1));
                    objCita.setInformacionProblema(consulta.getString(2));
                    objCita.setFechaCita(consulta.getString(3));
                    objCita.setHoraCita(consulta.getString(4));
                    objCita.setEstadoCita(consulta.getString(5));

                    listaXDia.add(objCita);
                } 
                return listaXDia;
            }
             catch(Exception error) {
                 System.out.println("ERROR: "+error);
            }
            return null;
        }
            
            //LISTAR X DIA PARA CLIENTE
            public ArrayList listarXDiaCliente(int idCliente, String fecha){
                
                try{
                    objCita.setIdCliente(idCliente);
                    objCita.setFechaCita(fecha);
                    ResultSet consulta = objCita.listarXDiaCliente();
                    ArrayList <Cita> listaXDiaCliente = new ArrayList<>(); 
                    
                while(consulta.next()){
                    objCita = new Cita();
                    objCita.setIdCita(consulta.getInt(1));
                    objCita.setInformacionProblema(consulta.getString(2));
                    objCita.setFechaCita(consulta.getString(3));
                    objCita.setHoraCita(consulta.getString(4));
                    objCita.setEstadoCita(consulta.getString(5));

                    listaXDiaCliente.add(objCita);
                } 
                return listaXDiaCliente;
            }
             catch(Exception error) {
                 System.out.println("ERROR: "+error);
            }
            return null;
        }
            
            // LISTAR POR DIA PARA JEFE
            
        public ArrayList listarXDia2(String fecha){
                
                try{
                   objCita.setFechaCita(fecha);
                    ResultSet consulta = objCita.listarXDia();
                    ArrayList <Cita> listaXDia = new ArrayList<>(); 
                    
                while(consulta.next()){
                    objCita = new Cita();
                    objCita.setIdCita(consulta.getInt(1));
                    objCita.setInformacionProblema(consulta.getString(2));
                    objCita.setFechaCita(consulta.getString(3));
                    objCita.setHoraCita(consulta.getString(4));
                    objCita.setEstadoCita(consulta.getString(5));

                    listaXDia.add(objCita);
                } 
                return listaXDia;
            }
             catch(Exception error) {
                 System.out.println("ERROR: "+error);
            }
            return null;
        }
            /// CONSULTAR X ID
        public ArrayList consultaXId(int idCita){
                
                try{
                   objCita.setIdCita(idCita);
                    ResultSet consulta = objCita.consultaXId();
                    ArrayList<Cita> listaCita = new ArrayList<>(); 
                    
                while(consulta.next()){
                    objCita = new Cita();
                    objCita.setIdCita(consulta.getInt(1));
                    objCita.setInformacionProblema(consulta.getString(2));
                    objCita.setFechaCita(consulta.getString(3));
                    objCita.setHoraCita(consulta.getString(4));
                    objCita.setEstadoCita(consulta.getString(5));

                    listaCita.add(objCita);
                } 
                return listaCita;
            }
             catch(Exception error) {
                 System.out.println("ERROR: "+error);
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
                        objCita.setIdCliente(consultaC.getInt(8));
                        objCita.setNombreCliente(consultaC.getString(11));
                        objCita.setApellidoCliente(consultaC.getString(12));
                        objCita.setTelefonoCliente(consultaC.getString(14));
                        objCita.setDireccionCliente(consultaC.getString(15));
                        
                       
                        listaXemplado.add(objCita);
                    }
                    return  listaXemplado;
                }
                 catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                return  null;
            }
            
            // LISTAR CITA PARA CLIENTE
            public ArrayList listaXcliente(int idCliente){
                try {
                    objCita.setIdCliente(idCliente);
                    ResultSet consultaC = objCita.listarCitaDeCliente();
                    ArrayList <Cita> listaXcliente = new ArrayList<>();
                    
                    while (consultaC.next()) {
                        objCita = new Cita();
                        objCita.setIdCita(consultaC.getInt(1));
                        objCita.setInformacionProblema(consultaC.getString(2));
                        objCita.setFechaCita(consultaC.getString(3));
                        objCita.setHoraCita(consultaC.getString(4));
                        objCita.setEstadoCita(consultaC.getString(5));
                        objCita.setIdClienteFK(consultaC.getString(6));
                        objCita.setIdUsuarioFK(consultaC.getString(7));
                        
                       
                        listaXcliente.add(objCita);
                    }
                    return  listaXcliente;
                }
                 catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                return  null;
            }
            
            //LISTAR DATOS DE CITA DEL EMPLEADO CUANDO LA CITA ESTE EN PROCESO
            public ArrayList listaempladoProceso(int idUsuario){
                try {
                    objCita.setIdUsuario(idUsuario);
                    ResultSet consultaC = objCita.CitaEmpleadoProceso();
                    ArrayList <Cita> listaempladoProceso = new ArrayList<>();
                    
                    while (consultaC.next()) {
                        objCita = new Cita();
                        objCita.setIdCita(consultaC.getInt(1));
                        objCita.setInformacionProblema(consultaC.getString(2));
                        objCita.setFechaCita(consultaC.getString(3));
                        objCita.setHoraCita(consultaC.getString(4));
                        objCita.setEstadoCita(consultaC.getString(5));
                        objCita.setIdCliente(consultaC.getInt(8));
                        objCita.setNombreCliente(consultaC.getString(11));
                        objCita.setApellidoCliente(consultaC.getString(12));
                        objCita.setTelefonoCliente(consultaC.getString(14));
                        objCita.setDireccionCliente(consultaC.getString(15));
                       
                        listaempladoProceso.add(objCita);
                    }
                    return listaempladoProceso;
                }
                 catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                return  null;
            }
            
            //LISTAR DATOS DE CITA DEL EMPLEADO CUANDO LA CITA ESTE REALIZADA
            public ArrayList listaempladoRealizada(int idUsuario){
                try {
                    objCita.setIdUsuario(idUsuario);
                    ResultSet consultaC = objCita.CitaEmpleadoRealizada();
                    ArrayList <Cita> listaempladoRealizada = new ArrayList<>();
                    
                    while (consultaC.next()) {
                        objCita = new Cita();
                        objCita.setIdCita(consultaC.getInt(1));
                        objCita.setInformacionProblema(consultaC.getString(2));
                        objCita.setFechaCita(consultaC.getString(3));
                        objCita.setHoraCita(consultaC.getString(4));
                        objCita.setEstadoCita(consultaC.getString(5));
                        objCita.setIdCliente(consultaC.getInt(8));
                        objCita.setNombreCliente(consultaC.getString(11));
                        objCita.setApellidoCliente(consultaC.getString(12));
                        objCita.setTelefonoCliente(consultaC.getString(14));
                        objCita.setDireccionCliente(consultaC.getString(15));
                       
                        listaempladoRealizada.add(objCita);
                    }
                    return listaempladoRealizada;
                }
                 catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                return  null;
            }
            
            
            //LISTAR DATOS DE LA CITA CUANDO LA CITA ESTE AGENDADA
            public ArrayList listaAgendado(){
                try {
                    ResultSet consultaC = objCita.CitaAgendado();
                    ArrayList <Cita> listaAgendado = new ArrayList<>();
                    
                    while (consultaC.next()) {
                        objCita = new Cita();
                        objCita.setIdCita(consultaC.getInt(1));
                        objCita.setInformacionProblema(consultaC.getString(2));
                        objCita.setFechaCita(consultaC.getString(3));
                        objCita.setHoraCita(consultaC.getString(4));
                        objCita.setEstadoCita(consultaC.getString(5));
                        objCita.setIdCliente(consultaC.getInt(8));
                        objCita.setNombreCliente(consultaC.getString(11));
                        objCita.setApellidoCliente(consultaC.getString(12));
                        objCita.setTelefonoCliente(consultaC.getString(14));
                        objCita.setDireccionCliente(consultaC.getString(15));
                       
                        listaAgendado.add(objCita);
                    }
                    return listaAgendado;
                }
                 catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                return  null;
            }
       
            //LISTAR DATOS DE LA CITA CUANDO LA CITA ESTE EN PROCESO
            public ArrayList listaEnProceso(){
                try {
                    ResultSet consultaC = objCita.CitaEnProceso();
                    ArrayList <Cita> listaEnProceso = new ArrayList<>();
                    
                    while (consultaC.next()) {
                        objCita = new Cita();
                        objCita.setIdCita(consultaC.getInt(1));
                        objCita.setInformacionProblema(consultaC.getString(2));
                        objCita.setFechaCita(consultaC.getString(3));
                        objCita.setHoraCita(consultaC.getString(4));
                        objCita.setEstadoCita(consultaC.getString(5));
                        objCita.setIdCliente(consultaC.getInt(8));
                        objCita.setNombreCliente(consultaC.getString(11));
                        objCita.setApellidoCliente(consultaC.getString(12));
                        objCita.setTelefonoCliente(consultaC.getString(14));
                        objCita.setDireccionCliente(consultaC.getString(15));
                       
                        listaEnProceso.add(objCita);
                    }
                    return listaEnProceso;
                }
                 catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                return  null;
            }        
            
            //LISTAR DATOS DE LA CITA CUANDO LA CITA ESTE YA REALIZADA
            public ArrayList listaRealizada(){
                try {
                    ResultSet consultaC = objCita.CitaYaRealizada();
                    ArrayList <Cita> listaYaRealizada = new ArrayList<>();
                    
                    while (consultaC.next()) {
                        objCita = new Cita();
                        objCita.setIdCita(consultaC.getInt(1));
                        objCita.setInformacionProblema(consultaC.getString(2));
                        objCita.setFechaCita(consultaC.getString(3));
                        objCita.setHoraCita(consultaC.getString(4));
                        objCita.setEstadoCita(consultaC.getString(5));
                        objCita.setIdCliente(consultaC.getInt(8));
                        objCita.setNombreCliente(consultaC.getString(11));
                        objCita.setApellidoCliente(consultaC.getString(12));
                        objCita.setTelefonoCliente(consultaC.getString(14));
                        objCita.setDireccionCliente(consultaC.getString(15));
                       
                        listaYaRealizada.add(objCita);
                    }
                    return listaYaRealizada;
                }
                 catch (Exception e) {
                    System.out.println("ERROR: " + e);
                }
                return  null;
            }   
            
}
