<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="esp">
<head>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../assets/img/configuraciones.png" />
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="assets/img/icono_figura.png" />
    <link rel="stylesheet" href="../css/Styles_login.css">
    <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/estilos0.css">
  <link rel="stylesheet" href="css/estilosmenu.css">
    <title>Tecni-Ya</title>
</head>
<body>
    <header>
        <a class="logo-img" href="../assets/img/login.jpg"></a>
        <a href="../index.jsp"><img class="logologin" src="../assets/img/logo2.png" alt=""></a>
    </header>
    <section class="form-login">
        <form action="../ControllerLogin" method="POST">
            <h5>Iniciar Sesión</h5>
            <input class="controladores" id="correoUsuario" type="email" name="correoUsuario" value="" placeholder="Correo">
            <input class="controladores" id="contrasenaUsuario" type="password" name="contrasenaUsuario" value="" placeholder="Contraseña">

            <button name="btnAccion" type="submit" class="buttons" value="Ingresar" >Ingresar Usuario</button>
            <p><a href="#">¿Olvidaste tu contraseña?</a></p>
        </form>
    </section>
    <script src="../js/cliente.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</body>
</html>