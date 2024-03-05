package main;

/**
 * Clase Record
 * 
 * @author elena
 */
public class Record {
	private final int MAX_JUGADORES = 10;
	private Jugador [] jugadores = new Jugador[MAX_JUGADORES];
	private int cont = 0;
	
	/**
	 * Metodo para anadir jugadores al array jugadores
	 * 
	 * Tiene una complejidad de 0(1) ya que no variara en funcion del tamano del dato
	 * 
	 * @param jugador es el jugador que tenemos que añadir a la array
	 */
	public void addPlayer(Jugador jugador) {
		if(this.cont == this.jugadores.length) {
			System.out.println("No se permiten más jugadores, lo siento");
		}else {
			this.jugadores[this.cont] = jugador;
			this.cont++;
		}
		
	}

	/**
	 * Metodo que muestra el ranking de los top 10 mejores jugadores
	 * 
	 * Tiene una complejidad de 0(n) donde n es this.cont (equivale al tamano ocupado del array)
	 */
	public void showRanking() {
		ordenarRanking();
		for (int i = 0; i < this.cont; i++) {
			System.out.println(i + 1 + "- " + this.jugadores[i].getNombre() + " = " + this.jugadores[i].getPuntuacion() + " puntos");
		}
	}

	/**
	 * Metodo que ordena el ranking con el metodo del algoritmo de la burbuja
	 * 
	 * Tiene una complejidad de 0(n2) ya que se realizan dos busquedas simultaneamente
	 */
	public void ordenarRanking() {
		for(int i = 0; i < this.cont; i++) {
			for(int j = 0; j < (this.cont - i - 1); j++) {
				if(this.jugadores[j].getPuntuacion() < this.jugadores[j + 1].getPuntuacion()) {
					Jugador x = this.jugadores[j + 1];
					this.jugadores[j + 1] = this.jugadores[j];
					this.jugadores[j] = x;
				}
			}
		}
	}
	/**
	 * Metodo que muestra al jugador/es con la maxima puntuacion
	 * 
	 * Tiene una complejidad de 0(n) donde n es this.cont (equivale al tamano ocupado del array)
	 */
	public void showBestPlayer() {
		ordenarRanking();
		for(int i = 0; i < this.cont; i++) {
			if(this.jugadores[0].getPuntuacion() == this.jugadores[i].getPuntuacion()) {
				System.out.println("El mejor(es) jugador(es) es:" + this.jugadores[i].getNombre() + " con  " + this.jugadores[i].getPuntuacion() + " puntos");
			}
		}
		
		
	}

}
