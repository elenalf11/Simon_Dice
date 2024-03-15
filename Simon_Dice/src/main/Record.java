package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import files.CustomReadFile;
import files.CustomWriteFile;

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
	private ArrayList<Jugador> arrayList;
	private File file;

	/**
	 * Constructora
	 */
	public Record() {
		this.cont = 0;
		this.MAX_JUGADORES = 10;
		this.jugadores = new Jugador[this.MAX_JUGADORES];
		this.ranking = 10;
		this.arrayList = new ArrayList<Jugador>(this.MAX_JUGADORES);
		this.file = new File("./src/data/top.txt");

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
		cargarRanking();
		System.out.println("El ranking es " + this.arrayList);

	}

	/**
	 * Metodo que ordena el ranking con el metodo del algoritmo de la burbuja
	 * 
	 * Tiene una complejidad de 0(n2) ya que se realizan dos busquedas
	 * simultaneamente
	 */
	public void ordenarRanking() {
		this.arrayList.sort(null);
		//for (int i = 0; i < this.cont; i++) {
			//for (int j = 0; j < (this.cont - i - 1); j++) {
				//if (this.jugadores[j].getPuntuacion() < this.jugadores[j + 1].getPuntuacion()) {
					//Jugador x = this.jugadores[j + 1];
					//this.jugadores[j + 1] = this.jugadores[j];
					//this.jugadores[j] = x;
				//}
			//}
		//}
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
		while (i < this.cont) {
			if (buscar == this.jugadores[i].getNombre()) {
				System.out.println("El jugador " + this.jugadores[i].getNombre() + " tiene una puntuación de "
						+ this.jugadores[i].getPuntuacion());
			}
			i++;
		}
		System.out.println("Lo siento el jugador que buscabas no existe");

	}

	/**
	 * Metodo que actualiza el ranking segun los jugadores que haya escritos en el
	 * fichero
	 */
	public void cargarRanking() {
		escribirRanking();
		try (CustomReadFile crf = new CustomReadFile(this.file)) {
			this.arrayList = crf.LeerJugadores();
			crf.CloseReadFile();
		} catch (FileNotFoundException e) {
			System.out.println("Excepción capturada en el método cargarRanking en la clase Record");
		} catch (IOException e) {
			System.out.println("Excepción capturada en el método cargarRanking en la clase Record");
		}

	}

	/**
	 * Metodo que almacena la puntuacion y el nombre de los jugadores para
	 * concatenarlos y crear un fichero
	 */

	public void escribirRanking() {
		try {
			CustomWriteFile cwf = new CustomWriteFile(this.file, true);
			String chain = "";
			for (int i = 0; i < this.arrayList.size(); i++) {
				chain += this.arrayList.get(i).getPuntuacion() + " - " + this.arrayList.get(i).getNombre() + "\n";
			}
			cwf.WriteFile(chain);
			cwf.CloseWriteFile();
		} catch (IOException e) {
			System.out.println("Excepción capturada en el método escribirRanking en la clase Record");
		}

	}

}
