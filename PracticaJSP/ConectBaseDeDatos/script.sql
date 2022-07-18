drop database if exists PracticaJSP;
create database if not exists PracticaJSP;
use PracticaJSP;

create table if not exists usuarios(
	correo varchar(100) not null primary key,
	clave blob
);

create table if not exists empleados(
	tipoDocumento char(3) not null,
	numeroDocumento varchar(20) not null,
	nombre varchar(30) not null,
	apellido varchar(30)not null,
	edad int,
	fechaNacimiento date not null,
	primary key(tipoDocumento, numeroDocumento)
);