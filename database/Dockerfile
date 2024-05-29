# Se descarga una version de MySQL 8.0 contenida en Debian 12 Bookworm 
FROM mysql:8.0.37-bookworm

# Se define el directorio dentro del contenedor donde se alojaran los scripts
WORKDIR /docker-entrypoint-initdb.d

# Se cargan los scripts de SQL de nuestro repositorio al contenedor
ADD barro_db.sql /docker-entrypoint-initdb.d
ADD test_data.sql /docker-entrypoint-initdb.d

# Se definen las variables de entorno para crear la base de datos
ENV MYSQL_ROOT_PASSWORD=pass1234 
ENV MYSQL_DATABASE=barro_db

# Se abre el puerto 3306 para poder conectarnos al contenedor
EXPOSE 3306