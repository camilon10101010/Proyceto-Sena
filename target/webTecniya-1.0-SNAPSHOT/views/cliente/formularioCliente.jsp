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
  <link href="../../css/estilosforms.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="../../css/estilosmenu.css"/>
  <title>Añadir Cliente</title>
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
                        <li><a href="#">Cliente</a>
                            <ul>
                                <li><a href="formularioCliente.jsp">Agregar </a></li>
                                <li><a href="listCliente.jsp">Listar De servicios</a></li>
                            </ul>
                        </li>
                        <li class="cerrar">
                            <a href="../login.jsp">Cerrar Sesion</a>
                        </li>                    </ul>
                </nav>
            </div>

        </div>
                    <section class="form-register">
                        <form class="case" method="GET" action="../../ControllerCliente">
                            <h4>Añadir Cliente</h4>
                                <div>
                                    <input class="controls " type="number" name="numeroDocumento" required placeholder="Numero de Documento">
                                </div>
                                <div>
                                    <select class="select-css"  name="tipoDocumento">
                                           <option class="option">Tipo de Documento</option>
                                           <option class="option">Cedula De Ciudadania</option>
                                           <option class="option">Cedula De Extranjeria</option>             
                                           <option class="option">Pasaporte</option>

                                 </div>
                                <div>
                                  <input class="controls" type="text" name="nombreCliente *"  required placeholder="Ingrese los Nombres">
                                </div>
                                <div>
                                  <input class="controls" type="text" name="apellidoCliente *"  required placeholder="Ingrese los Apellidos">
                                </div>
                                <div>
                                  <input class="controls " type="email" name="emailCliente *"  required placeholder="Ingrese el Email">
                                </div>
                                <div>
                                   <input class="controls" type="number" name="telefonoCliente *"  required placeholder="Ingrese el Telefono">
                                </div>
                                <div>
                                  <input class="controls" type="text" name="direccionCliente *"  required placeholder="Ingrese la Direccion">
                                </div>
                                <div>
                                  <input class="controls" type="text" name="passwordCliente *"  required placeholder="Ingrese la contraseña">
                                </div>
                            <button type="submit" class="botons" name="btnAccion" name="next" value="Insertar">Añadir Cliente</button>
                        </form>
                    </section> 
                <br>
            <br>
        <br>
</body>
</html>
