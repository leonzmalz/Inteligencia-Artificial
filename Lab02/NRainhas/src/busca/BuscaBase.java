package busca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import estruturas.Nodo;
import interfaces.Acao;
import interfaces.Busca;
import interfaces.Estado;
import interfaces.Problema;


public class BuscaBase implements Busca {
	protected final List<Estado> estadosVisitados;

	protected BuscaBase() {
		this.estadosVisitados = new ArrayList<Estado>();
	}

	protected LinkedList<Nodo> getFronteira() {
		return null;
	}

	@Override
	public List<Acao> buscar(Problema problema) {
		Set<Acao> acoesPossiveis = null;
		Nodo raiz = new Nodo(null, problema.estadoInicial(), null, 0.0, 0);
		this.getFronteira().add(raiz);
		
		while (!this.getFronteira().isEmpty()) {
			Nodo proximoNodo = this.getFronteira().remove();
			this.getEstadosVisitados().add(proximoNodo.getEstado());

			if (problema.testaObjetivo(proximoNodo.getEstado())) {
				return this.solucao(proximoNodo);
			}

			acoesPossiveis = problema.acoes(proximoNodo.getEstado());

			if (acoesPossiveis == null) {
				return null;
			}
			Estado estadoResultanteDestaAcao = proximoNodo.getEstado();
			for (Acao acao : acoesPossiveis) {
				estadoResultanteDestaAcao = problema.resultado(acao, estadoResultanteDestaAcao);

				if (this.estadoNuncaFoiVisitado(estadoResultanteDestaAcao)){
					getEstadosVisitados().add(estadoResultanteDestaAcao);
					
					Nodo nodoFilho = new Nodo(proximoNodo, estadoResultanteDestaAcao, acao, 1, 1);
					this.getFronteira().add(nodoFilho);

					if (problema.testaObjetivo(estadoResultanteDestaAcao)) {
						return this.solucao(nodoFilho);
					}
		
				}
					
			}
		}

		return null;
	}

	private boolean estadoNuncaFoiVisitado(Estado estadoQualquer) {
		for (Estado estadoVisitado : this.getEstadosVisitados()) {
			if (estadoVisitado.igual(estadoQualquer)) {
				return false;
			}
		}

		return true;
	}

	private List<Acao> solucao(Nodo n) {
		List<Acao> s = null;
		if (n != null) {
			s = new ArrayList<Acao>();
		}
		while (n != null) {
			if (n.getAcao() != null) {
				s.add(0, n.getAcao());
			}
			n = n.getPai();
		}
		return s;
	}

	public List<Estado> getEstadosVisitados() {
		return estadosVisitados;
	}
}
