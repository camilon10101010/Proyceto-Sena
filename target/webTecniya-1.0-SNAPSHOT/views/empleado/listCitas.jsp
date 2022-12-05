<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Cliente"%>
<%@page import="controller.ControllerCliente"%>



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
    <link rel="stylesheet" href="../../css/css.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                        <li><a href="#">Servicios</a>
                            <ul>
                                <li><a href="formularioCliente.jsp">Agregar </a></li>
                                <li><a href="listCliente.jsp">Listar De servicios</a></li>
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
            <table id="datos" number-per-page="6" current-page=""  class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Tipo Documento</th>
                        <th>N° Documento</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Telefono</th>
                        <th>Email</th>         
                        <th>Direccion</th>
                        <th>Accion</th>
                    </tr>
                </thead> 
                    <%
                        ArrayList<Cliente> listaCliente = new ArrayList<>();
                        ControllerCliente ctrCliente = new ControllerCliente();
                        listaCliente = ctrCliente.listar();
                        
                        for(int i=0; i<listaCliente.size();i++){
                    %>
                    <tr>
                            <td><%=listaCliente.get(i).getTipoDocumento()%></td>
                            <td><%=listaCliente.get(i).getNumeroDocumento()%></td>
                            <td><%=listaCliente.get(i).getNombreCliente()%></td>
                            <td><%=listaCliente.get(i).getApellidoCliente()%></td>
                            <td><%=listaCliente.get(i).getTelefonoCliente()%></td>
                            <td><%=listaCliente.get(i).getEmailCliente()%></td>
                            <td><%=listaCliente.get(i).getDireccionCliente()%></td>
                            <td>
                                <a href="editarCliente.jsp?idCliente=<%=listaCliente.get(i).getIdCliente()%>"> Actualizar </a>
                                <a href="../../ControllerCliente?idCliente=<%=listaCliente.get(i).getIdCliente()%>&btnAccion=Eliminar"><button class="btn btn-danger" onclick="return confirm('DESEA ELIMINAR EL CLIENTE SELECCIONADO?');">Eliminar</button></a>
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