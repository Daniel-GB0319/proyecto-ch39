// Función para generar un código de verificación
function generarCodigo() {
    return Math.floor(100000 + Math.random() * 900000);
}

// Obtener referencias a los elementos
const valid = document.querySelector(".verify-control");
const codigoInput = document.getElementById("codigo-input");
const buttonVerify = document.getElementById("b-verify");

// Desactivar el botón de verificación


let codigoGenerado; // Variable para almacenar el código generado

// Función para mostrar la alerta y solicitar el código
function mostrarAlerta() {

    // Mostrar una alerta con el código generado
    alert("Tu código de verificación es: " + codigoGenerado);

    // Limpiar el campo de entrada
    codigoInput.value = "";

    // Mostrar el campo de entrada
    codigoInput.style.display = "block";
}

// Función para validar el código ingresado
function validarCodigoIngresado() {
    const codigoIngresado = parseInt(codigoInput.value, 10);
    if (codigoGenerado === codigoIngresado) {
        // Si el código ingresado es correcto, activar el botón de verificación
    } else {
        // Si el código ingresado no es correcto, mantener el botón desactivado
    }
}

// Agregar un evento de clic al elemento de validación
valid.addEventListener("click", function() {
    // Generar un nuevo código de verificación
    codigoGenerado = generarCodigo();
    // Mostrar la alerta
    mostrarAlerta();
});

// Agregar un evento de entrada al campo de entrada para validar el código ingresado y habilitar el botón
codigoInput.addEventListener("input", validarCodigoIngresado);

