package teste;

import java.util.List;
import java.util.Scanner;

import busca.BuscaGenerica;
import busca.FactoryBusca;
import busca.TipoBusca;
import interfaces.Acao;
import interfaces.Busca;
import interfaces.Problema;
import modelos.ProblemaNRainhas;
import modelos.Tabuleiro;

public class TestNRainhas {

	public static void main(String[] args) {
		System.out.println("Problema NRainhas");
		System.out.println("Digite a dimensão do tabuleiro");
		int dimensao = Integer.parseInt(new Scanner(System.in).nextLine());
		
		Problema problema = new ProblemaNRainhas(dimensao);
		Busca busca = FactoryBusca.createBusca(TipoBusca.PROFUNDIDADE);
		List<Acao> result = busca.buscar(problema);
		
		if(result == null)
			System.out.println("Solução não encontrada");
		else{
			System.out.println("Acoes a serem realizadas para resolução de tabuleiro de dimensão " + Integer.toString(dimensao));
			for(int i = 0; i < result.size(); i ++)
				System.out.println("[Passo "+Integer.toString(i+1)+"]"+result.get(i).toString());
			System.out.println("Tabuleiro final");
			((Tabuleiro) ((BuscaGenerica) busca).getUltimoEstadoVisitado()).imprimeTabuleiro();
		}
		
		
	}

}
