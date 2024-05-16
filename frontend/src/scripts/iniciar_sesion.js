const emailInput = document.getElementById("exampleFormControlInput1");
const passwordInput = document.getElementById("exampleFormControlInput2");
const buttonContinue = document.querySelector(".button-continue"); // Cambiado getElementsByClassName a querySelector

// Boton desactivado hasta que se valide el correo
buttonContinue.disabled = true;

// Crear regex para que se cumpla el patrón
const emailRegex = /^[\w.+\-]+@[\w.+\-]+\.com$/; // Corregido el patrón de regex

// Validar Email
emailInput.addEventListener("input", (event) => {
    const email = event.target.value;
    const password = passwordInput.value.length

    if(emailRegex.test(email) && password >= 7) { // Corregido passwordInput.length a passwordInput.value.length
        buttonContinue.disabled = false;
    } else {
        buttonContinue.disabled = true;
    }
});