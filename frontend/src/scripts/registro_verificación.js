// Función para generar un código de verificación
function generarCodigo() {
    return Math.floor(100000 + Math.random() * 900000);
}

// Constantes de validación
const valid = document.getElementsByClassName("verify-control")[0]; // Seleccionar el primer elemento de la colección
const codigoInput = document.getElementById("codigo-input"); // Campo de entrada para el código de verificación

let codigoGenerado = generarCodigo(); // Generar el código al inicio

// Función para validar el código ingresado con el generado
function validarCódigoIngresado() {
    const codigoIngresado = codigoInput.value;
    return codigoGenerado === parseInt(codigoIngresado); // Convertir el valor ingresado a entero para comparar
}

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

// Agregar un evento de clic al elemento de validación
valid.addEventListener("click", mostrarAlerta);

// Agregar un evento de cambio al campo de entrada para validar el código ingresado
codigoInput.addEventListener("input", () => {
    if (validarCódigoIngresado()) {
        alert("Código correcto. ¡Bienvenido!");
    } else {
        alert("Código incorrecto. Por favor, inténtalo de nuevo.");
    }
});