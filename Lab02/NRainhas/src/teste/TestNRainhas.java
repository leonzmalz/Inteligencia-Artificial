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
		System.out.println("(C)om ou (S)em Heurística?");
		String tipoBusca  = new Scanner(System.in).nextLine().toUpperCase();
		Problema problema;
		Busca busca;
		if (tipoBusca.equals("S")){
			problema = new ProblemaNRainhas(dimensao,false);
			busca = FactoryBusca.createBusca(TipoBusca.PROFUNDIDADE);
			
		}else{
			problema = new ProblemaNRainhas(dimensao,true);
			busca = FactoryBusca.createBusca(TipoBusca.GULOSA);
	
		}
			
		List<Acao> result = busca.buscar(problema);
		
		if(result == null){
			System.out.println("Solução não encontrada");
			System.out.println("Último tabuleiro válido");
		}
		else{
			System.out.println("Acoes a serem realizadas para resolução de tabuleiro de dimensão " + Integer.toString(dimensao));
			for(int i = 0; i < result.size(); i ++)
				System.out.println("[Passo "+Integer.toString(i+1)+"]"+result.get(i).toString());
			System.out.println("Tabuleiro final");
		}
		((Tabuleiro) ((BuscaGenerica) busca).getUltimoEstadoVisitado()).imprimeTabuleiro();
		
		
	}

}
