import java.util.Scanner;


/**
 git branch practica-semanal-semana2
 "Crear un branch con el nombre practica-semanal-semana2:
 Realizar el ejercicio validacion de fechas:
 Ingresar una fecha dd/mm/yyyy
 
  Validar que dd >=1 && <=31 TENIENDO EN CUENTA EL MES
  Validar que mes >=1 && <=12
  Validar que año >=1900 && <= 2099"
  
  Datos que conozco: Operaciones disponibles (V.Días, V. Meses, V.Años), Entrada fecha a validar
  
  SOLID: Principio de una sola responsabilidad
 */
public class ValidarFecha {
	
	public static void main (String[]args) {
		
		//Bandera para llevar control del ciclo while
		int bandera = 0;
		
		while (bandera == 0) {
			//Array para guardar la fecha dividida
			String[] FechaDividida;
			int day = 0;
			int month = 0;
			int year = 0;
			
			
			Scanner lectura = new Scanner (System.in);
			System.out.println("Ingrese la fecha en el formato dd/mm/yyyy : ");
			
			//Leer datos ingresados por teclado
			String fecha = lectura.next();
			System.out.println("La fecha ingresada es: " + fecha);
			
			//System.out.println (ValidarDatos (fecha));
			
			//Dividir la fecha usando metodo DividirFecha y guardar en un arreglo tipo String
			FechaDividida= DividirFecha(fecha);
			
			//Usar la clase StringBuffer para almacenar fecha
			StringBuffer AuxiliarFecha = new StringBuffer ();
		
			
			//Ciclo para recorrer el array FechaDividida y añadir cada valor en AuxiliarFecha
			for (int i=0; i<FechaDividida.length; i++){
	           AuxiliarFecha = AuxiliarFecha.append(FechaDividida[i]);
			}
			//Crear String FechaUnida para asignar el valor convertido de AuxiliarFecha
			String FechaUnida = AuxiliarFecha.toString();
			//System.out.println("Valor de FechaUnida: " + FechaUnida);
			
			//Condicion para validar que no se ingresaron letras (usando metodo ValidarDatos)
			if (ValidarDatos (FechaUnida) == false) {
				System.out.println("Fecha incorrecta, Ingrese una fecha valida (numeros) ");
			}else {
				/*
				for (int i=0; i<FechaDividida.length; i++){
		            System.out.println(FechaDividida[i]);
				}
				*/
				
				//Asignar datos del arreglo a variables tipo int (usando metodo AsignarDatos)
				 day = AsignarDatos(FechaDividida, day, 0);
				 month = AsignarDatos(FechaDividida, month, 1);
				 year = AsignarDatos(FechaDividida, year, 2);
				 
				 //variable para control del total de dias por mes
				 int dayCheck = 0;
				 //Asignar valor a dayCheck segun el mes y año para el caso bisiesto
				 dayCheck = DefinirDiasPorMes (dayCheck, month, year );
				 /*
				 System.out.println("dia: " + day);
				 System.out.println("Mes: " + month);
				 System.out.println("Año: " + year);
				 */
				 
				 //Validar Fecha ingresada por el usuario usando los metodos validarDias, validarMeses y validarYears
				 if ((validarDias(day, dayCheck) == true) && validarMeses(month) == true && validarYears(year) == true) {
					 System.out.println("Fecha correcta");
					 bandera = 1;
				 }else {
					 System.out.println("Fecha Incorrecta");
				 }
			}
			
		}
	}
	//Metodo para validar caracteres ingresado por teclado
	public static boolean ValidarDatos(String FechaUnida) {
		boolean EstadoDatos = true;
		for (int i = 0; i < FechaUnida.length(); i++) {
			if (!Character.isDigit(FechaUnida.charAt(i))) {
				EstadoDatos = false;
			}
		}
		return EstadoDatos;
	}
	
	//Metodo para Dividir la fecha (estado: String)
	public static String[] DividirFecha(String fecha) {
		//"Mediante el método split de la Clase String de Java podemos generar un array a partir de una cadena"
		// Se divide la cadena en partes donde encuentre el simbolo /
		String[] FechaDividida= fecha.split("/");
		//retorna la fecha divida (Tipo Array-String)
		return FechaDividida;
	}
	
	//Asigna los datos del array a variables tipo int (catering) y las retorna (dia, mes año)
	public static int AsignarDatos(String[] FechaDividida, int date, int aux) {
		date = Integer.parseInt(FechaDividida[aux]);
		return date;
	}
	
	//Definir dias segun sea el mes (28-30-31) y año para saber si es bisiesto
	public static int DefinirDiasPorMes(int dayCheck, int month, int year) {
			if (month == 1) {
				dayCheck= 31;
			}else {
				if (month ==2) {
					if (year % 4 == 0) {
					dayCheck= 29;
					}else {
						dayCheck= 28;
					}
				}else {
					if(month >= 3 && month <= 7) {
						if(month % 2 == 0) {
							dayCheck = 30;
						}else {
							dayCheck = 31;
						}
					}else {
						if (month > 7 && month <=12) {
							if(month % 2 == 0) {
								dayCheck = 31;
							}else {
								dayCheck = 30;
							}
						}
					}
				}
			}
			return dayCheck;
		}
	
	//Validar que el dia ingresado por el usuario sea valido
	public static boolean validarDias(int day, int dayCheck) {
		
		if (day>=1 && day<=dayCheck){
			return true;
		}
		//System.out.println("Dia inexistente");
		return false;
	}
	
	//Validar que el mes ingresado por el usuario sea valido
	public static boolean validarMeses( int month) {
		
		if (month >= 1 && month <= 12) {
			return true;
		}
		//System.out.println("Mes inexistente");
		return false;
	}
	
	//Validar que el año ingresado por el usuario se encuentre en el rango
	public static boolean validarYears(int year) {
		
		if (year >= 1900 && year <= 2099) {
			return true;
		}
		//System.out.println("Año fuera del rango");
		return false;
	}
}
	



