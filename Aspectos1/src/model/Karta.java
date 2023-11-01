package model;

public abstract class Karta {
	
	//ATRIBUTUAK
	//private String mota;
	protected KartaMotak mota;
	
	//ERAIKITZAILEA
	/*public Karta (String pMota) {
		this.mota = pMota;
	}*/
	
	public KartaMotak getMota() {
		return this.mota;
	}
	
	public Karta () {
		
	}
	
	//BESTE METODOAK
	//GET MOTA METODOA
	/*public String getMota(){
		return this.mota;
	}*/
	
	//MOTA BERDINA METODOA
	public boolean motaBerdina(KartaMotak sarrera) {
		boolean erantzuna = false;
		if (this.mota == sarrera) {
			erantzuna = true;		
		}
		return erantzuna;
	}
	
	//OILAR DEN ALA EZ METODOA
	public boolean oilarDenAlaEz() {
		boolean erantzuna = false;
		//if (this.mota == "Oilar") {
		if (this.mota == KartaMotak.Rata) {
			erantzuna = true;
		}
		return erantzuna;
	}
	
	
	//OILO DEN ALA EZ METODOA
	public boolean oiloDenAlaEz() {
		boolean erantzuna = false;
		//if (this.mota == "Oilo") {
		if (this.mota == KartaMotak.Chef) {
			erantzuna = true;
		}
		return erantzuna;
	}
	
	//AZERI DEN ALA EZ METODOA
	public boolean azeriDenAlaEz() {
		boolean erantzuna = false;
		//if (this.mota == "Azeria") {
		if (this.mota == KartaMotak.Malo) {
			erantzuna = true;
		}
		return erantzuna;
	}
	//HABIA DEN ALA EZ METODOA
	public boolean habiaDenAlaEz() {
		boolean erantzuna = false;
		//if (this.mota == "Habia") {
		if (this.mota == KartaMotak.Cocina) {
			erantzuna = true;
		}
		return erantzuna;
	}
	
	
	//IMPRIMATU KARTA METODOA
	public void imprimatuKarta() {
		System.out.print(this.mota);
		//if (this.mota == "Oilo") {
		if (this.mota == KartaMotak.Chef) { 
			System.out.println("                 ║");
		//}else if (this.mota == "Oilar" || this.mota == "Habia") {
		}else if (this.mota == KartaMotak.Rata || this.mota == KartaMotak.Cocina) {
			System.out.println("                ║");
		//}else if (this.mota == "Azeria") {
		}else if (this.mota == KartaMotak.Malo) {
			System.out.println("               ║");
		}
	}
}
