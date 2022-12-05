<%@page import="models.Cita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Cliente"%>
<%@page import="controller.ControllerCita"%>
<%@page import="controller.ControllerCliente"%>

<!DOCTYPE html>
<html lang="esp">
<head>
    <!-- Favicon-->
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
          <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
                        <li><a href="menu.jsp" id="selected"></a></li>
                       
                        <li><a href="#">CITAS</a>
                            <ul>
                                <li><a href="formularioCliente.jsp">Agregar </a></li>
                                <li><a href="listaCitasEnProceso.jsp">Citas En Proceso</a></li>
                                <li><a href="listaCitasRealizadas.jsp">Citas Ya Realizadas</a></li>
                            </ul>
                        </li>
                        <li class="cerrar">
                            <a href="../loginUsuario.jsp">Cerrar Sesion</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    <div class="container">
    <div class="table-wrapper">
    <div class="main-container">
            <table id="datos" number-per-page="6" current-page=""  class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>ID CITA</th>
                        <th>INFORMACION PROBLEMA</th>
                        <th>FECHA DE CITA</th>
                        <th>HORA DE CITA</th>
                        <th>NOMBRE CLIENTE</th>
                        <th>APELLIDO CLIENTE</th>
                        <th>TELEFONO</th>
                        <th>DIRECCIÒN</th>
                        <th>ESTADO CITA</th>
                    </tr>
                </thead> 
                    <%
                        ArrayList<Cita> listaCitaEmpleado = new ArrayList<>();
                        ControllerCita ctrCita = new ControllerCita();
                        String IdStr = request.getParameter("idUsuario");
                        int id = Integer.parseInt(IdStr);
                        listaCitaEmpleado = ctrCita.listaXemplado(id);
                        for(int i=0; i<listaCitaEmpleado.size();i++){
                    %>
                    <tr>
                            <td><%=listaCitaEmpleado.get(i).getIdCita()%></td>
                            <td><%=listaCitaEmpleado.get(i).getInformacionProblema()%></td>
                            <td><%=listaCitaEmpleado.get(i).getFechaCita()%></td>
                            <td><%=listaCitaEmpleado.get(i).getHoraCita()%></td>
                            <td><%=listaCitaEmpleado.get(i).getNombreCliente()%></td>
                            <td><%=listaCitaEmpleado.get(i).getApellidoCliente()%></td>
                            <td><%=listaCitaEmpleado.get(i).getDireccionCliente()%></td>
                            <td><%=listaCitaEmpleado.get(i).getTelefonoCliente()%></td>
                            
                            
                            <td>
                                <form method="POST" action="../../ControllerCita">
                                    <input value="<%=listaCitaEmpleado.get(i).getIdCita()%>" class="controls " type="text" name="idCita" style="display: none" >
                                <select class="select-css"  name="estadoCita">
                                    <option class="option" name="estadoCita"><%=listaCitaEmpleado.get(i).getEstadoCita()%></option>
                                    <option class="option" name="estadoCita">Realizada</option>
                                </select>   
                                    <button type="submit" class="btn btn-warning" name="btnAccion" value="Cambiar">Cambiar</button>
                                </form>
                            </td>
                            
                    </tr>
                   <% } %> 
            </table>
    </div>
    </div>
    </div>
</header>
            
</body>
</html>