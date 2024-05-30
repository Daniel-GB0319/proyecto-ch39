
//¿Cómo funciona?
// El siguiente codigo porporciona funciones para actualizar la imagen principal, a partir de las pequeñas imagenes.
document.addEventListener("DOMContentLoaded", function() {
  const prevButton = document.getElementById("prev-button");
  const nextButton = document.getElementById("next-button");
  const subImages = Array.from(document.querySelectorAll(".sub-image"));
  const principalImg = document.getElementById("principal-img");

  //Ahora las variables para incrementar y descemrentar el numero de producto para agregar
  const btnDecremento = document.querySelector('.btn-decremento');
  const btnIncremento = document.querySelector('.btn-incremento');
  const inputCantidad = document.querySelector('.input-cantidad');


  let currentIndex = 0;

  // Función para actualizar la imagen principal
  function updatePrincipalImage(index) {
      principalImg.src = subImages[index].src;
      subImages.forEach((subImg, i) => subImg.classList.toggle("active", i === index));
  }

  // Evento para los botones de navegación
  prevButton.addEventListener("click", function() {
      currentIndex = (currentIndex - 1 + subImages.length) % subImages.length;
      updatePrincipalImage(currentIndex);
  });

  nextButton.addEventListener("click", function() {
      currentIndex = (currentIndex + 1) % subImages.length;
      updatePrincipalImage(currentIndex);
  });

  // Evento para las imágenes pequeñas
  subImages.forEach((img, index) => {
      img.addEventListener("click", function() {
          currentIndex = index;
          updatePrincipalImage(index);
      });
  });

  // Cargar dinámicamente las imágenes del producto (simulación)
  const productImages = [
      "https://via.placeholder.com/150",
      "https://via.placeholder.com/300",
      "https://via.placeholder.com/200",
      "https://via.placeholder.com/250",
      "https://via.placeholder.com/350",
      "https://via.placeholder.com/400",
      "https://via.placeholder.com/450",
      "https://via.placeholder.com/500"
  ];

  // Insertar imágenes del producto
  subImages.forEach((img, index) => {
      if (productImages[index]) {
          img.src = productImages[index];
      }
  });

  // Inicializar la imagen principal con la primera imagen pequeña
  if (subImages.length > 0) {
      updatePrincipalImage(0);
  }

  // Lógica para los botones de "Comprar" y "Agregar a carrito"
  const comprarButton = document.querySelector(".button--change");
  const agregarCarritoButton = document.querySelector(".button--change2");

  comprarButton.addEventListener("click", function() {
      // Lógica para "Comprar"
      const productId = 1; // Este ID debería ser dinámico basado en el producto actual
      const quantity = 1; // Cantidad deseada

      // Simulación de la operación de compra
      console.log(`Comprando producto ID: ${productId}, Cantidad: ${quantity}`);

      // Aquí se podría realizar una llamada a la API para procesar la compra
      // Ejemplo: fetch('/api/comprar', { method: 'POST', body: JSON.stringify({ productId, quantity }) });
  });

  agregarCarritoButton.addEventListener("click", function() {
      // Lógica para "Agregar a carrito"
      const productId = 1; // Este ID debería ser dinámico basado en el producto actual
      const quantity = 1; // Cantidad deseada

      // Simulación de agregar al carrito
      console.log(`Agregando al carrito producto ID: ${productId}, Cantidad: ${quantity}`);

      // Aquí se podría realizar una llamada a la API para agregar al carrito
      // Ejemplo: fetch('/api/agregar-carrito', { method: 'POST', body: JSON.stringify({ productId, quantity }) });
  });
  // Ahora las funciones para incrementar y decrementar la cantidad de productos para comprar o agragar al carrito
  btnDecremento.addEventListener('click', function() {
    decrementarCantidad();
  });

  btnIncremento.addEventListener('click', function() {
    incrementarCantidad();
  });

  function decrementarCantidad() {
    let cantidad = parseInt(inputCantidad.value);
    if (cantidad > 1) {
      cantidad--;
      inputCantidad.value = cantidad;
    }
  }

  function incrementarCantidad() {
    let cantidad = parseInt(inputCantidad.value);
    const stock = parseInt(document.querySelector('.cantidad').textContent);
    if (cantidad < stock) {
      cantidad++;
      inputCantidad.value = cantidad;
    }
  }

});

