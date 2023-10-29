package leerYprocesarPersonas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
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

	public LinkedList<Persona> getPersonasMayoresAEdad(LinkedList<Persona> p, int edad) {
		/*
		 * Implementar un m�todo getPersonasMayoresAEdad que reciba un objeto
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
		 * Guardar esas personas en un archivo �personasMayoresDeXX.out�, donde xx sea
		 * la edad que se us� como par�metro. Guardarlo ordenado alfab�ticamente
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

	public int cantidadPersonasPorEncimaPromedio() {
		/*
		 * Implementar un m�todo que devuelva la cantidad de personas cuya edad est� por
		 * encima de la edad promedio
		 */
		
		

		return 0;
	}

	public static void main(String[] args) throws IOException {

		RegistrarPersonas rnp = new RegistrarPersonas();

		/* Lista completa de personas */
		LinkedList<Persona> listaPersonas = rnp.getPersonas("personas.in");
		listaPersonas.forEach(i -> System.out.println(i));

		System.out.println("\n---------------------------\n");

		/* Personas mayore de xx ordenado alfabeticamente */
		LinkedList<Persona> aux = rnp.getPersonasMayoresAEdad(listaPersonas, 37);
		for (Persona persona : aux) {
			System.out.println(persona);
		}

		System.out.println("\n---------------------------\n");

		double promedioEdad = rnp.calcularEdadPromedio("personas.in");
		System.out.println(promedioEdad);
	}
}
