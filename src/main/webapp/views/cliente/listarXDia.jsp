<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Cita"%>
<%@page import="models.usuario"%>
<%@page import="controller.ControllerCita"%>
<%@page import="controller.ControllerUsuario"%>

<!DOCTYPE html>
<html lang="esp">
<head>
    <link rel="icon" type="image/x-icon" href="../../assets/img/configuraciones.png" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Cita</title>
    <%@include file="css-js.jsp" %>
    <link rel="stylesheet" href="../../css/estilosmenu.css">
    <link rel="stylesheet" href="../../css/css.css">
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
                        
                        <li><a href="#">Citas</a>
                            <ul>
                                <li><a href="consultarCita.jsp">AGENDAR CITA</a></li>
                                <li><a href="listaCitaxCliente.jsp">MIS CITAS</a> </li>
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
                        <th></th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                    <%
                        String idCliente = request.getParameter("idCliente");
                        String fechaCita = request.getParameter("fechaCita");
                        ArrayList<Cita> listaCita = new ArrayList<>();
                        ControllerCita ctrCita = new ControllerCita();
                        listaCita = ctrCita.listarXDia(fechaCita);
                        for(int i=0; i<listaCita.size();i++){
                    %>
                
                    
                <tr>
                            <!--<td><%=listaCita.get(i).getIdCita()%></td>-->
                            <!--<td><%=listaCita.get(i).getInformacionProblema()%></td>-->
                            <td></td>
                            <td><%=listaCita.get(i).getFechaCita()%></td>
                            <td><%=listaCita.get(i).getHoraCita()%></td>
                            <!--<td><%=listaCita.get(i).getEstadoCita()%></td>-->
                            
                            
                                
                                <td>
                                    <a  href="actualizarCita.jsp?idCita=<%=listaCita.get(i).getIdCita()%>"> <button type="button" class="btn btn-success">Escoger </button></a>
                                </td>
                </tr>
                     
                    <% } %>
            </table>
    </div>
    </div>
    </div>
</header>
</body>
<script src="../../js/cliente.js"></script>
<script type="text/javascript" src="../../js/paginacion.js"></script>
</html>