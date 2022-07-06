package com.protalento.interfaces;

import java.util.List;

public interface DAO <E>{
	boolean insertar(E e);
	
	List<E> listar();
}
