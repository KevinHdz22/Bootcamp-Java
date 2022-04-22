package com.bootcamp.practica_semana4;

import javax.swing.JOptionPane;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println();
    	Avion avion1 = new Avion ("Rey de las alturas", 500, new Detalle("Azul", "Boeing", 2012),300);
    	Helicoptero helicoptero1 = new Helicoptero("Fenix", 400, new Detalle("Negro", "Eurocopter", 2018), 8);
    	Superman superman1 = new Superman("Kal-El", 550, "Kriptoniano", "Kriptonita", 1.85f, "Hombre");
    	Ovni ovni1 = new Ovni("Interplanetario", 600, "Circular");
    	
    	JOptionPane.showMessageDialog(null,"AEROPUERTO EL DORADO" );
    	JOptionPane.showMessageDialog(null, "AUTORIZACIONES: ");
    	/*
    	System.out.println(avion1.toString());
    	System.out.println(helicoptero1.toString());
    	System.out.println(superman1.toString());
    	System.out.println(ovni1.toString());
    	*/
    	JOptionPane.showMessageDialog(null, avion1);
    	avion1.aterrizar();
    	JOptionPane.showMessageDialog(null, helicoptero1);
    	helicoptero1.aterrizar();
    	JOptionPane.showMessageDialog(null, superman1);
    	superman1.aterrizar();
    	JOptionPane.showMessageDialog(null, ovni1);
    	ovni1.aterrizar();
    }
}

