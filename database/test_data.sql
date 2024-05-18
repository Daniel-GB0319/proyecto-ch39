INSERT INTO usuario (nombre, ap_paterno, ap_materno, sexo, fec_nac, correo, contrasena, telefono, tipo_usuario)
VALUES
    ('Juan', 'Pérez', 'García', 'M', '1990-05-15', 'juan@example.com', 'contraseña123', '555-123-4567', 'cliente'),
    ('María', 'López', 'Martínez', 'F', '1985-08-20', 'maria@example.com', 'clave456', '555-987-6543', 'vendedor'),
    ('Pedro', 'González', 'Ramírez', 'M', '1988-03-10', 'pedro@example.com', 'clave789', '555-555-5555', 'cliente'),
    ('Ana', 'Rodríguez', 'Sánchez', 'F', '1992-11-25', 'ana@example.com', 'clave987', '555-111-2222', 'cliente');

INSERT INTO categorias (nombre, descripcion)
VALUES
    ('Floreros', 'Floreros artesanales'),
    ('Velas', 'Veladoras hechas a mano'),
    ('Joyeria', 'Con materiales reciclados'),
    ('Arte-Objeto', 'Aqui va descripcion');

INSERT INTO carrito (id_carrito, id_usuario)
VALUES
    (1, 1), 
    (3, 3), 
    (4, 4); 

INSERT INTO estatus (estado, descripcion)
VALUES
    ('Cancelado', 'El pedido ha sido cancelado por el cliente.'),
    ('Enviado', 'El pedido ha sido enviado y está en tránsito.'),
    ('Entregado', 'El pedido ha sido entregado al cliente.'),
    ('Devuelto', 'El pedido ha sido devuelto por el cliente.');

INSERT INTO usuario_direcciones (calle, num_ext, num_int, colonia, municipio, ciudad, estado, cp, id_usuario)
VALUES
    ('Av. Principal', 123, NULL, 'Centro', 'Ciudad de México', 'CDMX', 'CDMX', 12345, 1),
    ('Calle Secundaria', 456, 101, 'Col. Moderna', 'Guadalajara', 'Jalisco', 'Guadalajara', 54321, 2),
    ('Avenida Central', 789, NULL, 'Zona Norte', 'Monterrey', 'Nuevo León', 'Monterrey', 67890, 3),
    ('Calle Principal', 987, 202, 'Barrio Antiguo', 'Saltillo', 'Coahuila', 'Saltillo', 76543, 4);

INSERT INTO usuario_metodos_pago (tipo, numero_tarjeta, mes, anio, cvv, titular, dir_facturacion, id_usuario)
VALUES
    ('Debito/Crédito', '1234567890123456', 12, 2025, 123, 'Juan Pérez', 'Av. Principal 123', 1),
    ('Mercado Pago', '9876543210987654', NULL, NULL, NULL, 'María López', 'Calle Secundaria 456', 2),
    ('Debito/Crédito', '5678901234567890', 6, 2024, 456, 'Pedro González', 'Avenida Central 789', 3),
    ('PayPal', '1111222233334444', NULL, NULL, NULL, 'Ana Rodríguez', 'Calle Principal 987', 4);

INSERT INTO producto (nombre, descripcion, precio, cantidad, descuento, id_categoria, id_usuario)
VALUES
    ('Jarra de barro', 'Pieza de cerámica tradicional para servir líquidos.', 49.99, 20, NULL, 1, 1),
    ('Plato de alfarería', 'Plato hecho a mano con detalles en relieve.', 29.99, 30, NULL, 2, 2),
    ('Taza de barro', 'Taza rústica para disfrutar de bebidas calientes.', 19.99, 50, NULL, 1, 3),
    ('Maceta de cerámica', 'Maceta decorativa para plantas de interior.', 39.99, 15, NULL, 3, 4),
    ('Figura de barro', 'Escultura artesanal con motivos tradicionales.', 59.99, 10, NULL, 4, 1),
    ('Candelabro de alfarería', 'Candelabro de estilo mexicano para velas.', 24.99, 25, NULL, 2, 2),
    ('Plato hondo de barro', 'Plato profundo ideal para sopas y guisos.', 34.99, 40, NULL, 1, 3),
    ('Florero de cerámica', 'Florero decorativo para arreglos florales.', 44.99, 18, NULL, 3, 4);
