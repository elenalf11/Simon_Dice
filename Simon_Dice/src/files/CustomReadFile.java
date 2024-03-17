package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import main.Jugador;

/**
 * Clase CustomReadFile hereda de la superclase FileReader y esta implentada por
 * la interfaz ICustomReadFile
 * 
 * @author elena
 */

public class CustomReadFile extends FileReader implements ICustomReadFile {
	/**
	 * Constructora super de CustomReadFile
	 * 
	 * @param file es el archivo que va ir leyendo
	 * @throws FileNotFoundException es la excepcion que puede lanzar el programa
	 */
	public CustomReadFile(File file) throws FileNotFoundException {
		super(file);
	}

	private ArrayList<Jugador> arrayList = new ArrayList<Jugador>();
	private Scanner sc = new Scanner(this);

	/**
	 * Metodo que cierra el fichero. Tiene una complejidad 0(1)ya que no variara en
	 * funcion del tamano del dato.
	 */
	@Override
	public void CloseReadFile() {
		try {
			this.close();
		} catch (IOException e) {
			System.out.println("Excepción capturada en el método CloseReadFile en la clase CustomReadFile");
		}

	}

	/**
	 * Metodo que lee el fichero, para ello utilizando el metodo split() divide la
	 * cadena de texto que lee del fichero en dos partes: puntos y nombre, para que
	 * asi sea mas sencillo anadir los jugadores al ArrayList
	 * 
	 * @return Retorna un arraylist de tipo Jugador
	 */
	@Override
	public ArrayList<Jugador> LeerJugadores() {
		try {
			while (this.sc.hasNextLine()) {
				String palabra = this.sc.nextLine();
				String[] division = palabra.split(" ", 2);
				// parseInt convierte una cadena de texto en un numero entero
				int puntos = Integer.parseInt(division[1]);
				Jugador player = new Jugador(division[0], puntos);
				this.arrayList.add(player);
			}
		} catch (Exception e) {
			System.out.println("Excepción capturada en el método LeerJugadores en la clase CustomReadFile");
		}
		return this.arrayList;
	}
}