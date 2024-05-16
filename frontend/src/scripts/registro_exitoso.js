//Guardar el boton en una
const botonVerificar = document.getElementsByClassName("Go--back");
botonVerificar.addEventListener("click", () =>  {
     // Mostrar prompt al usuario
    const mensajeUsuario = prompt("Bienvenido a la comunidad Barro.On");
    alert(mensajeUsuario);
});
