package model;

import java.util.Scanner;

public class Teklatua {
	//ATRIBUTUAK
	private static Scanner sc;
	private static Teklatua nireTeklatua=null;
	

	//ERAIKITZAILEA
	private Teklatua() {
		Teklatua.sc=new Scanner(System.in);
	}

	//BESTE METODOAK
	//GET NIRE TEKLATUA METODOA
	public static Teklatua getNireTeklatua() {
		if (nireTeklatua==null) {
			nireTeklatua=new Teklatua();
		}
		return nireTeklatua;
	}
	
	
	//IRAKURRI OSOSA METODOA
	public int irakurriOsoa() {
		String zenb = this.irakurriString();
		boolean egokia=false;
		do {
			if (zenb.isEmpty()) {
				zenb=this.irakurriString();
			}
			else {
				try {
					Integer.parseInt(zenb);
					egokia=true;
				}
				catch (NumberFormatException e) {
					System.out.println("Bakarrik zenbaki osoak onartzen dira, saiatu  berriro:");
					zenb=this.irakurriString();
				}
			}
		} while (!egokia);
		return Integer.parseInt(zenb);
	}
	
	//IRAKURRI ZENBAKIA METODOA
	public static int irakurriZenb() throws NumberFormatException {		
		String sar= sc.nextLine();
		int zenb= Integer.parseInt(sar);
		return zenb;
	}
	
	
	//IRAKURRI STRING METODOA
	public String irakurriString() {
		String mezua=Teklatua.sc.nextLine();
		return mezua;
	}
	
	//IRAKURRI CHAR METODOA
	public char irakurriChar() {
		String karakterea=this.irakurriString();
		boolean egokia=false;
		do {
			if (karakterea.length()>1) {
				System.out.println("Bakarrik karaktereak onartzen dira.");
				karakterea=this.irakurriString();
			}
			else {
				egokia=true;
			}
		} while (!egokia);
		return karakterea.charAt(0);
	}
	
	
	//IRAKURRI ENTER METODOA
	public void irakurriEnter() {
		Teklatua.sc.nextLine();
	}
}