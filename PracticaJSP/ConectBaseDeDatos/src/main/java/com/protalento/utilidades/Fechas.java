package com.protalento.utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Fechas {
	public static final String PATRON_FECHA = "dd-MM-yyyy";
	// para que no me puedan instanciar la clase
	private Fechas() {
		
	}
	
	/**
	 * obtener LocalDate de String
	 * @param fecha con patron dd/MM/yyyy
	 * @return fecha LocalDate
	 */
	public static LocalDate getLocalDate(String fecha) {
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern(PATRON_FECHA));
	}
	
	/**
	 * obtener String de LocalDate
	 * @param fechaLocalDate
	 * @return fecha String con patron dd/MM/yyyy
	 */
	public static String getString(LocalDate fechaLocalDate) {
		return fechaLocalDate.format(DateTimeFormatter.ofPattern(PATRON_FECHA));
	}
}
