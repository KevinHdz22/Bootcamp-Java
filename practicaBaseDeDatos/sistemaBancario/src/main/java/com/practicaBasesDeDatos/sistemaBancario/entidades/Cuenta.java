package com.practicaBasesDeDatos.sistemaBancario.entidades;

public class Cuenta {
	Integer id;
	String tipoDeCuenta;
	
	
	public Cuenta() {
		super();
	}


	public Cuenta(Integer id, String tipoDeCuenta) {
		super();
		this.id = id;
		this.tipoDeCuenta = tipoDeCuenta;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTipoDeCuenta() {
		return tipoDeCuenta;
	}


	public void setTipoDeCuenta(String tipoDeCuenta) {
		this.tipoDeCuenta = tipoDeCuenta;
	}


	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", tipoDeCuenta=" + tipoDeCuenta + "]";
	}
	
	
	
}
