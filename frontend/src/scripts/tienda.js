/*
// Función para obtener el valor de un elemento por su ID

// Event listener para función crear productos
const botonCrear = document.getElementById("btn--crearProducto");
botonCrear.addEventListener("click", crearProductos);

// Event listener para función mostrar productos consola
document.getElementById("btn--regresar")
document.addEventListener("click", mostrarProductos);

// función para obtener datos de productos desde html y almacenarlos en un json en localstorage
function crearProductos() {
  // Se obtiene valores del formulario en html usando la función getElementById
  const nombre = getElementById("input--nombre");
  const precio = getElementById("input--precio");
  const descripcion = getElementById("input--descripcion");
  const descuento = getElementById("input--descuento");
  const cantidad = getElementById("input--cantidad");
  const categoria = getElementById("select--categoria");
  const imagen = getElementById("input--imagen");

  // Se almacenan los valores obtenidos como un objeto en productos
  const producto = {
    nombre,
    precio,
    descripcion,
    descuento,
    cantidad,
    categoria,
    imagen,
  };

  // Obtenemos la lista de productos desde localStorage o creamos una si no existe
  let productos = JSON.parse(localStorage.getItem("productos")) || [];

  // Se agrega el producto a la lista de productos
  productos.push(producto);

  // Se almacenan productos en localstorage
  localStorage.setItem("productos", JSON.stringify(productos));

  alert("Producto agregado con éxito");
} // crearProductos

// función para obtener todos los objetos de productos y mostrarlos en cards
function mostrarProductos() {
  // Se obtienen los productos almacenados en local storage
  const productos = JSON.parse(localStorage.getItem("productos"));

  if (productos == null) {
    // Si no hay productos se muestra un alerta
    alert("No hay productos para mostrar");
  } else {
    // se recorre productos con un for each para generar las card
    productos.forEach((producto) => {
      let card = document.createElement("div");
      card.classList.add(
        "card",
        "border",
        "border-2",
        "border-black",
        "rounded-4"
      );
      card.style.width = "250px";
      card.style.height = "330px";
      card.innerHTML = `
          <div class="card-body">
              <img src="${producto.imagen}" alt="${producto.nombre}" style="width: 215px; height: 210px;" class="border border-1 rounded-4">
              <h6>${producto.nombre}</h6>
              <h5>$${producto.precio}</h5>
              <p>${producto.descripcion}</p>
          </div>
          `;
      document.getElementById("productos").appendChild(card);
    });
  }

  function mostrarProductosConsola() {
    const productos = JSON.parse(localStorage.getItem("productos"));
    console.log(productos);
  }
} // mostrarProductos

// Función para modificar información de un producto
function modificarProducto(
  id,
  nuvevoNombre,
  nuevoPrecio,
  nuevaDescripción,
  nuevoDescuento,
  nuevaCantidad,
  nuevaCategoria,
  nuevaImagen
) {
  //Buscar el producto por su ID
  const productos = JSON.parse(localStorage.getItem("productos"));
  const producto = productos.find((producto) => producto.id === id);
  //Si el producto existe, modificar sus propiedades
  if (producto) {
    const nombre = document.getElementById("nombre");
    const precio = document.getElementById("precio");
    const descripcion = document.getElementById("descripcion");
    const descuento = document.getElementById("descuento");
    const cantidad = document.getElementById("cantidad");
    const categoria = document.getElementById("categoria");
    const imagen = document.getElementById("imagen");
  }
  // Almacenar los productos modificados en localstorage
  localStorage.setItem("productos", JSON.stringify(productos));
  alert("Producto modificado con éxito");
} // modificarProducto

// Función para eliminar un producto
function eliminarProducto(id) {
  let productos = JSON.parse(localStorage.getItem("productos")) || [];

  //Verificar si el producto con el ID proporcionado existe en la lista
  const productoExistente = productos.find((producto) => producto.id === id);
  if (!productoExistente) {
    alert("El producto con el ID proporcionado no existe");
    return;
  }

  //Filtrar la lista de productos para eliminar el producto con el ID proporcionado
  productos = productos.filter((producto) => producto.id !== id);

  //Guardar la lista actualizada de productos en el localStogare
  localStorage.setItem("productos", JSON.stringify(productos));
  alert("Producto eliminado con éxito");
} // eliminarProducto

// funcion para mostrar contenido de prodcutos en consola
function mostrarProductosConsola() {
  const productos = JSON.parse(localStorage.getItem("productos"));
  console.log(productos);
} // mostrarProductosConsola
*/
/*
const botonesCarro = document.getElementsByClassName("btn-carro");

// Array para almacenar los textos de los botones
const textosBotones = [];

// Iterar sobre la lista de botones obtenidos
for (let i = 0; i < botonesCarro.length; i++) {
    // Obtener el texto del botón y agregarlo al array
    textosBotones.push(botonesCarro[i].textContent);
}

// Convertir el array a JSON
const jsonTextosBotones = JSON.stringify(textosBotones);

// Mostrar el JSON en la consola
console.log(jsonTextosBotones);*/


/*
// Definimos la función mercancia que manejará la compra del producto
function mercancia(producto) {
  // Aquí puedes agregar la lógica para manejar la compra del producto
  console.log('Producto comprado:', producto);
  // Por ejemplo, podrías agregar el producto al carrito
  agregarAlCarrito(producto);
}

// Función para agregar el producto al carrito (puedes personalizarla según tu lógica)
function agregarAlCarrito(producto) {
  // Aquí puedes agregar la lógica para agregar el producto al carrito
  console.log('Producto agregado al carrito:', producto);
}

// Obtener una referencia al contenedor que contiene todos los productos
const contenedorProductos = document.querySelector('.contenedor');

// Asignamos eventos a los botones de comprar
contenedorProductos.addEventListener('click', function(event) {
  // Verificar si el elemento clickeado es un botón de comprar
  if (event.target.classList.contains('btn-carro')) {
      const producto = {
          nombre: event.target.parentNode.querySelector('.Nomdelproduct').innerText,
          precio: parseFloat(event.target.parentNode.querySelector('.precio-product').innerText.replace("$", ""))
      };
      // Llamar a la función que maneja la compra, en este caso 'mercancia'
      mercancia(producto);
  }
});
*/
// Definimos la función mercancia que manejará la compra del producto
function mercancia(producto) {
    // Aquí puedes agregar la lógica para manejar la compra del producto
    console.log('Producto comprado:', producto);
    // Por ejemplo, podrías agregar el producto al carrito
    agregarAlCarrito(producto);
    // También podrías realizar otras acciones, como actualizar la visualización del carrito
    actualizarCarrito();
}

// Función para agregar el producto al carrito (puedes personalizarla según tu lógica)
function agregarAlCarrito(producto) {
    // Aquí puedes agregar la lógica para agregar el producto al carrito
    console.log('Producto agregado al carrito:', producto);
}

// Función para actualizar la visualización del carrito (puedes personalizarla según tu lógica)
function actualizarCarrito() {
    // Aquí puedes agregar la lógica para actualizar la visualización del carrito
    console.log('Actualizando la visualización del carrito...');
}

// Obtener una referencia al contenedor que contiene todos los productos
const contenedorProductos = document.querySelector('.contenedor');

// Asignamos eventos a los botones de comprar
contenedorProductos.addEventListener('click', function(event) {
    // Verificar si el elemento clickeado es un botón de comprar
    if (event.target.classList.contains('btn-carro')) {
        const producto = {
            nombre: event.target.parentNode.querySelector('.Nomdelproduct').innerText,
            precio: parseFloat(event.target.parentNode.querySelector('.precio-product').innerText.replace("$", ""))
        };
        // Llamar a la función que maneja la compra, en este caso 'mercancia'
        mercancia(producto);
    }
});
