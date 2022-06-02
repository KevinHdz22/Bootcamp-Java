package com.practicaBasesDeDatos.sistemaBancario.entidades;

public class Jefe {
	int id;
	String nombreSubordinado;
	
	public Jefe() {
		super();
	}

	public Jefe(int id, String nombreSubordinado) {
		super();
		this.id = id;
		this.nombreSubordinado = nombreSubordinado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreSubordinado() {
		return nombreSubordinado;
	}

	public void setNombreSubordinado(String nombreSubordinado) {
		this.nombreSubordinado = nombreSubordinado;
	}

	@Override
	public String toString() {
		return "Jefe [id=" + id + ", nombreSubordinado=" + nombreSubordinado + "]";
	}
}
