package leerYprocesarPersonas;

public class Persona implements Comparable<Persona> {

	private int dni;
	private int edad;
	private String nombre;

	public Persona(int dni, String nombre, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return dni + " | " + edad + " | " + nombre;
	}

	@Override
	public int compareTo(Persona o) {

		return this.nombre.compareTo(o.getNombre());

	}

}
