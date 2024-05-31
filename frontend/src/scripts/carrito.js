
function mostrarProductosEnCarrito() {
  const carritoElemento = document.getElementById('carrito');
  const productosGuardados = JSON.parse(localStorage.getItem('productosComprados')) || [];

  carritoElemento.innerHTML = '';

  productosGuardados.forEach((producto, index) => {
    const li = document.createElement('li');
    const img = document.createElement('img');
    const nombreProducto = document.createElement('span');
    const precioProducto = document.createElement('span');
    const cantidadProducto = document.createElement('select');
    const botones = document.createElement('div');
    const productoContainer = document.createElement('div'); 

    li.classList.add('producto-carrito');
    img.classList.add('contorno-cafe');
    botones.classList.add('botones');
    productoContainer.classList.add('producto-container');

    img.src = producto.imagen;
    img.alt = 'Imagen del producto';
    nombreProducto.textContent = producto.nombre;
    precioProducto.textContent = producto.precio;

    for (let i = 1; i <= 10; i++) {
      const opcion = document.createElement('option');
      opcion.value = i;
      opcion.textContent = i;
      cantidadProducto.appendChild(opcion);
    }

    cantidadProducto.addEventListener('change', function(event) {
      const cantidadSeleccionada = event.target.value;
      console.log(`Cantidad seleccionada para ${producto.nombre}: ${cantidadSeleccionada}`);
    });

    const botonEliminar = document.createElement('button');
    botonEliminar.textContent = 'Eliminar';
    botonEliminar.addEventListener('click', function() {
      productosGuardados.splice(index, 1);
      localStorage.setItem('productosComprados', JSON.stringify(productosGuardados));
      mostrarProductosEnCarrito(); 
    });

    botones.appendChild(botonEliminar);

    productoContainer.appendChild(nombreProducto);
    productoContainer.appendChild(precioProducto);
    productoContainer.appendChild(cantidadProducto);
    productoContainer.appendChild(botones);

    li.appendChild(img);
    li.appendChild(productoContainer);
    carritoElemento.appendChild(li);
  });

  

}

mostrarProductosEnCarrito();
