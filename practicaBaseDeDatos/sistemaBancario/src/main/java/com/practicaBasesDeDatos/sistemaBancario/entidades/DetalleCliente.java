package com.practicaBasesDeDatos.sistemaBancario.entidades;

public class DetalleCliente {
	int idCliente;
	int idCuenta;
	
	
	public DetalleCliente() {
		super();
	}


	public DetalleCliente(int idCliente, int idCuenta) {
		super();
		this.idCliente = idCliente;
		this.idCuenta = idCuenta;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public int getIdCuenta() {
		return idCuenta;
	}


	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}


	@Override
	public String toString() {
		return "DetalleCliente [idCliente=" + idCliente + ", idCuenta=" + idCuenta + "]";
	}
	
	
}
