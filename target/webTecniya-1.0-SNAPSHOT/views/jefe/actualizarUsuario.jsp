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
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    

    <title>Actualizar Usuario</title>
</head>
<body>
    <% 
        String IdStr = request.getParameter("idUsuario");
        int id = Integer.parseInt(IdStr);
        ControllerUsuario ctrUsuarios = new ControllerUsuario();
        ArrayList<usuario> consultaUsuario = new ArrayList();
        consultaUsuario = ctrUsuarios.consultaXId(id);
    %>
  <header>
        <div class="container__menu">

            <div class="menu">
                <input type="checkbox" id="check__menu">
                <label for="check_menu" id="label_check">
                    <i class="fas fa-bars icon__menu"></i>
                </label>
                <nav>
                    <ul>
                        <li><a href="menu.jsp" id="selected"></a></li>
                        <li><a href="#">Empleado</a>
                            <ul>
                                <li><a href="formularioUsuario.jsp">Agregar</a></li>
                                <li><a href="listarUsuario.jsp">Lista de Usuarios</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Servicios</a>
                            <ul>
                                <li><a href="../servicios/formularioServicio.jsp">Agregar </a></li>
                                <li><a href="../servicios/listaServicio.jsp">Listar De servicios</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Cliente</a>
                            <ul>
                                <li><a href="../cliente/formularioCliente.jsp">Agregar </a></li>
                                <li><a href="../cliente/listCliente.jsp">Listar De servicios</a></li>
                            </ul>
                        </li>
                         <li><a href="#">Cita</a>
                            <ul>
                                <li><a href="../jefe/listarCita.jsp">Ver citas</a></li>
                                <li><a href="../../ControllerCita?btnAccion=1"> Crear Agenda</a></li>
                                <li><a href="../cliente/consultarCita.jsp"> Consultar Fecha</a></li>
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
        
            <h4>Estas editando a <%out.println(consultaUsuario.get(0).getNombreUsuario()); %><%out.println(consultaUsuario.get(0).getApellidoUsuario()); %></h4>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getIdUsuario()); %>" class="controls" type="text" name="idUsuario" style="display: none" readonly="#">
                </div>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getTipoUsuario()); %>" class="select-css"  type="text" name="tipoUsuario" readonly="#">
                </div>
                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getNombreUsuario()); %>" class="controls" type="text" name="nombreUsuario"  required placeholder="Apellido del Usuario">
                </div>
                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getApellidoUsuario()); %>" class="controls" type="text" name="apellidoUsuario"  required placeholder="Apellido del Usuario">
                </div>

                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getTipoDocumentoU()); %>" class="select-css"  type="text"  name="tipoDocumentoU" readonly="#">
                </div>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getNumeroDocumentoU()); %>" class="controls" type="text" name="numeroDocumentoU"  required placeholder="Numero de Documento">
                </div>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getTelefonoUsuario()); %>" class="controls " type="text" name="telefonoUsuario"  required placeholder="Telefono del Usuario">
                </div>
                <div>
                    <input value="<%out.println(consultaUsuario.get(0).getContrasenaUsuario()); %>" class="controls" type="text" name="contrasenaUsuario" style="display: none" required placeholder="Ingrese la Contraseña Usuario">      
                </div>


                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getDireccionUsuario()); %>" class="controls" type="text" name="direccionUsuario"  required placeholder="Direccion del Usuario">
                </div>
                <div>
                  <input value="<%out.println(consultaUsuario.get(0).getCorreoUsuario()); %>" class="controls" type="text" name="correoUsuario"  required placeholder="Email del Usuario">
                </div>
                
                <button name="btnAccion" type="submit" class="botons" onclick="actualizar()" value="Actualizar">Editar Usuario</button>
         </form>   
  </section>
</header>
</body>
<script src="../../js/jefe.js"></script>
</html>