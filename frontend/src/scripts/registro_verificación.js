
// Función para generar un código de verificación
function generarCodigo() {
    return Math.floor(100000 + Math.random() * 900000);
}


// Constantes de validación
const valid = document.getElementsByClassName("verify-control");
const codigoIngresado = valid.value;

// Función para validar el código ingresado con el generado
function validarCódigoIngresado() {
    return codigoGenerado === codigoIngresado;
}

validarCódigoIngresado();



