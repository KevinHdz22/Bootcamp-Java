package com.practicaBasesDeDatos.sistemaBancario.entidades;

import java.util.Date;

public class Empleado {
	int id;
	String nombre;
	String telefono;
	Date fechaIngreso;
	int idJefe;
	
	public Empleado() {
		super();
	}

	public Empleado(int id, String nombre, String telefono, Date fechaIngreso, int idJefe) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaIngreso = fechaIngreso;
		this.idJefe = idJefe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getIdJefe() {
		return idJefe;
	}

	public void setIdJefe(int idJefe) {
		this.idJefe = idJefe;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", fechaIngreso=" + fechaIngreso
				+ ", idJefe=" + idJefe + "]";
	}
	
	
}
