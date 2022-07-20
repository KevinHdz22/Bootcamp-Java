package com.protalento.main;

public enum Alertas {
	CERRAR_SESION("Ha cerrado correctamente la sesion","alertWarning"),
	CREDENCIALES_INCORRECTAS("Credenciales incorrectas, intente nuevamente","alertDanger"),
	INSERTAR("Se ha creado correctamente el registro","alertSuccess"),
	MODIFICAR("Se ha actualizado correctamente el registro","alertSuccess"),
	ELIMINAR("Se ha eliminado correctamente el registro","alertDanger");
	
	
	private String mensaje;
	private String claseCSS;
	
	private Alertas(String mensaje, String claseCSS) {
		this.mensaje = mensaje;
		this.claseCSS = claseCSS;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public String getClaseCSS() {
		return claseCSS;
	}
	
}
