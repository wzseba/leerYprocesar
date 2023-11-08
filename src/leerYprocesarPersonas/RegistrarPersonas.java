package leerYprocesarPersonas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import java.util.Scanner;

public class RegistrarPersonas {

	public static LinkedList<Persona> getPersonas(String archivo) {

		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		LinkedList<Persona> listaPersonas = new LinkedList<Persona>();
		String linea;

		String[] datos;

		try {
			/*implementacion con Scanner*/
//			Scanner sc = new Scanner(new File(archivo));
//			while(sc.hasNextLine()) {
//				linea = sc.nextLine();
//				datos = linea.split(" ");
//				listaPersonas.add(new Persona(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2])));
//			}

			f = new File(archivo);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			linea = br.readLine();
			
			while (linea != null) {
				datos = linea.split(" ");

				listaPersonas.add(new Persona(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2])));
				
				linea = br.readLine();
			}
		
		} catch (FileNotFoundException fnfe) {
			
			fnfe.printStackTrace();
			
		} catch(IOException e){
			
			e.printStackTrace();
			
		}finally {
			try {
				
				if(fr != null) {
					fr.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return listaPersonas;
	}

	public static LinkedList<Persona> getPersonasMayoresAedad(LinkedList<Persona> p, int edad) {
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
//		implementacion sin comparable
//		Collections.sort(listaPersonas, (o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
		Collections.sort(listaPersonas);// implementacion usando la interface Comparable
		return listaPersonas;
	}

	public static void generarArchivoDePersonasMayores(LinkedList<Persona> personas, int edad) throws IOException {
		/*
		 * Guardar esas personas en un archivo “personasMayoresDeXX.out”, donde xx sea
		 * la edad que se usó como parámetro. Guardarlo ordenado alfabéticamente
		 */

		String fileName = "personasMayoresDe" + edad + ".out";

		LinkedList<Persona> mayores = getPersonasMayoresAedad(personas, edad);

		escribirLista(fileName, mayores);
	}

	public static void escribirLista(String salidaArchivo, List<Persona> listaPersonas) throws IOException {

		PrintWriter pr = new PrintWriter(new File(salidaArchivo));

		listaPersonas.forEach(e -> pr.println(e));

		pr.close();
	}

	public static double calcularEdadPromedio(String archivo) {

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

	public static int cantidadPersonasPorEncimaPromedio(String archivo) {
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

				if (promedio > edad) {
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

	public static Map<Integer, LinkedList<Persona>> agruparPersonasPorEdad(LinkedList<Persona> personas) {
		/*
		 * Agrupar las personas por edad, o sea, generar un archivo tal que figure en
		 * una línea la edad, y debajo todas las personas que tienen esa edad.
		 */

		Map<Integer, LinkedList<Persona>> personasPorEdad = new HashMap<Integer, LinkedList<Persona>>();
		Integer key;
		LinkedList<Persona> value;

		for (Persona persona : personas) {
			key = persona.getEdad();

			if (personasPorEdad.containsKey(key)) {
				value = personasPorEdad.get(key);
			} else {
				value = new LinkedList<Persona>();
			}
			value.add(persona);
			personasPorEdad.put(key, value);
		}

		return personasPorEdad;
	}

	public static void generarPersonasPorEdad(Map<Integer, LinkedList<Persona>> map, String file) {
		/*
		 * generar un archivo tal que figure en una línea la edad, y debajo todas las
		 * personas que tienen esa edad.
		 * "personasAgrupadasPorEdad.out"
		 */
		try {
			PrintWriter pr = new PrintWriter(new File(file));
			
			for (Map.Entry<Integer, LinkedList<Persona>> entry : map.entrySet()) {
				Integer key = entry.getKey();
				List<Persona> val = entry.getValue();
				pr.println(key);
				for (Persona persona : val) {
					pr.println(persona);
				}
				pr.println("-------------------");
			}
			
			pr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {

		/*Se utilizan metodos static para no tener que invocarlos atravez de un objeto y solo usamos metodos de la clase*/

		/* Lista completa de personas */
		LinkedList<Persona> listaPersonas = RegistrarPersonas.getPersonas("personas.in");
		listaPersonas.forEach(i -> System.out.println(i));

//
//		System.out.println("\n---------------------------\n");
//		generarArchivoDePersonasMayores(listaPersonas, 39);
		
//		generarPersonasPorEdad(agruparPersonasPorEdad(listaPersonas));
		/* Personas mayore de xx ordenado alfabeticamente */
//		LinkedList<Persona> aux = rnp.getPersonasMayoresAedad(listaPersonas, 37);
//		for (Persona persona : aux) {
//			System.out.println(persona);
//		}
//
//		System.out.println("\n---------------------------\n");
//		System.out.println("\nEdad promedio\n");
//
//		double promedioEdad = rnp.calcularEdadPromedio("personas.in");
//		System.out.println(promedioEdad);
//		
//		System.out.println("\n---------------------------\n");
//		System.out.println("\nCantidad de personas que estan por encima del promedio\n");
//		
//		int cantidadPersonas = rnp.cantidadPersonasPorEncimaPromedio("personas.in");
//		System.out.println(cantidadPersonas);
	}
}
