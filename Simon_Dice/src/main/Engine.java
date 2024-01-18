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
		ROJO, VERDE, AZUL, DORADO
	}

	Scanner scanner = new Scanner(System.in);
	Random rand = new Random();
	final int MAX_COLORES_SEQ = 12;
	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * Este método relaciona el caracter que introduce el usuario con un color
	 * incluido en el enum tColores
	 * 
	 * @param _color
	 * @return
	 */
	public tColores charToColor(char _color) {
		tColores elegir1 = null;
		char letra = Character.toLowerCase(_color);
		switch (_color) {
		case 'a':
			elegir1 = tColores.AZUL;
			break;
		case 'r':
			elegir1 = tColores.ROJO;
			break;
		case 'v':
			elegir1 = tColores.VERDE;
			break;
		case 'd':
			elegir1 = tColores.DORADO;
			break;
		default:
			System.out.println("Caracter incorrecto, no se corresponde con ningún color.");
		}
		return elegir1;
	}

	/**
	 * Método que relaciona un número(posición del enum tColores) con un color
	 * incluido en el enum de tColores
	 * 
	 * @param _numero
	 * @return
	 */
	public tColores intToColor(int _numero) {
		tColores elegir2 = null;
		switch (_numero) {
		case 0:
			elegir2 = tColores.ROJO;
			break;
		case 1:
			elegir2 = tColores.VERDE;
			break;
		case 2:
			elegir2 = tColores.AZUL;
			break;
		case 3:
			elegir2 = tColores.DORADO;
			break;
		}
		return elegir2;
	}

	/**
	 * Método que genera el array de tipo tColores
	 * 
	 * @param _numColores
	 */
	public void generarSecuencia(int _numColores) {
		int longitud = MAX_COLORES_SEQ - 1;
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(0, 4);
			secuenciaColores[i] = intToColor(aleatorio);
		}

	}

	/**
	 * Método que compara si el color que ha puesto el usuario es el mismo que pone
	 * el programa
	 * 
	 * @param _index
	 * @param _color
	 * @return
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;

	}

	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}

	}

	public void play() {
		System.out.println("[1]--- Jugar");
		System.out.println("[2]--- Salir");
		Scanner scanner = new Scanner(System.in);
		int menu = scanner.nextInt();

		if (menu == 2) {
			System.out.println("Saliendo del sistema...");
		} else if (menu == 1) {
			System.out.println("¡Bienvenido a Simón Dice!");
			System.out.println("¿Cuál es su nombre?");
			String nombre = scanner.next();
			System.out.println("Hola " + nombre + " , ¿preparad@ para comenzar a jugar?");

			generarSecuencia(12);

			for (int i = 0; i < MAX_COLORES_SEQ; i++) {
				System.out.println("Pulse ENTER cuando esté listo... ¡SUERTE!");
				new Scanner(System.in).nextLine();

				for (int j = 0; j < 50; j++) {
					System.out.println();
				}
				mostrarSecuencia(3 + i);
				System.out.println();
				int secuencia = i + 1;
				
				System.out.println("Memorice la secuencia, y cuando esté listo pulse ENTER...");
				new Scanner(System.in).nextLine();
				
				for(int j = 0; j < 50; j++) {
					System.out.println();
				}
				
				System.out.println("Escriba la secuencia anterior en el orden correcto, por favor");
				for(int k = 0; k < 3 + i; k++) {
					System.out.println("¿Qué color había en la posición " + (k + 1) + " = ");
					char tuchar = scanner.next().charAt(0);
					tColores char_elegido = charToColor(tuchar);
					
					if(comprobarColor(k, char_elegido)) {
						System.out.println("¡Correcto! Acertaste la secuencia");
					}else {
						System.out.println("¡Incorrecto! Lo siento, la suerte no te acompañó :`(");
					}
				}
			}
		}else {
			System.out.println("Esa opción no estaba en la lista, lee bien");
		}
		scanner.close();
	}
	
}
