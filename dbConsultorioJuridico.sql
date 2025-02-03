-- Database: consultorioJuridico

-- DROP DATABASE IF EXISTS "consultorioJuridico";

CREATE DATABASE "consultorioJuridico"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Colombia.1252'
    LC_CTYPE = 'Spanish_Colombia.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

	CREATE TABLE usuario(
	id_usuario SERIAL PRIMARY KEY,
	nombre_usuario VARCHAR(50) , 
	rol_usuario VARCHAR(20) NOT NULL CHECK (rol_usuario IN ('ESTUDIANTE', 'CIUDADANO')),
	correo VARCHAR(50) UNIQUE NOT NULL
	);

	CREATE TABLE caso(
		id_caso SERIAL PRIMARY KEY,
		id_usuario INT NOT NULL,
		tipo_caso VARCHAR(255),
		descripcion TEXT,
		estado_caso VARCHAR(20) NOT NULL CHECK (estado_caso IN ('ABIERTO', 'EN_PROCESO','CERRADO')),
		fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		id_estudiante_asignado INT NULL,
		FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario),
		FOREIGN KEY(id_estudiante_asignado) REFERENCES usuario(id_usuario)
	);

	CREATE TABLE comentario(
		id_comentario SERIAL PRIMARY KEY,
		id_caso INT NOT NULL,
		id_usuario INT NOT NULL, 
		contenido TEXT NOT NULL, 
		fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		FOREIGN KEY(id_caso) REFERENCES caso(id_caso),
		FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)	
	);

