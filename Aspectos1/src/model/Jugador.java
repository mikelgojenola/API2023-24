package model;

import java.util.ArrayList;
import java.util.Observable;

//public abstract class Jokalaria extends Observable{
public abstract class Jugador{
		
	//ATRIBUTUAK
	private int edad;
	private Combinaciones konbi;
	protected int puntos;//puntu kopurua!!
	protected boolean haUsadoMalo = false;
	private ListaCarta cartasMano;
	private ListaPlato platosMano;
	protected int platoKop;
	protected int numTurno;
	
	//ERAIKITZAILEA
	protected Jugador(int pAdina) {
		this.cartasMano = new ListaCarta();
		this.platosMano = new ListaPlato();
		this.edad = pAdina;
		this.konbi = Combinaciones.getMisCombinaciones();
		this.puntos = 0;
	}	
	
	//BESTE METODOAK
	//GET  ESKUKO CartaK METODOA
	protected ListaCarta getCartasMano(){
		return this.cartasMano;
	}
		
	//GET ESKUKO PlatoK METODOA
    protected ListaPlato getPlatosMano(){
        return this.platosMano;
    } 
	
	//GET Plato KOP METODOA
	protected int getPlatoKop() {
		return this.getPlatosMano().getKop();
	}	
	
	//GET ADINA METODOA
	protected int getEdad() {
		return this.edad;
	}
	
	//GET KONBINAZIOAK METODOA
	protected Combinaciones getCombinaciones() {
		return this.konbi;
	}
	
	//PUNTUAK ERRESETEATU METODOA
	protected void resetearPuntos() {
		puntos = 0;
	}
	
	//DENA ERRESETEATU METODOA 
	protected void resetearTodo() {
		this.getCartasMano().resetear();
		this.getPlatosMano().resetear();
		this.resetearPuntos();
	}
	
	//GET PUNTUAK METODOA
	protected int getPuntos() {
		return this.puntos;
	}
	
	//GET MALO ERABILI DU METODOA
	protected boolean getHaUsadoMalo() {
		return this.haUsadoMalo;
	}
	
	protected void resetMalo() {
		this.haUsadoMalo = false;
	}
	
	
	//JOKALDIA EGIN METODOA
	protected abstract void hacerJugada();
	
	protected abstract void hacerJugada2(ArrayList<Integer> jokaldiCartak);
	
	//JOKALDI EXTRA EGIN METODOA
	protected abstract boolean hacerJugadaExtra();
		
	
	//IMRIMATU ESKUA METODOA
	protected abstract void imprimirMano();
	
	//IRABAZLE MEZUA METODOA
	protected abstract void mensajeGanador();
	
	/*
	public void eguneratu() {
		setChanged();
		//notifyObservers(new String[] {Meter las 4 cartas en orden para poner las fotos});
	}
	*/
	
}
