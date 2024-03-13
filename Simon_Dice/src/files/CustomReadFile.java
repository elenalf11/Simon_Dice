package files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import main.Jugador;

public class CustomReadFile extends FileReader implements ICustomReadFile {
	private Scanner sc;
	private ArrayList<Jugador> arrayList;
	private Jugador jr;
	private int puntos;
	private String nombre;
	/**
	 * Constructora super de CustomReadFile
	 * @param path es el String que toma la super Constructora
	 * @throws FileNotFoundException es la excepcion que puede lanzar el programa
	 */
	public CustomReadFile(String path) throws FileNotFoundException {
		super(path);
		this.sc = new Scanner(new FileReader("./src/data/top.txt"));
		this.arrayList = new ArrayList<Jugador>();
		this.jr = new Jugador(this.nombre);
		this.puntos = 0;
		this.nombre = nombre;

	}

	@Override
	public void CloseReadFile() {
		try {
			this.close();
		} catch (IOException e) {
			System.out.println("¡Oh!, ha ocurrido un error inesperado");
		}

	}

	@Override
	public ArrayList LeerJugadores() {
		try {
			while(this.sc.hasNextLine()) {
				this.puntos = this.sc.nextInt();
				this.nombre = this.sc.next();
				this.jr = new Jugador(this.nombre);
				this.arrayList.add(jr);
			}
		} catch (Exception e) {
			System.out.println("¡Oh!, ha ocurrido un error inesperado");
		}
		return this.arrayList;
	}
	/**
	 * 
	 * - Vector LeerJugadores(): devuelve un vector o arraylist de tipo jugador.
	 * Este método lee el archivo txt (jugadores de tipo Jugador) y los recoge para
	 * meterlos en el vector o arraylist. Para leerlo podemos usar el Scanner
	 */
}
