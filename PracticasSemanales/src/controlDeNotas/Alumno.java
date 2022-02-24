package controlDeNotas;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/*
 *La escuela primera xyz solicita el desarrollo de una aplicación para poder llevar el control
 *de notas para cada alumno. el programa solicitara el ingreso de alumnos a procesar.
 *
 *Para cada alumno se debera ingresar los siguientes datos:
 *Nombre (String)
 *Apellido (String)
 *Numero de examen (int)
 *Nota que obtuvo el alumno (int) (>=0 y <=10)
 *
 *OBJETIVO
 *Al finalizar el cargue de datos
 *Alumno/s calificacion mas alta
 *alumno/s calificación mas baja
 *Alumnos que promocionan, aquellos que obtuvieron un promedio>= 7
 *Alumnos que deben recursar la materia Alumnos con promedio < 7
*/
public class Alumno {

	private String nombre;
	private String apellido;
	private ArrayList<Integer>listNumExamen = new ArrayList<Integer>();
	private ArrayList<Integer>listNotaExamen = new ArrayList<Integer>();
	//metodo Constuctor
	public Alumno(String nombre, String apellido,  ArrayList<Integer> listNumExamen,  ArrayList<Integer> listNotaExamen) {
		this.setNombre(nombre);
		this.apellido = apellido;
		this.listNumExamen = listNumExamen;
		this.listNotaExamen = listNotaExamen;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public ArrayList<Integer> getNumExamen() {
		return listNumExamen;
	}
	public void setNumExamen(ArrayList<Integer> listNumExamen) {
		this.listNumExamen = listNumExamen;
	}
	
	public ArrayList<Integer> getNotaExamen() {
		return listNotaExamen;
	}
	public void setNotaExamen(ArrayList<Integer> listNotaExamen) {
		this.listNotaExamen = listNotaExamen;
	}
}


