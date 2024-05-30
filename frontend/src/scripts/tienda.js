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


const inormacion =document.getElementById(`contenedor`);
 informacion. addEventListener(`click`, () =>{
  const nomdelproducto=document.getElementById(`producto`).ariaValueMax;
  
  
  fetch(URL)
  .then (response => response.json())
  .then(Data => {
    userinfo.innerHTML=`
    <spam>nombrel del producto: ${Data.producto }</spam>
    <spam> el precio del producto es  ${data.precio} </spam>


    `
  })
  .catch(error => {
    console.error(error)
  })
  
 })