<%@page import="controller.ControllerCliente"%>
<%@page import="models.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <link rel="icon" type="image/x-icon" href="../../assets/img/configuraciones.png"/>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
  <link href="../../css/estilos0.css" rel="stylesheet" type="text/css"/>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
  <title>Actualizar Cliente</title>
</head>
<body>
    <%
        String IdStr = request.getParameter("idCliente");
        int id = Integer.parseInt(IdStr);
        ControllerCliente ctrClientes = new ControllerCliente();
        ArrayList<Cliente> consultaCliente = new ArrayList();
        consultaCliente = ctrClientes.consultanumeroDocumento(id);
        
    %>
  <section class="form-register">
      <form method="POST" action="../../ControllerCliente">
    <h4>Actualizar Cliente: <%out.println(consultaCliente.get(0).getNombreCliente()); %></h4>
    <div>
        <input value="<% out.println(consultaCliente.get(0).getIdCliente()); %>" class="controls" type="text" name="idCliente" readonly="#" style="display: none">
    </div>
    <label>Documento</label>
    <div>
        <input value="<%out.println(consultaCliente.get(0).getNumeroDocumento()); %>" class="controls " type="text" name="numeroDocumento">
    </div>
    <div>
        <input value="<%out.println(consultaCliente.get(0).getTipoDocumento()); %>" class="controls " type="text" name="tipoDocumento" required placeholder="Tipo del Documento" readonly="#">
    </div>
        <label>Nombre</label>
    <div>
      <input value="<%out.println(consultaCliente.get(0).getNombreCliente()); %>" class="controls" type="text" name="nombreCliente"  required placeholder="Ingrese los Nombres">
    </div>
        <label>Apellido</label>
    <div>
      <input value="<%out.println(consultaCliente.get(0).getApellidoCliente()); %>" class="controls" type="text" name="apellidoCliente"  required placeholder="Ingrese los Apellidos">
    </div>
        <label>Correo</label>
    <div>
      <input value="<%out.println(consultaCliente.get(0).getEmailCliente()); %>" class="controls " type="email" name="emailCliente"  required placeholder="Ingrese el Email">
    </div>
        <label>Telefono</label>
    <div>
      <input value="<%out.println(consultaCliente.get(0).getTelefonoCliente()); %>" class="controls" type="text" name="telefonoCliente"  required placeholder="Ingrese el Telefono">
    </div>
        <label>Documento</label>
    <div>
      <input value="<%out.println(consultaCliente.get(0).getDireccionCliente()); %>" class="controls" type="text" name="direccionCliente"  required placeholder="Ingrese la Direccion">
    </div>
    <div>
        <input value="<%out.println(consultaCliente.get(0).getPasswordCliente()); %>" class="controls" type="text" name="passwordCliente"  required placeholder="password" style="display: none">
    </div>
      <button type="submit" class="botons" name="btnAccion" value="Actualizar" onclick="actualizar()">Actualizar Cliente</button>
    </form>
  </section>
</body>
<script src="../../js/cliente.js"></script>
</html>