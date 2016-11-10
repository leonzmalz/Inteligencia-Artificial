package modelos;

import java.util.LinkedHashSet;
import java.util.Set;

import interfaces.Acao;
import interfaces.Estado;

public class MapaDeTransicaoHeuristica extends MapaDeTransicaoNRainhas {
	
	@Override
	public Set<Acao> acoes(Estado e) {
		int colunaRainha;
		double menorCusto;
		Set<Acao> acoes = new LinkedHashSet<>();
		AcaoNRainhas novaAcao = null;
		for(int linha = 0; linha < ((Tabuleiro) e).getCasas().length; linha ++){
			colunaRainha = ((Tabuleiro) e).getColunaRainha(linha);
			menorCusto = ((Tabuleiro) e).getNumDeAtaques(linha, colunaRainha);
			//O tabuleiro só pode permitir 1 rainha por linha, então removo para testes
			AcaoNRainhas removeRainha = new AcaoNRainhas(linha, colunaRainha, false);
			Estado novoEstado		  = this.resultado(removeRainha, e);
			for(int coluna = 0; coluna < ((Tabuleiro) e).getCasas().length; coluna ++){
				if(coluna != colunaRainha){
					AcaoNRainhas insereRainha = new AcaoNRainhas(linha, coluna, true);
					novoEstado = this.resultado(insereRainha, novoEstado);
					double novoCusto = this.custo(insereRainha, e, novoEstado);
					if(novoCusto < menorCusto){
						menorCusto = novoCusto;
						novaAcao = insereRainha;
					}
				}
			}
			if(novaAcao != null){
				acoes.add(new AcaoNRainhas(linha,colunaRainha, false)); //Remove a antiga rainha
				acoes.add(novaAcao);
			}
		}
		return acoes;
	}
	
	@Override
	public double custo(Acao a, Estado de, Estado para) {
		//Procuro onde houve a mudança de rainha entre os dois estados
		for(int i = 0; i < ((Tabuleiro) de).getCasas().length; i ++){
			for(int j = 0; j < ((Tabuleiro) de).getCasas().length; j ++){
				int colunaRainhaEstadoDe   = ((Tabuleiro) de).getColunaRainha(i);
				int colunaRainhaEstadoPara = ((Tabuleiro) para).getColunaRainha(i);
				if (colunaRainhaEstadoDe != colunaRainhaEstadoPara)
					return ((Tabuleiro) para).getNumDeAtaques(i, colunaRainhaEstadoPara);
		    }
		}
		return 0;
	}
}

