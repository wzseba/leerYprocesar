package leerYprocesarPersonas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
	
	public LinkedList<Persona> getPersonasMayoresAEdad(LinkedList<Persona> p , int edad){
		
		LinkedList<Persona> listaPersonas = new LinkedList<Persona>();
		
		
		
		
		return listaPersonas;
	}

	public static void main(String[] args) throws IOException {

		RegistrarPersonas rnp = new RegistrarPersonas();
		
		LinkedList<Persona> listaPersonas = rnp.getPersonas("personas.in");
		
		for (Persona persona : listaPersonas) {
			System.out.println(persona);
		}
	}
}
