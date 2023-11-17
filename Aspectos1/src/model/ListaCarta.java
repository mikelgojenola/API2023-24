package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaCarta {
	
	//ATRIBUTUAK
	private ArrayList<Carta> lista;
	private int CartaKop = 0;
	
	//ERAIKITZAILEA
	public ListaCarta() {
		this.lista = new ArrayList<Carta>();
	}
	
	//BESTE METODOAK
	//GET Carta METODOA
	public Carta getCarta(int pPos) {
		Carta k = lista.get(pPos);
		return k;
	}
	
	//GET Carta KOPURUA
	public int getTamano() {
		return CartaKop;
	}
	
	//KENDU Carta METODOA
	public void quitarCartaConNum(int pPos) {
		lista.remove(pPos);
		CartaKop--;
	}
	
	//KENDU Carta CartaZ METODOA
	public void quitarCartaConCarta(Carta pCarta) {
		lista.remove(pCarta);
		CartaKop--;
	}
	
	
	//GEHITU Carta METODOA
	public void meteCarta(Carta pCarta) {
		this.lista.add(pCarta);
		this.CartaKop++;
	}
	
	//SET Carta KOP METODOA
	public void setCartaKop(int pCartaKop) {
		this.CartaKop = pCartaKop;
	}
	
	//GET Carta KOP METODOA
	public int getCartaKop() {
		return this.CartaKop;
	}
		
	//ERRESETEATU METODOA
	public void resetear(){
		this.lista.clear();
	}
	
	//GET ITERADOREA METODOA
	public Iterator<Carta> getIterador(){
		return this.lista.iterator();
	}
	
	//IMPRIMATU CartaK METODOA
	public void imprimirCartas() {
		int i = 1;
		Iterator<Carta> itr = this.getIterador();
		Carta k = null;
		while (itr.hasNext()) {
			k = itr.next();
			
			System.out.print("║  ");
			System.out.print(i+".");
			k.imprimirCarta();
			i++;
		}
	}
	
	//DEFENDATU DEZAKET
	public boolean puedoDefender() {
		int kont = 0;
		Carta k;
		boolean respuesta = false;
		Iterator<Carta> itr = this.getIterador();
		while (itr.hasNext() && kont <2) {
			k = itr.next();
			if (k.esRataOno()) {
				kont++;
			}
		}
		if (kont > 1) {
			respuesta = true;
		}
		return respuesta;
	}
	
	//BAZTERTU Carta MOTA JAKINDA METODOA
	public Carta baztertuCartaMotaJakinda(TipoCartas sarrera) {
		Carta k = null, b = null;		
		Iterator<Carta> itr = this.getIterador();
		while (itr.hasNext() && k == null) {
			b = itr.next();
			if (b.mismoTipo(sarrera)) {
				k = b;
			}
		}
		return k;		
	}	
}



