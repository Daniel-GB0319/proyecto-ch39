USE `barro_db`;

INSERT INTO usuario (nombre, ap_paterno, ap_materno, sexo, fec_nac, correo, contrasena, telefono, tipo_usuario)
VALUES
    ('Roberto', 'Mendoza', 'Vega', 'M', '1986-02-14', 'roberto.mendoza@example.com', 'Roberto86', '555-234-5678', 'cliente'),
    ('Liliana', 'Ortiz', 'Reyes', 'F', '1990-07-19', 'liliana.ortiz@example.com', 'Lili90', '555-345-6789', 'vendedor'),
    ('Javier', 'Guzmán', 'Rojas', 'M', '1985-11-23', 'javier.guzman@example.com', 'Javier85', '555-456-7890', 'cliente'),
    ('Gabriela', 'Medina', 'Cortez', 'F', '1992-04-30', 'gabriela.medina@example.com', 'Gaby92', '555-567-8901', 'cliente'),
    ('Ricardo', 'Castillo', 'Herrera', 'M', '1987-09-15', 'ricardo.castillo@example.com', 'Ricky87', '555-678-9012', 'cliente'),
    ('Patricia', 'Romero', 'Guerrero', 'F', '1989-12-20', 'patricia.romero@example.com', 'Patty89', '555-789-0123', 'vendedor'),
    ('Luis', 'Torres', 'Alvarez', 'M', '1991-05-25', 'luis.torres@example.com', 'Luis91', '555-890-1234', 'cliente'),
    ('Sofía', 'Ruiz', 'García', 'F', '1993-08-30', 'sofia.ruiz@example.com', 'Sofia93', '555-901-2345', 'cliente'),
    ('Daniel', 'Moreno', 'Mendez', 'M', '1988-01-10', 'daniel.moreno@example.com', 'Danny88', '555-012-3456', 'cliente'),
    ('Mariana', 'Jimenez', 'Morales', 'F', '1990-06-15', 'mariana.jimenez@example.com', 'Mari90', '555-123-4567', 'vendedor'),
    ('Alejandro', 'Perez', 'Castro', 'M', '1986-03-20', 'alejandro.perez@example.com', 'Alex86', '555-234-5678', 'cliente'),
    ('Fernanda', 'Ramos', 'Guerra', 'F', '1992-10-25', 'fernanda.ramos@example.com', 'Fer92', '555-345-6789', 'cliente'),
    ('José', 'Hernandez', 'Torres', 'M', '1987-05-30', 'jose.hernandez@example.com', 'Jose87', '555-456-7890', 'cliente'),
    ('Andrea', 'Martinez', 'Peña', 'F', '1989-02-10', 'andrea.martinez@example.com', 'Andrea89', '555-567-8901', 'vendedor'),
    ('David', 'Lopez', 'Sanchez', 'M', '1990-08-15', 'david.lopez@example.com', 'David90', '555-678-9012', 'cliente');


INSERT INTO categorias (nombre, descripcion)
VALUES
    ('Floreros', 'Floreros artesanales'),
    ('Velas', 'Veladoras hechas a mano'),
    ('Joyeria', 'Con materiales reciclados'),
    ('Arte-Objeto', 'Aqui va descripcion');

   
INSERT INTO estatus_pedido (nombre, descripcion)
VALUES
    ('Cancelado', 'El pedido ha sido cancelado por el cliente.'),
    ('Enviado', 'El pedido ha sido enviado y está en tránsito.'),
    ('Entregado', 'El pedido ha sido entregado al cliente.'),
    ('Devuelto', 'El pedido ha sido devuelto por el cliente.'),
    ('Pendiente', 'El pedido ha sido realizado pero aún no ha sido procesado.'),
    ('Procesando', 'El pedido está siendo preparado para su envío.'),
    ('En espera de pago', 'El pedido ha sido realizado pero está esperando la confirmación del pago.'),
    ('Pago confirmado', 'El pago del pedido ha sido confirmado y está listo para ser procesado.'),
    ('En espera de recolección', 'El pedido está listo para ser recogido por el servicio de mensajería.'),
    ('Retrasado', 'El pedido está experimentando un retraso en el envío o la entrega.'),
    ('Entrega fallida', 'Hubo un intento de entregar el pedido pero falló.'),
    ('Reembolsado', 'El pedido ha sido reembolsado al cliente.'),
    ('Cambio solicitado', 'El cliente ha solicitado un cambio de producto.'),
    ('Devolución solicitada', 'El cliente ha solicitado la devolución del producto.');


INSERT INTO usuario_direcciones (calle, num_ext, num_int, colonia, municipio, ciudad, estado, cp, id_cliente)
VALUES
    ('Av. Insurgentes', 1234, NULL, 'Nápoles', 'Benito Juárez', 'Ciudad de México', 'CDMX', '03810', 1),
    ('Calle López Cotilla', 4567, 101, 'Americana', 'Guadalajara', 'Guadalajara', 'Jalisco', '44160', 2),
    ('Paseo de los Leones', 7890, NULL, 'Cumbres', 'Monterrey', 'Monterrey', 'Nuevo León', '64610', 3),
    ('Blvd. Venustiano Carranza', 9876, 202, 'República', 'Saltillo', 'Saltillo', 'Coahuila', '25280', 4),
    ('Calle Madero', 1112, NULL, 'Centro', 'Torreón', 'Torreón', 'Coahuila', '27000', 5),
    ('Av. Universidad', 1314, 303, 'Del Valle', 'San Pedro Garza García', 'San Pedro Garza García', 'Nuevo León', '66220', 6),
    ('Paseo de la Reforma', 1516, NULL, 'Cuauhtémoc', 'Ciudad de México', 'CDMX', 'CDMX', '06500', 7),
    ('Calle Independencia', 1718, 404, 'Centro', 'Guadalajara', 'Guadalajara', 'Jalisco', '44100', 8),
    ('Blvd. Miguel de la Madrid', 1920, NULL, 'Manzanillo', 'Manzanillo', 'Colima', 'Colima', '28239', 9),
    ('Calle Zaragoza', 2122, 505, 'Centro', 'Veracruz', 'Veracruz', 'Veracruz', '91700', 10);


   
INSERT INTO usuario_metodos_pago (tipo, numero_tarjeta, mes, anio, cvv, titular, dir_facturacion, id_cliente)
VALUES
    ('Debito/Crédito', '2345678901234567', '11', '26', '234', 'Roberto Mendoza', 'Calle Secundaria 321', 5),
    ('Mercado Pago', '8765432109876543', NULL, NULL, NULL, 'Roberto Mendoza', 'Calle Secundaria 321', 5),
    ('Debito/Crédito', '7890123456789012', '05', '25', '789', 'Liliana Ortiz', 'Avenida Central 654', 6),
    ('PayPal', '2222333344445555', NULL, NULL, NULL, 'Liliana Ortiz', 'Avenida Central 654', 6),
    ('Debito/Crédito', '3456789012345678', '10', '27', '345', 'Javier Guzmán', 'Calle Principal 432', 7),
    ('Mercado Pago', '7654321098765432', NULL, NULL, NULL, 'Javier Guzmán', 'Calle Principal 432', 7),
    ('Debito/Crédito', '8901234567890123', '04', '26', '890', 'Gabriela Medina', 'Avenida Secundaria 765', 8),
    ('PayPal', '3333444455556666', NULL, NULL, NULL, 'Gabriela Medina', 'Avenida Secundaria 765', 8),
    ('Debito/Crédito', '4567890123456789', '09', '28', '456', 'Ricardo Castillo', 'Calle Central 543', 9),
    ('Mercado Pago', '6543210987654321', NULL, NULL, NULL, 'Ricardo Castillo', 'Calle Central 543', 9),
    ('Debito/Crédito', '9012345678901234', '03', '27', '901', 'Patricia Romero', 'Avenida Principal 876', 10),
    ('PayPal', '4444555566667777', NULL, NULL, NULL, 'Patricia Romero', 'Avenida Principal 876', 10),
    ('Debito/Crédito', '5678901234567890', '08', '29', '567', 'Luis Torres', 'Calle Secundaria 654', 11),
    ('Mercado Pago', '5432109876543210', NULL, NULL, NULL, 'Luis Torres', 'Calle Secundaria 654', 11),
    ('Debito/Crédito', '6789012345678901', '07', '30', '678', 'Sofía Ruiz', 'Avenida Central 987', 12),
    ('PayPal', '5555666677778888', NULL, NULL, NULL, 'Sofía Ruiz', 'Avenida Central 987', 12),
    ('Debito/Crédito', '7890123456789012', '06', '31', '789', 'Daniel Moreno', 'Calle Principal 765', 13),
    ('Mercado Pago', '4321098765432109', NULL, NULL, NULL, 'Daniel Moreno', 'Calle Principal 765', 13),
    ('Debito/Crédito', '8901234567890123', '05', '32', '890', 'Mariana Jimenez', 'Avenida Secundaria 098', 14),
    ('PayPal', '6666777788889999', NULL, NULL, NULL, 'Mariana Jimenez', 'Avenida Secundaria 098', 14),
    ('Debito/Crédito', '9012345678901234', '04', '33', '901', 'Alejandro Perez', 'Calle Central 876', 15),
    ('Mercado Pago', '3210987654321098', NULL, NULL, NULL, 'Alejandro Perez', 'Calle Central 876', 15);


INSERT INTO producto (nombre, descripcion, precio, cantidad, descuento, id_categoria, id_vendedor)
VALUES
    ('Jarra de barro', 'Pieza de cerámica tradicional para servir líquidos.', 49.99, 20, NULL, 1, 1),
    ('Plato de alfarería', 'Plato hecho a mano con detalles en relieve.', 29.99, 30, NULL, 2, 2),
    ('Taza de barro', 'Taza rústica para disfrutar de bebidas calientes.', 19.99, 50, NULL, 1, 3),
    ('Maceta de cerámica', 'Maceta decorativa para plantas de interior.', 39.99, 15, NULL, 3, 4),
    ('Figura de barro', 'Escultura artesanal con motivos tradicionales.', 59.99, 10, NULL, 4, 1),
    ('Candelabro de alfarería', 'Candelabro de estilo mexicano para velas.', 24.99, 25, NULL, 2, 2),
    ('Plato hondo de barro', 'Plato profundo ideal para sopas y guisos.', 34.99, 40, NULL, 1, 3),
    ('Florero de cerámica', 'Florero decorativo para arreglos florales.', 44.99, 18, NULL, 3, 4);

INSERT INTO producto_imagen(id_producto, imagen_url)
VALUES
    (1,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (1,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (2,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (2,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (2,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (3,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (4,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (5,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (5,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (5,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg"),
    (6,"https://elsouvenir.com/wp-content/uploads/2016/10/Barro-Mexicano-Angelica-Portales-01.jpg");