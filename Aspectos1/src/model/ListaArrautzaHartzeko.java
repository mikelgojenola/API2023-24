package model;

import java.util.Random;

public class ListaArrautzaHartzeko {
	
	//ATRIBUTUAK
	public static ListaArrautza lista;
	private static ListaArrautzaHartzeko nireLista = null;
	public int kopurua = 0;
	
	//ERAIKITZAILEA 
	public ListaArrautzaHartzeko() {		
		lista = new ListaArrautza();
	}
	
	//BESTE METODOAK	
	//GET NIRE HASIERAKO BARAJA METODOA
	public static synchronized ListaArrautzaHartzeko getNireListaArrautzaHartzeko() {
		if (nireLista == null) {
			nireLista = new ListaArrautzaHartzeko();
		}
		return nireLista;
	}
	
	//BANAKETA METODOA
	public Arrautza banaketa() {
		Arrautza a = null;
		Random r = new Random();
		if(lista.getKopurua()>1){
			int random = r.nextInt(lista.getKopurua());
			a = lista.getArrautza(random);
		}
		lista.kenduArrautzaArrautzaz(a);		
		return a;		
	} 
		
		
	//GET KOPURUA METODOA
	public int getKopurua() {
		return this.kopurua;
	}
	
	//GET LISTA ARRAUTZA METODOA
	public static ListaArrautza getListaArrautza() {
		return lista;
	}

	//LISTA ARRAUTZA BETE METODOA
	public void listaArrautzaBete() {
		int i = 0;
		while (i<100) {
			lista.gehituArrautza(new Arrautza (false)); 
			kopurua++;
			i++;
		}
		this.kopurua = 100;			
	}

	//RESET METODOA
	public void reset() {
		lista.erreseteatu();
		listaArrautzaBete();
	}
}
