<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
    <link href="../../css/estilosmenu.css" rel="stylesheet" type="text/css"/>
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
        <a class="btn btn-primary btn-xl text-uppercase" href="#">
            EMPLEADO: <%out.println(consultaUsuario.get(0).getNombreUsuario()); %>
        </a>
    </header>
</body>
</html>