package com.protalento.excepciones;

import com.protalento.enumerados.ErroresPatrones;

public class PatronExcepcion extends Exception {
	private static final long serialVersionUID = 1L;
	
	private ErroresPatrones erroresPatrones;
	
	public PatronExcepcion(ErroresPatrones erroresPatrones) {
		this.erroresPatrones = erroresPatrones;
	}
	//Excepcion personalizada
	public PatronExcepcion(String mensaje) {
		super(mensaje);
	}
	
	@Override
	public String getMessage() {
		switch (erroresPatrones) {
		case CORREO:
			return erroresPatrones.getMensaje();

		case CLAVE:
			return erroresPatrones.getMensaje();
		}
		return super.getMessage();
	}

}
