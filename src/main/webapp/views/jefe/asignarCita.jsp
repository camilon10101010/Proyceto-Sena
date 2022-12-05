    

<%@page import="controller.ControllerCita"%>
<%@page import="controller.ControllerUsuario"%>
<%@page import="models.usuario"%>
<%@page import="models.Cita"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
   <link rel="icon" type="image/x-icon" href="../../assets/img/configuraciones.png"/>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
  <link href="../../css/estilos0.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="../../css/estilosmenu.css"/>
  <title>Actualizar Servicio</title>
</head>
<body>
    <!-- MENU -->
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
    <%
        String IdStr = request.getParameter("idCita");
        int id = Integer.parseInt(IdStr);
        ControllerCita ctrCita = new ControllerCita();
        ArrayList<Cita> consultaCita = new ArrayList<>();
        consultaCita = ctrCita.consultaXId(id);
    %>
  <section class="form-register">
      <form method="POST" action="../../ControllerCita">
            <h4>Actualizar Servicio</h4>
          
    <div>
        <input value="<%out.println(consultaCita.get(0).getIdCita()); %>" class="controls " type="text" name="idCita"  readonly >
    </div>
    <label>Fecha de la cita</label>
    <div>
        <input value="<%out.println(consultaCita.get(0).getFechaCita()); %>" class="controls " type="text" name="fechaCita" readonly >
    </div>
    <label>Hora de la cita</label>
    <div>
        <input value="<%out.println(consultaCita.get(0).getHoraCita()); %>" class="controls " type="text" name="horaCita" readonly>
    </div>
    <label>Ingrese la informacion del problema:</label>
    <div>
      <input value="<%out.println(consultaCita.get(0).getInformacionProblema()); %>" class="controls" type="text" name="informacionProblema"  readonly>
    </div>
    <div>
       <label> ASIGNAR EMPLEADO *</label>
      <select class="select-css"  name="idUsuarioFK">
          
        <%
        ArrayList<usuario> listaUsuario = new ArrayList<>();
        ControllerUsuario ctrUsuario = new ControllerUsuario();
        listaUsuario = ctrUsuario.listarEmpleado();
        for(int i=0; i<listaUsuario.size();i++){
        %>
        
        
        <option class="option" name="idUsuarioFK" value="<%=listaUsuario.get(i).getIdUsuario()%>"><%=listaUsuario.get(i).getNombreUsuario()%></option>
      
        <%}%>
        
      </select>              
             
      
    </div>
      <button type="submit" class="botons" name="btnAccion" value="Asignar">Asignar Cita</button>
    </form>
  </section>
</body>
</html>