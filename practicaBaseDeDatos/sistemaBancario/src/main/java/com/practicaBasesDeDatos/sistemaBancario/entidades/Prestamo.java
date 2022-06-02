package com.practicaBasesDeDatos.sistemaBancario.entidades;

import java.util.Date;

public class Prestamo {
	int id;
	Date fechaSolicitud;
	int idCliente;
	
	
	public Prestamo() {
		super();
	}

	public Prestamo(int id, Date fechaSolicitud, int idCliente) {
		super();
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
		this.idCliente = idCliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", fechaSolicitud=" + fechaSolicitud + ", idCliente=" + idCliente + "]";
	}
	
	
}
