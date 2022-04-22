package com.bootcamp.practica_semana4;

import javax.swing.JOptionPane;

public class Avion extends Volador{
	
	private Detalle detalle;
	private Integer numAsientos;

	public Avion() {
		super();
	}

	public Avion(String nombre, Integer velocidadMax, Detalle detalle, Integer numAsientos) {
		super(nombre, velocidadMax);
		this.detalle = detalle;
		this.numAsientos = numAsientos;
	}

	@Override
	public String toString() {
		return "Avion " + super.toString() + ", "+ detalle + ", numAsientos: " + numAsientos;
	}

	public Integer getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(Integer numAsientos) {
		this.numAsientos = numAsientos;
	}
	
	public boolean aterrizar() {
		JOptionPane.showMessageDialog(null, "Puede aterrizar " + getNombre() + " (Avion)");
		return true;
	}
	
}
