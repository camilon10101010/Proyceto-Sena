<%-- 
    Document   : formularioUsuario
    Created on : 17/10/2022, 12:25:28 p. m.
    Author     : julia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Favicon-->
  <link rel="icon" type="image/x-icon" href="../../assets/img/configuraciones.png" />
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="../../css/style.css">
  <link rel="stylesheet" href="../../css/estilos0.css">
  <link rel="stylesheet" href="../../css/estilosmenu.css">
  <title>Ingresar Usuario</title>
</head>
<body>
  <header>
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
                        
                        <li class="cerrar">
                            <a href="../loginUsuario.jsp">Cerrar Sesion</a>
                        </li>
                       
                    </ul>
                </nav>
            </div>

        </div>

  <section class="form-register">
      <form action="../../ControllerUsuario" method="post">
    <h4>Agrega el Usurio</h4>
    
    <div>
      <input class="controls" type="text" name="nombreUsuario"  required placeholder="Nombre del Usuario">
    </div>
    <div>
      <input class="controls" type="text" name="apellidoUsuario" required placeholder="Apellido del Usuario">
    </div>
    
    <div>
       <select class="select-css"  name="tipoDocumentoU">
              <option class="option">Tipo de Documento</option>
              <option class="option">Cedula De Ciudadania</option>
              <option class="option">Cedula De Extranjeria</option>             
              <option class="option">Pasaporte</option>
                
    </div>
    <div>
      <input class="controls" type="number" name="numeroDocumentoU" required placeholder="Numero de Documento">
    </div>
    <div>
      <input class="controls " type="number" name="telefonoUsuario" required placeholder="Telefono del Usuario">
    </div>
    <div>
        <input class="controls" type="text" name="contrasenaUsuario" required placeholder="Ingrese la Contraseña Usuario">      
    </div>
    <div>
      <input class="controls" type="text" name="direccionUsuario" required placeholder="Direccion del Usuario">
    </div>
    <div>
      <input class="controls" type="text" name="correoUsuario" required placeholder="Email del Usuario">
    </div>
      <button name="btnAccion" type="submit" class="botons" value="Insertar">Ingresar Usuario</button>
    </form>
  </section>
</header>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="../../js/alertasMejoradas.js"></script>
</body>
</html>