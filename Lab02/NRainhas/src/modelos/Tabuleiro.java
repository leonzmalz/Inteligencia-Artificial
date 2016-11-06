package modelos;

import interfaces.Estado;

public class Tabuleiro implements Estado {

	private boolean[][] casas;
	private int qtdRainhas;
	
	public Tabuleiro(boolean[][] casas, int qtdRainhas) {
		this.casas = casas;
		this.qtdRainhas = qtdRainhas;
	}
	
	public int getQtdRainhas() {
		return qtdRainhas;
	}
	
	public void setQtdRainhas(int qtdRainhas) {
		this.qtdRainhas = qtdRainhas;
	}
	
	public boolean[][] getCasas() {
		return this.casas;
	}
	
	public int getColunaRainha(int linha){
		for(int coluna = 0; coluna < this.casas.length -1; coluna ++)
			if(this.casas[linha][coluna])
				return coluna;
		return -1;
	}
	
	@Override
	public boolean estadoValido() {
		//Procuro uma rainha
		for(int linha = 0; linha < this.qtdRainhas; linha ++){
			for(int coluna = 0; coluna < this.casas.length -1; coluna ++){
				if (this.casas[linha][coluna]) //Se true, então possui rainha nessa coluna
					if (rainhaEhAtacada(linha, coluna))
						return false;
			}
		}
		return true;
	}

	@Override
	public boolean igual(Estado e) {
		for(int i = 0; i < this.casas.length -1; i ++)
			for(int j = 0; j < this.casas.length - 1; j ++)
				if(((Tabuleiro)e).casas[i][j] != this.casas[i][j])
					return false;
		return true;
	}
	
	private boolean rainhaEhAtacada(int linhaAtual, int colunaAtual){
		for(int linha = 1; linha < this.casas.length; linha ++){
			boolean existeRainhaVertical = this.casas[linhaAtual - linha][colunaAtual];
			if(existeRainhaVertical)
				return true;
			boolean existeDiagonalEsquerda  = colunaAtual - linha >= 0;
			if (existeDiagonalEsquerda){
				boolean existeRainhaDiagonalEsquerda = this.casas[linhaAtual-linha][colunaAtual - linha];
				if (existeRainhaDiagonalEsquerda)
					return true;
	 		}
			boolean existeDiagonalDireita  = colunaAtual + linha < this.casas.length;
			if (existeDiagonalDireita){
				boolean existeRainhaDiagonalDireita = this.casas[linhaAtual-linha][colunaAtual + linha];
				if (existeRainhaDiagonalDireita)
					return true;
	 		}
		}
		return false;
	}

}
