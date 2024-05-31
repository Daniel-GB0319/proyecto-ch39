//Se obtiene el formulario mediante ID 'registroForm' Y preventDefault evita que se comporte por defecto el formulario 
//(recargar la página y envíar datos al servidor)
document.getElementById ('registroForm').addEventListener('submit', function(event){
    event.preventDefault();

    // Se limpian alertas previas seleccionando todos los elementos de clase '.alert'
    //forEach elimina cada uno de esos elementos.
    document.querySelectorAll('.alert').forEach(alert => alert.remove());

    //Obtenemos los valores del formulario usando método .trim para eliminar espacios en blanco al inicio y final de cada campo o valor.
    const nombre = document.getElementById ('nombre').value.trim();
    const telefono = document.getElementById ('telefono').value.trim();
    const email = document.getElementById ('email').value.trim();
    const contrasena = document.getElementById ('contrasena').value.trim();

    //Validamos con variable en true y un Array para el manejo de errores 
    let valid = true;
    let errors = [];

//Validación del nombre si el nombre es un elemento vacío se resalta alerta.
if(nombre === ""){
    valid = false;
    errors.push("El nombre es obligatorio.");
}
//Validación de telefono, utilizamos la expresión regular telefonoRegex para verificar que el número contenga 10 digitos
const telefonoRegex = /^\d{10}$/;
if (!telefonoRegex.test(telefono)){
    valid = false;
    errors.push('El número de telefono debe contar con 10 digitos.')
}

//Validacion de correo electrónico o email, utilizamos expresión regular emailRegez para validar el formato del email
const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
if (!emailRegex.test(email)){
        valid = false;
        errors.push('El correo electrónico no es válido.');
    }

    //Validación para Contraseña, se verifica que cumpla con al menos 7 carácteres y sin espacios
    if (contrasena.length < 7 || /\s/.test(contrasena)){
        valid = false;
        errors.push('La contaseña debe incluir al menos 7 caracteres sin espacios.');
    }

    //MANEJO DE ERRORES, si valid es false o hay errores de validación se crea una alerta usando clase de Bootstrap 'alert alert-danger mt-3'
    if (!valid) {
        errors.forEach(error => {
            const alertDiv = document.createElement('div');
            alertDiv.className = 'alert alert-danger mt-3';
            alertDiv.textContent = error;
            document.querySelector('.Form--register').prepend(alertDiv);
        });
        } else{
            //Se crea un objeto JSON si todas las validaciones son correctas mediante el objeto usuario que contiene las propiedades dadas por el mismo.
            const user = {
                nombre, 
                telefono,
                email,
                contrasena
            };
            //Se utiliza la función JSON.stringify para convertir el objeto usuario en una cadena JSON.
            console.log(JSON.stringify(user));

            //Se crean mensaje de registro exitoso mediante clases de Bootstrap
            const successAlert = document.createElement('div');
            successAlert.className = 'alert alert-success mt-3';//clase de Bootstrap
            successAlert.textContent = 'Registro completado con éxito.'
            document.querySelector('.Form--register').prepend(successAlert);

            //Limpiamos formulario
            document.getElementById('registroForm').reset();
        
        }

        const url = `https://barro-on.onrender.com/api/usuarios`;
        
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(user)
        })
            .then(response => {
                return response.json();
            })
            .then(data => {
                console.log('Guardado', data)
            })
            .catch(error => {
                console.error(error);
            })
    }); 


