package busca;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import interfaces.Busca;

public class FactoryBusca {
	
	private static final Map<TipoBusca, Busca> factoryBusca = 
			Collections.unmodifiableMap(new HashMap<TipoBusca, Busca>() {{
		        put(TipoBusca.LARGURA, new BuscaEmLargura());
		        put(TipoBusca.PROFUNDIDADE, new BuscaEmProfundidade());
		    }});
	
	public static Busca createBusca(TipoBusca tipoBusca){
		return factoryBusca.get(tipoBusca);
		
	}

}
