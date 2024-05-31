function mostrarInventario(){
    // productos guardados de localStorage
    const productos = JSON.parse(localStorage.getItem("productos"));


    if (productos==null){
        document.getElementsByClassName("inventario").innerHTML=
        // si no hay inventario mostrara el mensaje "El inventario esta vacio"
        `
        <div class="container.fluid d-flex justify-content-center">
        <h5> El inventario está vacio</h5>
        </div>
        `
    }
    else {
        
    }
}

document.addEventListener("DOMContentLoaded",function() { 
    productosfalsosAleatorios();
    mostrarInventario();
}
);




function productosfalsosAleatorios(){
    //Lista de productos falsos
    const productos =[
    {
        nombre:"Jarron",
        Imagen:"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQgByBT5IiAT_a2x9pUVb4VMoOrlzHH7Jrzj-HB5jzHlR4lNLMS",
        precio:Math.floor(Math.random() * 500) + 100,
        descripcion:"cosas al zas de objetos al azar en momentos al azar y flores de hazar",
    },
    {
        nombre:"Collar",
        Imagen:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRF1IwK6-SxM83UpFVY6WtUZxXx-phss_gAUfdKbkTfau6VWVkt",
        precio:Math.floor(Math.random() * 500) + 100,
        descripcion:"cosas al zas de objetos al azar en momentos al azar y flores de hazar",
    },
    ];

    //guardar los productos aleatorios en ls
    
    const url = `https://barro-on.onrender.com/api/productos`;
    fetch(url, {
        method: 'GET',
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