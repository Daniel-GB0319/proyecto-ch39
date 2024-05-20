
// Estos valores tienen que venir de las variables de la página de registro o de la base de datos; se almacenan cuando creamos una cuenta.


let nomRegistro = "Compradror1";
let corrRegistro= "comprador1@gmail.com";
let contraRegistro = "Comprador1";



// Mostrar los datos correspondientes en la card de perfil_micuenta

///////////Campo nombre de usuario
let nomPerCue = document.getElementById("nombrePerfilCuenta");
nomPerCue.value = nomRegistro; // Asignando el valor de la variable.

///////////Campo correo electrónico
let corrPerCue = document.getElementById("emailPerfilCuenta");
corrPerCue.value = corrRegistro; // Asignando el valor de la variable.

///////////Campo contraseña
let contraPerCue = document.getElementById("contraPerfilCuenta");
contraPerCue.value = contraRegistro; // Asignando el valor de la variable.


// Función que modifica la información del perfil al precionar el botón de modificar

function modificarInformacion() {
    //Modifica campo nombre de usuario
    nomRegistro = document.getElementById("nombrePerfilCuenta");
    nomRegistro = nomPerCue.value ; // Asignando el valor de la variable.
    //Modifica campo nombre de usuario
    corrRegistro = document.getElementById("emailPerfilCuenta");
    corrRegistro = corrPerCue.value ; // Asignando el valor de la variable.
    //Modifica campo nombre de usuario
    contraRegistro = document.getElementById("contraPerfilCuenta");
    contraRegistro = contraPerCue.value ; // Asignando el valor de la variable.
    alert("Información modificada");
    console.log(nomRegistro); //Es para verificar que guardo los cambios
    console.log(corrRegistro); //Es para verificar que guardo los cambios
    console.log(contraRegistro); //Es para verificar que guardo los cambios
    return nomRegistro;
    
}

/*
function regresar(){
    window.location.href = "/frontend/index.html";
}
*/
