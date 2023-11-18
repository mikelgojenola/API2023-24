package model;

public abstract class Carta {
	
	//ATRIBUTUAK
	//private String mota;
	protected TipoCartas tipo;
	
	//ERAIKITZAILEA
	/*public Carta (String pMota) {
		this.mota = pMota;
	}*/
	
	public TipoCartas getTipo() {
		return this.tipo;
	}
	
	public Carta () {
		
	}
	
	//BESTE METODOAK
	//GET MOTA METODOA
	/*public String getMota(){
		return this.mota;
	}*/
	
	//MOTA BERDINA METODOA
	public boolean mismoTipo(TipoCartas sarrera) {
		boolean respuesta = false;
		if (this.tipo == sarrera) {
			respuesta = true;		
		}
		return respuesta;
	}
	
	//OILAR DEN ALA EZ METODOA
	public boolean esRataOno() {
		boolean respuesta = false;
		//if (this.mota == "Oilar") {
		if (this.tipo == TipoCartas.Rata) {
			respuesta = true;
		}
		return respuesta;
	}
	
	
	//OILO DEN ALA EZ METODOA
	public boolean esChefOno() {
		boolean respuesta = false;
		//if (this.mota == "Oilo") {
		if (this.tipo == TipoCartas.Chef) {
			respuesta = true;
		}
		return respuesta;
	}
	
	//MALO DEN ALA EZ METODOA
	public boolean esMaloOno() {
		boolean respuesta = false;
		//if (this.mota == "MALO") {
		if (this.tipo == TipoCartas.Malo) {
			respuesta = true;
		}
		return respuesta;
	}
	//HABIA DEN ALA EZ METODOA
	public boolean esCocinaOno() {
		boolean respuesta = false;
		//if (this.mota == "Habia") {
		if (this.tipo == TipoCartas.Cocina) {
			respuesta = true;
		}
		return respuesta;
	}
	
	
	//IMPRIMATU Carta METODOA
	public void imprimirCarta() {
		System.out.print(this.tipo);
		//if (this.mota == "Chef") {
		if (this.tipo == TipoCartas.Chef) { 
			System.out.println("                 ║");
		//}else if (this.mota == "Rata" || this.mota == "Cocina") {
		}else if (this.tipo == TipoCartas.Rata || this.tipo == TipoCartas.Cocina) {
			System.out.println("                ║");
		//}else if (this.mota == "MALO") {
		}else if (this.tipo == TipoCartas.Malo) {
			System.out.println("               ║");
		}
	}
}
