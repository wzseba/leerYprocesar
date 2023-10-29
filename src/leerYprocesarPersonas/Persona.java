package leerYprocesarPersonas;

public class Persona {
	
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
	
	

}
