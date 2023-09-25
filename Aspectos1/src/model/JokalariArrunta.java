package model;

public class JokalariArrunta extends Jokalaria {
	
	//ATRIBUTUAK
	private int txandaZenbakia;
	
	
	//ERAIKITZAILEA
	public JokalariArrunta(String pIzena, int pAdina, int pJ){
		super(pAdina);
		this.txandaZenbakia = pJ;
	}
	
	//BESTE METODOAK		
	//IMPRIMATU ESKUA METODOA
	public void imprimatuEskua() {
		int i;
		if (txandaZenbakia == 0) {
			i = 1;
		}else {
			i = 0;
		}
		System.out.println("Zure eskuko kartak:");
		System.out.println("╔═════════════════════════╗");
		this.getEskukoKartak().imprimatuKartak();
		System.out.println("╠═════════════════════════╣");
		System.out.print("║");
		System.out.print(" Arrautzak:");
		System.out.print(this.arrautzaKop);
		System.out.print("    Txitak:");
		System.out.print(this.puntuak);
		System.out.println(" ║");
		System.out.println("╚═════════════════════════╝");	
		System.out.println("IA-ren arrautzak:");
		System.out.println("╔═════════════════════════╗");
		System.out.print("║");
		System.out.print(" Arrautzak:");
		System.out.print(ListaJokalaria.getNireListaJokalariak().getZerrenda()[i].arrautzaKop);
		System.out.print("    Txitak:");
		System.out.print(ListaJokalaria.getNireListaJokalariak().getZerrenda()[i].puntuak);
		System.out.println(" ║");
		System.out.println("╚═════════════════════════╝");
		
	}
	
	//GET TXANDA ZENBAKIA METODOA
	public int getTxandaZenbakia() {
		return this.txandaZenbakia;
	}
	
	//JOKALDIA EGIN METODOA
	public void jokaldiaEgin() {
		int aukera = 0;
		System.out.println(" ");
		System.out.println("Zure txanda da.");
		System.out.println(" ");
		int s1, s2;
		this.azeriaErabiliDu = false;
		imprimatuEskua();
		//while (aukera != 1 || aukera != 2) {
		while (aukera != 1 && aukera != 2) {
			System.out.println("3333333333333333333333333333333333333333");
			if(!this.getKonbinazioak().konbinazioNormalikAhalDago(getEskukoKartak(),this.arrautzaKop, txandaZenbakia)) {
				System.out.println("Aukeratu karta bat baztertzeko eta berri bat hartu multzotik");			
				s1 = Teklatua.getNireTeklatua().irakurriOsoa();
				while (s1 != 1 && s1 != 2 && s1 != 3 && s1 != 4) {
					System.out.println("Aukeratu berriz baztertuko duzun karta");
					s1 = Teklatua.getNireTeklatua().irakurriOsoa();
				}
				this.getEskukoKartak().kenduKartaZenbakiz(s1-1);						
				this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
				aukera = 1;
				imprimatuEskua();
			}
			else {
				System.out.println("Aukeratu egin nahi duzun jokaldia:");
				System.out.println("1-Karta baztertu");
				System.out.println("2-Kartak jokatu");
				aukera = Teklatua.getNireTeklatua().irakurriOsoa();
				if (aukera == 1) {
					System.out.println("Aukeratu karta bat baztertzeko eta berri bat hartu multzotik");			
					s1 = Teklatua.getNireTeklatua().irakurriOsoa();
					while (s1 != 1 && s1 != 2 && s1 != 3 && s1 != 4) {
						System.out.println("Aukeratu berriz baztertuko duzun karta");
						s1 = Teklatua.getNireTeklatua().irakurriOsoa();
					}
					this.getEskukoKartak().kenduKartaZenbakiz(s1-1);						
					this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());			
					imprimatuEskua();
				}else if(aukera == 2) {
					System.out.println("Aukeratu kartak jokaldia egiteko:");
				int i = 0;
				ListaKarta lista = new ListaKarta();
				s2 = Teklatua.getNireTeklatua().irakurriOsoa();
				lista.gehituKarta(this.getEskukoKartak().getKarta(s2-1));
				while (!this.getKonbinazioak().konbinazioNormalikAhalDago(lista, this.arrautzaKop, txandaZenbakia)) {
					s2 = Teklatua.getNireTeklatua().irakurriOsoa();
					lista.gehituKarta(this.getEskukoKartak().getKarta(s2-1));		
					i++;
					if (i == 3 ) {
						System.out.println("Konbinazio okerra");
						lista.erreseteatu();
						i = -1;
					}
				}
				if (Konbinazioak.getNireKonbinazioak().getKonbinazioMota() == 1) {//oilo oilo
					this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Oilo"));
					this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Oilo"));
					this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
					this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
					this.getEskukoArrautzak().arrautzaKendu(0);
					this.puntuak++;
					this.arrautzaKop--;
					imprimatuEskua();
				} else if (Konbinazioak.getNireKonbinazioak().getKonbinazioMota() == 2) {//oilo oilar habia
					this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Oilo"));
					this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Oilar"));
					this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Habia"));
					this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
					this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
					this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
					this.getEskukoArrautzak().gehituArrautza(ListaArrautzaHartzeko.getNireListaArrautzaHartzeko().banaketa());
					this.arrautzaKop++;
					imprimatuEskua();				
				}else if (Konbinazioak.getNireKonbinazioak().getKonbinazioMota() == 3) {//zorro
					this.getEskukoKartak().kenduKartaKartaz(this.getEskukoKartak().baztertuKartaMotaJakinda("Azeria"));
					this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());						
					this.azeriaErabiliDu = true;				
				}
			}
		}
	}
}
	
	
	
	//IRABAZLE MEZUA METODOA
	public void irabazleMezua() {
		System.out.println("Irabazlea zara!");
	}
	
	
	//JOKALDI EXTRA EGIN METODOA
	public boolean jokaldiExtraEgin() {
		boolean erantzuna = false;
		int s1,s2;
		if (this.getEskukoKartak().defendatuDezaket()) {
			System.out.println("Aukeratu kartak defendatzeko");
			s1 = Teklatua.getNireTeklatua().irakurriOsoa();
			s2 = Teklatua.getNireTeklatua().irakurriOsoa();
			this.getEskukoKartak().kenduKartaZenbakiz(s2-1);
			this.getEskukoKartak().kenduKartaZenbakiz(s1-1);
			this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());
			this.getEskukoKartak().gehituKarta(HasierakoBaraja.getNireHasierakoBaraja().banaketa());	
			erantzuna = true;
		}
		return erantzuna;
	}
	
	
	
	

}
