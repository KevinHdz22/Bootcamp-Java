package com.bootcamp.practica_semana4;

import javax.swing.JOptionPane;

public class Superman extends Volador{
	private String raza;
	private String debilidad;
	private Float estatura;
	private String sexo;
	
	public Superman() {
		super();
	}
	public Superman(String nombre, Integer velocidadMax, String raza, String debilidad, Float estatura, String sexo) {
		super(nombre, velocidadMax);
		this.raza = raza;
		this.debilidad = debilidad;
		this.estatura = estatura;
		this.sexo = sexo;
	}
	public String toString() {
		return "Superman " + super.toString() + ", raza: " + raza + ", debilidad: " + debilidad
				+ ", estatura: " + estatura + ", sexo: " + sexo;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getDebilidad() {
		return debilidad;
	}
	public void setDebilidad(String debilidad) {
		this.debilidad = debilidad;
	}
	public Float getEstatura() {
		return estatura;
	}
	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public boolean aterrizar() {
		System.out.println("No puede aterrizar " + getNombre() + " (Superman)");
		JOptionPane.showMessageDialog(null, "No puede aterrizar " + getNombre() + " (Superman)");
		return false;
	}
	
	

}
