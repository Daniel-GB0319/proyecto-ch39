DROP DATABASE barro_db;

CREATE DATABASE barro_db;

USE `barro_db`;

CREATE TABLE usuario
(
id_usuario INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(20) NOT NULL,
ap_paterno VARCHAR(20) NOT NULL,
ap_materno VARCHAR(20) NOT NULL,
sexo CHAR NOT NULL,
fec_nac DATE NOT NULL,
correo VARCHAR(30) NULL,
contrasena VARCHAR(128) NOT NULL,
telefono VARCHAR(15) NOT NULL,
tipo_usuario VARCHAR(10) NOT NULL,
PRIMARY KEY (id_usuario)
);

CREATE TABLE categorias
(
id_categoria INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(15) NOT NULL,
descripcion TEXT NOT NULL,
PRIMARY KEY (id_categoria)
);

CREATE TABLE carrito
(
id_carrito INT NOT NULL,
id_usuario INT NOT NULL,
PRIMARY KEY (id_carrito),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE estatus
(
id_estatus INT NOT NULL,
estado VARCHAR(20) NOT NULL,
descripcion TEXT NOT NULL,
PRIMARY KEY (id_estatus)
);

CREATE TABLE usuario_direcciones
(
id_direcciones INT NOT NULL AUTO_INCREMENT,
calle VARCHAR(20) NOT NULL,
num_ext INT NOT NULL,
num_int INT NOT NULL,
colonia VARCHAR(20) NOT NULL,
municipio VARCHAR(20) NOT NULL,
ciudad VARCHAR(20) NOT NULL,
estado VARCHAR(20) NOT NULL,
cp INT NOT NULL,
id_usuario INT NOT NULL,
PRIMARY KEY (id_direcciones, id_usuario),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE usuario_metodos_pago
(
id_metodos_pago INT NOT NULL AUTO_INCREMENT,
tipo VARCHAR(10) NOT NULL,
numero_tarjeta VARCHAR(16) NOT NULL,
mes INT NOT NULL,
anio INT NOT NULL,
cvv INT NOT NULL,
titular VARCHAR(50) NOT NULL,
dir_facturacion TEXT NOT NULL,
id_usuario INT NOT NULL,
PRIMARY KEY (id_metodos_pago, id_usuario),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE producto
(
id_producto INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(20) NOT NULL,
descripcion TEXT NOT NULL,
precio DECIMAL(10,2) NOT NULL,
cantidad INT NOT NULL,
descuento INT,
id_categoria INT NOT NULL,
id_usuario INT NOT NULL,
PRIMARY KEY (id_producto),
FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE pedido
(
id_pedido INT NOT NULL AUTO_INCREMENT,
fecha DATETIME NOT NULL,
costo_total DECIMAL(10,2) NOT NULL,
id_usuario INT NOT NULL,
id_estatus INT NOT NULL,
PRIMARY KEY (id_pedido),
FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
FOREIGN KEY (id_estatus) REFERENCES estatus(id_estatus)
);

CREATE TABLE pedido_producto
(
id_pedido INT NOT NULL,
id_producto INT NOT NULL,
PRIMARY KEY (id_pedido, id_producto),
FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE carrito_producto
(
id_carrito INT NOT NULL,
id_producto INT NOT NULL,
PRIMARY KEY (id_carrito, id_producto),
FOREIGN KEY (id_carrito) REFERENCES carrito(id_carrito),
FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE producto_imagen
(
id_imagen INT NOT NULL,
id_producto INT NOT NULL,
imagen_url VARCHAR(2083)  NOT NULL,
PRIMARY KEY (id_imagen, id_producto),
FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

