package model;

/*import Model.Belarra;
import Model.Elektriko;
import Model.Pokemon;
import Model.PokemonFactory;
import Model.PokemonMotak;
import Model.Sua;
import Model.Ura;*/

public class CartaFactory {
	private static CartaFactory k = null;
	
	private CartaFactory() {
		
	}
	
	public static CartaFactory getK() {
		if(k == null) {
			k = new CartaFactory();
		}
		return k;
	}
	
	public Carta crearCarta(TipoCartas km, int p) {
		Carta kar = null;
			if(km == TipoCartas.Rata) {
				kar = new Rata();
				
			}else if(km == TipoCartas.Chef) {
				kar = new Chef();
			
			}else if(km == TipoCartas.Cocina) {
				kar = new Cocina();
				
			}else if(km == TipoCartas.Malo) {
				kar = new Malo();
			}
			return kar;
	}

}
