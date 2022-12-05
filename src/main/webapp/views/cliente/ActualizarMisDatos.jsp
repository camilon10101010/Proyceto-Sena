
<%@page import="models.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.ControllerCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../../assets/img/configuraciones.png" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/estilos0.css">
    <link rel="stylesheet" href="../../css/estilosmenu.css">

    <title>Actualiza Tus Datos</title>
</head>
<body>
    <% 
        ArrayList<Cliente> consultaCliente = new ArrayList();
        ControllerCliente ctrClientes = new ControllerCliente();
        int idClienteFK = Integer.parseInt(request.getSession().getAttribute("clienteF").toString());
        System.out.println(idClienteFK);
        consultaCliente = ctrClientes.consultanumeroDocumento(idClienteFK);
    %>
  <header>
   <!-- MENU -->
        <div class="container__menu">

            <div class="menu">
                <input type="checkbox" id="check__menu">
                <label for="check_menu" id="label_check">
                    <i class="fas fa-bars icon__menu"></i>
                </label>
                <nav>
                    <ul>
                        <li><a href="menu.jsp" id="selected"></a></li>
                        <li><a href="#"> AGENDAR TU CITA </a>
                            <ul>
                                <li><a href="../cliente/consultarCita.jsp">Actualizar mis Datos</a></li>
                            </ul>
                        </li>
                        
                        <li><a href="#"> MIS CITAS </a>
                            <ul>
                                <li><a href="listaCitaxCliente.jsp">Actualizar mis Datos</a></li>
                            </ul>
                        </li>
                        <li><a href="#"> MIS DATOS </a>
                            <ul>
                                <li><a href="ActualizarDatosCliente.jsp">Actualizar mis Datos</a></li>
                            </ul>
                        </li>
                        
                        <li class="cerrar">
                            <a href="../../views/login.jsp">Cerrar Sesion</a>
                        </li>
                       
                    </ul>
                </nav>
            </div>

        </div>

  <section class="form-register">
         <form action="../../ControllerCliente" class="form" method="POST">
        
            <h4>MIS DATOS</h4>
                <div>
                    <input value="<% out.println(consultaCliente.get(0).getIdCliente()); %>" class="controls" type="text" name="idCliente" style="display: none" readonly="">
    </div>
    <label>Numero Documento *</label>
    <div>
        <input value="<%out.println(consultaCliente.get(0).getNumeroDocumento()); %>" class="controls " type="text" name="numeroDocumento">
    </div>
        <label>Tipo Documento *</label>
    <div>
       <select class="select-css" value=" <%out.println(consultaCliente.get(0).getTipoDocumento()); %>"  name="tipoDocumento">
              <option class="option">Cedula De Ciudadania</option>
              <option class="option">Cedula De Extranjeria</option>             
              <option class="option">Pasaporte</option>
                
    </div>
        <label>Nombre *</label>
    <div>
      <input value=" <%out.println(consultaCliente.get(0).getNombreCliente()); %>" class="controls" type="text" name="nombreCliente"  required placeholder="Ingrese los Nombres">
    </div>
     <label>Apellido *</label>
    <div>
      <input value=" <%out.println(consultaCliente.get(0).getApellidoCliente()); %>" class="controls" type="text" name="apellidoCliente"  required placeholder="Ingrese los Apellidos">
    </div>
     <label>Email *</label>
    <div>
      <input value=" <%out.println(consultaCliente.get(0).getEmailCliente()); %>" class="controls " type="email" name="emailCliente"  required placeholder="Ingrese el Email">
    </div>
     <label>Telefono *</label>
    <div>
      <input value=" <%out.println(consultaCliente.get(0).getTelefonoCliente()); %>" class="controls" type="text" name="telefonoCliente"  required placeholder="Ingrese el Telefono">
    </div>
     <label>Direccion *</label>
    <div>
      <input value=" <%out.println(consultaCliente.get(0).getDireccionCliente()); %>" class="controls" type="text" name="direccionCliente"  required placeholder="Ingrese la Direccion">
    </div>
     <label>Contraseña *</label>
    <div>
      <input value="<%out.println(consultaCliente.get(0).getPasswordCliente()); %>" class="controls" type="text" name="passwordCliente"  placeholder="password">
             <button name="btnAccion" type="submit" class="botons"  value="Actualizar">Actualizar Datos</button>
         </form>   
  </section>
</header>
</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="js/alertasMejoradas.js"></script>
</html>