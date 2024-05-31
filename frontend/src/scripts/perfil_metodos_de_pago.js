document.getElementById('metodosPago').addEventListener('submit', function(event) {
    event.preventDefault();

    document.querySelectorAll('.alert').forEach(alert => alert.remove());

    const tarjeta = document.getElementById('input--tipo').value.trim();
    const numeroTarjeta = document.getElementById('input--numerotarjeta').value.trim();
    const mes = document.getElementById('input--mes').value.trim();
    const año = document.getElementById('input--año').value.trim();
    const titular = document.getElementById('input--titular').value.trim();

    let valid = true;
    let errors = [];

    if(tarjeta === ""){
        valid = false;
        errors.push("El tipo de tarjeta es obligatorio.");
    }

    const numeroTarjetaRegex = /^\d{16}$/;
    if (!numeroTarjetaRegex.test(numeroTarjeta)) {
        valid = false;
        errors.push("El número de tarjeta debe tener 16 dígitos.");
    }

    if (mes === "") {
        valid = false;
        errors.push("El mes de caducidad es obligatorio.");
    }

    if (año === "") {
        valid = false;
        errors.push("El año de caducidad es obligatorio.");
    }

    if (titular === "") {
        valid = false;
        errors.push("El titular de la tarjeta es obligatorio.");
    }

    if (!valid) {
        errors.forEach(error => {
            const alertDiv = document.createElement('div');
            alertDiv.className = 'alert alert-danger mt-3';
            alertDiv.textContent = error;
            document.querySelector('.Card--profile').prepend(alertDiv);
        });
    } else {
        const tarjetaInfo = {
            tarjeta: tarjeta,
            numeroTarjeta: numeroTarjeta,
            mes: mes,
            año: año,
            titular: titular
        };

        console.log(JSON.stringify(tarjetaInfo));

        document.getElementById('metodosPago').reset();
    }

    const url = `https://barro-on.onrender.com/api/usuarios/{idUsuario}/metodosPago`;
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(tarjetaInfo)
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

