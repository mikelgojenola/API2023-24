package model;

public class Karta {
	
	//ATRIBUTUAK
	private String mota;

	
	//ERAIKITZAILEA
	public Karta (String pMota) {
		this.mota = pMota;
	}
	
	//BESTE METODOAK
	/*GET MOTA METODOA
	public String getMota(){
		return this.mota;
	}*/
	
	//MOTA BERDINA METODOA
	public boolean motaBerdina(String sarrera) {
		boolean erantzuna = false;
		if (this.mota == sarrera) {
			erantzuna = true;		
		}
		return erantzuna;
	}
	
	//OILAR DEN ALA EZ METODOA
	public boolean oilarDenAlaEz() {
		boolean erantzuna = false;
		if (this.mota == "Oilar") {
			erantzuna = true;
		}
		return erantzuna;
	}
	
	
	//OILO DEN ALA EZ METODOA
	public boolean oiloDenAlaEz() {
		boolean erantzuna = false;
		if (this.mota == "Oilo") {
			erantzuna = true;
		}
		return erantzuna;
	}
	
	//AZERI DEN ALA EZ METODOA
	public boolean azeriDenAlaEz() {
		boolean erantzuna = false;
		if (this.mota == "Azeria") {
			erantzuna = true;
		}
		return erantzuna;
	}
	//HABIA DEN ALA EZ METODOA
	public boolean habiaDenAlaEz() {
		boolean erantzuna = false;
		if (this.mota == "Habia") {
			erantzuna = true;
		}
		return erantzuna;
	}
	
	
	//IMPRIMATU KARTA METODOA
	public void imprimatuKarta() {
		System.out.print(this.mota);
		if (this.mota == "Oilo") {
			System.out.println("                 ║");
		}else if (this.mota == "Oilar" || this.mota == "Habia") {
			System.out.println("                ║");
		}else if (this.mota == "Azeria") {
			System.out.println("               ║");
		}
	}
}
