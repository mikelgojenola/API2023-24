package model;


import java.util.Iterator;

public class Konbinazioak {
	
	//ATRIBUTUAK
	private static Konbinazioak nireKonbinazioak = null;

	private ListaKarta konbiKartak;
	private int konbinazioMota = 0;
	
	
	//ERAIKITZAILEA
	private Konbinazioak() {
		konbiKartak = new ListaKarta();
	}
	
	//BESTE METODOAK
	//GET KONBINAZIO MOTA METODOA
	public int getKonbinazioMota() {
		return this.konbinazioMota;
	}
	
	
	//GET NIRE KONBINAZIOAK METODOA
	public static Konbinazioak getNireKonbinazioak() {
		if (nireKonbinazioak==null){	
			nireKonbinazioak=new Konbinazioak();
		}
		return nireKonbinazioak;
	}
	
	//GET KONBI KARTAK METODOA
	public ListaKarta getKonbiKartak(){
		return konbiKartak;
	}
	
	
	//KONBINAZIOA DA METODOA
	public boolean konbinazioNormalikAhalDago(ListaKarta listaKarta, int arrautzaKop, int jokalaria)  {
		int i;
		boolean erantzuna = false;
		if (jokalaria == 1) {
			i = 0;
		}else {
			i = 1;
		}
		Karta k1 = new Karta("k1") ,k2 = new Karta("k2") ,k3 = new Karta("k3")  ,k4 = new Karta("k4");		
		Iterator<Karta> itr = listaKarta.getIteradorea();
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
		if (k1.oiloDenAlaEz() ) {//eclosionar un huevo
			kont++;
		}
		if (k2.oiloDenAlaEz()) {
			kont++;
		}
		if (k3 != null && k3.oiloDenAlaEz()) {
			kont++;
		}
		if (k4.oiloDenAlaEz()) {
			kont++;			
		}
		if (kont >= 2 && arrautzaKop > 0) {
			erantzuna = true;
			konbinazioMota = 1;
		}else if ((ListaArrautzaHartzeko.getNireListaArrautzaHartzeko().kopurua > 0) && ((k1.oiloDenAlaEz() && k2.oilarDenAlaEz() && k3.habiaDenAlaEz()) || (k1.oiloDenAlaEz() && k2.habiaDenAlaEz() && k3.oilarDenAlaEz()) || (k1.oilarDenAlaEz() && k2.oiloDenAlaEz() && k3.habiaDenAlaEz()) || (k1.oilarDenAlaEz() && k2.habiaDenAlaEz() && k3.oiloDenAlaEz()) || (k1.habiaDenAlaEz() && k2.oiloDenAlaEz() && k3.oilarDenAlaEz()) || (k1.habiaDenAlaEz() && k2.oilarDenAlaEz() && k3.oiloDenAlaEz()) || (k1.oiloDenAlaEz() && k2.oilarDenAlaEz() && k4.habiaDenAlaEz()) || (k1.oiloDenAlaEz() && k2.habiaDenAlaEz() && k4.oilarDenAlaEz()) || (k1.oilarDenAlaEz() && k2.oiloDenAlaEz() && k4.habiaDenAlaEz()) || (k1.oilarDenAlaEz() && k2.habiaDenAlaEz() && k4.oiloDenAlaEz()) || (k1.habiaDenAlaEz() && k2.oiloDenAlaEz() && k4.oilarDenAlaEz()) || (k1.habiaDenAlaEz() && k2.oilarDenAlaEz() && k4.oiloDenAlaEz()) || (k1.oiloDenAlaEz() && k3.oilarDenAlaEz() && k4.habiaDenAlaEz()) || (k1.oiloDenAlaEz() && k3.habiaDenAlaEz() && k4.oilarDenAlaEz()) || (k1.oilarDenAlaEz() && k3.habiaDenAlaEz() && k4.oiloDenAlaEz()) || (k1.oilarDenAlaEz() && k3.oiloDenAlaEz() && k4.habiaDenAlaEz()) || (k1.habiaDenAlaEz() && k3.oiloDenAlaEz() && k4.oilarDenAlaEz()) || (k1.habiaDenAlaEz() && k3.oilarDenAlaEz() && k4.oiloDenAlaEz()) || (k2.oiloDenAlaEz() && k3.oilarDenAlaEz() && k4.habiaDenAlaEz()) || (k2.oiloDenAlaEz() && k3.habiaDenAlaEz() && k4.oilarDenAlaEz()) || (k2.oilarDenAlaEz() && k3.oiloDenAlaEz() && k4.habiaDenAlaEz()) || (k2.oilarDenAlaEz() && k3.habiaDenAlaEz() && k4.oiloDenAlaEz()) || (k2.habiaDenAlaEz() && k3.oiloDenAlaEz() && k4.oilarDenAlaEz()) || (k2.habiaDenAlaEz() && k3.oilarDenAlaEz() && k4.oiloDenAlaEz()))) {//coger huevo de la pila 2
				erantzuna = true;
				konbinazioMota = 2;	
		}else if((ListaJokalaria.getNireListaJokalariak().getZerrenda()[i].arrautzaKop > 0) && (k1.azeriDenAlaEz() || k2.azeriDenAlaEz() || k3.azeriDenAlaEz() || k4.azeriDenAlaEz() ))	{
				erantzuna = true;
				konbinazioMota = 3;
		}
		return erantzuna;
	}	
}				

