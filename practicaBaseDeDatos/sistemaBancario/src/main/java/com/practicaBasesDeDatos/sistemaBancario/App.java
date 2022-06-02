package com.practicaBasesDeDatos.sistemaBancario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.practicaBasesDeDatos.sistemaBancario.entidades.Cliente;
import com.practicaBasesDeDatos.sistemaBancario.entidades.Cuenta;
import com.practicaBasesDeDatos.sistemaBancario.entidades.Empleado;
import com.practicaBasesDeDatos.sistemaBancario.entidades.Jefe;
import com.practicaBasesDeDatos.sistemaBancario.entidades.Prestamo;
import com.practicaBasesDeDatos.sistemaBancario.entidades.DetalleCliente;
import com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB.ImplementacionCliente;
import com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB.ImplementacionCuenta;
import com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB.ImplementacionEmpleado;
import com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB.ImplementacionJefe;
import com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB.ImplementacionPrestamo;
import com.practicaBasesDeDatos.sistemaBancario.implementaciones.mariaDB.ImplementacionDetalleCliente;

public class App {

	public static void main(String[] args) {
        Cliente cliente1;
//        Cliente cliente2;
//        Cuenta cuenta1;
//        Cuenta cuenta2;
//        Empleado empleado1;
        Jefe jefe1;
        Prestamo prestamo1;
        DetalleCliente detalleCliente1;
        
        ImplementacionCliente implementacionCliente = new ImplementacionCliente();
        ImplementacionCuenta implementacionCuenta = new ImplementacionCuenta();
        ImplementacionEmpleado implementacionEmpleado = new ImplementacionEmpleado();
        ImplementacionJefe implementacionJefe = new ImplementacionJefe();
        ImplementacionPrestamo implementacionPrestamo = new ImplementacionPrestamo();
        ImplementacionDetalleCliente implementacionDetalleCliente = new ImplementacionDetalleCliente();
        
        System.out.println("CLIENTES: ");
        //implementacionCliente.insertar(new Cliente(1, "kevin", "Sultana", "Bogota", 5));
        
        cliente1 = implementacionCliente.buscarPorId(4);
        System.out.println(cliente1);
        
//        cliente2 = implementacionCliente.buscarPorId(4);
//        cliente2.setNombre("Daniel");
//        cliente2.setCiudad("Manizales");
//        System.out.println(implementacionCliente.modificar(cliente2));
        
//		  System.out.println(implementacionCliente.eliminar(cliente1));
        
        for (Cliente cliente : implementacionCliente.listar()) {
			System.out.println(cliente);
		}
        System.out.println("\nCUENTAS: ");
        
//        cuenta1 = implementacionCuenta.buscarPorId(10);
//        System.out.println(cuenta1);
//        
//        //implementacionCuenta.insertar(new Cuenta(15, "Corriente"));
//        
//        cuenta2 = implementacionCuenta.buscarPorId(11);
//        
//        cuenta2.setTipoDeCuenta("PremiumDos");
//        System.out.println(implementacionCuenta.modificar(cuenta2));
//        
//        System.out.println(implementacionCuenta.eliminar(cuenta1));
        
        for (Cuenta cuenta : implementacionCuenta.listar()) {
			System.out.println(cuenta);
		}
        
        System.out.println("\nEMPLEADOS: ");
//      empleado1 = implementacionEmpleado.buscarPorId(11);
//      System.out.println(empleado1);
        
//      String fecha = "2022-5-13";
//		Date fechaDate = convertirFecha(fecha);
        
	  //implementacionCliente.insertar(new Cliente(1, "kevin", "Sultana", "Bogota", 5));
	  //implementacionEmpleado.insertar(new Empleado(13, "Juan", "32546097", fechaDate , 22));
      //empleado1.setNombre("Marcos");
      //System.out.println(implementacionEmpleado.modificar(empleado1));
        
      //System.out.println(implementacionEmpleado.eliminar(empleado1));
        
        for (Empleado empleado : implementacionEmpleado.listar()) {
			System.out.println(empleado);
		}
        
        System.out.println("\nEMPLEADOS: ");
        
        jefe1 = implementacionJefe.buscarPorId(15);
        System.out.println(jefe1);
        
      //implementacionJefe.insertar(new Jefe(15, "Mateo"));
        
      //jefe1.setNombreSubordinado("Franco");
      //System.out.println(implementacionJefe.modificar(jefe1));
        
      //System.out.println(implementacionJefe.eliminar(jefe1));
        
        for (Jefe jefe : implementacionJefe.listar()) {
			System.out.println(jefe);
		}
        
        System.out.println("\nPRESTAMOS: ");
        
        prestamo1 = implementacionPrestamo.buscarPorId(5);
        System.out.println(prestamo1);
        
      //String fechaPrestamo = "2000-5-13";
      //Date fechaDateP = convertirFecha(fechaPrestamo);
      //implementacionPrestamo.insertar(new Prestamo(10, fechaDateP, 4));
        
      //prestamo1.setFechaSolicitud(fechaDateP);
      //System.out.println(implementacionPrestamo.modificar(prestamo1));
        
      //System.out.println(implementacionPrestamo.eliminar(prestamo1));
      //System.out.println(implementacionJefe.eliminar(jefe1));
        
        for (Prestamo prestamo : implementacionPrestamo.listar()) {
			System.out.println(prestamo);
		}
        
        System.out.println("\nDETALLE_CLIENTE: ");
        
        detalleCliente1 = implementacionDetalleCliente.buscarPorId(11);
        System.out.println(detalleCliente1);
        
      //implementacionDetalleCliente.insertar(new DetalleCliente(4, 15));
        
      //detalleCliente1.setIdCliente(8);
      //System.out.println(implementacionDetalleCliente.modificar(detalleCliente1));
        
      //System.out.println(implementacionDetalleCliente.eliminar(detalleCliente1));
        
        for (DetalleCliente detalleCliente : implementacionDetalleCliente.listar()) {
			System.out.println(detalleCliente);
		}
      
        
	}
	
	public static Date convertirFecha(String fecha) {
		DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate = null;
		
		try {
			fechaDate = formatoFecha.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaDate;
	}

}
