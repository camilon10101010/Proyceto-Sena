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
    <link rel="icon" type="image/x-icon" href="assets/img/configuraciones.png" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Cita</title>
    <link href="../../css/MenuCliente.css" rel="stylesheet" type="text/css"/>
    <script src="../../js/MenuCliente.js" type="text/javascript"></script>
  
    <link rel="stylesheet" href="../../css/tablalista.css">
    <link rel="stylesheet" href="../../css/tlabalistar.css">
    <link rel="stylesheet" href="../../css/css.css"/>
</head>
<body>
    <!--MENU-->
    <header>
        <div class="container__menu">

            <div class="menu">
              
                <label for="check__menu" id="label__check">
                    <i class="fas fa-bars icon__menu"></i>
                </label>
             <nav>
            <div class="logo">
                <h4>CLIENTE</h4>
            </div>
            <ul class="nav-links"> 
                
                <a href="../cliente/consultarCita.jsp">AGENDAR CITA</a>
                <a href="listaCitaxCliente.jsp">MIS CITAS</a> 
                
                <a href="ActualizarMisDatos.jsp">MIS DATOS</a> 
                
                <a href="../login.jsp">CERRAR SESION</a>
                <a href="menu.jsp">VOLVER</a>
            </ul>
            <div class="burger"> 
              <div class="line1"></div>
              <div class="line2"></div>
              <div class="line3"></div>
            </div>
</nav>
            </div>

        </div>
    <div class="main-container">
            <!-- <div class="form-header">
                <h1 class="form-title"><span>Listar el </span><span>Album</span></h1>
            </div> -->
            <table>
                    <tr>
                        <th>INFORMACION PROBLEMA</th>
                        <th>FECHA DE CITA</th>
                        <th>HORA DE CITA</th>
                        <th>ESTADO DE LA CITA</th>
                        <th>CANCELAR CITA</th>
                    </tr>
                    <%
                        ArrayList<Cita> listaCitaEmpleado = new ArrayList<>();
                        ControllerCita ctrCita = new ControllerCita();
                        int idClienteFK = Integer.parseInt(request.getSession().getAttribute("clienteF").toString());
                        System.out.println(idClienteFK);
                        listaCitaEmpleado = ctrCita.listaXcliente(idClienteFK);
                        for(int i=0; i<listaCitaEmpleado.size();i++){
                    %>
                    <tr>
                            <td><%=listaCitaEmpleado.get(i).getInformacionProblema()%></td>
                            <td><%=listaCitaEmpleado.get(i).getFechaCita()%></td>
                            <td><%=listaCitaEmpleado.get(i).getHoraCita()%></td>
                            
                            
                            <td><%=listaCitaEmpleado.get(i).getEstadoCita()%></td>
                                    
                            <td>
                                <form method="POST" action="../../ControllerCita">
                                    <input value="<%=listaCitaEmpleado.get(i).getIdCita()%>" class="controls " type="text" name="idCita"  style="display: none" >
                                    <input value="<%=listaCitaEmpleado.get(i).getFechaCita()%>" class="controls " type="text" name="fechaCita"  style="display: none" >
                                    <input value="<%=listaCitaEmpleado.get(i).getHoraCita()%>" class="controls " type="text" name="horaCita"  style="display: none" >
                                    <input value="<%=listaCitaEmpleado.get(i).getHoraCita()%>" class="controls " type="text" name="horaCita"  style="display: none" >
                                    <button type="submit" class="btn btn-danger"  name="btnAccion" value="Cancelar" onclick="cancelar()">Cancelar</button>
                                </form>
                            </td>
                    </tr>
                   <% } %> 
            </table>
    </div>
</header>
<script src="../../js/cita.js"></script>
</body>
</html>