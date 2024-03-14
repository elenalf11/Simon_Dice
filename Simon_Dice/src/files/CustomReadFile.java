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
		this.jr = new Jugador(this.nombre, this.puntos);
		this.puntos = 0;
		this.nombre = nombre;

	}

	@Override
	public void CloseReadFile() {
		try {
			this.close();
		} catch (IOException e) {
			System.out.println("Excepción capturada en el método CloseReadFile en la clase CustomReadFile");
		}

	}

	@Override
	public ArrayList LeerJugadores() {
		try {
			while(this.sc.hasNextLine()) {
				this.jr = new Jugador(this.sc.next(), this.sc.nextInt());
				this.arrayList.add(jr);
			}
		} catch (Exception e) {
			System.out.println("Excepción capturada en el método LeerJugadores en la clase CustomReadFile");
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