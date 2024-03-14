package main;

import java.util.ArrayList;
import java.util.Scanner;
import files.CustomReadFile;

/**
 * Clase Record
 * 
 * @author elena
 */
public class Record {
	private final int MAX_JUGADORES;
	private Jugador[] jugadores;
	private int cont;
	private int ranking;


	/**
	 * Constructora
	 */
	public Record() {
		this.cont = 0;
		this.MAX_JUGADORES = 10;
		this.jugadores = new Jugador[this.MAX_JUGADORES];
		this.ranking = 10;

	}

	/**
	 * Metodo para anadir jugadores al array jugadores
	 * 
	 * Tiene una complejidad de 0(1) ya que no variara en funcion del tamano del
	 * dato
	 * 
	 * @param jugador es el jugador que tenemos que añadir a la array
	 */
	public void addPlayer(Jugador jugador) {
		if (this.cont < this.MAX_JUGADORES) {
			this.jugadores[this.cont] = jugador;
			this.cont++;

		} else {
			System.out.println("No se permiten más jugadores, lo siento");
		}

	}

	/**
	 * Metodo que muestra el ranking de los top 10 mejores jugadores
	 * 
	 * Tiene una complejidad de 0(n) donde n es this.cont (equivale al tamano
	 * ocupado del array)
	 */
	public void showRanking() {
		ordenarRanking();
		for (int i = 0; i < this.ranking; i++) {
			System.out.println(i + 1 + "- " + this.jugadores[i].getNombre() + " = " + this.jugadores[i].getPuntuacion()
					+ " puntos");
		}
	}

	/**
	 * Metodo que ordena el ranking con el metodo del algoritmo de la burbuja
	 * 
	 * Tiene una complejidad de 0(n2) ya que se realizan dos busquedas
	 * simultaneamente
	 */
	public void ordenarRanking() {
		for (int i = 0; i < this.cont; i++) {
			for (int j = 0; j < (this.cont - i - 1); j++) {
				if (this.jugadores[j].getPuntuacion() < this.jugadores[j + 1].getPuntuacion()) {
					Jugador x = this.jugadores[j + 1];
					this.jugadores[j + 1] = this.jugadores[j];
					this.jugadores[j] = x;
				}
			}
		}
	}

	/**
	 * Metodo que muestra al jugador/es con la maxima puntuacion
	 * 
	 * Tiene una complejidad de 0(n) donde n es this.cont (equivale al tamano
	 * ocupado del array)
	 */
	public void showBestPlayer() {
		ordenarRanking();
		int i = 0;
		while (i < this.cont && this.jugadores[0].getPuntuacion() == this.jugadores[i].getPuntuacion()) {
			System.out.println("El mejor(es) jugador(es) es:" + this.jugadores[i].getNombre() + " con  "
					+ this.jugadores[i].getPuntuacion() + " puntos");
			i++;
		}
	}

	/**
	 * Método para buscar a los jugadores por su nombre
	 */
	public void buscarJugador() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿A qué jugador quieres buscar?");
		String buscar = sc.next();
		int i = 0;
		while(i < this.cont) {
			if(buscar == this.jugadores[i].getNombre()) {
				System.out.println("El jugador " + this.jugadores[i].getNombre() + " tiene una puntuación de " + this.jugadores[i].getPuntuacion() );
			}
			i++;
		}
		System.out.println("Lo siento el jugador que buscabas no existe");

	}
	
	/**
	 * void cargarRanking: crea un objeto del CustomReadFile (hay que pasarle el fichero de los jugadores). Hay que
	 * crear un vector -> Vector <...> miVector = file.LeerJugadores(); Esto devuelve un vector. Tenemos que recorrer
	 * el vector y coger un jugador del vector y meterlo en mi array de jugadores, hay que rellenar hasta que se acaben los jugadores
	 * del vector O hasta que nos indice MAX_JUGADORES. También va a lanzar otra excepción, hay que capturarla también
	 */
	
	public void cargarRanking() {
		CustomReadFile crf = new CustomReadFile();
		ArrayList<Jugador> arrayList = crf.LeerJugadores();
		for(int i = 0; i < this.MAX_JUGADORES; i++) {
			for(int j = 0; j < this.cont; j++) {
				this.jugadores[j] = arrayList.get(i);
			}
		}
		//Llama a LeerJugadores
	}
	
	/**
	 * void escribirRanking: va a ir al primer jugador y va coger su puntuación y su nombre y lo va a almacenar para concatenar y crear un fichero txt
	 * con el resto de posiciones del array. 
	 */
	
	public void escribirRanking() {
		
	}

}
