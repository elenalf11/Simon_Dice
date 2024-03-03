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
	public Jugador(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = 0;
		
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
	 * Metodo que suma los puntos del usuario
	 * @param puntosmas son los puntos que hay que aumentar al usuario
	 * @return devuelve la puntuacion 
	 */
	public int SumaPuntos (int puntosmas) {
		return this.puntuacion += puntosmas;
	}
	/**
	 * Metodo que resta los puntos del usuario
	 * @param puntosmenos son los puntos que hay que quitar al usuario
	 * @return devuelve la puntuacion 
	 */
	public int RestaPuntos (int puntosmenos) {
		return this.puntuacion -= puntosmenos;
	}
	/**
	 * Metodo que obtiene la puntuacion total del jugador
	 * @param puntuacion es la puntuacion total del jugador
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}


}
