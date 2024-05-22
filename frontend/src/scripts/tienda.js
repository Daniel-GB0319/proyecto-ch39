function handleCompra(event) {
  const nombreProducto = event.target.parentNode.querySelector('.Nomdelproduct').textContent;
  const imgProducto = event.target.parentNode.querySelector('.img-item').getAttribute('src');
  const precioProducto = event.target.parentNode.querySelector('.precio-product').textContent;

  const productosComprados = JSON.parse(localStorage.getItem('productosComprados')) || [];

  productosComprados.push({
    nombre: nombreProducto,
    imagen: imgProducto,
    precio: precioProducto
  });

  localStorage.setItem('productosComprados', JSON.stringify(productosComprados));

  console.log(`Se ha comprado ${nombreProducto}`);
}

const botonesCompra = document.querySelectorAll('.btn-carro');

botonesCompra.forEach(boton => {
  boton.addEventListener('click', handleCompra);
});
