// Obtener referencias a los elementos del DOM
const emailInput = document.getElementById("exampleFormControlInput1"); // Campo de entrada para el correo electrónico
const passwordInput = document.getElementById("password"); // Campo de entrada para la contraseña
const buttonLogin = document.getElementById("button-login"); // Botón de inicio de sesión

// Desactivar el botón de inicio de sesión inicialmente
buttonLogin.disabled = true;

// Expresión regular para validar direcciones de correo electrónico
const emailRegex = /^[\w.+\-]+@[\w.+\-]+\.com$/;

// Función para validar los campos de correo electrónico y contraseña
function validarCampos() {
    // Obtener los valores actuales de correo electrónico y contraseña
    const email = emailInput.value;
    const password = passwordInput.value;

    // Verificar si el correo electrónico y la contraseña cumplen con los criterios de validación
    const emailValido = emailRegex.test(email); // Verificar si el correo electrónico coincide con la expresión regular
    const passwordValido = password.length >= 7; // Verificar si la longitud de la contraseña es al menos 7 caracteres

    // Desactivar el botón de inicio de sesión si alguna de las validaciones falla
    buttonLogin.disabled = !(emailValido && passwordValido);
}

// Agregar un evento de escucha para el evento de entrada en el campo de correo electrónico
emailInput.addEventListener("input", validarCampos);

// Agregar un evento de escucha para el evento de entrada en el campo de contraseña
passwordInput.addEventListener("input", validarCampos);