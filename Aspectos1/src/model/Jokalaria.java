package model;

import java.util.Observable;

public abstract class Jokalaria extends Observable{
	
	//ATRIBUTUAK
	private int adina;
	private Konbinazioak konbi;
	protected int puntuak;//txita kopurua!!
	protected boolean azeriaErabiliDu = false;
	private ListaKarta eskukoKartak;
	private ListaArrautza eskukoArrautzak;
	protected int arrautzaKop;
	protected int txandaZenbakia;
	
	//ERAIKITZAILEA
	protected Jokalaria(int pAdina) {
		this.eskukoKartak = new ListaKarta();
		this.eskukoArrautzak = new ListaArrautza();
		this.adina = pAdina;
		this.konbi = Konbinazioak.getNireKonbinazioak();
		this.puntuak = 0;
	}	
	
	//BESTE METODOAK
	//GET  ESKUKO KARTAK METODOA
	protected ListaKarta getEskukoKartak(){
		return this.eskukoKartak;
	}
		
	//GET ESKUKO ARRAUTZAK METODOA
    protected ListaArrautza getEskukoArrautzak(){
        return this.eskukoArrautzak;
    } 
	
	//GET ARRAUTZA KOP METODOA
	protected int getArrautzKop() {
		return this.getEskukoArrautzak().getKopurua();
	}	
	
	//GET ADINA METODOA
	protected int getAdina() {
		return this.adina;
	}
	
	//GET KONBINAZIOAK METODOA
	protected Konbinazioak getKonbinazioak() {
		return this.konbi;
	}
	
	//PUNTUAK ERRESETEATU METODOA
	protected void puntuakErreseteatu() {
		puntuak = 0;
	}
	
	//DENA ERRESETEATU METODOA 
	protected void denaErreseteatu() {
		this.getEskukoKartak().erreseteatu();
		this.getEskukoArrautzak().erreseteatu();
		this.puntuakErreseteatu();
	}
	
	//GET PUNTUAK METODOA
	protected int getPuntuak() {
		return this.puntuak;
	}
	
	//GET AZERIA ERABILI DU METODOA
	protected boolean getAzeriaErabiliDu() {
		return this.azeriaErabiliDu;
	}
	
	
	//JOKALDIA EGIN METODOA
	protected abstract void jokaldiaEgin();
	
	//JOKALDI EXTRA EGIN METODOA
	protected abstract boolean jokaldiExtraEgin();
		
	
	//IMRIMATU ESKUA METODOA
	protected abstract void imprimatuEskua();
	
	//IRABAZLE MEZUA METODOA
	protected abstract void irabazleMezua();
	
	public void eguneratu() {
		setChanged();
		//notifyObservers(new String[] {Meter las 4 cartas en orden para poner las fotos});
	}
	
	
}
