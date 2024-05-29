// Obtener referencias a los elementos del DOM
const emailInput = document.getElementById("exampleFormControlInput1"); // Campo de entrada para el correo electrónico
const passwordInput = document.getElementById("password"); // Campo de entrada para la contraseña
const buttonLogin = document.getElementById("button-login"); // Botón de inicio de sesión

// Desactivar el botón de inicio de sesión inicialmente
buttonLogin.disabled = true;

// Función para validar los campos de correo electrónico y contraseña usando Fetch API
async function validarCampos() {
    // Obtener los valores actuales de correo electrónico y contraseña
    const email = emailInput.value;
    const password = passwordInput.value;

    // Solo proceder si ambos campos no están vacíos
    if (email && password) {
        try {
            const response = await fetch('http://localhost:8080/api/usuarios', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ email: correo, password: contraseña }) // Enviar el correo electrónico y la contraseña en el cuerpo de la solicitud
            });

            if (response.ok) { // Si la respuesta es satisfactoria
                const data = await response.json(); // Obtener los datos de la respuesta
                console.log("Respuesta de la API:", data);
                if (data.valid) { // Suponiendo que la respuesta contiene una propiedad 'valid' para indicar si las credenciales son válidas
                    buttonLogin.disabled = false; // Si las credenciales son válidas, habilitar el botón
                    console.log("Credenciales válidas.");
                } else {
                    buttonLogin.disabled = true; // Si las credenciales no son válidas, desactivar el botón
                    console.log("Credenciales no válidas.");
                }
            } else {
                console.error('Error en la validación de las credenciales:', response.statusText);
                buttonLogin.disabled = true; // Si hay un error en la solicitud, desactivar el botón
            }
        } catch (error) {
            console.error('Error en la solicitud de validación:', error);
            buttonLogin.disabled = true; // Si hay un error en la solicitud, desactivar el botón
        }
    } else {
        buttonLogin.disabled = true; // Si algún campo está vacío, desactivar el botón
    }
}

// Agregar un evento de escucha para el evento de entrada en el campo de correo electrónico
emailInput.addEventListener("input", validarCampos);

// Agregar un evento de escucha para el evento de entrada en el campo de contraseña
passwordInput.addEventListener("input", validarCampos);