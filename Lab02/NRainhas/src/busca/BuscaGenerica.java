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


public class BuscaGenerica implements Busca {
	protected final List<Estado> estadosVisitados;

	protected BuscaGenerica() {
		this.estadosVisitados = new ArrayList<Estado>();
	}

	protected LinkedList<Nodo> getFronteira() {
		return null;
	}

	@Override
	public List<Acao> buscar(Problema problema) {
		Set<Acao> acoesParaRealizar = null;
		Nodo raiz = new Nodo(null, problema.estadoInicial(), null, 0.0, 0);
		this.getFronteira().add(raiz);
		while (!this.getFronteira().isEmpty()) {
				
			//Nodo proximoNodo = this.getFronteira().getLast();
			Nodo proximoNodo = this.getFronteira().remove();
			this.estadosVisitados.add(proximoNodo.getEstado());

			if (problema.testaObjetivo(proximoNodo.getEstado())){ 
				return this.solucao(proximoNodo);
			}
			
			acoesParaRealizar = problema.acoes(proximoNodo.getEstado());
			if (acoesParaRealizar == null) 
				return null;
			
			Nodo nodoFilho;
			Estado estadoAtual = proximoNodo.getEstado();
			for (Acao acao : acoesParaRealizar) {
				estadoAtual = problema.resultado(acao, estadoAtual);
				nodoFilho = new Nodo(proximoNodo, estadoAtual, acao, 1, 1);
				proximoNodo = nodoFilho;
				//if (this.estadoNuncaFoiVisitado(estadoAtual)){	
				this.estadosVisitados.add(estadoAtual);
				this.getFronteira().add(nodoFilho);
				//}
				if (problema.testaObjetivo(estadoAtual)) {
					return this.solucao(nodoFilho);
				}
				
			}
		}
		return null;
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

	public Estado getUltimoEstadoVisitado() {
		return this.estadosVisitados.get(this.estadosVisitados.size() -1);
	}
}
