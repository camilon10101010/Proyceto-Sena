<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Cliente"%>
<%@page import="controller.ControllerCliente"%>
<!DOCTYPE html>
<html lang="esp">
<link href="../../css/MenuCliente.css" rel="stylesheet" type="text/css"/>
<script src="../../js/MenuCliente.js" type="text/javascript"></script>
<link href="../../css/styles.css" rel="stylesheet" type="text/css"/>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <title>Inicio</title>
  <body >
      <% 
        ArrayList<Cliente> consultaCliente = new ArrayList();
        ControllerCliente ctrClientes = new ControllerCliente();
        int idClienteFK = Integer.parseInt(request.getSession().getAttribute("clienteF").toString());
        System.out.println(idClienteFK);
        consultaCliente = ctrClientes.consultanumeroDocumento(idClienteFK);
    %>
<nav>
  <div class="logo">
      <h4>CLIENTE</h4>
  </div>
  <ul class="nav-links"> 
      <a href="#"></a>
      <a href="../cliente/consultarCita.jsp">AGENDAR CITA</a>
      <a href="listaCitaxCliente.jsp">MIS CITAS</a> 
      <a href="ActualizarMisDatos.jsp">MIS DATOS</a> 
      <a href="../../views/login.jsp">CERRAR SESION</a>
     
  </ul>
  <div class="burger"> 
    <div class="line1"></div>
    <div class="line2"></div>
    <div class="line3"></div>
  </div>
</nav>
<a class="btn btn-primary btn-xl text-uppercase" href="ActualizarMisDatos.jsp">
            CLIENTE: <%out.println(consultaCliente.get(0).getNombreCliente()); %>
        </a>
</body>
<script src="../../js/actualizar_1.js"></script>
</html>

