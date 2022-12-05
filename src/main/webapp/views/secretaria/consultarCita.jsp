<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <link rel="icon" type="image/x-icon" href="../../assets/img/configuraciones.png"/>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
  <link href="../../css/estilos0.css" rel="stylesheet" type="text/css"/>
  <title>Añadir Cita</title>
  
</head>

<script>
    function validarFecha(){
        var fechaInput = document.getElementById('fechaCita').value;
        fechaInput = Date.parse(fechaInput);  
        fechaActual = new Date();
        if(fechaInput < fechaActual){
            alert("La fecha no puede ser inferior a " + fechaActual.toISOString().split("T")[0]);
            return false; 
        }
        else{
            return true; 
        }
    }
</script>
<body>
  <section class="form-register">
      <form method="GET" action="listarXDia.jsp" onsubmit=" return validarFecha()">
    <h4>CONSULTAR CITA</h4>
    
    <div>
      <label>Fecha *</label>
      
      <input class="controls " type="date" name="fechaCita" id="fechaCita">
    </div>
    <div>
    
      <button type="submit" class="botons" name="btnAccion" value="listarXDia2">CONSULTAR</button>
    </form>
  </section>
</body>
</html>
