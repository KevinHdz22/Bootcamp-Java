package controlDeNotas;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner lectura = new Scanner (System.in);
		//Lista para almacenar objetos tipo Alumno
		ArrayList<Alumno>alumnoList = new ArrayList<Alumno>();
		//Pedir información por teclado
		System.out.println("Ingrese la cantidad de estudiantes: \n");
		String numDeAlumnosAux = lectura.next();
		Integer numDeEstudiantes = validarNumAlumnos(numDeAlumnosAux);
		alumnoList = cargueDeDatos(numDeEstudiantes);
		//bandera para el control del ciclo while
		Integer bandera = 0;
		while(bandera == 0) {
			System.out.println("\nOPCIONES: ");
			System.out.println("\n1.Alumno/s calificacion mas alta: ");
			System.out.println("2.Alumno/s calificacion mas baja: ");
			System.out.println("3.Alumno/s que promocionan: ");
			System.out.println("4.Alumno/s que no promocionan: ");
			System.out.println("5.Mostrar toda la informacion de los alumnos: ");
			System.out.println("6.SALIR: \n");
			System.out.println("Que acción desea realizar: ");
			String opcionElegidaAux = lectura.next();
			
			//Uso de metodo para validar que la opcion elegida sea valida
			Integer opcionElegida = validarOpcionElegida(opcionElegidaAux);
			System.out.println("opcion" + opcionElegida);
			//Se usa un switch para realizar la accion segun la elección del usuario
			switch (opcionElegida) 
		     {
					//BUSCAR NOTA MAYOR
		            case 1:  opcionElegida = 1;
				            System.out.println("\nNOTA MAYOR: \n");
				    		
				    		Integer notaMayor = notaMasAlta(alumnoList);
				    		ArrayList<String>listEstudiantesNotaMayor = new ArrayList<String>();
				    		listEstudiantesNotaMayor = estudiantesNotaMasAlta(notaMayor, alumnoList);
				    		System.out.println("Estudiante/s con nota mayor: \n");
				    		for (int i = 0; i < listEstudiantesNotaMayor.size(); i++) {
				    			System.out.println("Estudiante: " + listEstudiantesNotaMayor.get(i));
				    			System.out.println("Nota: " + notaMayor);
				    		}
		                     break;
		             //BUSCAR NOTA MENOR
		            case 2:  opcionElegida = 2;
				            System.out.println("\nNOTA MENOR: ");
				    		Integer notaMenor = notaMasBaja(alumnoList);
				    		ArrayList<String>listEstudiantesNotaMenor = new ArrayList<String>();
				    		listEstudiantesNotaMenor = estudiantesNotaMasBaja(notaMenor, alumnoList);
				    		System.out.println("Estudiante/s con nota menor: \n");
				    		for (int i = 0; i < listEstudiantesNotaMenor.size(); i++) {
				    			System.out.println("Estudiante: " + listEstudiantesNotaMenor.get(i));
				    			System.out.println("Nota: " + notaMenor);
				    		}
				    		
		                     break;
		             // BUSCAR ALUMNOS QUE APRUEBAN
		            case 3:  opcionElegida = 3;
				    		ArrayList<Alumno>listEstudAprobados = new ArrayList<Alumno>();
				    		listEstudAprobados = alumnosAprobados(alumnoList);
				    		
				    		if(listEstudAprobados == null || listEstudAprobados.size() == 0) {
				    			System.out.println("\nNO HAY ESTUDIANTES APROBADOS ");
				             
				            }
				            else{
				            	System.out.println("\nESTUDIANTES APROBADOS: ");
					    		for (int i = 0; i < listEstudAprobados.size(); i++) {
					    			System.out.println("Estudiante: " + listEstudAprobados.get(i).getNombre() + " " + listEstudAprobados.get(i).getApellido());
					    			System.out.println("Promedio: " + promedioNotas(listEstudAprobados, i) + "\n");
					    		}
				            }
				    		
				    		
		                     break;
		            //BUSCAR ALUMNOS QUE DESAPRUEBAN
		            case 4:  opcionElegida = 4;
		
				    		ArrayList<Alumno>listEstudDesaprobados = new ArrayList<Alumno>();
				    		listEstudDesaprobados = alumnosDesaprobados(alumnoList);
				    		
				    		if(listEstudDesaprobados == null || listEstudDesaprobados.size() == 0) {
				    			System.out.println("\nNO HAY ESTUDIANTES DESAPROBADOS ");
				             
				            }else {
				            	System.out.println("\nESTUDIANTES DESAPROBADOS: ");
					    		for (int i = 0; i < listEstudDesaprobados.size(); i++) {
					    			System.out.println("Estudiante: " + listEstudDesaprobados.get(i).getNombre() + " " + listEstudDesaprobados.get(i).getApellido());
					    			System.out.println("Promedio: " + promedioNotas(listEstudDesaprobados, i) + "\n");
					    		}
				            }
		                     break;
		            //MOSTRAR EN PANTALLA TODOS LOS ALUMNOS Y SU INFORMACIÓN
		            case 5:  opcionElegida = 5;
				            for (int i = 0; i < alumnoList.size(); i++) {
				    			System.out.println("\n Nombre: " + alumnoList.get(i).getNombre() + "\n Apellido: " + alumnoList.get(i).getApellido() + "\n Numero de examen: " + alumnoList.get(i).getNumExamen() + "\n Nota de Examen: " + alumnoList.get(i).getNotaExamen());
				    		}
		            		break;
		            //ROMPER EL WHILE CAMBIANDO VALOR DE LA BANDERA
		            case 6:  opcionElegida = 6;
			        		bandera = 1;
			        		break;
		        }
		}
	}
    //METODO PARA VALIDAR LA OPCION ELEGIDA POR EL USUARIO (QUE SEA UN NUMERO Y ESTE ENTRE LAS OPCIONES)       
	public static Integer validarOpcionElegida(String opcionElegidaAux){
		Integer opcionElegida = 0;
		boolean esNumero = false;
		Scanner lectura = new Scanner (System.in);
		while(esNumero == false) {
	        for (int i = 0; i < opcionElegidaAux.length(); i++) {
	            if (!Character.isDigit(opcionElegidaAux.charAt(i))) {
	                esNumero = false;
	            }else {
	            	esNumero = true;
	            	opcionElegida = Integer.parseInt(opcionElegidaAux);
	            	if(opcionElegida <= 0 || opcionElegida >= 7) {
		        		System.out.println("!Ingrese número disponible! ");
		        		esNumero = false;
	            	}
	            }
		        if (esNumero == false) {
		        	System.out.println("Debe Ingresar un número: ");
		        	opcionElegidaAux = lectura.next();
		        }	
	        }
		}
		return opcionElegida;
	}
	//METODO PARA VALIDAR EL NUMERO DE ESTUDIANTES A INGRESAR (QUE SEA UN NUMERO Y QUE SEA MAYOR A 0)
	public static Integer validarNumAlumnos(String numDeAlumnosAux){
		Integer numAlumnos = 0;
		boolean esNumero = false;
		Scanner lectura = new Scanner (System.in);
		while(esNumero == false) {
	        for (int i = 0; i < numDeAlumnosAux.length(); i++) {
	            if (!Character.isDigit(numDeAlumnosAux.charAt(i))) {
	                esNumero = false;
	            }else {
	            	esNumero = true;
	            	numAlumnos = Integer.parseInt(numDeAlumnosAux);
	            	if (numAlumnos <= 0) {
	            		System.out.println("!Debe Ingresar un número de alumnos! ");
	            		esNumero=false;
	            	}
	            }
		        if (esNumero == false) {
		        	System.out.println("Debe Ingresar un número de alumnos valido: ");
		        	numDeAlumnosAux = lectura.next();
		        }	
	        }
		}
		return numAlumnos;
	}
	
	//METODO PARA INGRESAR LOS DATOS DE TODOS LOS ALUMNOS
	public static ArrayList<Alumno> cargueDeDatos(Integer numDeEstudiantes){
		Scanner lectura = new Scanner (System.in);
		ArrayList<Alumno>alumnoList = new ArrayList<Alumno>();
		for (int i = 0; i < numDeEstudiantes; i++) {
			//LISTAS AUXILIARES PARA GUARDAR LOS NUMEROS Y NOTAS DE EXAMEN
			ArrayList<Integer>listNumExamen = new ArrayList<Integer>();
			ArrayList<Integer>listNotaExamen = new ArrayList<Integer>();
			
			System.out.println("Ingrese el nombre del estudiante: \n");
			String nombre = lectura.next();
			System.out.println("Ingrese el Apellido del estudiante: \n");
			String apellido = lectura.next();
			//VALIDAR QUE LA CADENA DE TEXTO NO SEA NULA, NI VACIA
			while (validarCadenaTexto(nombre, apellido) == true) {
				System.out.println("Ingrese el nombre del estudiante: \n");
				nombre = lectura.next();
				System.out.println("Ingrese el Apellido del estudiante: \n");
				apellido = lectura.next();
			}
			//VALIDAR QUE EL ALUMNO INGRESADO NO SE HAYA INGRESADO ANTES
			if (validarLista(nombre, apellido, alumnoList)==false) {
				
				System.out.println("Ingrese el numero del examen: \n");
				Integer numExamen  = lectura.nextInt();
				
				System.out.println("Ingrese la nota del examen: \n");
				Integer notaExamen = lectura.nextInt();
				//VALIDAR QUE EL NUMERO Y NOTA DEL EXAMEN SEAN VALIDOS
				while(validarNumYNotaExamen(numExamen, notaExamen)== true) {
					System.out.println("Ingrese el numero del examen: \n");
					numExamen  = lectura.nextInt();
					System.out.println("Ingrese la nota del examen: \n");
					notaExamen = lectura.nextInt();
				}
				//AGREGAR ELEMENTOS A LAS LISTAS AUXILIARES
				listNumExamen.add(numExamen);
				listNotaExamen.add(notaExamen);
				//CREAR OBJETO DE TIPO ALUMNO Y SE AÑADE A LA LISTA DE ALUMNOS
				Alumno alumno = new Alumno (nombre, apellido, listNumExamen , listNotaExamen);
				alumnoList.add(alumno);
			}else {
				//RUTA A SEGUIR EN CASO DE QUE EL ALUMNO SE INGRESO ANTERIORMENTE
				System.out.println("YA EXISTE EL ALUMNO \n");
				System.out.println("Desea añadir un nuevo examen: \n 1.Si \n 2.No");
				Integer auxRespuesta = lectura.nextInt();
				if (auxRespuesta == 1) {
					
					System.out.println("Ingrese el numero del examen \n");
					Integer numExamen = lectura.nextInt();
					Integer controlValidacion = 0;
					//VALIDAR QUE EL NUEVO EXAMEN A INGRESAR NO SEA REPETIDO
					while(controlValidacion == 0) {
						if(validarNumExamenRepetido(nombre, apellido, numExamen, alumnoList)==true) {
							System.out.println("!YA EXISTE ESE NUMERO DE EXAMEN! \n");
							System.out.println("Ingrese un numero del examen no repetido: \n");
							numExamen = lectura.nextInt();
						//SI ES UN EXAMEN NUEVO SE ROMPE EL CICLO Y SE AÑADE EL EXAMEN
						}else {
							controlValidacion = 1;
							listNumExamen.add(numExamen);
						}
						
					}
					//BUSCAR UBICACION DEL ALUMNO PARA PODER REALIZAR MODIFICACION DE NUMERO DE EXAMENES
					int posicion = buscarPosicionAlumno(nombre, apellido, alumnoList);
					//SE ASIGNA EL VALOR  DEL EXAMEN DEL ALUMNO A LA LISTA AUXILIAR DE EXAMENES 
					listNumExamen = alumnoList.get(posicion).getNumExamen();
					//SE AÑADE EL NUEVO NUMERO DE EXAMEN
					listNumExamen.add(numExamen);
					//MODIFICAR LA LISTA DE EXAMENES DEL ESTUDIANTE INDICADO (SE MODIFICA LA LISTA DE OBJETOS)
					alumnoList.get(posicion).setNumExamen(listNumExamen);
					//SE RELIZA EL MISMO PROCESO ANTERIOR, PERO AL VALOR DE LA NOTA DEL EXAMEN
					System.out.println("Ingrese la nota del examen: \n");
					Integer notaExamen = lectura.nextInt();
					listNotaExamen = alumnoList.get(posicion).getNotaExamen();
					listNotaExamen.add(notaExamen);
					alumnoList.get(posicion).setNotaExamen(listNotaExamen);
					
				}
			}
		}
		//RETORNA LA LISTA DE ALUMNOS MODIFICADA
		return alumnoList;
	}
	//METOD PARA OBTENER CUALES ALUMNO APRUEBAN
	public static ArrayList<Alumno> alumnosAprobados(ArrayList<Alumno> alumnoList){
		ArrayList<Alumno>listEstudAprobados = new ArrayList<Alumno>();
		for (int i = 0; i < alumnoList.size(); i++) {
			Double promedio = promedioNotas (alumnoList, i);
			if (promedio >= 7) {
				listEstudAprobados.add(alumnoList.get(i));
			}
		}
		return listEstudAprobados;
	}
	//METODO PARA OBTENER ALUMNOS QUE NO APRUEBAN
	public static ArrayList<Alumno> alumnosDesaprobados(ArrayList<Alumno> alumnoList){
		ArrayList<Alumno>listEstudDesaprobados = new ArrayList<Alumno>();
		for (int i = 0; i < alumnoList.size(); i++) {
			Double promedio = promedioNotas (alumnoList, i);
			if (promedio >= 0 && promedio < 7) {
				listEstudDesaprobados.add(alumnoList.get(i));
			}
		}
		return listEstudDesaprobados;
	}
	
	//METODO PARA OBTENER EL PROMEDIO DE UN DETERMINADO NUMERO DE NOTAS
	//SE INGRESA i AL METODO PARA SABER LA POSICION DE UN ALUMNO Y ASI USAR SU INFORMACION
	public static Double promedioNotas(ArrayList<Alumno> alumnoList, Integer i){
		//Lista para usar dentro del metodo y almacenar las notas del alumno
		ArrayList<Integer>listNotasAux = new ArrayList<Integer>();
		//Variable para almacenar suma de los valores de las notas
		Double auxValAcumul = 0.0;
		Double auxValPromedio = 0.0;
		//Se asigna a la lista Auxiliar las notas del alumno en la posicion i 
		listNotasAux = alumnoList.get(i).getNotaExamen();
		//Ciclo que recorre la lista auxiliar anteriormente llenada
		for (int j = 0; j < listNotasAux.size(); j++) {
			//La variable acumulativa suma el valor de la lista en cada posicion j
			auxValAcumul = auxValAcumul + listNotasAux.get(j);
			//la condicion se cumple cuando se llega a la ultima iteracion del ciclo
			if (j == listNotasAux.size()-1) {
				auxValPromedio = auxValAcumul / listNotasAux.size();
			}		
		}
		//retornar el valor del promedio
		return auxValPromedio;
	}
	//METODO PARA BUSCAR AL ESTUDIANTE/S CON LA NOTA MAS ALTA
	public static ArrayList<String> estudiantesNotaMasAlta(Integer notaMayor, ArrayList<Alumno> alumnoList){
		ArrayList<String>listEstudiantesNotaMayor = new ArrayList<String>();
		for (int i = 0; i < alumnoList.size(); i++) {
			if(alumnoList.get(i).getNotaExamen().contains(notaMayor)) {
				String nombEstudianteAux = alumnoList.get(i).getNombre() + " " + alumnoList.get(i).getApellido();
				listEstudiantesNotaMayor.add(nombEstudianteAux);
			}
		}
		return listEstudiantesNotaMayor;
	}
	//METODO PARA BUSCAR LA NOTA MAS ALTA
	public static Integer notaMasAlta(ArrayList<Alumno> alumnoList){
		//Listas para usar dentro del metodo
		ArrayList<Integer>listNotasAux = new ArrayList<Integer>();
		ArrayList<Integer>listTodasLasNotas = new ArrayList<Integer>();
		//Variables para almacenar valores de las listas
		Integer auxValMayor = 0;
		Integer auxVal;
		//Ciclo que recorre la lista de alumnos
		for (int i = 0; i < alumnoList.size(); i++) {
			//Se asigna a la lista Auxiliar las notas del alumno en la posicion i de la iteracion
			listNotasAux = alumnoList.get(i).getNotaExamen();
			//Ciclo que recorre la lista auxiliar anteriormente llenada
			for (int j = 0; j < listNotasAux.size(); j++) {
				//La variable auxiliar almacena eL valor de la lista en la posicion j
				auxVal = listNotasAux.get(j);
				//Se agrega la nota obtenida a la lista de todas las notas
				listTodasLasNotas.add(auxVal);			}
		}
		//Ciclo que recorre la lista de todas las notas para buscar la nota mayor
		for (int j = 0; j < listTodasLasNotas.size(); j++) {
			if(listTodasLasNotas.get(j)>auxValMayor) {
				auxValMayor = listTodasLasNotas.get(j);
			}
		}
		//retornar la nota mayor
		return auxValMayor;
	}

	//METODO PARA OBTENER EL ESTUDIANTE/S CON LA NOTA MAS BAJA
	public static ArrayList<String> estudiantesNotaMasBaja(Integer notaMenor, ArrayList<Alumno> alumnoList){
		ArrayList<String>listEstudiantesNotaMenor = new ArrayList<String>();
		for (int i = 0; i < alumnoList.size(); i++) {
			if(alumnoList.get(i).getNotaExamen().contains(notaMenor)) {
				String nombEstudianteAux = alumnoList.get(i).getNombre() + " " + alumnoList.get(i).getApellido();
				listEstudiantesNotaMenor.add(nombEstudianteAux);
			}
		}
		return listEstudiantesNotaMenor;
	}
	//METODO PARA BUSCAR LA NOTA MAS BAJA 
	public static Integer notaMasBaja(ArrayList<Alumno> alumnoList){
		//Listas para usar dentro del metodo
		ArrayList<Integer>listNotasAux = new ArrayList<Integer>();
		ArrayList<Integer>listTodasLasNotas = new ArrayList<Integer>();
		//Variables para almacenar valores de las listas
		Integer auxValMenor = 10;
		Integer auxVal;
		//Ciclo que recorre la lista de alumnos
		for (int i = 0; i < alumnoList.size(); i++) {
			//Se asigna a la lista Auxiliar las notas del alumno en la posicion i de la iteracion
			listNotasAux = alumnoList.get(i).getNotaExamen();
			//Ciclo que recorre la lista auxiliar anteriormente llenada
			for (int j = 0; j < listNotasAux.size(); j++) {
				//La variable auxiliar almacena en valor de la lista en la posicion j
				auxVal = listNotasAux.get(j);
				//Se agrega la nota obtenida a la lista de todas las notas
				listTodasLasNotas.add(auxVal);			}
		}
		//Ciclo que recorre la lista de todas las notas para buscar la nota menor
		for (int j = 0; j < listTodasLasNotas.size(); j++) {
			if(listTodasLasNotas.get(j)<auxValMenor) {
				auxValMenor = listTodasLasNotas.get(j);
			}
		}
		return auxValMenor;
	}
		
	//METODO QUE VALIDA EL NUMERO Y LA NOTA DE LOS EXAMENES
	public static boolean validarNumYNotaExamen(Integer numExamen, Integer notaExamen) {
		boolean validarDatosNum = false;
		if (numExamen <= 0) {
			System.out.println("Debe ingresar un numero de examen valido ");
			validarDatosNum = true;
		}
		if (notaExamen <0 || notaExamen > 10) {
			System.out.println("Debe ingresar una nota valida \n");
			validarDatosNum = true;
		}
		return validarDatosNum;
	}
	//METODO PARA VALIDAR LAS CADENAS DE TEXTO (QUE NO ESTE VACIAS O NULAS)
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
	//METODO PARA VALIDAR SI UN EXAMEN QUE SE INGRESA YA ESTABA
	public static boolean validarNumExamenRepetido(String nombre, String apellido, Integer numExamen, ArrayList<Alumno> alumnoList) {
		boolean validarNumExamen = false;
		for (int i = 0; i < alumnoList.size(); i++) {
			if (alumnoList.get(i).getNombre().equals(nombre)&& alumnoList.get(i).getApellido().equals(apellido)) {
				if (alumnoList.get(i).getNumExamen().contains(numExamen)) {
					//System.out.println("Examen ya existente: \n");
					validarNumExamen = true;
				}
			}
		}
		return validarNumExamen;
	}
	//METODO PARA BUSCAR EN LA LISTA DE ALUMNOS LA POSICION DE UN ALUMNO ESPECIFICO
	public static int buscarPosicionAlumno(String nombre, String apellido, ArrayList<Alumno> alumnoList) {
		int posicion = 0;
		for (int i = 0; i < alumnoList.size(); i++) {
			if (alumnoList.get(i).getNombre().equals(nombre)&& alumnoList.get(i).getApellido().equals(apellido)) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	
	//METODO PARA VALIDAR QUE NO SE INGRESE UN ESTUDIANTE YA INGRESADO ANTERIORMENTE
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
