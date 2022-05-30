package com.bootcamp.practicaSemana5;

import java.util.Arrays;

public class CollectionCustom<T> {
	T[] arrayDeT;
	
	@SuppressWarnings("unchecked")
	public CollectionCustom(int t) {
		super();
		this.arrayDeT = (T[]) new Object[t];
	}

	public int size() {
		return arrayDeT.length;
	}
	
	public T getArrayDeT(int t) {
		return arrayDeT[t];
	}

	public void setArrayDeT(int s, T t) {
		this.arrayDeT[s] = t;
	}

	public void addFirst(T t) {
		T auxT = arrayDeT[0];
		T auxT2 = arrayDeT[0];
		if (arrayDeT[0]!=null && validarPosDisponible()== true) {
			for (int i = 0; i < arrayDeT.length-1; i++) {
				if(arrayDeT[i+1]==null) {
					auxT2 = arrayDeT[i+1];
					arrayDeT[i+1]=auxT;
					auxT= auxT2;
					break;
				}else {
					auxT2 = arrayDeT[i+1];
					arrayDeT[i+1]=auxT;
					auxT= auxT2;
				}
			}
			arrayDeT[0] = t;
		}else {
			if(validarPosDisponible()== true) {
				arrayDeT[0] = t;
			}else {
				System.out.println("No Es posible agregar, no hay posicion disponible");
			}
		}
		
	}
	
	public void addLast(T t) {
		T auxT = arrayDeT[arrayDeT.length-1];
		T auxT2 = arrayDeT[0];
		if (arrayDeT[arrayDeT.length-1] != null && validarPosDisponible()== true) {
			for (int i = arrayDeT.length-1; i > 0; i--) {
				if(arrayDeT[i-1]==null) {
					auxT2 = arrayDeT[i-1];
					arrayDeT[i-1]=auxT;
					auxT= auxT2;
					break;
				}else {
					auxT2 = arrayDeT[i-1];
					arrayDeT[i-1]=auxT;
					auxT= auxT2;
				}
			}
			arrayDeT[arrayDeT.length-1] = t;
		}else {
			if(validarPosDisponible()== true) {
				arrayDeT[arrayDeT.length-1] = t;
			}else {
				System.out.println("No Es posible agregar, no hay posicion disponible");
			}
		}
		
	}

	public void add(T t) {
		if (validarPosDisponible()== true) {
			for (int i = 0; i < arrayDeT.length; i++) {
				if (arrayDeT[i]==null) {
					arrayDeT[i] = t;
					break;
				}
			}
		}else {
			System.out.println("No se pudo agregar, no hay posiciones disponibles");
		}
		
	}
	
	public T remove(T t) {
		T auxT = arrayDeT[0];
		for (int i = 0; i < arrayDeT.length; i++) {
			if (arrayDeT[i]!=null && arrayDeT[i].equals(t)) {
				auxT=arrayDeT[i];
				arrayDeT[i]=null;
				break;
			}else {
				auxT=null;
			}
		}
		return auxT;
	}
	
	@Override
	public String toString() {
		return "\nArrayDeT: " + Arrays.toString(arrayDeT);
	}

	public void removeAll() {
		for (int i = 0; i < arrayDeT.length; i++) {
			arrayDeT[i] = null;
		}
	}
	


	public boolean empty() {
		int contPosition = 0;
		for (int i = 0; i < arrayDeT.length; i++) {
			if (arrayDeT[i]!=null) {
				contPosition++;
			}
		}
		if (contPosition>=1) {
			return false;
		}else {
			return true;
		}	
	}
	
	public boolean validarPosDisponible() {
		boolean validacion = false;
		for (int i = 0; i < arrayDeT.length; i++) {
			if (arrayDeT[i] == null) {
				validacion = true;
				break;
			}else {
				validacion = false;
			}
		}
		return validacion;
	}
}