package modelos;

import java.util.LinkedHashSet;
import java.util.Set;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.MapaDeTransicao;

public class MapaDeTransicaoNRainhas implements MapaDeTransicao {

	@Override
	public Set<Acao> acoes(Estado e) {
		int colunaRainha;
		Set<Acao> acoes = new LinkedHashSet<>();
		for(int linha = 0; linha < ((Tabuleiro) e).getCasas().length; linha ++){
				colunaRainha = ((Tabuleiro) e).getColunaRainha(linha);
				//Se não existe rainha na linha
				if (colunaRainha == -1){
					Acao insereRainha = this.tentaInserirRainha(e, linha, 0); //Tenta inserir rainha na primeira posição
					//Enquanto não conseguir inserir uma rainha, volta uma linha e insere na próxima coluna
					while(insereRainha == null){
						//Primeiro remove a rainha da linha anterior
						linha --; 
						colunaRainha = ((Tabuleiro) e).getColunaRainha(linha);  
						Acao removeRainha = new AcaoNRainhas(linha, colunaRainha, false);
						acoes.add(removeRainha);
						e = resultado(removeRainha, e);
						//Agora tenta adicionar nas próximas colunas da mesma linha
						colunaRainha ++;
						insereRainha = this.tentaInserirRainha(e, linha, colunaRainha);
					}
					acoes.add(insereRainha);
					return acoes;
				}
		}
		return null;
	}
		
	protected Acao tentaInserirRainha(Estado e, int linha, int colunaAtual){
		for (int coluna = colunaAtual; coluna < ((Tabuleiro) e).getCasas().length; coluna ++){
			Acao insereRainha = new AcaoNRainhas(linha, coluna, true);
			Estado novoEstado = resultado(insereRainha, e);
			if(novoEstado.estadoValido())
				return insereRainha;
		}
		return null;
	}
		
	@Override
	public Estado resultado(Acao a, Estado e) {
		int linha 			    = ((AcaoNRainhas) a).getLinha();
		int coluna              = ((AcaoNRainhas) a).getColuna();
		if(linha >= 0 && coluna >= 0){
			boolean[][]novasCasas   = ((Tabuleiro) e).getCasas();
			int qtdRainhas          = ((Tabuleiro) e).getQtdRainhas();
			boolean possuiRainha    = ((AcaoNRainhas) a).getPossuiRainha();
			Tabuleiro tab = new Tabuleiro(novasCasas,qtdRainhas);
			tab.alteraTabuleiro(linha, coluna, possuiRainha);
			return tab;
		}else
			return e;
		
	}

	@Override
	public double custo(Acao a, Estado de, Estado para) {
		return 1;
	}

	
}
