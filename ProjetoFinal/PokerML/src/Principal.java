import java.io.IOException;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.core.Dataset;

public class Principal {

	public static void main(String[] args) {
		try {
			
			System.out.println("Aprendizagem de Máquina para jogadas de poker");

			//--------------------Treino----------------------------
			PokerClassification pokerTreino = new PokerClassification();
			System.out.println("Carregando dataset de Treino");
			Dataset datasetDeTreino = pokerTreino.getDatasetDeTreino();
			System.out.println("Dataset de Treino Carregado");

			System.out.println("Criando classificador...");
			Classifier classificadorDeTreino = pokerTreino.criaArvore(9);
			classificadorDeTreino = pokerTreino.criaClassificador(classificadorDeTreino, datasetDeTreino);
			System.out.println("Classificador Criado!");

			System.out.println("Realizando treino...");
			double tempoTreino = pokerTreino.calculaTempoDeTreino(classificadorDeTreino, datasetDeTreino);
			System.out.println("Tempo de treino : " + tempoTreino + " ms");

			System.out.println("Calculando performance simples do treino...");
			pokerTreino.calculaPerformanceSimples(classificadorDeTreino, datasetDeTreino);
			
			System.out.println("Calculando performance completa do treino...");
			pokerTreino.calculaPerformance(classificadorDeTreino, datasetDeTreino); 
			
			
			//--------------------Teste----------------------------
			PokerClassification pokerTeste = new PokerClassification();
			System.out.println("Carregando dataset de Teste");
			Dataset datasetDeTeste = pokerTeste.getDatasetDeTeste();
			System.out.println("Dataset de Teste Carregado");

			System.out.println("Criando classificador...");
			Classifier classificadorDeTeste = pokerTeste.criaArvore(9);
			classificadorDeTeste = pokerTeste.criaClassificador(classificadorDeTeste, datasetDeTeste);
			System.out.println("Classificador Criado!");

			System.out.println("Realizando teste...");
			double tempoTeste = pokerTeste.calculaTempoDeTreino(classificadorDeTeste, datasetDeTeste);
			System.out.println("Tempo de teste : " + tempoTeste + " ms");

			System.out.println("Calculando performance simples do teste...");
			pokerTeste.calculaPerformanceSimples(classificadorDeTeste, datasetDeTeste);
			
			System.out.println("Calculando performance completa do teste...");
			pokerTeste.calculaPerformance(classificadorDeTeste, datasetDeTeste);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
