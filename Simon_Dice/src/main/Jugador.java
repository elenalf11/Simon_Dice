package main;

public class Jugador {
	/**
	 * Atributos
	 */
	private String nombre;
	private int puntuacion;
	/**
	 * Constructora 
	 * @param nombre
	 */
	public Jugador(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Métodos
	 */
	public String getNombre() {
		return this.nombre;
	}
	public int getPuntuacion() {
		return this.puntuacion;
	}
	public void setNombre() {
		this.nombre = nombre;
	}
	public void setPuntuacion() {
		this.puntuacion = puntuacion;
	}

}
