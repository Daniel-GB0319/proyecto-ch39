const emailInput = document.getElementById("exampleFormControlInput1");

const buttonContinue = document.getElementById("b-continue")

//Boton desactivado hasta que se valide el correo
buttonContinue.disabled = true;

//Crear regex para que se cumpla el patrón
const emailRegex = /^[\w.+\-]+@gmail\.com$/;

//Validar Email
emailInput.addEventListener("input", (event) => {
    const email = event.target.value;

    if(emailRegex.test(email) === true) {
        buttonContinue.disabled = false;
    } else {
        buttonContinue.disabled = true;
    }
});