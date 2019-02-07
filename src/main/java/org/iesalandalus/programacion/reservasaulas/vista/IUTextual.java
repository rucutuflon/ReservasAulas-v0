package org.iesalandalus.programacion.reservasaulas.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class IUTextual {
	
	private final String ERROR = "Error";
	private final String NOMBRE_VALIDO = "Nombre valido";
	private final String CORREO_VALIDO = "Correo valido";
	private ModeloReservasAulas modelo;

	public IUTextual () {
		this.modelo = new ModeloReservasAulas();
	}
	
	public void comenzar () {
		System.out.println("COMENZANDO");
	}
	
	public void salir () {
		System.out.println("SALIENDO");
		System.exit(0);
	}

	public void insertarAula() {
		System.out.println("INSERTA UN AULA");
		try {
			modelo.insertarAula(Consola.leerAula());
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+": "+e.getMessage());
		}
		
	}

	public void borrarAula() {
		System.out.println("BORRA UN AULA");
		try {
			modelo.borrarAula(Consola.leerAula());
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+": "+e.getMessage());
		}
	}

	public void buscarAula() {
		System.out.println("BUSCA UN AULA");
		Aula a = modelo.buscarAula(Consola.leerAula());
		if(a == null) {
			System.out.println("No existe el aula buscada");
		}else {
			System.out.println(a.toString());
		}
	}

	public void listarAulas() {
		System.out.println("LISTAR LAS AULAS");
		Aula[] a = modelo.getAulas();
		for (int i = 0; i < modelo.getNumAulas(); i++) {
			System.out.println(a[i].toString());
		}
		System.out.println("TOTAL DE AULAS: "+modelo.getNumAulas());
	}

	public void insertarProfesor() {
		System.out.println("INSERTA UN PROFESOR");
		try {
			modelo.insertarProfesor(Consola.leerProfesor());
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+": "+e.getMessage());
		}
	}

	public void borrarProfesor() {
		System.out.println("BORRA UN PROFESOR");
		try {
			modelo.borrarProfesor(new Profesor(Consola.leerNombreProfesor(), "-"));
		} catch (OperationNotSupportedException e) {
			System.out.println(ERROR+": "+e.getMessage());
		}
	}

	public void buscarProfesor() {
		System.out.println("BUSCA UN PROFESOR");
		Profesor p = modelo.buscarProfesor(new Profesor(Consola.leerNombreProfesor(), "-"));
		if(p == null) {
			System.out.println("No existe el aula buscada");
		}else {
			System.out.println(p.toString());
		}
	}

	public void listarProfesores() {
		System.out.println("LISTAR LOS PROFESORES");
		Profesor[] p = modelo.getProfesores();
		for (int i = 0; i < modelo.getNumProfesores(); i++) {
			System.out.println(p[i].toString());
		}
		System.out.println("TOTAL DE PROFESORES: "+modelo.getNumProfesores());
	}

	public void realizarReserva() {
		System.out.println("REALIZA UNA RESERVA");
		Profesor p = Consola.leerProfesor();
		Aula a = Consola.leerAula();
		Permanencia per = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		if(modelo.buscarProfesor(p) == null) {
			System.out.println("No existe el profesor "+p.getNombre());
		}else if(modelo.buscarAula(a) == null) {
			System.out.println("No existe el aula "+a.getNombre());
		}else {
			Reserva r = new Reserva(p, a, per);
			try {
				modelo.realizarReserva(r);
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR+": "+e.getMessage());
			}
		}
	}

	private void leerReserva(Profesor profesor) {
		
	}

	public void anularReserva() {
		System.out.println("ANULA UNA RESERVA");
		Profesor p = Consola.leerProfesor();
		Aula a = Consola.leerAula();
		Permanencia per = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		if(modelo.buscarProfesor(p) == null) {
			System.out.println("No existe el profesor "+p.getNombre());
		}else if(modelo.buscarAula(a) == null) {
			System.out.println("No existe el aula "+a.getNombre());
		}else {
			Reserva r = new Reserva(p, a, per);
			try {
				modelo.anularReserva(r);
			} catch (OperationNotSupportedException e) {
				System.out.println(ERROR+": "+e.getMessage());
			}
		}
		
	}
	
	public void listarReservas() {
		System.out.println("LISTAR LAS RESERVAS");
		Reserva[] r = modelo.getReservas();
		for (int i = 0; i < modelo.getNumReservas(); i++) {
			System.out.println(r[i].toString());
		}
		System.out.println("TOTAL DE RESERVAS: "+modelo.getNumReservas());
		
	}
	
	public void listarReservasAula() {
		System.out.println("LISTAR LAS RESERVAS DE UN AULA");
		Aula a = Consola.leerAula();
		if(modelo.buscarAula(a) == null) {
			System.out.println("No existe el aula "+a.getNombre());
		}else {
			Reserva[] r = modelo.getReservasAula(a);
			for (int i = 0; i < r.length; i++) {
				if(r[i] != null) {
					System.out.println(r[i].toString());
				}
			}
		}
	}
	
	public void listarReservasProfesor() {
		System.out.println("LISTAR LAS RESERVAS DE UN PROFESOR");
		Profesor p = Consola.leerProfesor();
		if(modelo.buscarProfesor(p) == null) {
			System.out.println("No existe el profesor "+p.getNombre());
		}else {
			Reserva[] r = modelo.getReservasProfesor(p);
			for (int i = 0; i < r.length; i++) {
				if(r[i] != null) {
					System.out.println(r[i].toString());
				}
			}
		}
	}
	
	public void listarReservasPermanencia() {
		System.out.println("LISTAR LAS RESERVAS POR PERMANENCIA");
		Permanencia p = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		Reserva[] r = modelo.getReservasPermanencia(p);
		for (int i = 0; i < r.length; i++) {
			if(r[i] != null) {
				System.out.println(r[i].toString());
			}
		}
	}
	
	public void consultarDisponibilidad() {
		System.out.println("CONSULTA LA DISPONIBILIDAD DE UN AULA");
		Aula a = Consola.leerAula();
		Permanencia p = new Permanencia(Consola.leerDia(), Consola.leerTramo());
		if(modelo.buscarAula(a) == null) {
			System.out.println("No existe el aula "+a.getNombre());
		}else if(modelo.consultarDisponibilidad(a, p)){
			System.out.println("El aula "+a.getNombre()+" esta disponible "+p.toString());
		}else {
			System.out.println("El aula "+a.getNombre()+" no esta disponible "+p.toString());
		}
	}
}