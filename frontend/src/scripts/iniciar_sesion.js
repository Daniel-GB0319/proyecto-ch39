//Constantes de cada elemento de html
const emailInput = document.getElementById("exampleFormControlInput1");
const buttonContinue = document.getElementById("b-continue")

//Boton desactivado hasta que se valide el correo
buttonContinue.disabled = true;

//Crear regex para que se cumpla el patrón
const emailRegex = /^[\w.+\-]+@^[\w.+\-]\.com$/;

//Validar Email
emailInput.addEventListener("input", (event) => {
    const email = event.target.value;

    if(emailRegex.test(email) === true) {
        buttonContinue.disabled = false;
        alert ("El email que ingresaste es correcto");
    } else {
        buttonContinue.disabled = true;
    }
});


