<%-- 
    Document   : menu
    Created on : 17/10/2022, 12:28:38 p. m.
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="controller.ControllerUsuario"%>
<%@page import="models.usuario"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/img/configuraciones.png" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tecni-Ya</title>
    <script src="https://kit.fontawesome.com/41bcea2ae3.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="../../css/estilosmenu.css">
    <link href="../../css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background-color: #F9F49F">
    <% 
        ArrayList<usuario> consultaUsuario = new ArrayList();
        ControllerUsuario ctrUsuarios = new ControllerUsuario();
        int idUsuarioFK = Integer.parseInt(request.getSession().getAttribute("usuarioF").toString());
        System.out.println(idUsuarioFK);
        consultaUsuario = ctrUsuarios.consultaXId(idUsuarioFK);
    %>
    <header>
        <div class="container__menu">

            <div class="menu">
                <input type="checkbox" id="check__menu">
                <label for="check__menu" id="label__check">
                    <i class="fas fa-bars icon__menu"></i>
                </label>
                <nav>
                    <ul>
                        <li><a href="menu.jsp" id="selected"></a></li>
                       
                        <li><a href="#">Usuarios</a>
                            <ul>
                                <li><a href="formularioUsuario.jsp">Agregar</a></li>
                                <li><a href="listarUsuario.jsp">Consultar Usuarios</a></li>
                                <li><a href="listarEmpleados.jsp">Consultar Empleados</a></li>
                                <li><a href="ActualizarDatosEmp.jsp?idUsuario=">Actualizar mis Datos</a></li>
                            </ul>
                        </li>
                        <!--<li><a href="#">Servicios</a>
                            <ul>
                                <li><a href="../servicios/formularioServicio.jsp">Agregar </a></li>
                                <li><a href="../servicios/listaServicio.jsp">Listar De servicios</a></li>
                            </ul>
                        </li>-->
                        <li><a href="../cliente/menu.jsp">Cliente</a>
                            <ul>
                                <li><a href="../cliente/formularioCliente.jsp">Agregar </a></li>
                                <li><a href="../cliente/listCliente0.jsp">Consultar  Clientes</a></li>
                            </ul>
                        </li>
                         <li><a href="#">Cita</a>
                            <ul>
                                <li><a href="listarCita.jsp">Ver citas</a></li>
                                <li><a href="../../ControllerCita?btnAccion=1"> Crear Agenda</a></li>
                                <li><a href="consultarCita.jsp"> Consultar Fecha</a></li>
                            </ul>
                        </li>
                        <li class="cerrar">
                            <a href="../loginUsuario.jsp">Cerrar Sesion</a>
                        </li>
                       
                    </ul>
                </nav>
            </div>

        </div>
        <a class="btn btn-primary btn-xl text-uppercase" href="#">
            SECRETARIA: <%out.println(consultaUsuario.get(0).getNombreUsuario()); %>
        </a>
    </header>

   
</body>
</html>