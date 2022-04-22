package com.bootcamp.practica_semana4;

import javax.swing.JOptionPane;

public class Ovni extends Volador{
	private String forma;

	public Ovni() {
		super();
	}

	public Ovni(String nombre, Integer velocidadMax, String forma) {
		super(nombre, velocidadMax);
		this.forma = forma;
	}

	@Override
	public String toString() {
		return "Ovni " + super.toString() + ", forma: " + forma;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}
	
	public boolean aterrizar() {
		JOptionPane.showMessageDialog(null, "No puede aterrizar " + getNombre() + " (Ovni)");
		return false;
	}
	
	
}
