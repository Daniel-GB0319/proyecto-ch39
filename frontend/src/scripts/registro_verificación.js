// Función para generar un código de verificación
function generarCodigo() {
    return Math.floor(100000 + Math.random() * 900000);
}

// Obtener referencias a los elementos
const valid = document.querySelector(".verify-control");
const codigoInput = document.getElementById("codigo-input");
const buttonVerify = document.getElementById("b-verify");

let codigoGenerado; // Variable para almacenar el código generado

// Función para mostrar la alerta y solicitar el código
function mostrarAlerta() {
    // Generar un nuevo código
    codigoGenerado = generarCodigo();

    // Mostrar una alerta con el código generado
    alert("Tu código de verificación es: " + codigoGenerado);

    // Limpiar el campo de entrada
    codigoInput.value = "";

    // Mostrar el campo de entrada
    codigoInput.style.display = "block";
}

// Desactivar el botón al mostrar el nuevo código
buttonVerify.disabled = true;

// Función para validar el código ingresado
function validarCodigoIngresado() {
    const codigoIngresado = parseInt(codigoInput.value, 10);
    return codigoGenerado === codigoIngresado;
}

// Agregar un evento de clic al elemento de validación
valid.addEventListener("click", mostrarAlerta);

// Agregar un evento de entrada al campo de entrada para validar el código ingresado y habilitar el botón
codigoInput.addEventListener("input", () => {
    if (validarCodigoIngresado()) {
        buttonVerify.disabled = false;
    } else {
        buttonVerify.disabled = true;
    }
});

