//Se obtiene el formulario mediante ID 'registroForm' Y preventDefault evita que se comporte por defecto el formulario 
//(recargar la página y envíar datos al servidor)
document.getElementById ('perfilForm').addEventListener('submit', function(event){
    event.preventDefault();

    // Se limpian alertas previas seleccionando todos los elementos de clase '.alert'
    //forEach elimina cada uno de esos elementos.
document.querySelectorAll('.alert').forEach(alert => alert.remove());

 //Obtenemos los valores del formulario usando método .trim para eliminar espacios en blanco al inicio y final de cada campo o valor.
 const nombre = document.getElementById ('nombre').value.trim();
 const apePaterno = document.getElementById ('apePaterno').value.trim();
 const apeMaterno = document.getElementById ('apeMaterno').value.trim();
 const fecNacimiento= document.getElementById ('fecNacimiento').value.trim();
 const sexo = document.getElementById ('sexo').value.trim();
 const telefono = document.getElementById ('telefono').value.trim();

 //Validamos con variable en true y un Array para el manejo de errores 
 let valid = true;
 let errors = [];
 
//Validación del nombre si el nombre es un elemento vacío se resalta alerta.
 if(nombre === ""){
     valid = false;
     errors.push('El nombre no puede estar vacío.');
 }

 //Validación del apellido paterno si el apellido paterno es un elemento vacío se resalta alerta.
 if(apePaterno === ""){
     valid = false;
     errors.push('El apellido paterno no puede estar vacío.');
 }

 //Validación del apellido materno si el apellido materno es un elemento vacío se resalta alerta.
 if(apeMaterno === ""){
     valid = false;
     errors.push('El apellido materno no puede estar vacío.');
 }

 //Validación de la fecha de nacimiento si la fecha de nacimiento es un elemento vacío se resalta alerta.
 if(fecNacimiento === ""){
     valid = false;
     errors.push('La fecha de nacimiento no puede estar vacía.');
 }



