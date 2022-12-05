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
    <link rel="stylesheet" href="../css/loginIndex.css"/>
    <link rel="stylesheet" href="css/estilos0.css">
    <link rel="stylesheet" href="css/estilosmenu.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Tecni-Ya</title>
</head>
<body>
    <header>
        <a class="logo-img" href="../assets/img/login.jpg"></a>
        <a href="../index.jsp"><img class="logologin" src="../assets/img/logo2.png" alt=""></a>
    </header>
        
    <section class="forms-section">
        <div class="forms">
          <div class="form-wrapper is-active">
            <button type="button" class="switcher switcher-login">
              Iniciar sesion
              <span class="underline"></span>
            </button>
              
              
            <form action="../ControllerLogin" method="POST" class="form form-login">
              <fieldset>
                <legend>Please, enter your email and password for login.</legend>
                <div class="input-block">
                  <label for="login-email">Numero de Documento</label>
                  <input id="numeroDocumento" type="number" name="numeroDocumento" required>
                </div>
                <div class="input-block">
                  <label for="login-password">Password</label>
                  <input id="passwordCliente" type="password" name="passwordCliente" required>
                </div>
              </fieldset>
                <button name="btnAccion" type="submit" class="btn-login" value="loginCliente" onclick="inicio()">Iniciar Sesión</button>
            </form>
          </div>
            
          <div class="form-wrapper">
            <button type="button" class="switcher switcher-signup">
                Registrarse
              <span class="underline"></span>
            </button>
          
              
              <form class="form form-signup" action="../ControllerCliente" method="POST">
                <fieldset>
                    
                <div class="input-block">
                  <label for="login-email">Numero de Documento</label>
                  <input id="login-email" type="number" name="numeroDocumento" required>
                </div>
                
                <div class="input-block">
                  <label for="login-password">contraseña</label>
                  <input id="login-password" type="password" name="passwordCliente" required>
                </div>
                    
                <div class="input-block">
                  <label for="login-password">Confirmar contraseña</label>
                <input id="login-password" type="password" required>
                </div>
              </fieldset>
                  <button type="submit" class="btn-signup" name="btnAccion" value="Registrar">Continue</button>
            </form>
           </div>
          </div>
        </div>
      </section>
    <script src="../js/loguear.js"></script>
    <script src="../js/cliente.js"></script>
</body>
</html>
