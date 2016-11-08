package busca;

import java.util.LinkedList;
import estruturas.FIFOQueue;
import estruturas.Nodo;

public class BuscaEmLargura extends BuscaGenerica {
	private FIFOQueue<Nodo> fronteira; 

	public BuscaEmLargura() {
		this.fronteira = new FIFOQueue<>();
	}
	
	@Override
	protected LinkedList<Nodo> getFronteira() {
		return this.fronteira;
	}
}