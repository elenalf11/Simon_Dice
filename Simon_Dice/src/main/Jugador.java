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
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
		
	}

	/**
	 * Metodo get Nombre
	 * 
	 * Tiene una complejidad de 0(1) ya que no variara en funcion del tamano del dato
	 * 
	 * @return Retorna el nombre del usuario jugador
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Metodo get Puntuacion
	 * 
	 * Tiene una complejidad de 0(1) ya que no variara en funcion del tamano del dato
	 * 
	 * @return Retorna la puntuacion del usuario jugador
	 */
	public int getPuntuacion() {
		return this.puntuacion;
	}

	/**
	 * Metodo set Nombre
	 * 
	 * Tiene una complejidad de 0(1) ya que no variara en funcion del tamano del dato
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que suma los puntos del usuario
	 * 
	 * Tiene una complejidad 0(1) ya que no variara en funcion del tamano del dato
	 * 
	 * @param puntosmas son los puntos que hay que aumentar al usuario
	 * @return devuelve la puntuacion 
	 */
	public int SumaPuntos (int puntosmas) {
		return this.puntuacion += puntosmas;
	}
	/**
	 * Metodo que resta los puntos del usuario
	 * 
	 * Tiene una complejidad 0(1) ya que no variara en funcion del tamano del dato
	 * 
	 * @param puntosmenos son los puntos que hay que quitar al usuario
	 * @return devuelve la puntuacion 
	 */
	public int RestaPuntos (int puntosmenos) {
		return this.puntuacion -= puntosmenos;
	}
	/**
	 * Metodo que obtiene la puntuacion total del jugador
	 * 
	 * Tiene una complejidad de 0(1) ya que no variara en funcion del tamano del dato
	 * 
	 * @param puntuacion es la puntuacion total del jugador
	 */
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}


}
