package model;

/*import Model.Belarra;
import Model.Elektriko;
import Model.Pokemon;
import Model.PokemonFactory;
import Model.PokemonMotak;
import Model.Sua;
import Model.Ura;*/

public class KartaFactory {
	private static KartaFactory k = null;
	
	private KartaFactory() {
		
	}
	
	public static KartaFactory getK() {
		if(k == null) {
			k = new KartaFactory();
		}
		return k;
	}
	
	public Karta sortuKarta(KartaMotak km, int p) {
		Karta kar = null;
			if(km == KartaMotak.Rata) {
				kar = new Rata();
				
			}else if(km == KartaMotak.Chef) {
				kar = new Chef();
			
			}else if(km == KartaMotak.Cocina) {
				kar = new Cocina();
				
			}else if(km == KartaMotak.Malo) {
				kar = new Malo();
			}
			return kar;
	}

}
