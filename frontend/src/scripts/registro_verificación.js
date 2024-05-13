// Obtener el correo electrónico del campo de entrada
const email = document.getElementById("email").value;

// Constante de nodemailer
const nodemailer = require("nodemailer");

// Creamos transporter donde van los datos del remitente
const transporter = nodemailer.createTransport({
    host: "example@mail.com",
    port: 587,
    secure: false,
    auth: {
        user: email,
        pass: "tu_contraseña_aquí", // Aquí debes poner tu contraseña
    },
});

// Función para generar un código de verificación
function generarCodigo() {
    return Math.floor(100000 + Math.random() * 900000);
}

async function main() {
    try {
        const codigo = generarCodigo();
        const info = await transporter.sendMail({
            from:  `"Barro.On" <barro.on@mail.com>`,
            to: email,
            subject: "Código de verificación",
            text: `Tu código de verificación es: ${codigo}`,
            html: `<p>Tu código de verificación es: <strong>${codigo}</strong></p>`,
        });
        prompt ("Correo enviado:", info.response);
    } catch (error) {
        prompt ("Error al enviar correo:", error);
    }
}

// Constantes de validación
const valid = document.getElementById("verify");
const codigoIngresado = valid.value;

// Función para validar el código enviado con el generado
function validarCódigoIngresado(codigoGenerado, codigoIngresado) {
    return codigoGenerado === codigoIngresado;
}