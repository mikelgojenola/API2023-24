package model;

import java.util.Random;

public class ListaPlatoHartzeko {
	
	//ATRIBUTUAK
	public static ListaPlato lista;
	private static ListaPlatoHartzeko nireLista = null;
	public int kopurua = 0;
	
	//ERAIKITZAILEA 
	public ListaPlatoHartzeko() {		
		lista = new ListaPlato();
	}
	
	//BESTE METODOAK	
	//GET NIRE HASIERAKO BARAJA METODOA
	public static synchronized ListaPlatoHartzeko getNireListaPlatoHartzeko() {
		if (nireLista == null) {
			nireLista = new ListaPlatoHartzeko();
		}
		return nireLista;
	}
	
	//BANAKETA METODOA
	public Plato banaketa() {
		Plato a = null;
		Random r = new Random();
		if(lista.getKop()>1){
			int random = r.nextInt(lista.getKop());
			a = lista.getPlato(random);
		}
		lista.quitarPlatoConPlato(a);		
		return a;		
	} 
		
		
	//GET KOPURUA METODOA
	public int getKopurua() {
		return this.kopurua;
	}
	
	//GET LISTA Plato METODOA
	public static ListaPlato getListaPlato() {
		return lista;
	}

	//LISTA Plato BETE METODOA
	public void listaPlatoBete() {
		int i = 0;
		while (i<100) {
			lista.sumaPlato(new Plato (false)); 
			kopurua++;
			i++;
		}
		this.kopurua = 100;			
	}

	//RESET METODOA
	public void reset() {
		lista.resetear();
		listaPlatoBete();
	}
}
