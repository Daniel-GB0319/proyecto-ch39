// Constantes de cada elemento de HTML
const emailInput = document.getElementById("exampleFormControlInput1"); // Obtener el campo de entrada de correo electrónico
const buttonContinue = document.getElementById("b-continue"); // Obtener el botón de continuar

// Botón desactivado hasta que se valide el correo
buttonContinue.disabled = true; // Inicialmente, el botón está desactivado

// Crear regex para que se cumpla el patrón
const emailRegex = /^[\w.+\-]+@[\w.+\-]+\.com$/; // Expresión regular para validar direcciones de correo electrónico

// Validar Email
emailInput.addEventListener("input", (event) => { // Agregar un evento de escucha para el evento de entrada en el campo de correo electrónico
    const email = event.target.value; // Obtener el valor del campo de correo electrónico

    if (emailRegex.test(email)) { // Verificar si el correo electrónico cumple con el patrón de la expresión regular
        buttonContinue.disabled = false; // Si el correo electrónico es válido, habilitar el botón
        alert("El email que ingresaste es correcto"); // Mostrar una alerta indicando que el correo electrónico es válido
    } else {
        buttonContinue.disabled = true; // Si el correo electrónico no es válido, desactivar el botón
        alert("El correo ingresado no es válido. Por favor, introduce un correo válido."); // Mostrar una alerta indicando que el correo electrónico no es válido
    }
});
