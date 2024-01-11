package main;
import java.util.Scanner;


public class Engine {
	
	public enum tColores{ROJO, VERDE, AZUL, DORADO}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int MAX_COLORES_SEQ = 12;
		tColores [] secuenciaColores = new tColores[MAX_COLORES_SEQ];
		char _color = scanner.next().charAt(MAX_COLORES_SEQ);
		
	
	
		
		
		
		
		
		
	}
	/**
	 * Este método relaciona el caracter que introduce el usuario con un color incluido en el enum tColores
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
	
	 
	
	

}
