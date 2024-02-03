package main;

/**
 * Clase Jugador
 * 
 * @author elena
 */

public class Jugador {
	/**
	 * Atributos
	 */
	private String nombre;
	private int puntuacion;

	/**
	 * Constructora
	 * 
	 * @param nombre Es el nombre del usuario
	 */
	public Jugador() {
		
	}

	/**
	 * Metodo get Nombre
	 * 
	 * @return Retorna el nombre del usuario jugador
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Metodo get Puntuacion
	 * 
	 * @return Retorna la puntuacion del usuario jugador
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}

	/**
	 * Metodo set Nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo set Puntuacion
	 */
	public void setPuntuacion() {
		this.puntuacion = 0;
	}

}
