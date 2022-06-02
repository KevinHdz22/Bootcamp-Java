package com.practicaBasesDeDatos.sistemaBancario.entidades;

public class Cliente {
	int id;
	String nombre;
	String calle;
	String ciudad;
	int idEmpleado;
	
	public Cliente() {
		super();
	}

	public Cliente(int id, String nombre, String calle, String ciudad, int idEmpleado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.calle = calle;
		this.ciudad = ciudad;
		this.idEmpleado = idEmpleado;
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

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", calle=" + calle + ", ciudad=" + ciudad + ", idEmpleado="
				+ idEmpleado + "]";
	}
	
	
	
	
}
