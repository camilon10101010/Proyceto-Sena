<%@page import="models.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Cliente"%>
<%@page import="controller.ControllerCita"%>

<!DOCTYPE html>
<html lang="esp">
<head>
    <link rel="icon" type="image/x-icon" href="../../assets/img/configuraciones.png" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Cita</title>
    <%@include file="../cliente/css-js.jsp" %>
    <link rel="stylesheet" href="../../css/estilosmenu.css">
    <link rel="stylesheet" href="../../css/css.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>
    <header>
        <div class="container__menu">
            <div class="menu">
                <input type="checkbox" id="check__menu">
                <label for="check__menu" id="label__check">
                    <i class="fas fa-bars icon__menu"></i>
                </label>
                <nav>
                    <ul>
                        <li><a href="usuario?accion=Menu" id="selected"></a></li>
                        <li><a href="#">Empleado</a>
                            <ul>
                                <li><a href="usuario?accion=formulario">Agregar</a></li>
                                <li><a href="usuario?accion=listar">Lista de Usuarios</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Servicios</a>
                            <ul>
                                <li><a href="listaCitasEnProceso.jsp">Citas En Proceso</a></li>
                                <li><a href="listaCitasRealizadas.jsp">Citas Ya Realizadas</a></li>
                                <li><a href="listaCitaxEmpleado.jsp">Listar De Citas</a></li>
                                
                                <li><a href="listaCitasAgendadas.jsp"> Citas Agendadas</a></li>
                                <li><a href="listaCitasRealizadas.jsp"> Citas Realizadas</a></li>
                            </ul>
                        </li>
                        <li class="cerrar">
                            <a href="../login.jsp">Cerrar Sesion</a>
                        </li>
                       
                    </ul>
                </nav>
            </div>

        </div>
    <div class="container">
    <div class="table-wrapper">
    <div class="main-container">
            <table  id="datos" number-per-page="6" current-page=""  class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID CITA</th>
                        <th>INFORMACION PROBLEMA</th>
                        <th>FECHA DE CITA</th>
                        <th>HORA DE CITA</th>
                        <th>NOMBRE CLIENTE</th>
                        <th>APELLIDO CLIENTE</th>
                        <th>TELEFONO</th>
                        <th>DIRECCI??N</th>
                        <th>ACCION</th>
                       
                    </tr>
                </thead>
                    <%
                        ArrayList<Cita> listaCita = new ArrayList<>();
                        ControllerCita ctrCita = new ControllerCita();
                        listaCita = ctrCita.listaAgendado();
                        for(int i=0; i<listaCita.size();i++){
                    %>
                    <tr>
                            <td><%=listaCita.get(i).getIdCita()%></td>
                            <td><%=listaCita.get(i).getInformacionProblema()%></td>
                            <td><%=listaCita.get(i).getFechaCita()%></td>
                            <td><%=listaCita.get(i).getHoraCita()%></td>
                            <td><%=listaCita.get(i).getNombreCliente()%></td>
                            <td><%=listaCita.get(i).getApellidoCliente()%></td>
                            <td><%=listaCita.get(i).getTelefonoCliente()%></td>
                            <td><%=listaCita.get(i).getDireccionCliente()%></td>
                            
                            
                                <td> 
                                    <a href="asignarCita.jsp?idCita=<%=listaCita.get(i).getIdCita()%>" onclick="return Asignar()"><button type="button" class="btn btn-success"> Asignar</button>  </a>
                                </td> 
                        
                    </tr>
                    <% } %>
            </table>
    </div>
    </div>
    </div>
</header>
</body>
<script src="../../js/js.js"></script>
<script type="text/javascript" src="../../js/paginacion.js"></script>
</html>