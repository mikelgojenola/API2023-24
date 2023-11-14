package model;


import java.util.ArrayList;
import java.util.Iterator;

public class JugadorCPU extends Jugador{
	//ATRIBUTUAK
	
	private int txandaZenbakia;
	
	//ERAIKITZAILEA 
	public JugadorCPU(int pAdina, int pM) {
		super(pAdina);
	
		this.txandaZenbakia = pM;
	}
	
	//BESTE METODOAK	
	//JOKALDIA EGIN METODOA
	public void hacerJugada() {
		System.out.println(" ");
		System.out.println("IA-ren txanda da.");
		this.haUsadoMalo = false;
		Carta k1 = null,k2 = null,k3 = null,k4 = null, baztertzekoCarta;
		imprimirMano();
		
		boolean puedeHacerCombinaciones = this.getCombinaciones().konbinazioNormalikAhalDago2(getCartasMano(),this.platoKop, txandaZenbakia);
		//if(!this.getCombinaciones().konbinazioNormalikAhalDago2(getCartasMano(),this.platoKop, txandaZenbakia)) {
		if(puedeHacerCombinaciones == false) {
			Iterator<Carta> itr = this.getCartasMano().getIterador();
			while (itr.hasNext()) {
				k1 = itr.next();
				k2 = itr.next();
				k3 = itr.next();
				k4 = itr.next();			
			}
			baztertzekoCarta = queDescartarCPU(k1, k2, k3, k4);
			this.getCartasMano().quitarCartaConCarta(baztertzekoCarta);					
			this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
			imprimirMano();
			System.out.println("Makinak Carta bat baztertu du eta beste bat hartu du.");
		}else {
			if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 1) {//doble oilo
				if (this.platoKop >= 1) {
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());			
					this.puntos++;
					this.platoKop--;
					imprimirMano();
					System.out.println("La maquina ha utilizado Chef + Chef + Plato para conseguir un punto.");
				}else {
					puedeHacerCombinaciones = false;
					this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
					this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
					
				}
				
				
			}else if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 2) {//oilo oilar habia
				this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Chef));
				this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Rata));
				this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Cocina));
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());
				this.getPlatosMano().sumaPlato(ListaPlatoHartzeko.getNireListaPlatoHartzeko().banaketa());
				this.platoKop++;
				imprimirMano();
				System.out.println("La maquina ha utilizado Chef + Rata + Cocina para obtener un plato.");
				
			}else if (Combinaciones.getMisCombinaciones().getTipoCombinacion() == 3){//zorro
				
				//this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Cocina));
				this.getCartasMano().quitarCartaConCarta(this.getCartasMano().baztertuCartaMotaJakinda(TipoCartas.Malo));
				this.getCartasMano().meteCarta(BarajaInicial.getMiBarajaInicial().reparto());					
				this.haUsadoMalo = true;
				System.out.println("La maquina ha utilizado al Malo para robarte un plato.");
			}
		}
		
	}
	
	public void hacerJugada2(ArrayList<Integer> jokaldiCartak) {
		//TODO
	}
	
	
	
	//JOKALDI EXTRA EGIN METODOA
	public boolean hacerJugadaExtra() {
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
			System.out.println("Makinak bere Plato defendatu du bi oilar erabiliz.");
		}else {
			System.out.println("Makinak ez du Plato defendatzeko aukerarik.");
		}
		return erantzuna;
	}
	

	
	//IMPRIMATU ESKUA METODOA
	public void imprimirMano() {
		System.out.println("Makinaren Cartak:");
		System.out.println("-----------------------------------------------------");
		//System.out.println("â•”â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•—");
		this.getCartasMano().imprimirCartas();
		//System.out.println("â• â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•£");
		//System.out.print("â•‘");
		System.out.println("-----------------------------------------------------");
		System.out.print("IA-ren Platok:");
		System.out.print(this.platoKop);
		System.out.print("    Txitak:");
		System.out.println(this.puntos);
		//System.out.println(" â•‘");
		//System.out.println("â•šâ•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�");
		System.out.println("-----------------------------------------------------");
	}

	//IRABAZLE MEZUA METODOA
		public void mensajeGanador() {
			System.out.println("Makinak irabazi du!");
		}
	

	
	//ZER BAZTERTU CPU METODOA
	public Carta queDescartarCPU(Carta k1, Carta k2, Carta k3, Carta k4) {
		Carta k = null;
		int azeriKont = 0;
		int habiaKont = 0;
		int oiloKont = 0;
		int oilarKont = 0;
		if (k1.esMaloOno()) {
			azeriKont++;
		}
		if (k2.esMaloOno()) {
			azeriKont++;
		}
		if (k3.esMaloOno()) {
			azeriKont++;
		}
		if (k4.esMaloOno()) {
			azeriKont++;
		}
		if (k1.esCocinaOno()) {
			habiaKont++;
		}
		if (k2.esCocinaOno()) {
			habiaKont++;
		}
		if (k3.esCocinaOno()) {
			habiaKont++;
		}
		if (k4.esCocinaOno()) {
			habiaKont++;
		}
		if (k1.esChefOno()) {
			oiloKont++;
		}
		if (k2.esChefOno()) {
			oiloKont++;
		}
		if (k3.esChefOno()) {
			oiloKont++;
		}
		if (k4.esChefOno()) {
			oiloKont++;
		}
		if (k1.esRataOno()) {
			oilarKont++;
		}
		if (k2.esRataOno()) {
			oilarKont++;
		}
		if (k3.esRataOno()) {
			oilarKont++;
		}
		if (k4.esRataOno()) {
			oilarKont++;
		}
		if (oiloKont > 2) { //1.egoera
			if (k1.esChefOno()) {
				k = k1;
			}else if (k2.esChefOno()) {
				k = k2;
			}
		}else if (oilarKont > 2) { //2.egoera
			if (k1.esRataOno()) {
				k = k1;
			}else if (k2.esRataOno()) {
				k = k2;
			}
		}else if (habiaKont > 1) { //3.egoera
			if (k1.esCocinaOno()) {
				k = k1;
			}else if (k2.esCocinaOno()) {
				k = k2;
			}else if (k3.esCocinaOno()) {
				k = k3;
			}
		}else if (azeriKont > 1) { //4.egoera
			if (k1.esMaloOno()) {
				k = k1;
			}else if (k2.esMaloOno()) {
				k = k2;
			}else if (k3.esMaloOno()) {
				k = k3;
			}
		}else if (oiloKont == 2 && oilarKont == 2) { //5.egoera
			if (k1.esRataOno()) {//descartar gallo
				k = k1;
			}else if (k2.esRataOno()) {
				k = k2;
			}else if (k3.esRataOno()) {
				k = k3;
			}
		}else if (azeriKont == 1 && habiaKont == 1 && oiloKont == 2) { //6.egoera
			if (this.platoKop > 0) {//descartar nido
				if (k1.esCocinaOno()) {
					k = k1;
				}else if (k2.esCocinaOno()) {
					k = k2;
				}else if (k3.esCocinaOno()) {
					k = k3;
				}else if (k4.esCocinaOno()) {
					k = k4;
				}
			}else { // descartar gallina
				if (k1.esChefOno()) {
					k = k1;
				}else if (k2.esChefOno()) {
					k = k2;
				}else if (k3.esChefOno()) {
					k = k3;
				}
			}
		}else if (azeriKont == 1 && habiaKont == 1 && oilarKont == 2) { //7.egoera
			if (this.platoKop > 0) { //descartar zorro
				if (k1.esMaloOno()) {
					k = k1;
				}else if (k2.esMaloOno()) {
					k = k2;
				}else if (k3.esMaloOno()) {
					k = k3;
				}else if (k4.esMaloOno()) {
					k = k4;
				}
			}else {	//descartar gallo
				if (k1.esRataOno()) {
					k = k1;
				}else if (k2.esRataOno()) {
					k = k2;
				}else if (k3.esRataOno()) {
					k = k3;
				}
				
			}
		}else if (oiloKont == 2 && azeriKont == 1 && oilarKont == 1) { //8.egoera
			if (k1.esChefOno()) {
				k = k1;		
			}else if (k2.esChefOno()) {
				k = k2;
			}else if (k3.esChefOno()) {
				k = k3;
			}
		}else if (oilarKont == 2 && azeriKont == 1 && oiloKont == 1) { //9.egoera
			if (this.platoKop > 0) { //descartar zorro
				if (k1.esMaloOno()) {
					k = k1;		
				}else if (k2.esMaloOno()) {
					k = k2;
				}else if (k3.esMaloOno()) {
					k = k3;
				}else if (k4.esMaloOno()) {
					k = k4;
				}
			}else {//descartar gallo
				if (k1.esRataOno()) {
					k = k1;		
				}else if (k2.esRataOno()) {
					k = k2;
				}else if (k3.esRataOno()) {
					k = k3;
				}
				
			}
		}
		return k;
	}
}
	
	
	

