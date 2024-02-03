package main;

/**
 * Clase Main
 * @author elena
 */

public class Main {

	public static void main(String[] args) {
		Engine eng = new Engine();
		eng.start();
		
		

	}
	
	/**
	 * Método start
	 * Menú, tu nombre, que quieres hacer (switch, bucle hasta que el usuario pulse 0, si se pulsa 1 entra al método play
	 */
	
	/**
	 * Método play
	 * 1 - Generar array (según el modo de juego)
	 * 2 - Se entra en un bucle que muestra la primera secuencia (3 colores) 
	 * 	   Es un while, el bucle acaba cuando cometa un error (luego vuelve al menú) 
	 * 	   o cuando acierte los 12 colores
	 * 3 - Otro bucle while, acabará cuando falle o cuando haya acertado la secuencia (3 + i)
	 */
	
	/**
	 * Sistema de puntuación (No puntos negativos)
	 * - Si acierta un color +2 puntos 
	 * - Si acierta una secuencia +5 puntos
	 * - Si utiliza ayuda -8 puntos
	 * - Si se pasa el juego +40 puntos
	 * - Si juegas en modo difícil x2
	 */
	
	/**
	 * Una única constante en modo fácil y modo difícil, tiene que haber 15 secuencias.
	 */

}


