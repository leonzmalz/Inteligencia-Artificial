package modelos;

import java.util.Set;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.Problema;

public class ProblemaNRainhas implements Problema {
	private final MapaDeTransicaoNRainhas mapa;
	private final Tabuleiro tabuleiroInicial;
	private final TesteDeObjetivoNRainhas testeDeObjetivo;
	
	public ProblemaNRainhas(int dimensao) {
		this.mapa = new MapaDeTransicaoNRainhas();
		this.testeDeObjetivo = new TesteDeObjetivoNRainhas();
		this.tabuleiroInicial = novoTabuleiro(dimensao);
	}
	
	@Override
	public Estado resultado(Acao a, Estado e) {
		return this.mapa.resultado(a, e);
	}

	@Override
	public Set<Acao> acoes(Estado e) {
		return this.mapa.acoes(e);
	}
	@Override
	public boolean testaObjetivo(Estado e) {
		return this.testeDeObjetivo.ehObjetivo(e);
	}
	@Override
	public double custo(Acao a, Estado ei, Estado ej) {
		return this.mapa.custo(a, ei, ej);
	}
	private Tabuleiro novoTabuleiro(int dimensao){
		boolean[][] casas = new boolean[dimensao][dimensao];
		for(int i = 0; i < dimensao; i ++)
			for(int j = 0; j < dimensao; j ++)
				casas[i][j] = false;
		return new Tabuleiro(casas, 0);
	}
	@Override
	public Estado estadoInicial() {
		return this.tabuleiroInicial;
	}

}
