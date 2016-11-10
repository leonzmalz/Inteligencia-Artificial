package modelos;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import interfaces.Acao;
import interfaces.Estado;
import interfaces.MapaDeTransicao;
import interfaces.Problema;

public class ProblemaNRainhas implements Problema {
	private final MapaDeTransicao mapa;
	private final Tabuleiro tabuleiroInicial;
	private final TesteDeObjetivoNRainhas testeDeObjetivo;
	
	public ProblemaNRainhas(int dimensao, boolean comHeuristica) {
		this.testeDeObjetivo = new TesteDeObjetivoNRainhas();
		if(!comHeuristica){
			this.mapa = new MapaDeTransicaoNRainhas();
			this.tabuleiroInicial = novoTabuleiro(dimensao);
		}else{
			this.mapa = new MapaDeTransicaoHeuristica();
			this.tabuleiroInicial = novoTabuleiroAleatorio(dimensao);
		}
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
	
	private Tabuleiro novoTabuleiroAleatorio(int dimensao){
		Tabuleiro tabuleiro = this.novoTabuleiro(dimensao); 
		for(int i = 0; i < dimensao; i ++){
			int colunaAleatoria = ThreadLocalRandom.current().nextInt(0, dimensao);
			tabuleiro.alteraTabuleiro(i, colunaAleatoria, true);
		}
		return tabuleiro;
	}
	
	@Override
	public Estado estadoInicial() {
		return this.tabuleiroInicial;
	}
	
}
