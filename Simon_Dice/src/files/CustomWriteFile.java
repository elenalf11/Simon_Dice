package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase CustomWriteFile hereda de la superclase FileWriter y esta implementada
 * por la interfaz ICustomWriteFile
 * 
 * @author elena
 */

public class CustomWriteFile extends FileWriter implements ICustomWriteFile {
	/**
	 * Constructora super de CustomWriteFile
	 * 
	 * @param file es el fichero que va a utilizar para escribir en el
	 * @param append es una opcion que permite que el fichero no se borre en la ejecucion del programa
	 * @throws IOException es la excepcion que puede lanzar el programa
	 */
	public CustomWriteFile(File file, Boolean append) throws IOException {
		super(file, true);
	}

	/**
	 * Metodo que escribe en el fichero top.txt. Tiene una complejidad de 0(1), ya
	 * que no variara en funcion del tamano del dato.
	 * 
	 * @param chain es la cadena de texto que escribira en el fichero
	 */
	@Override
	public void WriteFile(String chain) {
		try {
			this.write(chain);
		} catch (IOException e) {
			System.out.println("Excepción capturada en el método WriteFile en la clase CustomWriteFile");
		}
	}

	/**
	 * Metodo que cierra el fichero. Tiene una complejidad 0(1) ya que no variara en
	 * funcion del tamano del dato
	 */
	@Override
	public void CloseWriteFile() {
		try {
			this.close();
		} catch (IOException e) {
			System.out.println("Excepción capturada en el método CloseWriteFile en la clase CustomWriteFile");
		}
	}
}
