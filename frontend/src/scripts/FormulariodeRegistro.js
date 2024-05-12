// función para validar el formulario
function validarFormulario() {
    // Obtener los valores de los campos en el formulario
    let nombre = document.getElementById('nombre');
    let telefono = document.getElementById('telefono');
    let email = document.getElementById('email');
    let contrasena = document.getElementById('contrasena');

    // validar que nombre no esté vacío
    if (nombre.trim() === '') {
        mostrarError('Ingresar nombre completo');
        return false;
    }

    // validar que la contraseña tenga al menos 7 caracteres
    if (contrasena.length < 7) {
        mostrarError('La contraseña debe tener al menos 7 caracteres.');
        return false;
    }

    // Crear un objeto JSON con los campos del usuario
    let usuario = {
        nombre: nombre,
        telefono: telefono,
        email: email,
        contrasena: contrasena
    };

    // se maneja objeto JSON (para ser enviado a un servidor por ejemplo)
    enviarDatosUsuario(usuario);

    // devolver true para enviar el formulario
    return true;
}

// función que muestra errores
function mostrarError(mensaje) {
    // Crea alerta de Bootstrap
    let alerta = '<div class="alert alert-danger alert-dismissible fade show" role="alert">' +
                 mensaje +
                 '  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>' +
                 '</div>';

    // agregar la alerta al div con el id 'alertas'
    document.getElementById('alertas').innerHTML = alerta;
}

// función para enviar los datos del usuario a un servidor
function enviarDatosUsuario(usuario) {

    // se envía  objeto JSON utilizando fetch:
    fetch('url_del_servidor', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    })
    .then(response => {
        if (response.ok) {
            console.log('Datos de usuario enviados correctamente');
        } else {
            console.error('Error al enviar datos de usuario');
        }
    })
    .catch(error => {
        console.error('Error al enviar datos de usuario:', error);
    });
}