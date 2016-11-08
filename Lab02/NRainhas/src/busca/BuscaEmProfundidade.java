package busca;

import java.util.LinkedList;
import estruturas.LIFOQueue;
import estruturas.Nodo;

public class BuscaEmProfundidade extends BuscaGenerica {
	private LIFOQueue<Nodo> fronteira;
	
	public BuscaEmProfundidade() {
		this.fronteira = new LIFOQueue<>();
	}
	
	@Override
	protected LinkedList<Nodo> getFronteira(){
		return this.fronteira;
	}
}
