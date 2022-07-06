package com.protalento.entidades;

import java.time.LocalDate;

public class Consulta {
	String texto;
	String url;
	LocalDate fecha;
	
	public Consulta() {
		super();
	}
	public Consulta(String texto, String url, LocalDate fecha) {
		super();
		this.texto = texto;
		this.url = url;
		this.fecha = fecha;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Consulta [texto=" + texto + ", url=" + url + ", fecha=" + fecha + "]";
	}	
	
}
