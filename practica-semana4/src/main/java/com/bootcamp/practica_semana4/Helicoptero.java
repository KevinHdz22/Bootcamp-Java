package com.bootcamp.practica_semana4;

import javax.swing.JOptionPane;

public class Helicoptero extends Volador{

	private Detalle detalle;
	private Integer numTripulantes;

	public Helicoptero() {
		super();
	}

	public Helicoptero(String nombre, Integer velocidadMax, Detalle detalle, Integer numTripulantes) {
		super(nombre, velocidadMax);
		this.detalle = detalle;
		this.numTripulantes = numTripulantes;
	}

	@Override
	public String toString() {
		return "Helicoptero " + super.toString() + detalle + ", numero de tripulantes: "
				+ numTripulantes;
	}

	public Integer getNumTripulantes() {
		return numTripulantes;
	}

	public void setNumTripulantes(Integer numTripulantes) {
		this.numTripulantes = numTripulantes;
	}
	
	public boolean aterrizar() {
		JOptionPane.showMessageDialog(null, "Puede aterrizar " + getNombre() + " (Helicoptero)");
		return true;
	}
}



