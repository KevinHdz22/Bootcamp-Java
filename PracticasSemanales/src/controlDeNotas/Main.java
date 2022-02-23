package controlDeNotas;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//String nombre;
		//String apellido;
		//Integer numExamen;
		//Integer notaExamen;
		ArrayList<Alumno>alumnoList = new ArrayList<Alumno>();
		
		Scanner lectura = new Scanner (System.in);
		System.out.println("Ingrese la cantidad de estudiantes: \n");
		int numDeEstudiantes = lectura.nextInt();
		//ArrayList<Integer>listNumExamen = new ArrayList<Integer>();
		//ArrayList<Integer>listNotaExamen = new ArrayList<Integer>();
		
		for (int i = 0; i < numDeEstudiantes; i++) {
			
			ArrayList<Integer>listNumExamen = new ArrayList<Integer>();
			ArrayList<Integer>listNotaExamen = new ArrayList<Integer>();
			//ArrayList<Integer>listNumExamenAux = new ArrayList<Integer>();
			
			System.out.println("Ingrese el nombre del estudiante: \n");
			String nombre = lectura.next();
			System.out.println("Ingrese el Apellido del estudiante: \n");
			String apellido = lectura.next();
			//nombre = "";
			while (validarCadenaTexto(nombre, apellido) == true) {
				System.out.println("Ingrese el nombre del estudiante: \n");
				nombre = lectura.next();
				System.out.println("Ingrese el Apellido del estudiante: \n");
				apellido = lectura.next();
			}
			if (validarLista(nombre, apellido, alumnoList)==false) {
				
				
				System.out.println("Ingrese el numero del examen \n");
				Integer numExamen  = lectura.nextInt();
				
				listNumExamen.add(numExamen);
				
				System.out.println("Ingrese la nota del examen: \n");
				Integer notaExamen = lectura.nextInt();
				listNotaExamen.add(notaExamen);
				
				Alumno alumno = new Alumno (nombre, apellido, listNumExamen , listNotaExamen);
				alumnoList.add(alumno);
			}else {
				System.out.println("YA EXISTE EL ALUMNO \n");
				System.out.println("Desea añadir un nuevo examen: \n 1.Si \n 2.No");
				Integer auxRespuesta = lectura.nextInt();
				if (auxRespuesta == 1) {
					
					System.out.println("Ingrese el numero del examen \n");
					Integer numExamen = lectura.nextInt();
					listNumExamen.add(numExamen);
					
					if (validarNumExamen(nombre, apellido, listNumExamen, alumnoList)==true) {
						System.out.println("YA EXISTE ESE NUMERO DE EXAMEN: \n");
					}else {
						int posicion = buscarPosicionAlumno(nombre, apellido, alumnoList);
						listNumExamen = alumnoList.get(posicion).getNumExamen();//modificar
						listNumExamen.add(numExamen);
						alumnoList.get(posicion).setNumExamen(listNumExamen);//modificar
						
						System.out.println("Ingrese la nota del examen: \n");
						Integer notaExamen = lectura.nextInt();
						listNotaExamen = alumnoList.get(posicion).getNotaExamen();//modificar
						listNotaExamen.add(notaExamen);
						alumnoList.get(posicion).setNotaExamen(listNotaExamen);//modificar
					}
				}
				
				
			}
			/*
			System.out.println("Ingrese el numero del examen \n");
			Integer numExamen = lectura.nextInt();
			System.out.println("Ingrese la nota del examen: \n");
			Integer notaExamen = lectura.nextInt();
			
			
			
			Alumno alumno = new Alumno (nombre, apellido, numExamen, notaExamen);
			alumnoList.add(alumno);
			*/
		}
		
		for (int i = 0; i < alumnoList.size(); i++) {
			System.out.println("\n Nombre: " + alumnoList.get(i).getNombre() + "\n Apellido: " + alumnoList.get(i).getApellido() + "\n Numero de examen: " + alumnoList.get(i).getNumExamen() + "\n Nota de Examen: " + alumnoList.get(i).getNotaExamen());
		}
		

	}
	public static boolean validarCadenaTexto(String nombre, String apellido) {
		boolean validarCadena = false;
		if (nombre.isEmpty() || nombre == null) {
			System.out.println("Debe ingresar un nombre: ");
			validarCadena = true;
		}
		if (apellido.isEmpty() || apellido == null) {
			System.out.println("Debe ingresar un Apellido: ");
			validarCadena = true;
		}
		return validarCadena;
	}
	
	public static boolean validarNumExamen(String nombre, String apellido, ArrayList<Integer> numExamen, ArrayList<Alumno> alumnoList) {
		boolean validarNumExamen = false;
		for (int i = 0; i < alumnoList.size(); i++) {
			if (alumnoList.get(i).getNombre().equals(nombre)&& alumnoList.get(i).getApellido().equals(apellido)) {
				if (alumnoList.get(i).getNumExamen().equals(numExamen)) {
					//System.out.println("Examen ya existente: \n");
					validarNumExamen = true;
				}
			}
		}
		return validarNumExamen;
	}
	
	public static int buscarPosicionAlumno(String nombre, String apellido, ArrayList<Alumno> alumnoList) {
		int posicion = 0;
		for (int i = 0; i < alumnoList.size(); i++) {
			if (alumnoList.get(i).getNombre().equals(nombre)&& alumnoList.get(i).getApellido().equals(apellido)) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	

	public static boolean validarLista(String nombre, String apellido, ArrayList<Alumno> alumnoList) {
		boolean validacion = false;
		for (int i = 0; i < alumnoList.size(); i++) {
			if (alumnoList.get(i).getNombre().equals(nombre)&& alumnoList.get(i).getApellido().equals(apellido)) {
				System.out.println("Estudiante ya ingresado: \n");
				validacion = true;
			}
		}
		return validacion;
	}
}
