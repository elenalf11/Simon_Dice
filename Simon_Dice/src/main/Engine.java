package main;

import java.util.Scanner;
import java.util.Random;

/**
 * Clase Engine
 * 
 * @author elena
 */

public class Engine {

	public enum tColores {
		ROJO, VERDE, AZUL, DORADO, BLANCO, MARRON, NARANJA
	}
	public enum tModo{
		Facil, Dificil
	}

	Scanner scanner = new Scanner(System.in);
	final int MAX_COLORES_SEQ = 15;
	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	boolean fallo;
	int _numColores;

	/**
	 * Este metodo relaciona el caracter que introduce el usuario con un color
	 * incluido en el enum tColores.
	 * 
	 * @param _color Este parametro representa el caracter del color introducido por
	 *               el usuario.
	 * @return El metodo retorna el char introducido convertido en el tipo tColores.
	 *         (convertirlo en un color del enum)
	 */
	public tColores charToColor(char _color) {
		char color = Character.toLowerCase(_color);
		switch (color) {
		case 'a':
			return tColores.AZUL;
		case 'r':
			return tColores.ROJO;
		case 'v':
			return tColores.VERDE;
		case 'd':
			return tColores.DORADO;
		case 'b':
			return tColores.BLANCO;
		case 'm':
			return tColores.MARRON;
		case 'n':
			return tColores.NARANJA;	
		default:
			System.out.println("Caracter incorrecto, no se corresponde con ningún color.");
		}
		return null;
	}

	/**
	 * Metodo que relaciona un numero(posicion del enum tColores) con un color
	 * incluido en el enum de tColores.
	 * 
	 * @param _numero Este parametro representa un numero entero.
	 * @return El metodo retorna un numero entero convertido en un tipo tColores.
	 *         (se convierte en un color del enum)
	 */
	public tColores intToColor(int _numero) {
		switch (_numero) {
		case 0:
			return tColores.ROJO;
		case 1:
			return tColores.VERDE;
		case 2:
			return tColores.AZUL;
		case 3:
			return tColores.DORADO;
		case 4:
			return tColores.BLANCO;
		case 5:
			return tColores.MARRON;
		case 6:
			return tColores.NARANJA;	
		}
		return null;
	}

	/**
	 * Metodo que genera el array de tipo tColores.
	 * 
	 * @param _numColores representa el numero de colores que tiene el tipo
	 *                    enumerado tColores.
	 */
	public void generarSecuencia(int _numColores) {
		_numColores = 6;
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(0, _numColores);
			secuenciaColores[i] = intToColor(aleatorio);
		}

	}

	/**
	 * Metodo que compara si el color que ha puesto el usuario es el mismo que pone
	 * el programa
	 * 
	 * @param _index indice que el color ocupa dentro del array secuenciaColores.
	 * @param _color color introducido por el usuario.
	 * @return Retorna que el color en la posicion _index es igual al _color
	 *         introducido por el usuario
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;

	}

	/**
	 * Metodo que imprime la secuencia creada en el metodo generarSecuencia
	 * 
	 * @param _numero numero de la secuencia actual.
	 */
	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}

	}

	public void start() {
		System.out.println("[0]--- Salir");
		System.out.println("[1]--- Jugar modo fácil");
		System.out.println("[2]--- Jugar modo difícil");
		System.out.println("¿Qué desea hacer?");
		int menu = scanner.nextInt();
		while (menu != 0) {
			switch (menu) {
			case 1:
				Engine jugar = new Engine();
				jugar.play();
				break;
			case 2:
				Engine jugar2 = new Engine();
				jugar2.play();
				break;
			}
		}
		System.out.println("Saliendo del sistema...");

	}

	/**
	 * Metodo que controla todo el flujo del juego, empezando por el control del
	 * menu, limitar la impresion de la secuencia de colores y el comparador para
	 * saber si se escribe correctamente la secuencia.
	 */
	public void play() {
		Engine jugar3 = new Engine();
		System.out.println("¡Bienvenido a Simón Dice!");
		System.out.println("¿Cuál es tu nombre? ");
		Jugador jugador = new Jugador();
		String nombre = scanner.next();
		jugador.setNombre(nombre);
		System.out.println("Hola " + jugador.getNombre() + " ,¿preparad@ para jugar?");
		generarSecuencia(MAX_COLORES_SEQ);
			
			for (int i = 0; i < MAX_COLORES_SEQ - 2; i++) {
				System.out.println("Pulse ENTER cuando esté listo... ¡SUERTE!");
				new Scanner(System.in).nextLine();

				for (int j = 0; j < 50; j++) {
					System.out.println();
				}
				mostrarSecuencia(3 + i);
				System.out.println();

				System.out.println("Memorice la secuencia, y cuando esté listo pulse ENTER...");
				new Scanner(System.in).nextLine();

				for (int j = 0; j < 50; j++) {
					System.out.println();
				}

				System.out.println("Escriba la secuencia anterior en el orden correcto, por favor");
				for (int m = 0; m < 3 + i; m++) {

					System.out.println("¿Qué color había en la posición " + (m + 1) + " = ");
					char tu_char = scanner.next().charAt(0);
					tColores char_elegido = charToColor(tu_char);

					if (comprobarColor(m, char_elegido)) {
						System.out.println("¡Correcto! Acertaste la secuencia");
						fallo = false;
					} else {
						System.out.println("¡Has perdido! la suerte no te acompañó");
						fallo = true;
						jugar3.start();
						
						

					}
				}

			}
		

		System.out.println("¡ENHORABUENA, HAS GANADO!");
		jugar3.start();
		for (int j = 0; j < 50; j++) {
			System.out.println();
		}

		scanner.close();
	}

}
