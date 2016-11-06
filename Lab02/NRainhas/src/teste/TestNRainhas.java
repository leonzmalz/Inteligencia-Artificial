package teste;

import java.util.ArrayList;
import java.util.List;

import busca.BuscaBase;
import busca.BuscaEmLargura;
import interfaces.Acao;
import interfaces.Problema;
import modelos.ProblemaNRainhas;

public class TestNRainhas {

	public static void main(String[] args) {
		Problema problema = new ProblemaNRainhas(4);
		BuscaBase busca = new BuscaEmLargura();
		List<Acao> result = new ArrayList<>();
		result = busca.buscar(problema);
		
		for (int i=0;i<result.size();i++){
			System.out.println("[Passo "+i+"]"+result.get(i).toString());
		}
	}

}
