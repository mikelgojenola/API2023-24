package model;

//TODO Esto creo que se usa cuando eliges mal algo

public class HasieranAukeraOkerraSalbuespena  extends Exception {
	public HasieranAukeraOkerraSalbuespena() {
		super();
	}
	
	
	//INPRIMATU MEZUA METODOA
	public void inprimatuMezua() {
		System.out.println("Egindako kontsulta ez da zuzena, aukeratu beste bat.");
	}
}
