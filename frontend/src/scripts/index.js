function mostrarProductos() {
  // Se obtienen los productos almacenados en local storage
  const productos = JSON.parse(localStorage.getItem("productos"));

  if (productos == null) {
    // Si no hay productos se inserta un mensaje en el HTML
    document.getElementById("productos").innerHTML =
      '<div class="d-flex justify-content-center">No hay productos disponibles</div>';
  } else {
    // Se obtienen solo los últimos 8 productos
    const ultimosProductos = productos.slice(
      Math.max(productos.length - 12, 0)
    );

    // Se recorren los últimos productos con un for each para generar las card
    for (let i = 0; i < ultimosProductos.length; i += 4) {
      let card = document.createElement("div");
      card.classList.add("carousel-item", i === 0 ? "active" : "");

      let row = document.createElement("div");
      row.classList.add(
        "row",
        "d-flex",
        "justify-content-center",
        "align-items-center",
        "px-3"
      );

      for (let j = 0; j < 4 && i + j < ultimosProductos.length; j++) {
        let producto = ultimosProductos[i + j];
        let col = document.createElement("div");
        col.classList.add("col", "px-1"); // Agregar la clase px-1 para reducir el espacio horizontal
        col.innerHTML = `
          <div class="card border border-2 border-black rounded-4" style="width: 250px;height:360px;">
            <div class="card-body">
              <img src="${producto.imagen}" alt="${producto.nombre}" style="width: 215px; height: 210px;" class="border border-1 rounded-4 my-2">
              <h6 class="body--font1">${producto.nombre}</h6>
              <h5 class="title--font5">$${producto.precio}.00</h5>
              <p class="body--font1 mb-2" style="overflow: hidden; text-overflow: ellipsis; display: -webkit-box; -webkit-line-clamp: 3; -webkit-box-orient: vertical;">${producto.descripcion}</p>
            </div>
          </div>
        `;
        row.appendChild(col);
      }

      card.appendChild(row);
      document.getElementById("productos").appendChild(card);
    }
  }
} // mostrarProductos

// funcion para generar las card al cargar el index.html
document.addEventListener("DOMContentLoaded", function () {
  generarProductosAleatorios();
  mostrarProductos();
});

function generarProductosAleatorios() {
  // Lista de productos ficticios
  const productos = [
    {
      nombre: "Joyería de barro",
      imagen:
        "https://casamejicu.com/cdn/shop/products/DSC_0139_Tiendaenlinea1_2048x2048.jpg?v=1597110636",
      precio: Math.floor(Math.random() * 500) + 100,
      descripcion: "Hermosa joyería de barro hecha a mano.",
    },
    {
      nombre: "Florero de barro",
      imagen:
        "https://www.pieldebarro.com/wp-content/uploads/2021/05/Ontis-5.jpg",
      precio: Math.floor(Math.random() * 500) + 100,
      descripcion: "Florero de barro elegante y duradero.",
    },
    {
      nombre: "Vela de barro",
      imagen:
        "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiZz1DyNSQ3zKvKw0B1Qort3rRZWTl3oJoCW8J09X18TUcGm6CRXIvwx_wl1Mwhl23FAtclSVlq0lX-usfy5pyA9qjkJNaw8rhv6caZ0i9o54yRU3vveQVJKn0HIT4oGSakEG-5WEeBc44/s1600/CANDLES.jpg",
      precio: Math.floor(Math.random() * 500) + 100,
      descripcion: "Vela de barro con un aroma encantador.",
    },
  ];

  // Generar 16 productos aleatorios
  const productosAleatorios = Array.from(
    { length: 16 },
    () => productos[Math.floor(Math.random() * productos.length)]
  );

  // Guardar los productos aleatorios en local storage

  const url = `https://barro-on.onrender.com/api/productos`;
  fetch(url, {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json'
      },
      body: JSON.stringify(productos)
  })
      .then(response => {
          return response.json();
      })
      .then(data => {
          console.log('Guardado', data)
      })
      .catch(error => {
          console.error(error);
      })




}
