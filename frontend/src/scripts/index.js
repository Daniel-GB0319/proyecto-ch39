// JavaScript
function mostrarProductos() {
  // Se obtienen los productos almacenados en local storage
  const productos = JSON.parse(localStorage.getItem("productos"));

  if (productos == null) {
    // Si no hay productos se inserta un mensaje en el HTML
    document.getElementById("productos").innerHTML =
      '<div class="d-flex justify-content-center">No hay productos disponibles</div>';
  } else {
    // Se obtienen solo los últimos 8 productos
    const ultimosProductos = productos.slice(Math.max(productos.length - 8, 0));

    // Se recorren los últimos productos con un for each para generar las card
    ultimosProductos.forEach((producto, index) => {
      let card = document.createElement("div");
      card.classList.add("carousel-item", index === 0 ? "active" : "");
      card.innerHTML = `
          <div class="row">
            <div class="col">
              <div class="card border border-2 border-black rounded-4" style="width: 250px;height:330px;">
                <div class="card-body">
                  <img src="${producto.imagen}" alt="${producto.nombre}" style="width: 215px; height: 210px;" class="border border-1 rounded-4">
                  <h6>${producto.nombre}</h6>
                  <h5>$${producto.precio}</h5>
                  <p>${producto.descripcion}</p>
                </div>
              </div>
            </div>
          </div>
        `;
      document.getElementById("productos").appendChild(card);
    });
  }
} // mostrarProductos

// funcion para generar las card al cargar el index.html
document.addEventListener("DOMContentLoaded", function () {
  mostrarProductos();
});
