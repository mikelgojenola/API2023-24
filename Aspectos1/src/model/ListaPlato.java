package model;

import java.util.ArrayList;



public class ListaPlato {
	
	//ATRIBUTUAK
	private ArrayList<Plato> lista;
	private int platoKop = 0; 
	
	
	//ERAIKITZAILEA
	public ListaPlato() {
		this.lista = new ArrayList<Plato>();
	
	}
	
	//BESTE METODOAK	
	//GET Plato METODOA
		public Plato getPlato(int pPos) {
			Plato a = lista.get(pPos);
			return a;
		}
	
	
	//Plato KENDU METODOA
	public void quitaPlato(int pPos) {
		this.lista.remove(pPos);
		platoKop--;
	}
	
	//GEHITU Plato METODOA
	public void sumaPlato(Plato pPlato) {
		this.lista.add(pPlato);
		platoKop++;
	}
	
	//ERRESETEATU METODOA
	public void resetear(){
		this.lista.clear();
		this.platoKop = 0;
	}	
	
	//GET LISTA Plato METODOA
	public ArrayList<Plato> getListaPlato() {
		return lista;
	}
	
	//KENDU Carta CartaZ METODOA
		public void quitarPlatoConPlato(Plato pPlato) {
			lista.remove(pPlato);
			platoKop--;
		}	
	
	//GET KOPURUA METODOA
	public int getKop() {
		return this.platoKop;
	}
	
	
	
	
	
}
