
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import be.abeel.util.Pair;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.evaluation.EvaluateDataset;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.classification.tree.RandomTree;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.sampling.Sampling;
import net.sf.javaml.tools.data.FileHandler;


public class PokerClassification implements Classification {

	private Pair<Dataset, Dataset> data;
	
	private Map<PokerHands, Integer> mapTotais;
	
	public Pair<Dataset, Dataset> getData() {
		return data;
	}
	
	@Override
	public Classifier criaArvore(int numeroDeAtributos) {
		return new RandomTree(numeroDeAtributos, new Random());
	}

	@Override
	public double calculaTempoDeTreino(Classifier classificador, Dataset dataset){
		double tempoInicial = System.currentTimeMillis();
		
		for (Instance inst :this.data.y()) {
			classificador.classify(inst);
		}

		return System.currentTimeMillis() - tempoInicial;
	}

	@Override
	public double calculaPerformanceSimples(Classifier classificador, Dataset dataset) {
		int acertou = 0, errou = 0;
	    this.inicializaTotais();
		for (Instance inst : this.data.y()) {
			Object classePredita = classificador.classify(inst);
			Object classeReal    = inst.classValue();
			
			if (classePredita.equals(classeReal)){
				acertou++;
				int numMao = Integer.parseInt(classePredita.toString());
				
				//Adiciona um acerto para a mão
				int contador = this.mapTotais.get(PokerHands.valueOf(numMao));
				this.mapTotais.replace(PokerHands.valueOf(numMao), contador + 1);
			
			}else
		        errou++;
		}
		System.out.println("Acertos: " + acertou + " - " + (acertou * 100) / (acertou + errou) + "%");
		System.out.println("Erros: " + errou + " - " + (errou * 100) / (acertou + errou) + "%");
		System.out.println("Acertos por classe: ");
		
		for(Entry<PokerHands, Integer> entry : this.mapTotais.entrySet()){
			System.out.println(entry.getKey().getTexto() + " = " + entry.getValue());
		}
		
		return 1;
	}

	@Override
	public double calculaPerformance(Classifier classificador, Dataset dataset) {
		Map<Object, PerformanceMeasure> performance = EvaluateDataset.testDataset(classificador, this.data.y());
		DecimalFormat df = new DecimalFormat("0.##");
		
		System.out.println(String.format("%-15s", "Classe") + "|" + 
						   String.format("%-6s", "Total") + "|" +
						   String.format("%-8s", "Precisão") + "|" +
						   String.format("%-12s", "Taxa de Erro") + "|" + 
						   String.format("%-8s", "Acurácia") + "|" +
						   String.format("%-6s", "TPRate") + "|" + //Verdadeiros positivos
						   String.format("%-6s", "FPRate") + "|" + //Falsos positivos
						   String.format("%-6s", "Recall") + "|");
		
		for(Object rotulo : performance.keySet()){
			int numMao = Integer.parseInt(rotulo.toString());
			String classe   = PokerHands.valueOf(numMao).getTexto();
			String precisao = df.format(performance.get(rotulo).getPrecision());
			String erro     = df.format(performance.get(rotulo).getErrorRate());
			String acuracia = df.format(performance.get(rotulo).getAccuracy());
			String tpRate   = df.format(performance.get(rotulo).getTPRate());
			String fpRate   = df.format(performance.get(rotulo).getFPRate());
			String recall   = df.format(performance.get(rotulo).getRecall());
			
			String total    = df.format(performance.get(rotulo).getQ9());
			
			System.out.println(String.format("%-15s", classe) 	+ "|" +
							   String.format("%-6s", total) 	+ "|" +
							   String.format("%-8s", precisao) + "|" +
							   String.format("%-12s", erro) 	+ "|" +	
							   String.format("%-8s", acuracia) + "|" +
							   String.format("%-6s", tpRate)	+ "|" +
							   String.format("%-6s", fpRate) 	+ "|" +
							   String.format("%-6s", recall) 	+ "|");
		}
		return 1;
	}
	
	public Dataset getDatasetDeTreino() throws IOException{
		return  FileHandler.loadDataset(new File("src/datasets/poker-hand-training.data"),10, ",");
	}
	
	public Dataset getDatasetDeTeste() throws IOException{
		return FileHandler.loadDataset(new File("src/datasets/poker-hand-testing.data"),10, ",");
		
	}
	
	public Classifier criaClassificador(Classifier classificador, Dataset dataset){
		Sampling s = Sampling.SubSampling;
		this.data = s.sample(dataset, (int)(dataset.size()*((double)3/10)), 7);
		classificador.buildClassifier(data.x());
		return classificador;
	}
	
	private void inicializaTotais(){
	
		if (this.mapTotais == null)
			this.mapTotais = new HashMap<>();
		
		this.mapTotais.clear();
		this.mapTotais.put(PokerHands.NADA_NA_MAO, 0);
		this.mapTotais.put(PokerHands.UM_PAR, 0);
		this.mapTotais.put(PokerHands.DOIS_PARES, 0);
		this.mapTotais.put(PokerHands.TRINCA, 0);
		this.mapTotais.put(PokerHands.STRAIGHT, 0);
		this.mapTotais.put(PokerHands.FLUSH, 0);
		this.mapTotais.put(PokerHands.FULL_HOUSE, 0);
		this.mapTotais.put(PokerHands.QUADRA, 0);
		this.mapTotais.put(PokerHands.STRAIGHT_FLUSH, 0);
		this.mapTotais.put(PokerHands.ROYAL_FLUSH, 0);

	}
}
