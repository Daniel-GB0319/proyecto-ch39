//Se obtiene el formulario mediante ID 'registroForm' Y preventDefault evita que se comporte por defecto el formulario 
//(recargar la página y envíar datos al servidor)
document.getElementById('perfilForm').addEventListener('submit', function (event) {
    event.preventDefault();

    // Se limpian alertas previas seleccionando todos los elementos de clase '.alert'
    //forEach elimina cada uno de esos elementos.
    document.querySelectorAll('.alert').forEach(alert => alert.remove());

    //Obtenemos los valores del formulario usando método .trim para eliminar espacios en blanco al inicio y final de cada campo o valor.
    const nombre = document.getElementById('nombre').value.trim();
    const apePaterno = document.getElementById('apePaterno').value.trim();
    const apeMaterno = document.getElementById('apeMaterno').value.trim();
    const fecNacimiento = document.getElementById('fecNacimiento').value.trim();
    const sexo = document.getElementById('sexo').value;
    const telefono = document.getElementById('telefono').value.trim();


// Añade console.log() para imprimir los valores de los campos antes de realizar las validaciones solo para verificar que los ha optenido
//console.log('Nombre:', nombre);
//console.log('Apellido Paterno:', apePaterno);
//console.log('Apellido Materno:', apeMaterno);
//console.log('Fecha de Nacimiento:', fecNacimiento);
//console.log('Sexo:', sexo);
//console.log('Teléfono:', telefono);

    //Validamos con variable en true y un Array para el manejo de errores 
    let valid = true;
    let errors = [];

    //Validación del nombre si el nombre es un elemento vacío se resalta alerta.
    if (nombre === "") {
        valid = false;
        errors.push('El nombre no puede estar vacío.');
    }

    //Validación del apellido paterno si el apellido paterno es un elemento vacío se resalta alerta.
    if (apePaterno === "") {
        valid = false;
        errors.push('El apellido paterno no puede estar vacío.');
    }

    //Validación del apellido materno si el apellido materno es un elemento vacío se resalta alerta.
    if (apeMaterno === "") {
        valid = false;
        errors.push('El apellido materno no puede estar vacío.');
    }

//Validación de fecha de nacimiento
const fechaNacimientoRegex = /^\d{4}-\d{2}-\d{2}$/;
if (!fechaNacimientoRegex.test(fecNacimiento)) {
    valid = false;
    errors.push('La fecha de nacimiento no es válida.');
}


    //Validación de sexo
    if (sexo !== 'Femenino' && sexo !== 'Masculino') {
        valid = false;
        errors.push('El sexo debe ser "Femenino" o "Masculino".');
    }

    //Validación de teléfono
    const telefonoRegex = /^\d{10}$/;
    if (!telefonoRegex.test(telefono)) {
        valid = false;
        errors.push('El número de teléfono debe contener 10 dígitos.');
    }

    //MANEJO DE ERRORES, si valid es false o hay errores de validación se crea una alerta usando clase de Bootstrap 'alert alert-danger mt-3'
    if (!valid) {
        errors.forEach(error => {
            const alertDiv = document.createElement('div');
            alertDiv.className = 'alert alert-danger mt-3';
            alertDiv.textContent = error;
            document.querySelector('.Form--perfil').prepend(alertDiv);
        });
        } else{
            //Se crea un objeto JSON si todas las validaciones son correctas mediante el objeto usuario que contiene las propiedades dadas por el mismo.
            const user = {
                nombre,
                apePaterno,
                apeMaterno,
                fecNacimiento,
                sexo,
                telefono
            };
            //Se utiliza la función JSON.stringify para convertir el objeto usuario en una cadena JSON.
            console.log(JSON.stringify(user));

            //Se crean mensaje de registro exitoso mediante clases de Bootstrap
            const successAlert = document.createElement('div');
            successAlert.className = 'alert alert-success mt-3';//clase de Bootstrap
            successAlert.textContent = 'Registro completado con éxito.'
            document.querySelector('.Form--perfil').prepend(successAlert);

            //Limpiamos formulario
            document.getElementById('perfilForm').reset();
               }

        const url = "https://barro-on.onrender.com/api/usuarios";

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