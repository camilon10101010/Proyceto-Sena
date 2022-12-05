<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.usuario"%>
<%@page import="controller.ControllerUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <link rel="icon" type="image/x-icon" href="../../assets/img/configuraciones.png" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Usuario</title>
    <%@include file="../cliente/css-js.jsp" %>
    <link rel="stylesheet" href="../../css/estilosmenu.css">
    <link rel="stylesheet" href="../../css/css.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
                        <li><a href="#">Empleado</a>
                            <ul>
                                <li><a href="../jefe/formularioUsuario.jsp">Agregar</a></li>
                                <li><a href="listarEmpleados.jsp">Consultar Empleados</a></li>
                                
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
                       
                        <th>NOMBRE</th>
                        <th>APELLIDO</th>
                        <th>DIRECCIION</th>
                        <th>TELEFONO</th>
                        <th>NUMERO DOCUMENTO</th>
                        <th>TIPO DOCUMENTO</th>
                        <th>ACCIÓN</th>
                        <th>FUNCIÓN</th>
                    </tr>
                </thead>
                    <%
                        ArrayList<usuario> listaUsuario = new ArrayList<>();
                        ControllerUsuario ctrUsuario = new ControllerUsuario();
                        listaUsuario = ctrUsuario.listar();
            
                      for(int i=0; i<listaUsuario.size();i++){
                    %>
                    
                        <tr>
                            <td><%=listaUsuario.get(i).getNombreUsuario()%></td>
                            <td><%=listaUsuario.get(i).getApellidoUsuario()%></td>
                            <td><%=listaUsuario.get(i).getDireccionUsuario()%></td>
                            <td><%=listaUsuario.get(i).getTelefonoUsuario()%></td>
                            <td><%=listaUsuario.get(i).getNumeroDocumentoU()%></td>
                            <td><%=listaUsuario.get(i).getTipoDocumentoU()%></td>
                            <td>
                                    <a href="actualizarUsuario.jsp?idUsuario=<%=listaUsuario.get(i).getIdUsuario()%>"> <button type="button" class="btn btn-warning">Actualizar </button> </a>
                                    <button class="btn btn-danger" onclick="eliminar(<%=listaUsuario.get(i).getIdUsuario()%>)">Eliminar</button>
                            </td>
                            <td><%=listaUsuario.get(i).getTipoUsuario()%></td>

                        </tr> 
                    <% }%>
            </table>
    </div>
    </div>
    </div>
</header>
</body>
<script src="../../js/jefe.js"></script>
<script type="text/javascript" src="../../js/paginacion.js"></script>
</html>