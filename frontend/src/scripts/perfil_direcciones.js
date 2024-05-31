//Se obtiene el formulario mediante ID 'registroForm' Y preventDefault evita que se comporte por defecto el formulario 
//(recargar la página y envíar datos al servidor)
document.getElementById ('direccionesForm').addEventListener('submit', function(event){
    event.preventDefault();

 // Se limpian alertas previas seleccionando todos los elementos de clase '.alert'
    //forEach elimina cada uno de esos elementos.
    document.querySelectorAll('.alert').forEach(alert => alert.remove());

//Obtenemos los valores del formulario usando método.trim para eliminar espacios en blanco al inicio y final de cada campo o valor.
    const calle = document.getElementById ('calle').value.trim();
    const exterior = document.getElementById ('exterior').value.trim();
    const interior = document.getElementById ('interior').value.trim();
    const colonia = document.getElementById ('colonia').value.trim();
    const delegacionM = document.getElementById ('delegacionM').value.trim();
    const ciudad = document.getElementById ('ciudad').value.trim();
    const entidad = document.getElementById ('entidad').value.trim();
    const codigo = document.getElementById ('codigo').value.trim();

//Validamos con variable en true y un Array para el manejo de errores
    let valid = true;
    let errors = [];

//Validación de calle si la calle es un elemento vacío se resalta alerta.
    if(calle === ""){
        valid = false;
        errors.push("La calle es obligatoria.");
    }

//Validación de exterior si el exterior es un elemento vacío se resalta alerta.
    if(exterior === ""){
        valid = false;
        errors.push("El exterior es obligatorio.");
    }

//Validación de interior si el interior es un elemento vacío se resalta alerta.
    if(interior === ""){
        valid = false;
        errors.push("El interior es obligatorio.");
    }
//Validación de colonia si la colonia es un elemento vacío se resalta alerta.
    if(colonia === ""){
        valid = false;
        errors.push("La colonia es obligatoria.");
    }

//Validación de delegacionM si la delegacionM es un elemento vacío se resalta alerta.
    if(delegacionM === ""){
        valid = false;
        errors.push("La delegacion es obligatoria.");
    }

//Validación de ciudad si la ciudad es un elemento vacío se resalta alerta.
    if(ciudad === ""){
        valid = false;
        errors.push("La ciudad es obligatoria.");
    }

//Validación de entidad si la entidad es un elemento vacío se resalta alerta.
    if(entidad === ""){
        valid = false;
        errors.push("La entidad es obligatoria.");
    }

//Validación de codigo si el codigo es un elemento vacío se resalta alerta.
    if(codigo === ""){
        valid = false;
        errors.push("El codigo es obligatorio.");
    }

   //MANEJO DE ERRORES, si valid es false o hay errores de validación se crea una alerta usando clase de Bootstrap 'alert alert-danger mt-3'
    if (!valid) {
        errors.forEach(error => {
            const alertDiv = document.createElement('div');
            alertDiv.className = 'alert alert-danger mt-3';
            alertDiv.textContent = error;
            document.querySelector('.Form--direcciones').prepend(alertDiv);
        });
    } else {
        //Se crea un objeto con los datos del formulario
        const direccion = {
            calle: calle,
            exterior: exterior,
            interior: interior,
            colonia: colonia,
            delegacionM: delegacionM,
            ciudad: ciudad,
            entidad: entidad,
            codigo: codigo
        };
//Se utiliza la función JSON.stringify para convertir el objeto direccion en una cadena JSON.
        console.log(JSON.stringify(direccion));

//Se crean mensaje de registro exitoso mediante clases de Bootstrap
        const successAlert = document.createElement('div');
        successAlert.className = 'alert alert-success mt-3';//clase de Bootstrap
        successAlert.textContent = 'Registro completado con éxito.'
        document.querySelector('.Form--direcciones').prepend(successAlert);

//Limpiamos formulario
        document.getElementById('direccionesForm').reset();
        
    }

    const url = `https://barro-on.onrender.com/api/usuarios/{idUsuario}/direcciones`;
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(direccion)
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


