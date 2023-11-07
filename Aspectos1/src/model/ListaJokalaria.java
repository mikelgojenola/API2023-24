package model;


import java.util.Random;

import vista.HasieraMenua;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class ListaJokalaria {
	
	//ATRIBUTUAK
	private static Jokalaria[]lista;
	private static ListaJokalaria nireListaJokalaria = null;
	private int jokalariKop = 2;
	
	//ERAIKITZAILEA
	public ListaJokalaria() {
		this.lista = new Jokalaria[this.jokalariKop];
	}
	
	//BESTE METODOAK
	//GET NIRE LISTA JOKALARIAK METODOA	
	public static synchronized ListaJokalaria getNireListaJokalariak() {
		if (ListaJokalaria.nireListaJokalaria == null) {
			ListaJokalaria.nireListaJokalaria = new ListaJokalaria();
		}
		return ListaJokalaria.nireListaJokalaria;		
	}
	
	//GET ZERRENDA METODOA
	public static Jokalaria[] getZerrenda() {
		return lista;
	}
	
	
	//IRAKURRI METODOA
	public static void irakurri(File txt){
		FileReader fr=null;
		BufferedReader br=null;
		
		try{
			fr= new FileReader(txt);
			br= new BufferedReader(fr);
			String lerroa;
			while((lerroa=br.readLine())!=null)
				System.out.println(lerroa);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//MAIN METODOA
	/*public static void main(String[] args) {
		partidaHasieratu();
	}*/
	
	//PARTIDA HASIERATU METODOA
	/*public static void partidaHasieratu() {
		System.out.println("                MENUA");
		System.out.println("Sakatu 1 jolasteko, 2 arauak irakurtzeko edo 3 irtetzeko");
		int sarrera = Teklatua.getNireTeklatua().irakurriOsoa();
		try{
			if(sarrera==1){
				partidaJolastu();
			}
			else if(sarrera==2){
				System.out.println("Jokuaren helburua: 3 txita lortzea aurkariak baino lehen.");
				System.out.println("Arauak: Jokalari bakoitzak 4 karta hartuko ditu eta urte gehiago dituen jokalaria hasiko da."); 
				System.out.println("Zure txanda denean jokatzeko konbinaziorik izanez gero nahitaezkoa da jokaldia egitea,"); 
				System.out.println("jokaldia egin eta gero erabilitako kartak baztertu eta berri batzuk hartuko dira 4 izan arte."); 
				System.out.println("Konbinazio posiblerik ez baduzu zure aukerako karta bat baztertu eta berri bat hartuko duzu.");
				System.out.println("Konbinazio posibleak:");
				System.out.println("1. Oilo/Oilar/Habia = Arrautza bat hartu");
				System.out.println("2. Oilo/Oilo = Arrautzarik izanez gero txita bihurtu");				
				System.out.println("3. Azeria = Aurkariak arrautzaren bat izanez gero hau lapurtzen saiatu");
				System.out.println("4. Oilar/Oilar = Aurkariak azeriarekin erasoz gero hauek erabiliz arrautza defendatu dezakezu");
				System.out.println("Programak konbinazioa sartzeko eskatzen dizunean zenbakiak eskatuko ditu konbinazioa dagoela detektatu arte");

				System.out.println(" ");				
				System.out.println("Sakatu enter menura itzultzeko");
				Teklatua.getNireTeklatua().irakurriEnter();
				partidaHasieratu();
			}
			else if (sarrera ==3) {
				System.exit(1);
			}
				throw new HasieranAukeraOkerraSalbuespena();
		}catch(HasieranAukeraOkerraSalbuespena e){
			e.inprimatuMezua();
			partidaHasieratu();
		}
	}*/
	
	
	
	//KARTAK BANATU METODOA
	public static void kartakBanatu() {
		int kont = 4;
		while (kont > 0) {
			Karta k = null;
			k = HasierakoBaraja.getNireHasierakoBaraja().banaketa();
			getZerrenda()[0].getEskukoKartak().gehituKarta(k);
			//TODO
			k = HasierakoBaraja.getNireHasierakoBaraja().banaketa();
			getZerrenda()[1].getEskukoKartak().gehituKarta(k);
			kont--;
		}
	}		
	
	
	
	//PARTIDA JOLASTU METODOA	
	public static void partidaJolastu() {
		//int j,m;
		//System.out.println("Sartu zure nick-a");
		//String izena = Teklatua.getNireTeklatua().irakurriString();
		//System.out.println("Zure nick-a: " + n);
		//System.out.println("Sartu zure adina");
		//Teklatua.getNireTeklatua();
		//int adina = Teklatua.getNireTeklatua().irakurriOsoa();
		//Random rd = new Random();
		//int adinaCPU = rd.nextInt(100)+1;
		//System.out.println(adinaCPU);
		//System.out.println(e);
		//if (adinaCPU < e) {
			//System.out.println("Makina lehenengo jokalaria da");			
			//m = 0;
			//j = 1;
			
		//}
		//else {
			//System.out.println("Lehenengo jokalaria zara");
			
			//j = 0;
			//m = 1;
		//}
		//ListaJokalaria.getNireListaJokalariak().getZerrenda()[j] = new JokalariArrunta(n,e,j);
		//ListaJokalaria.getNireListaJokalariak().getZerrenda()[j].addObserver(Tableroa);
		//ListaJokalaria.getNireListaJokalariak().getZerrenda()[m] = new JokalariCPU(adinaCPU,m);
		//ListaJokalaria.getNireListaJokalariak().getZerrenda()[m].addObserver(Tableroa);
		jokoaBerrabiarazi();
		kartakBanatu();
		while (!bukaera()) {
			rondaJolastu();		
		}
		if (getZerrenda()[1].getPuntuak() == 3) {
			System.out.println("Jokua bukatu da");
			getZerrenda()[1].irabazleMezua();
		}
		
	}	
	
	
	//JOKOA BERRABIARAZI METODOA
	public static void jokoaBerrabiarazi() {
		getZerrenda()[0].denaErreseteatu();
		getZerrenda()[1].denaErreseteatu();
		HasierakoBaraja.getNireHasierakoBaraja().reset();
		ListaArrautzaHartzeko.getNireListaArrautzaHartzeko().reset();	
	}	
	
	
	//BUKAERA METODOA
	public static boolean bukaera() {
		boolean erantzuna = false;
		if (getZerrenda()[0].getPuntuak() == 3 || getZerrenda()[1].getPuntuak() == 3){
			erantzuna = true;
		}
		return erantzuna;
	}
	
	//RONDA JOLASTU METODOA
	public static void rondaJolastu() {	
		System.out.println("---------------------------------------------------");
			getZerrenda()[0].jokaldiaEgin();
			if (getZerrenda()[0].getAzeriaErabiliDu()) {
				if (!getZerrenda()[1].jokaldiExtraEgin()) {
					Arrautza a = new Arrautza(false);
					getZerrenda()[0].getEskukoArrautzak().gehituArrautza(a);
					getZerrenda()[1].getEskukoArrautzak().arrautzaKendu(0);
					getZerrenda()[0].arrautzaKop++;
					getZerrenda()[1].arrautzaKop--; 
				}
				getZerrenda()[0].imprimatuEskua();
			}		
		if (getZerrenda()[0].getPuntuak() != 3) {
			getZerrenda()[1].jokaldiaEgin();
			if (getZerrenda()[1].getAzeriaErabiliDu()) {
				if (!getZerrenda()[0].jokaldiExtraEgin()) {
					Arrautza a = new Arrautza(false);
					getZerrenda()[1].getEskukoArrautzak().gehituArrautza(a);
					getZerrenda()[0].getEskukoArrautzak().arrautzaKendu(0);
					getZerrenda()[1].arrautzaKop++;
					getZerrenda()[0].arrautzaKop--; 
					
				}	
				getZerrenda()[1].imprimatuEskua();
			}
		}else {
			System.out.println("Jokua bukatu da");
			getZerrenda()[0].irabazleMezua();
		}
		
	}
}
