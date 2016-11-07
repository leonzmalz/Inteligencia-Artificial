package busca;

import java.util.LinkedList;
import estruturas.LIFOQueue;
import estruturas.Nodo;

public class BuscaEmProfundidade extends BuscaBase {
	private LIFOQueue<Nodo> fronteira;
	
	@Override
	protected LinkedList<Nodo> getFronteira(){
		if (this.fronteira == null)
			this.fronteira = new LIFOQueue<>();
		return this.fronteira;
	}
}
