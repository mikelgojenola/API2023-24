package model;

import java.util.Random;


public class BarajaInicial {
	
	//ATRIBUTUAK
	private ListaCarta lista;
	private static BarajaInicial miBaraja = null;
	private Random ran = new Random();
	
	//ERAIKITZAILEA
	private BarajaInicial() {
		lista = new ListaCarta();
	}
	
	//BESTE METODOAK
	//GET NIRE HASIERAKO BARAJA METODOA
	public static synchronized BarajaInicial getMiBarajaInicial() {
		if (miBaraja == null) {
			miBaraja = new BarajaInicial();
		}
		return miBaraja;
	}
	
	//BARAJA BETE METODOA
	public void llenarBaraja() {
		int i = 0,x = 0,p = 0, k = 0;
		while (i<48) {
			//lista.gehituCarta(new Carta ("Malo"));
			Carta kar = CartaFactory.getK().crearCarta(TipoCartas.Malo, p);
			lista.meteCarta(kar);
			i++;
		}
		while (x<88) {
			//lista.gehituCarta(new Carta ("Habia"));
			Carta kar = CartaFactory.getK().crearCarta(TipoCartas.Cocina, p);
			lista.meteCarta(kar);
			x++;
		}
		while (p<120) {
			//lista.gehituCarta(new Carta ("Oilar"));
			Carta kar = CartaFactory.getK().crearCarta(TipoCartas.Rata, p);
			lista.meteCarta(kar);
			p++;
		}
		while (k<120) {
			//lista.gehituCarta(new Carta ("Oilo"));
			Carta kar = CartaFactory.getK().crearCarta(TipoCartas.Chef, p);
			lista.meteCarta(kar);
			k++;
		}
		lista.setCartaKop(376);
	}	
	
	
	//BANAKETA METODOA (Carta BAT BANATZEKO)
	public Carta reparto() { 
		Carta k = null;
		Random r = new Random();
		if(lista.getCartaKop()>1){
			int random = r.nextInt(lista.getCartaKop());
			k = lista.getCarta(random);
		}
		lista.quitarCartaConCarta(k);
		return k;		
	}
	
	//RESET METODOA
	public void reset() {
		lista.resetear();
		llenarBaraja();
	}
	
	
}
