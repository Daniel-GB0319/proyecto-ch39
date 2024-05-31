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
document.addEventListener('click', function() {
  window.location.href = 'producto.html';
});


const botonesCompra = document.querySelectorAll('.btn-carro');

botonesCompra.forEach(boton => {
  boton.addEventListener('click', handleCompra);
});


document.addEventListener("DOMContentLoaded", function() {
  fetch("http://localhost:8080/api/productos")
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok ' + response.statusText);
      }
      return response.json();
    })
    .then(data => {
      const container = document.querySelector('.mercancia');
      container.innerHTML = ''; // Limpiar contenido existente
      data.forEach(product => {
        const productCard = `
          <div class="Product" data-id="${product.id}">
            <span class="Nomdelproduct">${product.nombre}</span>
            <span class="precio-product">$${product.precio.toFixed(2)}</span>
            <img src="${product.imageUrl || '../../public/assets/default-image.jpg'}" alt="" class="img-item">
            <input type="button" class="btn-carro" value="Comprar">
          </div>
        `;
        container.innerHTML += productCard;
      });

      // Añadir evento de clic a cada tarjeta de producto
      document.querySelectorAll('.Product').forEach(productCard => {
        productCard.addEventListener('click', function() {
          const productId = this.getAttribute('data-id');
          window.location.href = `producto.html?id=${productId}`;
        });
      });
    })
    .catch(error => console.error('Error fetching products:', error));
});
// const informacion =document.getElementById(`contenedor`);

//  informacion. addEventListener(`click`, () =>{
//   const nomdelproducto=document.getElementById(`producto`).ariaValueMax;
  
  
//   fetch(URL)
//   .then (response => response.json())
//   .then(Data => {
//     userinfo.innerHTML=`
//     <spam>nombrel del producto: ${Data.producto }</spam>
//     <spam> el precio del producto es  ${data.precio} </spam>


//     `
//   })
//   .catch(error => {
//     console.error(error)
//   })
  
//  })