package com.bootcamp.practica_semana4;

public abstract class Volador implements Aterrizable {
	private String nombre;
	private Integer velocidadMax;
	
	public Volador () {
		super();
	}
	public Volador(String nombre, Integer velocidadMax) {
		super();
		this.nombre = nombre;
		this.velocidadMax = velocidadMax;
	}
	
	@Override
	public String toString() {
		return "[Nombre: " + nombre +", Velocidad Maxima: " + velocidadMax + " Km/h" + "]";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getVelocidad() {
		return velocidadMax;
	}
	public void setVelocidad(Integer velocidad) {
		this.velocidadMax = velocidad;
	}
	
}
