package main;

/**
 * Clase Main
 * 
 * @author elena
 */

public class Main {

	public static void main(String[] args) {
		Engine eng = new Engine();
		eng.start();

	}

	/**
	 * - Cambiar lo de llamar a métodos dentro de
	 * otros métodos sin acabar al menos uno de ellos. 
	 * - Para hacer eso hay que
	 * preguntar cuando acabe el metodo play, otra especie de menú ¿Quieres volver a
	 * jugar? /1/2/0 
	 * - Cont es un atributo de la clase Record 
	 * - El array de
	 * jugadores de la clase Record es otro atributo (Record) 
	 * - La constante
	 * MAX_JUGADORES es un atributo de la clase Record (Record) 
	 * - Método
	 * añadirJugador para añadir nuevos jugadores (Record) 
	 * - Método que dado un
	 * nombre de un jugador, retorne el objeto jugador (public Jugador xxxx (String
	 * nombre)) (Record) 
	 * - Métodos para coger el último jugador (Posibilidad),
	 * métodos para retornar el contador (Record) 
	 * - Método OrdenarRanking, void , su
	 * utilidad es ordenar el array jugador dependiendo de sus puntuaiones (de
	 * manera descendente)(Record) 
	 * - ShowRanking, muestra los n mejores jugadores
	 * (top 10, top 5,...) 
	 * - ShowBestPlayer 
	 * - TIP: en el método play (llamada), la
	 * puntuación se actualizará solo si es mayor a la anterior, una vez se
	 * inicialice el objeto jugador se añade a la array de record
	 * - Añadir la complejidad de los metodos en el JavaDoc
	 * 
	 */

}
