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
	final private int MAX_COLORES_SEQ = 12;
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
	char _color = scanner.next().charAt(MAX_COLORES_SEQ);
	int _numColores = 4;
	int aleatorio = (int) (Math.random() * 4);
	int _index = 0;

	/**
	 * Este método relaciona el caracter que introduce el usuario con un color
	 * incluido en el enum tColores
	 * 
	 * @param _color
	 * @return
	 */
	public tColores charToColor(char _color) {
		tColores elegir1 = null;
		switch (_color) {
		case 'a':
			elegir1 = tColores.AZUL;
			break;
		case 'A':
			elegir1 = tColores.AZUL;
			break;
		case 'r':
			elegir1 = tColores.ROJO;
			break;
		case 'R':
			elegir1 = tColores.ROJO;
			break;
		case 'v':
			elegir1 = tColores.VERDE;
			break;
		case 'V':
			elegir1 = tColores.VERDE;
			break;
		case 'd':
			elegir1 = tColores.DORADO;
			break;
		case 'D':
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
		default:
			System.out.println("Número incorrecto, no se corresponde con ningún color.");
		}
		return elegir2;
	}

	/**
	 * Método que genera el array de tipo tColores
	 * 
	 * @param _numColores
	 */
	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < secuenciaColores.length; i++) {
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
		boolean comparar = false;
		
		if (_color == secuenciaColores[_index]) {
			comparar = false;
			_index++;

		} else {
			comparar = true;
			System.out.println("Fallaste, ese no era el color");
		}
		return comparar;

	}
	
	public void mostrarSecuencia(int _numero) {
		
	}
	
	public void start() {
		
		System.out.println("¡Bienvenido a Simón Dice!s");
		System.out.println("¿Cuál es su nombre?: ");
		String nombre = scanner.next();
		System.out.println("Hola " + nombre + " ,pulse ENTER para empezar a jugar");
		int num = scanner.nextInt();
		do {
			switch(num){
				case 1:
					System.out.println("Empezar a jugar");
					break;
				case 2:
					System.out.println("Salir");
					break;
				case 3:
					System.out.println("Consultar perfil");
					break;
			}
		}
		while(num != 0); 
			
		
	}

}
