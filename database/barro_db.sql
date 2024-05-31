-- DROP DATABASE barro_db;

CREATE DATABASE IF NOT EXISTS barro_db;

-- Modificar base de datos existente para usar UTF-8
ALTER DATABASE barro_db CHARACTER SET utf8 COLLATE utf8_general_ci;

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
contrasena CHAR(64) NOT NULL,
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
id_carrito INT NOT NULL AUTO_INCREMENT,
id_cliente INT NOT NULL,
PRIMARY KEY (id_carrito),
FOREIGN KEY (id_cliente) REFERENCES usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE estatus_pedido
(
id_estado INT AUTO_INCREMENT NOT NULL,
nombre VARCHAR(30) NOT NULL,
descripcion TEXT NOT NULL,
PRIMARY KEY (id_estado)
);

CREATE TABLE usuario_direcciones
(
id_direcciones INT NOT NULL AUTO_INCREMENT,
calle VARCHAR(50) NOT NULL,
num_ext INT NOT NULL,
num_int INT,
colonia VARCHAR(50) NOT NULL,
municipio VARCHAR(50) NOT NULL,
ciudad VARCHAR(50) NOT NULL,
estado VARCHAR(50) NOT NULL,
cp VARCHAR(5) NOT NULL,
id_cliente INT NOT NULL,
PRIMARY KEY (id_direcciones, id_cliente),
FOREIGN KEY (id_cliente) REFERENCES usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE usuario_metodos_pago
(
id_metodos_pago INT NOT NULL AUTO_INCREMENT,
tipo VARCHAR(20) NOT NULL,
numero_tarjeta VARCHAR(16) NOT NULL,
mes VARCHAR(2),
anio VARCHAR(2),
cvv VARCHAR(3),
titular VARCHAR(50) NOT NULL,
dir_facturacion TEXT NOT NULL,
id_cliente INT NOT NULL,
PRIMARY KEY (id_metodos_pago, id_cliente),
FOREIGN KEY (id_cliente) REFERENCES usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE producto
(
id_producto INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(30) NOT NULL,
descripcion TEXT NOT NULL,
precio DECIMAL(10,2) NOT NULL,
cantidad INT NOT NULL,
descuento INT,
id_categoria INT NOT NULL,
id_vendedor INT NOT NULL,
PRIMARY KEY (id_producto),
FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
FOREIGN KEY (id_vendedor) REFERENCES usuario(id_usuario) ON DELETE CASCADE
);

CREATE TABLE pedido
(
id_pedido INT NOT NULL AUTO_INCREMENT,
fecha DATETIME NOT NULL,
costo_total DECIMAL(10,2) NOT NULL,
id_cliente INT NOT NULL,
estado_pedido INT NOT NULL,
PRIMARY KEY (id_pedido),
FOREIGN KEY (id_cliente) REFERENCES usuario(id_usuario) ON DELETE CASCADE,
FOREIGN KEY (estado_pedido) REFERENCES estatus_pedido(id_estado)
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
FOREIGN KEY (id_carrito) REFERENCES carrito(id_carrito) ON DELETE CASCADE,
FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE producto_imagen
(
id_imagen INT NOT NULL AUTO_INCREMENT,
id_producto INT NOT NULL,
imagen_url VARCHAR(2083)  NOT NULL,
PRIMARY KEY (id_imagen, id_producto),
FOREIGN KEY (id_producto) REFERENCES producto(id_producto) ON DELETE CASCADE
);

-- TRIGGERS
-- Genera carrito a cada cliente nuevo
DELIMITER //
CREATE TRIGGER after_generar_carrito AFTER INSERT ON usuario 
FOR EACH ROW
BEGIN
    IF NEW.tipo_usuario = 'cliente'
THEN
    INSERT INTO carrito(id_cliente) VALUES (NEW.id_usuario);
    END IF;
END;//
DELIMITER ;
