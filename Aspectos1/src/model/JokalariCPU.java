package model;


import java.util.Iterator;

public class JokalariCPU extends Jokalaria{
	//ATRIBUTUAK
	
	private int txandaZenbakia;
	
	//ERAIKITZAILEA 
	public JokalariCPU(int pAdina, int pM) {
		super(pAdina);
	
		this.txandaZenbakia = pM;
	}
	
	//BESTE METODOAK	
	//JOKALDIA EGIN METODOA
	public void jokaldiaEgin() {
		System.out.println(" ");
		System.out.println("IA-ren txanda da.");
		this.azeriaErabiliDu = false;
		Karta k1 = null,k2 = null,k3 = null,k4 = null, baztertzekoKarta;
		//imprimatuEskua();
		if(!this.getKonbinazioak().konbinazioNormalikAhalDago(getEskukoKartak(),this.arrautzaKop, txandaZenbakia)) {
			Iterator<Karta> itr = this.getEskukoKartak().getIteradorea();
			while (itr.hasNext()) {
				k1 = itr.next();
				k2 = itr.next();
				k3 = itr.next();
				k4 = itr.next();			
			}
			baztertzekoKarta = zerBaztertuCPU(k1, k2, k3, k4);
			this.getEskukoKartak().kenduKartaKartaz(baztertzekoKarta);					
			this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
			//imprimatuEskua();
			System.out.println("Makinak karta bat baztertu du eta beste bat hartu du.");
		}else {
			if (Konbinazioak.getNireKonbinazioak().getKonbinazioMota() == 1) {//doble oilo
				this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Oilo"));
				this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Oilo"));
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());			
				this.puntuak++;
				this.arrautzaKop--;
				//imprimatuEskua();
				System.out.println("Makinak bi oilo erabili ditu arrautza bat txita bihurtzeko.");
				
			}else if (Konbinazioak.getNireKonbinazioak().getKonbinazioMota() == 2) {//oilo oilar habia
				this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Oilo"));
				this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Oilar"));
				this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Habia"));
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				this.getEskukoArrautzak().gehituArrautza(ListaArrautzaHartzeko.getNireListaArrautzaHartzeko().banaketa());
				this.arrautzaKop++;
				//imprimatuEskua();
				System.out.println("Makinak oilo bat, oilar bat eta habia bat erabili ditu arrautza bat hartzeko.");
				
			}else if (Konbinazioak.getNireKonbinazioak().getKonbinazioMota() == 3){//zorro
				this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Azeria"));
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());					
				this.azeriaErabiliDu = true;
				System.out.println("Makinak azeri bat erabili du zuri arrautza bat lapurtzeko.");
			}
		}
		
	}
	
	
	
	//JOKALDI EXTRA EGIN METODOA
	public boolean jokaldiExtraEgin() {
		boolean erantzuna = false;
		int kont = 0;
		Karta k1, k2, k3, k4;
		if(this.getEskukoKartak().defendatuDezaket()){
			
			erantzuna = true;
			Iterator<Karta> itr = this.getEskukoKartak().getIteradorea();
			k1 = itr.next();
			k2 = itr.next();
			k3 = itr.next();
			k4 = itr.next();
			if (k1.oilarDenAlaEz() && kont != 2) {
				this.getEskukoKartak().kenduKartaKartaz(k1);
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				kont++;						
			}
			if (k2.oilarDenAlaEz() && kont != 2) {
				this.getEskukoKartak().kenduKartaKartaz(k2);
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				kont++;						
			}
			if (k3.oilarDenAlaEz() && kont != 2) {
				this.getEskukoKartak().kenduKartaKartaz(k3);
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				kont++;						
			}
			if (k4.oilarDenAlaEz() && kont != 2) {
				this.getEskukoKartak().kenduKartaKartaz(k4);
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				kont++;						
			}	
			System.out.println("Makinak bere arrautza defendatu du bi oilar erabiliz.");
		}else {
			System.out.println("Makinak ez du arrautza defendatzeko aukerarik.");
		}
		return erantzuna;
	}
	

	
	//IMPRIMATU ESKUA METODOA
	public void imprimatuEskua() {
		System.out.println("Makinaren kartak:");
		System.out.println(" ");
		System.out.println("╔═══════════════════════════════╗");
		this.getEskukoKartak().imprimatuKartak();
		System.out.println("╠═══════════════════════════════╣");
		System.out.print("║");
		System.out.print("IA-ren arrautzak:");
		System.out.print(this.arrautzaKop);
		System.out.print("    Txitak:");
		System.out.print(this.puntuak);
		System.out.println(" ║");
		System.out.println("╚═══════════════════════════════╝");
		System.out.println(" ");
	}

	//IRABAZLE MEZUA METODOA
		public void irabazleMezua() {
			System.out.println("Makinak irabazi du!");
		}
	

	
	//ZER BAZTERTU CPU METODOA
	public Karta zerBaztertuCPU(Karta k1, Karta k2, Karta k3, Karta k4) {
		Karta k = null;
		int azeriKont = 0;
		int habiaKont = 0;
		int oiloKont = 0;
		int oilarKont = 0;
		if (k1.azeriDenAlaEz()) {
			azeriKont++;
		}
		if (k2.azeriDenAlaEz()) {
			azeriKont++;
		}
		if (k3.azeriDenAlaEz()) {
			azeriKont++;
		}
		if (k4.azeriDenAlaEz()) {
			azeriKont++;
		}
		if (k1.habiaDenAlaEz()) {
			habiaKont++;
		}
		if (k2.habiaDenAlaEz()) {
			habiaKont++;
		}
		if (k3.habiaDenAlaEz()) {
			habiaKont++;
		}
		if (k4.habiaDenAlaEz()) {
			habiaKont++;
		}
		if (k1.oiloDenAlaEz()) {
			oiloKont++;
		}
		if (k2.oiloDenAlaEz()) {
			oiloKont++;
		}
		if (k3.oiloDenAlaEz()) {
			oiloKont++;
		}
		if (k4.oiloDenAlaEz()) {
			oiloKont++;
		}
		if (k1.oilarDenAlaEz()) {
			oilarKont++;
		}
		if (k2.oilarDenAlaEz()) {
			oilarKont++;
		}
		if (k3.oilarDenAlaEz()) {
			oilarKont++;
		}
		if (k4.oilarDenAlaEz()) {
			oilarKont++;
		}
		if (oiloKont > 2) { //1.egoera
			if (k1.oiloDenAlaEz()) {
				k = k1;
			}else if (k2.oiloDenAlaEz()) {
				k = k2;
			}
		}else if (oilarKont > 2) { //2.egoera
			if (k1.oilarDenAlaEz()) {
				k = k1;
			}else if (k2.oilarDenAlaEz()) {
				k = k2;
			}
		}else if (habiaKont > 1) { //3.egoera
			if (k1.habiaDenAlaEz()) {
				k = k1;
			}else if (k2.habiaDenAlaEz()) {
				k = k2;
			}else if (k3.habiaDenAlaEz()) {
				k = k3;
			}
		}else if (azeriKont > 1) { //4.egoera
			if (k1.azeriDenAlaEz()) {
				k = k1;
			}else if (k2.azeriDenAlaEz()) {
				k = k2;
			}else if (k3.azeriDenAlaEz()) {
				k = k3;
			}
		}else if (oiloKont == 2 && oilarKont == 2) { //5.egoera
			if (k1.oilarDenAlaEz()) {//descartar gallo
				k = k1;
			}else if (k2.oilarDenAlaEz()) {
				k = k2;
			}else if (k3.oilarDenAlaEz()) {
				k = k3;
			}
		}else if (azeriKont == 1 && habiaKont == 1 && oiloKont == 2) { //6.egoera
			if (this.arrautzaKop > 0) {//descartar nido
				if (k1.habiaDenAlaEz()) {
					k = k1;
				}else if (k2.habiaDenAlaEz()) {
					k = k2;
				}else if (k3.habiaDenAlaEz()) {
					k = k3;
				}else if (k4.habiaDenAlaEz()) {
					k = k4;
				}
			}else { // descartar gallina
				if (k1.oiloDenAlaEz()) {
					k = k1;
				}else if (k2.oiloDenAlaEz()) {
					k = k2;
				}else if (k3.oiloDenAlaEz()) {
					k = k3;
				}
			}
		}else if (azeriKont == 1 && habiaKont == 1 && oilarKont == 2) { //7.egoera
			if (this.arrautzaKop > 0) { //descartar zorro
				if (k1.azeriDenAlaEz()) {
					k = k1;
				}else if (k2.azeriDenAlaEz()) {
					k = k2;
				}else if (k3.azeriDenAlaEz()) {
					k = k3;
				}else if (k4.azeriDenAlaEz()) {
					k = k4;
				}
			}else {	//descartar gallo
				if (k1.oilarDenAlaEz()) {
					k = k1;
				}else if (k2.oilarDenAlaEz()) {
					k = k2;
				}else if (k3.oilarDenAlaEz()) {
					k = k3;
				}
				
			}
		}else if (oiloKont == 2 && azeriKont == 1 && oilarKont == 1) { //8.egoera
			if (k1.oiloDenAlaEz()) {
				k = k1;		
			}else if (k2.oiloDenAlaEz()) {
				k = k2;
			}else if (k3.oiloDenAlaEz()) {
				k = k3;
			}
		}else if (oilarKont == 2 && azeriKont == 1 && oiloKont == 1) { //9.egoera
			if (this.arrautzaKop > 0) { //descartar zorro
				if (k1.azeriDenAlaEz()) {
					k = k1;		
				}else if (k2.azeriDenAlaEz()) {
					k = k2;
				}else if (k3.azeriDenAlaEz()) {
					k = k3;
				}else if (k4.azeriDenAlaEz()) {
					k = k4;
				}
			}else {//descartar gallo
				if (k1.oilarDenAlaEz()) {
					k = k1;		
				}else if (k2.oilarDenAlaEz()) {
					k = k2;
				}else if (k3.oilarDenAlaEz()) {
					k = k3;
				}
				
			}
		}
		return k;
	}
}
	
	
	

