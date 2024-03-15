package files;

import java.util.ArrayList;

/**
 * Interfaz ICustomReadFile sus metodos se desarrollaran en la clase
 * CustomReadFile
 * 
 * @author elena
 */
public interface ICustomReadFile {
	/**
	 * Metodo que cierra el fichero. Tiene una complejidad 0(1)ya que no variara en
	 * funcion del tamano del dato.
	 */
	public void CloseReadFile();

	/**
	 * 
	 * Metodo que lee el fichero, para ello utilizando el metodo split() divide la
	 * cadena de texto que lee del fichero en dos partes: puntos y nombre, para que
	 * asi sea mas sencillo anadir los jugadores al ArrayList
	 *
	 * @return retorna un arrayList de tipo Jugador
	 */
	public ArrayList LeerJugadores();

}
