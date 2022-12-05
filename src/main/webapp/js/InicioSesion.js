function login(){
    var correo, pass;

    correo = document.getElementById("correoUsuario").value;
    pass = document.getElementById("contrasenaUsuario").value;

    if(correo ==  "julian@gmail.com" && pass == "123456"){
        
        window.location= "usuario?accion=Menu";
        alert=("El jefe acaba de iniciar sesión");

    }

    if(correo ==  "daniela@gmail.com" && pass == "123456"){
        
        window.location= "secretaria?accion=Menu";
        alert=("La secretaria acaba de iniciar sesión");

    }

    if(correo ==  "mauricio@gmail.com" && pass == "123456" || correo ==  "camilo@gmail.com" && pass == "123456"){
        
        window.location= "empleado?accion=Menu";
        alert=("El empleado acaba de iniciar sesión");

    }
}