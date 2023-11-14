package model;


import java.util.Iterator;

public class Combinaciones {
	
	//ATRIBUTUAK
	private static Combinaciones misCombinaciones = null;

	private ListaCarta combiCartas;
	private int tipoCombinacion = 0;
	
	
	//ERAIKITZAILEA
	private Combinaciones() {
		combiCartas = new ListaCarta();
	}
	
	//BESTE METODOAK
	//GET KONBINAZIO MOTA METODOA
	public int getTipoCombinacion() {
		return this.tipoCombinacion;
	}
	
	
	//GET NIRE KONBINAZIOAK METODOA
	public static Combinaciones getMisCombinaciones() {
		if (misCombinaciones==null){	
			misCombinaciones=new Combinaciones();
		}
		return misCombinaciones;
	}
	
	//GET KONBI CartaK METODOA
	public ListaCarta getCombiCartas(){
		return combiCartas;
	}
	
	
	//KONBINAZIOA DA METODOA
	public boolean hayCombinacionNormal(ListaCarta listaCarta, int platoKop, int jokalaria)  {
		int i;
		boolean erantzuna = false;
		if (jokalaria == 1) {
			i = 0;
		}else {
			i = 1;
		}
		Carta k1 = new Carta("k1") ,k2 = new Carta("k2") ,k3 = new Carta("k3")  ,k4 = new Carta("k4");		
		Iterator<Carta> itr = listaCarta.getIterador();
		if(itr.hasNext()) {			
			k1 = itr.next();
			if(itr.hasNext()) {
				k2 = itr.next();
				if (itr.hasNext()) {
					k3 = itr.next();
					if (itr.hasNext()) {
						k4 = itr.next();
					}
				}				
			}
		}		
		int kont = 0;
		if (k1.esChefOno() ) {//eclosionar un huevo
			kont++;
		}
		if (k2.esChefOno()) {
			kont++;
		}
		if (k3 != null && k3.esChefOno()) {
			kont++;
		}
		if (k4.esChefOno()) {
			kont++;			
		}
		if (kont >= 2 && platoKop > 0) {
			erantzuna = true;
			tipoCombinacion = 1;
		}else if ((ListaPlatoHartzeko.getNireListaPlatoHartzeko().kopurua > 0) && ((k1.esChefOno() && k2.esRataOno() && k3.esCocinaOno()) || (k1.esChefOno() && k2.esCocinaOno() && k3.esRataOno()) || (k1.esRataOno() && k2.esChefOno() && k3.esCocinaOno()) || (k1.esRataOno() && k2.esCocinaOno() && k3.esChefOno()) || (k1.esCocinaOno() && k2.esChefOno() && k3.esRataOno()) || (k1.esCocinaOno() && k2.esRataOno() && k3.esChefOno()) || (k1.esChefOno() && k2.esRataOno() && k4.esCocinaOno()) || (k1.esChefOno() && k2.esCocinaOno() && k4.esRataOno()) || (k1.esRataOno() && k2.esChefOno() && k4.esCocinaOno()) || (k1.esRataOno() && k2.esCocinaOno() && k4.esChefOno()) || (k1.esCocinaOno() && k2.esChefOno() && k4.esRataOno()) || (k1.esCocinaOno() && k2.esRataOno() && k4.esChefOno()) || (k1.esChefOno() && k3.esRataOno() && k4.esCocinaOno()) || (k1.esChefOno() && k3.esCocinaOno() && k4.esRataOno()) || (k1.esRataOno() && k3.esCocinaOno() && k4.esChefOno()) || (k1.esRataOno() && k3.esChefOno() && k4.esCocinaOno()) || (k1.esCocinaOno() && k3.esChefOno() && k4.esRataOno()) || (k1.esCocinaOno() && k3.esRataOno() && k4.esChefOno()) || (k2.esChefOno() && k3.esRataOno() && k4.esCocinaOno()) || (k2.esChefOno() && k3.esCocinaOno() && k4.esRataOno()) || (k2.esRataOno() && k3.esChefOno() && k4.esCocinaOno()) || (k2.esRataOno() && k3.esCocinaOno() && k4.esChefOno()) || (k2.esCocinaOno() && k3.esChefOno() && k4.esRataOno()) || (k2.esCocinaOno() && k3.esRataOno() && k4.esChefOno()))) {//coger huevo de la pila 2
				erantzuna = true;
				tipoCombinacion = 2;	
		}else if((Juego.getMiJuego().getLista()[i].platoKop > 0) && (k1.esMaloOno() || k2.esMaloOno() || k3.esMaloOno() || k4.esMaloOno() ))	{
				erantzuna = true;
				tipoCombinacion = 3;
		}
		return erantzuna;
	}	
	
	public boolean konbinazioNormalikAhalDago2(ListaCarta listaCarta, int platoKop, int jokalaria)  {

		boolean erantzuna = false;
		
		int kont = 0;
		int chefKop = 0;
		int rataKop = 0;
		int cocinaKop = 0;
		int maloKop = 0;
		
		for(int j = 0; j < listaCarta.getTamaño(); j++) {
			if(listaCarta.getCarta(j).getTipo().equals(TipoCartas.Chef)) {
				chefKop++;
			}
			if(listaCarta.getCarta(j).getTipo().equals(TipoCartas.Rata)) {
				rataKop++;
			}
			if(listaCarta.getCarta(j).getTipo().equals(TipoCartas.Cocina)) {
				cocinaKop++;
			}
			if(listaCarta.getCarta(j).getTipo().equals(TipoCartas.Malo)) {
				maloKop++;
			}
		}
		
		if(chefKop >= 2) {
			erantzuna = true;
			tipoCombinacion = 1;
		} 
		if(chefKop >= 1 && rataKop >= 1 && cocinaKop >= 1) {
			erantzuna = true;
			tipoCombinacion = 2;
		} 
		if(maloKop >= 1) {
			erantzuna = true;
			tipoCombinacion = 3;
		}
		
		return erantzuna;
	}
}				

