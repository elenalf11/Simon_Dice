package files;

/**
 * Interfaz ICustomWriteFile sus metodos se desarrollaran en la clase
 * CustomWriteFile
 * 
 * @author elena
 */
public interface ICustomWriteFile {
	/**
	 * Metodo que cierra el fichero. Tiene una complejidad 0(1) ya que no variara en
	 * funcion del tamano del dato
	 */
	public void CloseWriteFile();

	/**
	 * Metodo que escribe en el fichero top.txt. Tiene una complejidad de 0(1), ya
	 * que no variara en funcion del tamano del dato.
	 * 
	 * @param chain es la cadena de texto que escribira en el fichero
	 */
	public void WriteFile(String chain);

}
