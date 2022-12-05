<%-- 
    Document   : actualizarUsuario
    Created on : 1/11/2022, 2:58:27 p. m.
    Author     : julia
--%>

<%@page import="models.usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.ControllerUsuario"%>
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

    <title>Actualizar Usuario</title>
</head>
<body>
    <% 
        ArrayList<usuario> consultaUsuario = new ArrayList();
        ControllerUsuario ctrUsuarios = new ControllerUsuario();
        int idUsuarioFK = Integer.parseInt(request.getSession().getAttribute("usuarioF").toString());
        System.out.println(idUsuarioFK);
        consultaUsuario = ctrUsuarios.consultaXId(idUsuarioFK);
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
                        <li><a href="#"> MI INFORMACIÓN </a>
                            <ul>
                                <li><a href="ActualizarDatosEmp.jsp?idUsuario=">Actualizar mis Datos</a></li>
                            </ul>
                        </li>
                        <li><a href="#">MIS CITAS</a>
                            <ul>
                                <li><a href="listaCitasEnProceso.jsp">Citas En Proceso</a></li>
                                <li><a href="listaCitasRealizadas.jsp">Citas Ya Realizadas</a></li>
                                <li><a href="listaCitaxEmpleado.jsp">Listar De Citas</a></li>
                            </ul>
                        </li>
                        <li class="cerrar">
                            <a href="../loginUsuario.jsp">Cerrar Sesion</a>
                        </li>
                       
                    </ul>
                </nav>
            </div>

        </div>

  <section class="form-register">
         <form action="../../ControllerUsuario" class="form" method="POST">
        
            <h4>Estas editando</h4>
                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getIdUsuario()); %>" class="controls" type="text" name="idUsuario" style="display: none" readonly>
                </div>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getTipoUsuario()); %>" class="select-css"  type="text" name="tipoUsuario" style="display: none" readonly>
                </div>
                <label>Nombre *</label>
                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getNombreUsuario()); %>" class="controls" type="text" name="nombreUsuario"  required placeholder="Apellido del Usuario">
                </div>
                <label>Apellido *</label>
                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getApellidoUsuario()); %>" class="controls" type="text" name="apellidoUsuario"  required placeholder="Apellido del Usuario">
                </div>
                <label>Documento *</label>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getTipoDocumentoU()); %>" class="select-css"  type="text"  name="tipoDocumentoU" readonly>
                </div>  
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getNumeroDocumentoU()); %>" class="controls" type="text" name="numeroDocumentoU"  required placeholder="Numero de Documento">
                </div>
                <label>Telefono *</label>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getTelefonoUsuario()); %>" class="controls " type="text" name="telefonoUsuario"  required placeholder="Telefono del Usuario">
                </div>
                <label>Contraseña *</label>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getContrasenaUsuario()); %>" class="controls" type="text" name="contrasenaUsuario"  required placeholder="Ingrese la Contraseña Usuario">      
                </div>
                <label>Dirección *</label>
                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getDireccionUsuario()); %>" class="controls" type="text" name="direccionUsuario"  required placeholder="Direccion del Usuario">
                </div>
                <label>Correo *</label>
                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getCorreoUsuario()); %>" class="controls" type="text" name="correoUsuario"  required placeholder="Email del Usuario">
                </div>
                
             <button name="btnAccion" type="submit" class="botons"  value="Actualizar2">Actualizar Datos</button>
         </form>   
  </section>
</header>

</body>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="js/alertasMejoradas.js"></script>
</html>