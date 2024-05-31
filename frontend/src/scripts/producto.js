document.addEventListener("DOMContentLoaded", function() {
  const urlParams = new URLSearchParams(window.location.search);
  const productId = urlParams.get('id');

  if (productId) {
    fetch(`http://localhost:8080/api/productos/${productId}`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
      })
      .then(product => {
        // Actualizar los detalles del producto en el DOM
        document.getElementById('product-name').textContent = product.nombre;
        document.getElementById('product-price').textContent = `$${product.precio.toFixed(2)}`;
        document.getElementById('principal-img').src = product.imageUrl || '../../public/assets/default-image.jpg';
        document.getElementById('product-description').textContent = product.descripcion;

        // Cargar dinámicamente las imágenes del producto
        const subImages = Array.from(document.querySelectorAll(".sub-image"));
        const productImages = product.imageUrls || [];

        subImages.forEach((img, index) => {
          if (productImages[index]) {
            img.src = productImages[index];
          } else {
            img.style.display = 'none';
          }
        });

        // Inicializar la imagen principal con la primera imagen pequeña
        if (subImages.length > 0) {
          updatePrincipalImage(0);
        }
      })
      .catch(error => {
        console.error('Error fetching product details:', error);
        showDefaultImage();
      });
  } else {
    showDefaultImage();
  }

  function showDefaultImage() {
    document.getElementById('principal-img').src = '../../public/assets/default-image.jpg';
    document.querySelector('.product-detail').innerHTML = '<p>Producto no encontrado.</p>';
  }

  const prevButton = document.getElementById("prev-button");
  const nextButton = document.getElementById("next-button");
  const subImages = Array.from(document.querySelectorAll(".sub-image"));
  const principalImg = document.getElementById("principal-img");

  const btnDecremento = document.querySelector('.btn-decremento');
  const btnIncremento = document.querySelector('.btn-incremento');
  const inputCantidad = document.querySelector('.input-cantidad');

  let currentIndex = 0;

  // Función para actualizar la imagen principal
  function updatePrincipalImage(index) {
    if (subImages[index]) {
      principalImg.src = subImages[index].src;
      subImages.forEach((subImg, i) => subImg.classList.toggle("active", i === index));
    }
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

  // Eventos para incrementar y decrementar la cantidad
  btnDecremento.addEventListener('click', function() {
    const currentValue = parseInt(inputCantidad.value);
    if (currentValue > 1) {
      inputCantidad.value = currentValue - 1;
    }
  });

  btnIncremento.addEventListener('click', function() {
    const currentValue = parseInt(inputCantidad.value);
    inputCantidad.value = currentValue + 1;
  });
});
