package model;


import java.util.ArrayList;
import vista.Ganador;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import vista.HasieraMenua;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Juego extends Observable{
	
	//ATRIBUTUAK
	private static int m;
	private static int j;
	private static Jugador[]lista;
	private static Juego miJuego = null;
	private int jugadorKop = 2;
	
	//ERAIKITZAILEA
	public Juego() {
		this.lista = new Jugador[this.jugadorKop];
	}
	
	//BESTE METODOAK
	//GET NIRE LISTA JOKALARIAK METODOA	
	public static Juego getMiJuego() {
		if (Juego.miJuego == null) {
			Juego.miJuego = new Juego();
		}
		return Juego.miJuego;		
	}
	
	//GET ZERRENDA METODOA
	public static Jugador[] getLista() {
		return lista;
	}
	
	
	//IRAKURRI METODOA
	public static void leer(File txt){
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
				System.out.println("Arauak: Jokalari bakoitzak 4 Carta hartuko ditu eta urte gehiago dituen jokalaria hasiko da."); 
				System.out.println("Zure txanda denean jokatzeko konbinaziorik izanez gero nahitaezkoa da jokaldia egitea,"); 
				System.out.println("jokaldia egin eta gero erabilitako Cartak baztertu eta berri batzuk hartuko dira 4 izan arte."); 
				System.out.println("Konbinazio posiblerik ez baduzu zure aukerako Carta bat baztertu eta berri bat hartuko duzu.");
				System.out.println("Konbinazio posibleak:");
				System.out.println("1. Oilo/Oilar/Habia = Plato bat hartu");
				System.out.println("2. Oilo/Oilo = Platorik izanez gero txita bihurtu");				
				System.out.println("3. Azeria = Aurkariak Platoren bat izanez gero hau lapurtzen saiatu");
				System.out.println("4. Oilar/Oilar = Aurkariak azeriarekin erasoz gero hauek erabiliz Plato defendatu dezakezu");
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
	
	
	
	//CartaK BANATU METODOA
	public static void repartirCartas() {
		int kont = 4;
		ArrayList<String> listaJok = new ArrayList<String>();
		ArrayList<String> listaPC = new ArrayList<String>();
		ArrayList<String> listaKonbinao = new ArrayList<String>();
		while (kont > 0) {
			Carta k = null;
			k = BarajaInicial.getMiBarajaInicial().reparto();
			getLista()[0].getCartasMano().meteCarta(k);
			if (m == 0) {
				listaPC.add(k.tipo.toString());
			}else {
				listaJok.add(k.tipo.toString());
			}
			k = BarajaInicial.getMiBarajaInicial().reparto();
			getLista()[1].getCartasMano().meteCarta(k);
			if (m == 1) {
				listaPC.add(k.tipo.toString());
			}else {
				listaJok.add(k.tipo.toString());
			}
			kont--;
		}
		listaKonbinao.addAll(listaJok);
		listaKonbinao.addAll(listaPC);
		//TODO listaKonbinao.add(Integer.toString(platos y lo mismo con dinero))
		//eguneratuar bista
		Juego.getMiJuego().setChanged();
		Juego.getMiJuego().notifyObservers(listaKonbinao);
	}		
	
	//PARTIDA JOLASTU METODOA	
	public static void partidaJolastu(int jok, int pc) {
		j = jok;
		m = pc;
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
		repartirCartas();
		if(m == 0) {
			lehenRondaJolastu();
		}
		/*while (!bukaera()) {
			rondaJolastu();		
		}
		if (getLista()[1].getPuntos() == 3) {
			System.out.println("Jokua bukatu da");
			getLista()[1].mensajeGanador();
		}*/
		
	}	
	
	
	//JOKOA BERRABIARAZI METODOA
	public static void jokoaBerrabiarazi() {
		getLista()[0].resetearTodo();
		getLista()[1].resetearTodo();
		BarajaInicial.getMiBarajaInicial().reset();
		ListaPlatoHartzeko.getNireListaPlatoHartzeko().reset();	
	}	
	
	
	//BUKAERA METODOA
	public static boolean bukaera() {
		boolean erantzuna = false;
		if (getLista()[0].getPuntos() == 3 || getLista()[1].getPuntos() == 3){
			erantzuna = true;
		}
		return erantzuna;
	}
	
	private static void lehenRondaJolastu() {
		getLista()[0].hacerJugada(false);
		if (getLista()[0].getHaUsadoMalo()) {
			if (!getLista()[1].hacerJugadaExtra()) {
				Plato a = new Plato(false);
				getLista()[0].getPlatosMano().sumaPlato(a);
				getLista()[1].getPlatosMano().quitaPlato(0);
				getLista()[0].platoKop++;
				getLista()[1].platoKop--; 
			}
			getLista()[0].imprimirMano();
		}	
	}
	
	//RONDA JOLASTU METODOA
	public static void rondaJolastu() {	
		System.out.println("---------------------------------------------------");
		getLista()[0].hacerJugada(getLista()[m].getPlatoKop() >= 1);
		if (getLista()[0].getHaUsadoMalo()) {
			if (!getLista()[1].hacerJugadaExtra()) {
				Plato a = new Plato(false);
				getLista()[0].getPlatosMano().sumaPlato(a);
				getLista()[1].getPlatosMano().quitaPlato(0);
				getLista()[0].platoKop++;
				getLista()[1].platoKop--; 
			}
			getLista()[0].imprimirMano();
		}		
		if (getLista()[0].getPuntos() != 3) {
			getLista()[1].hacerJugada(getLista()[j].getPlatoKop() >= 1);
			if (getLista()[1].getHaUsadoMalo()) {
				if (!getLista()[0].hacerJugadaExtra()) {
					Plato a = new Plato(false);
					getLista()[1].getPlatosMano().sumaPlato(a);
					getLista()[0].getPlatosMano().quitaPlato(0);
					getLista()[1].platoKop++;
					getLista()[0].platoKop--; 

				}	
				getLista()[1].imprimirMano();
			}
		}else {
			System.out.println("Jokua bukatu da");
			getLista()[0].mensajeGanador();
		}

	}
	
	public static void rondaJolastu2(ArrayList<Integer> jokaldiCartak) {
		
		if(getLista()[m].getPuntos() == 3) {
			Ganador g = new Ganador("Maquina");
			
		}else {
			
			getLista()[j].hacerJugada2(jokaldiCartak, getLista()[m].getPlatoKop() >= 1);
			if (getLista()[j].getHaUsadoMalo()) {
				if (!getLista()[m].hacerJugadaExtra()) {
					Plato a = new Plato(false);
					getLista()[j].getPlatosMano().sumaPlato(a);
					getLista()[m].getPlatosMano().quitaPlato(0);
					getLista()[j].platoKop++;
					getLista()[m].platoKop--; 
				}
				getLista()[j].imprimirMano();
				getLista()[j].resetMalo();
			}
			
			
			if (getLista()[j].getPuntos() != 3) {
				getLista()[m].hacerJugada(getLista()[j].getPlatoKop() >= 1);
				if (getLista()[m].getHaUsadoMalo()) {
					if (!getLista()[j].hacerJugadaExtra()) {
						Plato a = new Plato(false);
						getLista()[m].getPlatosMano().sumaPlato(a);
						getLista()[j].getPlatosMano().quitaPlato(0);
						getLista()[m].platoKop++;
						getLista()[j].platoKop--; 

					}	
					getLista()[1].imprimirMano();
					getLista()[m].resetMalo();
				}
			
			}else {
				System.out.println("Jokua bukatu da");
				getLista()[0].mensajeGanador();
				Ganador g = new Ganador("Tu");
			}
			
			ArrayList<String> listaInfo = getInfoUpdate();
			Juego.getMiJuego().setChanged();
			Juego.getMiJuego().notifyObservers(listaInfo);
		}

		
	}
	
	private static ArrayList<String> getInfoUpdate() {
		int kont = 4;
		ArrayList<String> listaJok = new ArrayList<String>();
		ArrayList<String> listaPC = new ArrayList<String>();
		ArrayList<String> listaKonbinao = new ArrayList<String>();
		while (kont > 0) {
			Carta k = null;
			k = getLista()[0].getCartasMano().getCarta(4-kont);
			if (m == 0) {
				listaPC.add(k.tipo.toString());
			}else {
				listaJok.add(k.tipo.toString());
			}
			k = getLista()[1].getCartasMano().getCarta(4-kont);
			if (m == 1) {
				listaPC.add(k.tipo.toString());
			}else {
				listaJok.add(k.tipo.toString());
			}
			kont--;
		}
		listaKonbinao.addAll(listaJok);
		listaKonbinao.addAll(listaPC);
		
		if(m == 1) {
			listaKonbinao.add(String.valueOf(getLista()[0].platoKop));
			listaKonbinao.add(String.valueOf(getLista()[0].puntos));
			listaKonbinao.add(String.valueOf(getLista()[1].platoKop));
			listaKonbinao.add(String.valueOf(getLista()[1].puntos));
		} else {
			listaKonbinao.add(String.valueOf(getLista()[1].platoKop));
			listaKonbinao.add(String.valueOf(getLista()[1].puntos));
			listaKonbinao.add(String.valueOf(getLista()[0].platoKop));
			listaKonbinao.add(String.valueOf(getLista()[0].puntos));
		}
		
		
		return listaKonbinao;
	}
}
