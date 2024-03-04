package main;

/**
 * Clase Record
 */
public class Record {
	private final int MAX_JUGADORES = 10;
	private Jugador [] jugadores = new Jugador[MAX_JUGADORES];
	private int cont = 0;
	
	/**
	 * Metodo para añadir jugadores al array jugadores
	 * @param jugador es el jugador que tenemos que añadir a la array
	 */
	public void addPlayer(Jugador jugador) {
		int x = 0;
		for (int i = 0; i < this.cont; i++) {
			if(this.jugadores[i].getPuntuacion() < this.jugadores[x].getPuntuacion()) {
				x = i;
			}
		}
		if(this.cont < this.MAX_JUGADORES) {
			this.jugadores[this.cont] = jugador;
			this.cont++;
		}else {
			if(jugador.getPuntuacion() > this.jugadores[x].getPuntuacion()) {
				this.jugadores[x] = jugador;
			}
		}
	}

	/**
	 * Metodo que muestra el ranking de los top 10 mejores jugadores
	 */
	public void showRanking() {
		int x = 0;
		if (this.cont < this.MAX_JUGADORES) {
			x = this.cont;
		}else {
			x = this.MAX_JUGADORES;
		}
		ordenarRanking();
		for (int i = 0; i < x; i++) {
			System.out.println(i + 1 + "- " + this.jugadores[i].getNombre() + " = " + this.jugadores[i].getPuntuacion());
		}
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
