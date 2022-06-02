package com.practicaBasesDeDatos.sistemaBancario.entidades;

public class DetalleCliente {
	Integer idCliente;
	Integer idCuenta;
	
	
	public DetalleCliente() {
		super();
	}


	public DetalleCliente(Integer idCliente, Integer idCuenta) {
		super();
		this.idCliente = idCliente;
		this.idCuenta = idCuenta;
	}


	public Integer getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}


	public Integer getIdCuenta() {
		return idCuenta;
	}


	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}


	@Override
	public String toString() {
		return "DetalleCliente [idCliente=" + idCliente + ", idCuenta=" + idCuenta + "]";
	}
	
	
}
