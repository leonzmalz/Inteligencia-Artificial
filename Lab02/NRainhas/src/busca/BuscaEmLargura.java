package busca;

import java.util.LinkedList;
import estruturas.FIFOQueue;
import estruturas.Nodo;

public class BuscaEmLargura extends BuscaGenerica {
	private FIFOQueue<Nodo> fronteira; 

	@Override
	protected LinkedList<Nodo> getFronteira() {
		if (this.fronteira == null)
			this.fronteira = new FIFOQueue<>();
		return this.fronteira;
	}
}