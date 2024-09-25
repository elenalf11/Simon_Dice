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
	private int ranking;
	private ArrayList<Jugador> arrayList;
	private File file;

	/**
	 * Constructora
	 */
	public Record() {
		this.MAX_JUGADORES = 10;
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
	 * @param jugador es el jugador que tenemos que anadir a la array
	 */
	public void addPlayer(Jugador jugador) {
		this.arrayList.add(jugador);

	}

	/**
	 * Metodo que muestra el ranking de los top 10 mejores jugadores
	 * 
	 * Tiene una complejidad de 0(n) donde n es this.cont (equivale al tamano
	 * ocupado del array)
	 */
	public void showRanking() {
		try {
			ordenarRanking();
			for(int i = 0; i < this.ranking; i++) {
				System.out.println(i + " - " + this.arrayList.get(i).getNombre() + " = " + this.arrayList.get(i).getPuntuacion());
			}
		}catch(Exception e) {
			System.out.println("Excepción capturada en el método showRanking en la clase Record");
		}
		
		

	}

	/**
	 * Metodo que ordena el ranking con el metodo del algoritmo de la burbuja
	 * 
	 * Tiene una complejidad de 0(n2) ya que se realizan dos busquedas
	 * simultaneamente
	 */
	public void ordenarRanking() {
		for(int i = 0; i < this.arrayList.size(); i++) {
			for (int j = 0; j < this.arrayList.size() - i - 1; j++) {
				if(this.arrayList.get(j).getPuntuacion() < this.arrayList.get(j + 1).getPuntuacion()) {
					Jugador x = this.arrayList.get(j);
					this.arrayList.set(j, this.arrayList.get(j + 1));
					this.arrayList.set(j + 1, x);
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
		while (i < this.arrayList.size() && this.arrayList.get(0).getPuntuacion() == this.arrayList.get(i).getPuntuacion()) {
			System.out.println("El mejor(es) jugador(es) es:" + this.arrayList.get(i).getNombre() + " con  "
					+ this.arrayList.get(i).getPuntuacion() + " puntos");
			i++;
		}
	}

	/**
	 * Metodo para buscar a los jugadores por su nombre
	 */
	public void buscarJugador() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿A qué jugador quieres buscar?");
		String buscar = sc.next();
		int i = 0;
		while (i < this.arrayList.size()) {
			if (buscar == this.arrayList.get(i).getNombre()) {
				System.out.println("El jugador " + this.arrayList.get(i).getNombre() + " tiene una puntuación de "
						+ this.arrayList.get(i).getPuntuacion());
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
			CustomWriteFile cwf = new CustomWriteFile(this.file);
			String chain = "";
			for (int i = 0; i < this.arrayList.size(); i++) {
				chain += this.arrayList.get(i).getNombre() + " " + this.arrayList.get(i).getPuntuacion() + "\n";
			}
			cwf.WriteFile(chain);
			cwf.CloseWriteFile();
			
			
			
		} catch (IOException e) {
			System.out.println("Excepción capturada en el método escribirRanking en la clase Record");
		}

	}

}