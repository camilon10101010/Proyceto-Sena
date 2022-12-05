<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.Cita"%>
<%@page import="models.usuario"%>
<%@page import="controller.ControllerCita"%>
<%@page import="controller.ControllerUsuario"%>

<!DOCTYPE html>
<html lang="esp">
<head>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/img/configuraciones.png" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Cita</title>
    <link rel="stylesheet" href="../../css/estilosmenu.css">
    <link rel="stylesheet" href="../../css/tablalista.css">
  <link rel="stylesheet" href="../../css/tlabalistar.css">
</head>
<body>
    <!--MENU-->
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
                        
                        <li><a href="#">Citas</a>
                            <ul>
                                <li><a href="insertarCita.jsp">Agregar Cita</a></li>
                                <li><a href="listarCita.jsp">Lista de Citas</a></li>
                            </ul>
                        </li>
                        <li class="cerrar">
                            <a href="../login.jsp">Cerrar Sesion</a>
                        </li>
                       
                    </ul>
                </nav>
            </div>

        </div>
    <div class="main-container">
            <!-- <div class="form-header">
                <h1 class="form-title"><span>Listar el </span><span>Album</span></h1>
            </div> -->
            
         
            <table>
                    <tr>
                        <!--<th>CITA</th>-->
                        <!--<th>Información Problema</th>-->
                        <!--<th>Estado Cita</th>-->
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Acción</th>
                    </tr>
                    
                    <%
                        ArrayList<Cita> listaCita = new ArrayList<>();
                        ControllerCita ctrCita = new ControllerCita();
                        listaCita = ctrCita.listar();
                        for(int i=0; i<listaCita.size();i++){
                    %>
                
                    
                        <tr>
                            
                            <!--<%=listaCita.get(i).getIdCita()%></td>-->
                            <!--<td><%=listaCita.get(i).getInformacionProblema()%></td>-->
                            <td><%=listaCita.get(i).getFechaCita()%></td>
                            <td><%=listaCita.get(i).getHoraCita()%></td>
                            <!--<td><%=listaCita.get(i).getEstadoCita()%></td>-->
                            
                            
                                
                                <td>
                                 <!--   <a href="#">
                                        <button type="button">
                                            Editar
                                        </button> 
                                    </a> -->
                                       
                                                <button>
                                           <a href="actualizarCita.jsp?idCita=<%=listaCita.get(i).getIdCita()%>"> Escoger </a>
                                                </button>
                                                
                                    </a>
                                </td>
                         
                        </tr>
                     
                    <% } %>
            </table>
    </div>
</header>
</body>
</html>