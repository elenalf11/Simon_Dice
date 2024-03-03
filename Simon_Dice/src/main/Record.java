package main;

/**
 * Clase Record
 */
public class Record {
	private final int MAX_JUGADORES = 20;
	private Jugador jugadores[];
	private int cont = 0;

	/**
	 * Constructora Record
	 */
	public Record() {
		this.jugadores = new Jugador[MAX_JUGADORES];
		this.cont = 0;

	}

	/**
	 * Metodo que muestra el ranking de los top 10 mejores jugadores
	 */
	public void showRanking() {

	}

	/**
	 * Método que ordena el ranking con el método del algoritmo de la burbuja
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
	 * Método que muestra al jugador/es con la máxima puntuación
	 */
	public void showBestPlayer() {
		
	}

}
