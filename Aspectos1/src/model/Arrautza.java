package model;

public class Arrautza {
	
	//ATRIBUTUAK
	private boolean txita = false;
	
	//ERAIKITZAILEA
	public Arrautza(boolean pTxita) {
		this.txita = pTxita;
	}
	
	//BESTE METODOAK
	//BUELTA EMAN METODOA
	public void bueltaEman() {
		if (!txita) {
			txita = true;
		}		
	}
	
	//GET TXITA METODOA
	public boolean getTxitxa() {
		return this.txita;
	}
}
