package com.protalento.enumerados;

public enum ErroresPatrones {
	CORREO("Debe ingresar un formato permitido 'usuario@dominio.ext'"), 
	CLAVE("La clave contraseña debe tener entre 8 y 16 caracteres, al menos un digito, al menos una minuscula y al menos una mayuscula. No puede tener otros simbolos.");
	private String mensaje;

	ErroresPatrones(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
}
