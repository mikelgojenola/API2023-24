package model;

import java.util.ArrayList;



public class ListaArrautza {
	
	//ATRIBUTUAK
	private ArrayList<Arrautza> lista;
	private int arrautzaKop = 0; 
	
	
	//ERAIKITZAILEA
	public ListaArrautza() {
		this.lista = new ArrayList<Arrautza>();
	
	}
	
	//BESTE METODOAK	
	//GET ARRAUTZA METODOA
		public Arrautza getArrautza(int pPos) {
			Arrautza a = lista.get(pPos);
			return a;
		}
	
	
	//ARRAUTZA KENDU METODOA
	public void arrautzaKendu(int pPos) {
		this.lista.remove(pPos);
		arrautzaKop--;
	}
	
	//GEHITU ARRAUTZA METODOA
	public void gehituArrautza(Arrautza pArrautza) {
		this.lista.add(pArrautza);
		arrautzaKop++;
	}
	
	//ERRESETEATU METODOA
	public void erreseteatu(){
		this.lista.clear();
		this.arrautzaKop = 0;
	}	
	
	//GET LISTA ARRAUTZA METODOA
	public ArrayList<Arrautza> getListaArrautza() {
		return lista;
	}
	
	//KENDU KARTA KARTAZ METODOA
		public void kenduArrautzaArrautzaz(Arrautza pArrautza) {
			lista.remove(pArrautza);
			arrautzaKop--;
		}	
	
	//GET KOPURUA METODOA
	public int getKopurua() {
		return this.arrautzaKop;
	}
	
	
	
	
	
}
