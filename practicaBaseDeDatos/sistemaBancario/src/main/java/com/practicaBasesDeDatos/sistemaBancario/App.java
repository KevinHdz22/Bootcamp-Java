package com.practicaBasesDeDatos.sistemaBancario;

import com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB.ImplementacionCliente;
import com.practicaBasesDeDatos.sistemaBancario.entidades.Cliente;

public class App {

	public static void main(String[] args) {
        Cliente cliente1;
        Cliente cliente2;
        ImplementacionCliente implementacionCliente = new ImplementacionCliente();
        
        implementacionCliente.insertar(new Cliente(1, "kevin", "Sultana", "Bogota", 5));
        
        cliente1 = implementacionCliente.buscarPorId(2);
        System.out.println(cliente1);
        
        cliente2 = implementacionCliente.buscarPorId(4);
        
        //cliente2.setNombre("Daniel");
        //System.out.println(implementacionCliente.modificar(cliente2));
        
        //System.out.println(implementacionCliente.eliminar(cliente1));
        
        for (Cliente cliente : implementacionCliente.listar()) {
			System.out.println(cliente);
		}

	}

}
