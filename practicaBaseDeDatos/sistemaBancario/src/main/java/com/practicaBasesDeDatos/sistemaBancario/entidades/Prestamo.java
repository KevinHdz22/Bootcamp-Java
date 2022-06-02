package com.practicaBasesDeDatos.sistemaBancario.entidades;

import java.util.Date;

public class Prestamo {
	Integer id;
	Date fechaSolicitud;
	Integer idCliente;
	
	
	public Prestamo() {
		super();
	}

	public Prestamo(Integer id, Date fechaSolicitud, Integer idCliente) {
		super();
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
		this.idCliente = idCliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", fechaSolicitud=" + fechaSolicitud + ", idCliente=" + idCliente + "]";
	}
	
	
}
