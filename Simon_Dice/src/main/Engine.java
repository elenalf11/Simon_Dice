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
	int aleatorio = (int) (Math.random()*4);
	

	/**
	 * Este método relaciona el caracter que introduce el usuario con un color
	 * incluido en el enum tColores
	 * 
	 * @param _color
	 * @return
	 */

	public tColores charToColor(char _color) {
		tColores elegir = null;
		switch (_color) {
		case 'a':
			elegir = tColores.AZUL;
			break;
		case 'A':
			elegir = tColores.AZUL;
			break;
		case 'r':
			elegir = tColores.ROJO;
			break;
		case 'R':
			elegir = tColores.ROJO;
			break;
		case 'v':
			elegir = tColores.VERDE;
			break;
		case 'V':
			elegir = tColores.VERDE;
			break;
		case 'd':
			elegir = tColores.DORADO;
			break;
		case 'D':
			elegir = tColores.DORADO;
			break;
		default:
			System.out.println("Caracter incorrecto, no se corresponde con ningún color.");
		}
		return elegir;
	}

	/**
	 * Método que relaciona un número(posición del enum tColores) con un color
	 * incluido en el enum de tColores
	 * 
	 * @param _numero
	 * @return
	 */
	public tColores intToColor(int _numero) {
		tColores elegir = null;
		switch (_numero) {
		case 0:
			elegir = tColores.ROJO;
			break;
		case 1:
			elegir = tColores.VERDE;
			break;
		case 2:
			elegir = tColores.AZUL;
			break;
		case 3:
			elegir = tColores.DORADO;
			break;
		default:
			System.out.println("Número incorrecto, no se corresponde con ningún color.");
		}
		return elegir;
	}
	
	/**
	 * Método que genera el array de tipo tColores
	 * @param _numColores
	 */

	public void generarSecuencia(int _numColores) {
		for(int i = 0; i < secuenciaColores.length; i++) {
			secuenciaColores[i] = intToColor(aleatorio);
			System.out.print(secuenciaColores[i]);
		}
		

	}
	
	public boolean comprobarColor(int _index, tColores _color) {
		
		
	}

}
