package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile{
	private Scanner sc;
	public CustomWriteFile(String path) throws IOException {
		super(path);
		this.sc = new Scanner (new FileWriter("./src/data/top.txt"));

	}
	@Override
	public void WriteFile(String chain) {
		try {
			this.write(chain);
		} catch (IOException e) {
			System.out.println("Excepción capturada en el método WriteFile en la clase CustomWriteFile");
		}
	}
	@Override
	public void CloseWriteFile() {
		try {
			this.close();
		} catch (IOException e) {			
			System.out.println("Excepción capturada en el método CloseWriteFile en la clase CustomWriteFile");
		}
	}
	/**
	 *  - void CloseWriteFile(): pertenece a la clase CustomWriteFile(cierra el fichero),
	 * lanzará una excepción, imprimir el mensaje de manera formal(try catch) e
	 * indicativo (Ex: Excepción capturada en el método x en la clase x)
	 * 
	 * 
	 * Se tiene que crear una constructora super(...) de la clase FileWriter, tenemos que mirar las constructoras de la clase FileWriter
	 */
}
