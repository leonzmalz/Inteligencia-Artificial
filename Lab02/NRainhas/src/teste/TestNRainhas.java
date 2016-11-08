package teste;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import busca.BuscaBase;
import busca.BuscaEmLargura;
import interfaces.Acao;
import interfaces.Problema;
import modelos.ProblemaNRainhas;
import modelos.Tabuleiro;

public class TestNRainhas {

	public static void main(String[] args) {
		System.out.println("Problema NRainhas");
		System.out.println("Digite a dimensão do tabuleiro");
		int dimensao = Integer.parseInt(new Scanner(System.in).nextLine());
		Problema problema = new ProblemaNRainhas(dimensao);
		BuscaBase busca = new BuscaEmLargura();
		List<Acao> result = new ArrayList<>();
		result = busca.buscar(problema);
		
		if(result == null)
			System.out.println("Solução não encontrada");
		else{
			System.out.println("Acoes a serem realizadas para resolução de tabuleiro de dimensão " + Integer.toString(dimensao));
			for(int i = 0; i < result.size() -1; i ++)
				System.out.println("[Passo "+i+"]"+result.get(i).toString());
			System.out.println("Tabuleiro final");
			((Tabuleiro) busca.getUltimoEstadoVisitado()).imprimeTabuleiro();
		}
		
		
	}

}
