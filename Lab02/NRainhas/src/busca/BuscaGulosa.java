package busca;

import java.util.List;
import java.util.Set;

import estruturas.Nodo;
import interfaces.Acao;
import interfaces.Estado;
import interfaces.Problema;

public class BuscaGulosa extends BuscaEmProfundidade {

	@Override
	public List<Acao> buscar(Problema problema) {
		Set<Acao> acoesParaRealizar = null;
		Nodo raiz = new Nodo(null, problema.estadoInicial(), null, 0.0, 0);
		this.getFronteira().add(raiz);
		while (!this.getFronteira().isEmpty()) {
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
				//if(estadoNuncaFoiVisitado(estadoAtual)){
					this.estadosVisitados.add(estadoAtual);
					
					this.getFronteira().add(nodoFilho);
					if (problema.testaObjetivo(estadoAtual)) 
						return this.solucao(nodoFilho);
				//}
				
			}
		}
		return null;

	}
}
