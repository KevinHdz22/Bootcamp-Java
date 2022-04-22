package com.bootcamp.practica_semana4;

public final class Detalle {
	private String color;
	private String fabricante;
	private Integer anioFabricacion;
	
	public Detalle() {
		super();
	}

	public Detalle(String color, String fabricante, Integer anioFabricacion) {
		super();
		this.color = color;
		this.fabricante = fabricante;
		this.anioFabricacion = anioFabricacion;
	}

	@Override
	public String toString() {
		return  "Color: " + color + ", Fabricante: " + fabricante + ", Año fabricación: " + anioFabricacion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(Integer anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	
	
	
	
	
	
	
}
