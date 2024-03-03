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

	public enum tModo {
		Facil, Dificil
	}

	Scanner scanner = new Scanner(System.in);
	private final int MAX_COLORES_SEQ = 15;
	private final int MAX_COLORES_FACIL = 4;
	private final int MAX_COLORES_DIFICIL = 6;
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	tModo[] modo = new tModo[2];
	private int puntuacion = 0;
	String nombre;
	private boolean fallo = false;
	private int ayuda = 3;

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
	 * @param _numColores_dificil representa el numero de colores que tiene el tipo
	 *                            enumerado tColores. En este caso es el referente
	 *                            al modo dificil por lo que su valor es 6
	 */
	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < this.secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(0, _numColores);
			this.secuenciaColores[i] = intToColor(aleatorio);
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
		return this.secuenciaColores[_index] == _color;

	}

	/**
	 * Metodo que imprime la secuencia creada en el metodo generarSecuencia
	 * 
	 * @param _numero numero de la secuencia actual.
	 */
	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(this.secuenciaColores[i] + " ");
		}

	}

	/**
	 * Metodo que permite utilizar las ayudas disponibles.
	 * 
	 * @param _index indice del color que se desea comprobar
	 * @return
	 */
	public boolean usarAyuda(int _index) {
		if (this.ayuda > 0) {
			this.ayuda--;
			System.out.println("El siguiente color es: " + this.secuenciaColores[_index] + " , te siguen quedando "
					+ this.ayuda + " ayudas");
			return true;

		} else {
			System.out.println("Lo siento, no tienes más ayudas");
			return false;
		}

	}

	/**
	 * Metodo que controla el inicio del juego y las diferentes opciones disponibles
	 */
	public void start() {
		int menu;
		System.out.println("¡Bienvenido a Simón Dice!");
		System.out.println("¿Cuál es tu nombre? ");
		Jugador jugador = new Jugador(this.nombre, this.puntuacion);
		String nombre = scanner.next();
		jugador.setNombre(nombre);
		do {
			System.out.println("Hola " + jugador.getNombre() + " ,¿qué desea hacer?");
			System.out.println("[0]--- Salir");
			System.out.println("[1]--- Jugar modo fácil");
			System.out.println("[2]--- Jugar modo difícil");
			System.out.println("[3]--- Ver 10 mejores jugadores");
			System.out.println("[4]--- Ver jugador(es) con la puntuación más alta");
			menu = scanner.nextInt();
			switch (menu) {
			case 0:
				System.out.println("Saliendo del sistema...");
				break;
			case 1:
				play(tModo.Facil);
				jugador.setPuntuacion(this.puntuacion);
				break;
			case 2:
				play(tModo.Dificil);
				jugador.setPuntuacion(this.puntuacion * 2);
				break;
			}
		} while (menu != 0);

	}

	/**
	 * Metodo que controla todo el flujo del juego, empezando por el control del
	 * menu, limitar la impresion de la secuencia de colores y el comparador para
	 * saber si se escribe correctamente la secuencia.
	 * 
	 * @param modo es el modo de juego que elige el usuario en el metodo play
	 */
	public int play(tModo modo) {
		Jugador jugador = new Jugador(this.nombre, this.puntuacion);
		if (modo == tModo.Facil) {
			generarSecuencia(this.MAX_COLORES_FACIL);
		} else {
			generarSecuencia(this.MAX_COLORES_DIFICIL);
		}
		int x = 0;
		do {
			while (x < this.MAX_COLORES_SEQ - 2 && this.fallo == false) {

				System.out.println("Pulse ENTER cuando esté listo... ¡SUERTE!");
				new Scanner(System.in).nextLine();

				for (int j = 0; j < 50; j++) {
					System.out.println();
				}
				mostrarSecuencia(3 + x);
				System.out.println();

				System.out.println(" Memorice la secuencia, y cuando esté listo pulse ENTER...");
				new Scanner(System.in).nextLine();

				for (int j = 0; j < 50; j++) {
					System.out.println();
				}

				System.out.println("Escriba la secuencia anterior en el orden correcto, por favor");
				int y = 0;
				while (y < (3 + x) && this.fallo == false) {
					System.out.println("¿Qué colores habían en la secuencia " + (x + 1) + " = ");
					char tu_char = scanner.next().charAt(0);
					tColores char_elegido = charToColor(tu_char);
					boolean check = true;
					while (check) {
						if (tu_char == 'x' || tu_char == 'X') {
							if (usarAyuda(y)) {
								y++;
								jugador.RestaPuntos(8);
							}
							check = false;
						} else if (comprobarColor(y, char_elegido)) {
							y++;
							System.out.println("¡Correcto! Acertaste la secuencia");
							jugador.SumaPuntos(2);
							check = false;
						} else {
							System.out.println("¡Has perdido! la suerte no te acompañó, tenías un total de "
									+ jugador.getPuntuacion(this.puntuacion) + " puntos");
							this.fallo = true;
							check = false;
						}
					}

				}
					jugador.SumaPuntos(5);
				x++;
			}
			if (x == this.MAX_COLORES_SEQ - 2) {
				jugador.SumaPuntos(40);
				System.out.println("¡ENHORABUENA, HAS GANADO! Has conseguido un total de "
						+ jugador.getPuntuacion(this.puntuacion) + " puntos");
				for (int j = 0; j < 50; j++) {
					System.out.println();
				}
			}

			scanner.close();
		} while (x < this.MAX_COLORES_SEQ && this.fallo == false);
		return puntuacion;
	}

}
