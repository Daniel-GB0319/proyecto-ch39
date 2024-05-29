// Constantes de cada elemento de HTML
const axios = require('axios').default;
const emailInput = document.getElementById("exampleFormControlInput1"); // Obtener el campo de entrada de correo electrónico
const buttonContinue = document.getElementById("b-continue"); // Obtener el botón de continuar

// Botón desactivado hasta que se valide el correo
buttonContinue.disabled = true; // Inicialmente, el botón está desactivado

// Validar Email contra la base de datos
emailInput.addEventListener("input", async (event) => { // Agregar un evento de escucha para el evento de entrada en el campo de correo electrónico
    const email = event.target.value; // Obtener el valor del campo de correo electrónico

    if (email) { // Verificar si el campo de correo no está vacío
        try {
            const response = await axios.post('http://localhost:8080/api/usuarios', { email: correo }); // Enviar el correo electrónico a la API utilizando axios

            if (response.status === 200) { // Si la respuesta es satisfactoria
                const data = response.data; // Obtener los datos de la respuesta
                if (data.exists) { // Suponiendo que la respuesta contiene una propiedad 'exists' para indicar si el correo existe
                    buttonContinue.disabled = false; // Si el correo electrónico existe en la base de datos, habilitar el botón
                } else {
                    buttonContinue.disabled = true; // Si el correo electrónico no existe en la base de datos, desactivar el botón
                }
            } else {
                console.error('Error en la validación del correo electrónico:', response.statusText);
                buttonContinue.disabled = true; // Si hay un error en la solicitud, desactivar el botón
            }
        } catch (error) {
            console.error('Error en la solicitud de validación:', error);
            buttonContinue.disabled = true; // Si hay un error en la solicitud, desactivar el botón
        }
    } else {
        buttonContinue.disabled = true; // Si el campo de correo está vacío, desactivar el botón
    }
});