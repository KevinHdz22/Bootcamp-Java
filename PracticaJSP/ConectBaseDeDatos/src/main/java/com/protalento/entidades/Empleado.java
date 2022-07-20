package com.protalento.entidades;

import java.time.LocalDate;

public class Empleado {
	
	private String tipoDocumento;
	private String numeroDocumento;
	private String nombreEmpleado;
	private String apellidoEmpleado;
	private Integer edadEmpleado;
	private LocalDate fechaNacimiento;
	public Empleado() {
		
	}
	
	public Empleado(String tipoDocumento, String numeroDocumento, String nombreEmpleado, String apellidoEmpleado,
			Integer edadEmpleado, LocalDate fechaNacimiento) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombreEmpleado = nombreEmpleado;
		this.apellidoEmpleado = apellidoEmpleado;
		this.edadEmpleado = edadEmpleado;
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Empleado [tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", nombreEmpleado="
				+ nombreEmpleado + ", apellidoEmpleado=" + apellidoEmpleado + ", edadEmpleado=" + edadEmpleado
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public Integer getEdadEmpleado() {
		return edadEmpleado;
	}

	public void setEdadEmpleado(Integer edadEmpleado) {
		this.edadEmpleado = edadEmpleado;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
}
