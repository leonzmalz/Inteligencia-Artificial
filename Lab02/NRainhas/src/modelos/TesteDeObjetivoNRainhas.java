package modelos;

import interfaces.Estado;
import interfaces.TesteDeObjetivo;

public class TesteDeObjetivoNRainhas implements TesteDeObjetivo {

	private Tabuleiro tabuleiroObjetivo;
	
	public TesteDeObjetivoNRainhas(int dimensaoDoTabuleiro) {
		tabuleiroObjetivo = this.getEstadoInicial(dimensaoDoTabuleiro);
	}
	
	//O estado final é um tabuleiro de tamanho n com n rainhas posicionadas
	@Override
	public boolean ehObjetivo(Estado e) {
		return ((Tabuleiro) e).getQtdRainhas() == ((Tabuleiro) e).getCasas().length;
	}
	
	private Tabuleiro getEstadoInicial(int dimensao){
		boolean[][] casas = new boolean[dimensao][dimensao];
		for(int i = 0; i < dimensao; i ++)
			for(int j = 0; j < dimensao; j ++)
				casas[i][j] = false;
		return new Tabuleiro(casas, 0);
	}

}
