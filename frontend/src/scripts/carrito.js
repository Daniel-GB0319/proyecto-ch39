const cuentaCarritoElement = document.getElementById("cuenta-carrito");

// Asignamos eventos a los botones de comprar
const botonesComprar = document.querySelectorAll("#btn-c arro");
botonesComprar.forEach(btn => {
  btn.addEventListener("click", function() {
    const producto = {
      id: this.dataset.productId, // Suponiendo que tienes un atributo 'data-product-id' en el botón con el ID del producto
      nombre: this.parentNode.querySelector('.Nomdelproduct').innerText, // Nombre del producto
      // Otros atributos del producto que quieras agregar
    };
    mercancia(producto);
  });
});

// 