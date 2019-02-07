package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.vista.Consola;
import org.iesalandalus.programacion.reservasaulas.vista.Opcion;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para la gesti�n de reservas de espacios del IES Al-�ndalus");
		int opcion = 0;
		
		do {
			Consola.mostrarCabecera("==========IES Al-�ndalus==========");
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion();
			Opcion.getOpcionSegunOrdinal(opcion).ejecutar();
		} while (opcion != 0);
	
	}

}

