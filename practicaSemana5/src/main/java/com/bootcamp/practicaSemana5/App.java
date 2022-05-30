package com.bootcamp.practicaSemana5;

public class App {
	public static void main(String[] args) {
		CollectionCustom<String> tipos = new CollectionCustom <String>(10);
		System.out.println("El tamaño de la coleccion es: " + tipos.size());
		
		tipos.add("Tania");
		tipos.add("Tania2");
		System.out.println(tipos.toString());

		tipos.addLast("Daniela");
		tipos.setArrayDeT(3, "Hola Mundo");
		
		System.out.println("\nImpresion Main: ");
		for (int i = 0; i < tipos.size(); i++) {
			System.out.println(tipos.getArrayDeT(i));
		}
		
		tipos.remove("Tania");
		System.out.println(tipos.toString());
		
		tipos.addLast("Frank");
		System.out.println(tipos.toString());
		
		tipos.addLast("DanielaNuevo");
		System.out.println(tipos.toString());
		
		tipos.remove("Daniela");
		System.out.println(tipos.toString());
		
		tipos.addFirst("TaniaNuevo");
		System.out.println(tipos.toString());
		
		tipos.add("Francisco");
		System.out.println(tipos.toString());
		
		System.out.println(tipos.remove("Tania3"));
		System.out.println(tipos.toString());
	
		System.out.println(tipos.empty()); 
		
		tipos.removeAll();
		System.out.println(tipos.toString());
		
		System.out.println(tipos.empty()); 
	}
}
