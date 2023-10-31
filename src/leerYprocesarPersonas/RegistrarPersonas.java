package leerYprocesarPersonas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class RegistrarPersonas {

	public LinkedList<Persona> getPersonas(String archivo) {

		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		LinkedList<Persona> listaPersonas = new LinkedList<Persona>();

		String linea;
		String[] datos;

		f = new File(archivo);
		try {

			fr = new FileReader(f);
			br = new BufferedReader(fr);
			linea = br.readLine();

			while (linea != null) {
				datos = linea.split(" ");

//				int edad = Integer.parseInt(datos[2]);
//				int dni = Integer.parseInt(datos[0]);
//
//				Persona p = new Persona(dni, datos[1], edad);
//				listaPersonas.add(p);

				listaPersonas.add(new Persona(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2])));
				linea = br.readLine();
			}

			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaPersonas;
	}

	public LinkedList<Persona> getPersonasMayoresAedad(LinkedList<Persona> p, int edad) {
		/*
		 * Implementar un método getPersonasMayoresAEdad que reciba un objeto
		 * LinkedList<Persona> y una edad y devuelva otro objeto LinkedList<Persona> con
		 * las personas cuyas edades son mayores a esa edad
		 */
		LinkedList<Persona> listaPersonas = new LinkedList<Persona>();

		for (Persona persona : p) {
			if (persona.getEdad() > edad) {
				listaPersonas.add(persona);
			}
		}

		/*
		 * Guardar esas personas en un archivo “personasMayoresDeXX.out”, donde xx sea
		 * la edad que se usó como parámetro. Guardarlo ordenado alfabéticamente
		 */

//		implementacion sin comparable
//		Collections.sort(listaPersonas, (o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));

		Collections.sort(listaPersonas);// implementacion usando la interface Comparable

		String fileName = "personasMayoresDe" + edad + ".out";
		String encoding = "UTF-8";
		try {
			PrintWriter writer = new PrintWriter(fileName, encoding);
			listaPersonas.forEach(e -> writer.println(e));

			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return listaPersonas;
	}

	public double calcularEdadPromedio(String archivo) {

		int totalEdad = 0;
		int contadorPersonas = 0;
		String[] datos;
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea;

		try {
			f = new File(archivo);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			linea = br.readLine();

			while (linea != null) {
				datos = linea.split(" ");
				int edad = Integer.parseInt(datos[2]);
				totalEdad += edad;
				contadorPersonas++;
				linea = br.readLine();
			}
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (contadorPersonas > 0)
			return Math.round(totalEdad / contadorPersonas);
		else
			return 0;

	}

	public int cantidadPersonasPorEncimaPromedio(String archivo) {
		/*
		 * Implementar un método que devuelva la cantidad de personas cuya edad está por
		 * encima de la edad promedio
		 */
		int contadorPersonas = 0;
		double promedio = calcularEdadPromedio(archivo);
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		String[] datos;
		int edad;
		
		try {
			f = new File(archivo);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			linea = br.readLine();

			while (linea != null) {
				datos = linea.split(" ");
				edad = Integer.parseInt(datos[2]);
				
				if(promedio > edad) {					
					contadorPersonas++;
				}
				linea = br.readLine();
			}
			fr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return contadorPersonas;
	}

	public Map<Integer, ArrayList<Persona>> agruparPersonasPorEdad(String archivo) {
		/*
		 * Agrupar las personas por edad, o sea, generar un archivo tal que figure en
		 * una línea la edad, y debajo todas las personas que tienen esa edad.
		 */
		
		

		return null;

	}

	public static void main(String[] args) throws IOException {

		RegistrarPersonas rnp = new RegistrarPersonas();

		/* Lista completa de personas */
		LinkedList<Persona> listaPersonas = rnp.getPersonas("personas.in");
		listaPersonas.forEach(i -> System.out.println(i));

		System.out.println("\n---------------------------\n");

		/* Personas mayore de xx ordenado alfabeticamente */
		LinkedList<Persona> aux = rnp.getPersonasMayoresAedad(listaPersonas, 37);
		for (Persona persona : aux) {
			System.out.println(persona);
		}

		System.out.println("\n---------------------------\n");
		System.out.println("\nEdad promedio\n");

		double promedioEdad = rnp.calcularEdadPromedio("personas.in");
		System.out.println(promedioEdad);
		
		System.out.println("\n---------------------------\n");
		System.out.println("\nCantidad de personas que estan por encima del promedio\n");
		
		int cantidadPersonas = rnp.cantidadPersonasPorEncimaPromedio("personas.in");
		System.out.println(cantidadPersonas);
	}
}
