
<%@page import="controller.ControllerCita"%>
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
  <title>Actualizar Servicio</title>
</head>
<body>
    <%
        String IdStr = request.getParameter("idCita");
        int id = Integer.parseInt(IdStr);
        ControllerCita ctrCita = new ControllerCita();
        ArrayList<Cita> consultaCita = new ArrayList<>();
        consultaCita = ctrCita.consultaXId(id);

    %>
  <section class="form-register">
      <form method="POST" action="../../ControllerCita">
            <h4>Informacion Cita</h4>
          
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
    <label>Ingrese la informacion del problema *</label>
    <div>
      <input class="controls" type="text" name="informacionProblema"  required placeholder="informacion Problema">
    </div>
   
      <button type="submit" class="botons" name="btnAccion" value="Actualizar2">Actualizar Cita</button>
    </form>
  </section>
</body>
</html>