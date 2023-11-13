package model;

import java.util.ArrayList;
import java.util.Iterator;

public class JugadorNormal extends Jugador {
	
	//ATRIBUTUAK
	private int txandaZenbakia;
	
	
	//ERAIKITZAILEA
	public JugadorNormal(String pIzena, int pAdina, int pJ){
		super(pAdina);
		this.txandaZenbakia = pJ;
	}
	
	//BESTE METODOAK		
	//IMPRIMATU ESKUA METODOA
	public void imprimirMano() {
		int i;
		if (txandaZenbakia == 0) {
			i = 1;
		}else {
			i = 0;
		}
		System.out.println("Zure eskuko Cartak:");
		System.out.println("-----------------------------------------------------");
		//System.out.println("â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—");
		this.getCartasMano().imprimirCartas();
		//System.out.println("â• â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•£");
		//System.out.print("â•‘");
		System.out.println("-----------------------------------------------------");
		System.out.print(" Platok:");
		System.out.print(this.platoKop);
		System.out.print("    Txitak:");
		System.out.println(this.puntos);
		System.out.println("-----------------------------------------------------");
		//System.out.println(" â•‘");
		//System.out.println("â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�");	
		System.out.println("IA-ren Platok:");
		//System.out.println("â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—");
		//System.out.print("â•‘");
		System.out.print(" Platok:");
		System.out.print(Juego.getMiJuego().getLista()[i].platoKop);
		System.out.print("    Txitak:");
		System.out.println(Juego.getMiJuego().getLista()[i].puntos);
		System.out.println("-----------------------------------------------------");
		//System.out.println(" â•‘");
		//System.out.println("â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�");
		
	}
	
	//GET TXANDA ZENBAKIA METODOA
	public int getTxandaZenbakia() {
		return this.txandaZenbakia;
	}
	
	//JOKALDIA EGIN METODOA
	public void hacerJugada() {
		int aukera = 0;
		System.out.println(" ");
		System.out.println("Zure txanda da.");
		System.out.println(" ");
		int s1, s2;
		this.haUsadoMalo = false;
		imprimirMano();
		//while (aukera != 1 || aukera != 2) {
		while (aukera != 1 && aukera != 2) {
			if(!this.getCombinaciones().hayCombinacionNormal(getCartasMano(),this.platoKop, txandaZenbakia)) {
				System.out.println("Aukeratu Carta bat baztertzeko eta berri bat hartu multzotik");			
				s1 = Teklatua.getNireTeklatua().irakurriOsoa();
				while (s1 != 1 && s1 != 2 && s1 != 3 && s1 != 4) {
					System.out.println("Aukeratu berriz baztertuko duzun Carta");
					s1 = Teklatua.getNireTeklatua().irakurriOsoa();
				}
				this.getCartasMano().quitarCartaConNum(s1-1);						
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
				aukera = 1;
				imprimirMano();
			}
			else {
				System.out.println("Aukeratu egin nahi duzun jokaldia:");
				System.out.println("1-Carta baztertu");
				System.out.println("2-Cartak jokatu");
				aukera = Teklatua.getNireTeklatua().irakurriOsoa();
				if (aukera == 1) {
					System.out.println("Aukeratu Carta bat baztertzeko eta berri bat hartu multzotik");			
					s1 = Teklatua.getNireTeklatua().irakurriOsoa();
					while (s1 != 1 && s1 != 2 && s1 != 3 && s1 != 4) {
						System.out.println("Aukeratu berriz baztertuko duzun Carta");
						s1 = Teklatua.getNireTeklatua().irakurriOsoa();
					}
					this.getCartasMano().quitarCartaConNum(s1-1);						
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());			
					imprimirMano();
				}else if(aukera == 2) {
					System.out.println("Aukeratu Cartak jokaldia egiteko:");
					int i = 0;
					ListaCarta lista = new ListaCarta();
					s2 = Teklatua.getNireTeklatua().irakurriOsoa();
					lista.meteCarta(this.getCartasMano().getCarta(s2-1));
					while (!this.getCombinaciones().hayCombinacionNormal(lista, this.platoKop, txandaZenbakia)) {
						s2 = Teklatua.getNireTeklatua().irakurriOsoa();
						lista.meteCarta(this.getCartasMano().getCarta(s2-1));		
						i++;
						if (i == 3 ) {
							System.out.println("Konbinazio okerra");
							lista.resetear();
							i = -1;
						}
					}
					if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 1) {//oilo oilo
						this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
						this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
						this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
						this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
						this.getPlatosMano().quitaPlato(0);
						this.puntos++;
						this.platoKop--;
						imprimirMano();
					} else if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 2) {//oilo oilar habia
						this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
						this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Rata));
						this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Cocina));
						this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
						this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
						this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
						this.getPlatosMano().sumaPlato(ListaPlatoHartzeko.getNireListaPlatoHartzeko().banaketa());
						this.platoKop++;
						imprimirMano();				
					}else if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 3) {//zorro
						this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Malo));
						this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());						
						this.haUsadoMalo = true;				
					}
				}
			}
		}
	}
	
	public void hacerJugada2(ArrayList<Integer> jokaldiCartak) {
		if(jokaldiCartak.size() == 5) {
			desCartatu(jokaldiCartak.get(0));
		} else {
			ListaCarta lista = new ListaCarta();
			for(int i = 0; i < jokaldiCartak.size(); i++) {
				Carta k = this.getCartasMano().getCarta(jokaldiCartak.get(i)-1);
				lista.meteCarta(k);
			}
			if (!this.getCombinaciones().konbinazioNormalikAhalDago2(lista, this.platoKop, txandaZenbakia)) {
	
			}
			else {
				if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 1) {//oilo oilo
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
					this.getPlatosMano().quitaPlato(0);
					this.puntos++;
					this.platoKop--;
					imprimirMano();
				} else if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 2) {//oilo oilar habia
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Rata));
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Cocina));
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
					this.getPlatosMano().sumaPlato(ListaPlatoHartzeko.getNireListaPlatoHartzeko().banaketa());
					this.platoKop++;
					imprimirMano();				
				}else if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 3) {//zorro
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Malo));
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());						
					this.haUsadoMalo = true;	
					imprimirMano();				
				}
			}
		}
	}
	
	public void desCartatu(int kPos) {
		this.getCartasMano().quitarCartaConNum(kPos-1);	
		this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());			
		imprimirMano();
	}

	
	
	
	//IRABAZLE MEZUA METODOA
	public void mensajeGanador() {
		System.out.println("Irabazlea zara!");
	}
	
	
	//JOKALDI EXTRA EGIN METODOA
	public boolean hacerJugadaExtra() {
		/*boolean erantzuna = false;
		int s1,s2;
		if (this.getCartasMano().puedoDefender()) {
			System.out.println("Aukeratu Cartak defendatzeko");
			s1 = Teklatua.getNireTeklatua().irakurriOsoa();
			s2 = Teklatua.getNireTeklatua().irakurriOsoa();
			this.getCartasMano().quitarCartaConNum(s2-1);
			this.getCartasMano().quitarCartaConNum(s1-1);
			this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
			this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());	
			erantzuna = true;
		}
		return erantzuna;*/
		
		boolean erantzuna = false;
		int kont = 0;
		Carta k1, k2, k3, k4;
		if(this.getCartasMano().puedoDefender()){
			
			erantzuna = true;
			Iterator<Carta> itr = this.getCartasMano().getIterador();
			k1 = itr.next();
			k2 = itr.next();
			k3 = itr.next();
			k4 = itr.next();
			if (k1.esRataOno() && kont != 2) {
				this.getCartasMano().quitarCartaConCarta(k1);
				
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
				kont++;						
			}
			if (k2.esRataOno() && kont != 2) {
				this.getCartasMano().quitarCartaConCarta(k2);
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
				kont++;						
			}
			if (k3.esRataOno() && kont != 2) {
				this.getCartasMano().quitarCartaConCarta(k3);
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
				kont++;						
			}
			if (k4.esRataOno() && kont != 2) {
				this.getCartasMano().quitarCartaConCarta(k4);
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
				kont++;						
			}	
			System.out.println("El jugador ha defendido su plato.");
		}else {
			System.out.println("El jugador no puede defender su plato.");
		}
		return erantzuna;
		
		
	}
	
	
	
	

}
