import java.io.File;
import java.io.IOException;

import be.abeel.util.Pair;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.sampling.Sampling;
import net.sf.javaml.tools.data.FileHandler;

public class Principal {

	public static void main(String[] args) {
		try {
			System.out.println("Carregando dataset");
			
			Dataset dataset = FileHandler.loadDataset(new File("src/datasets/poker-hand-training.data"),10, ",");
			//Dataset dataset = FileHandler.loadDataset(new File("src/datasets/car.data"), 4, ",");
			System.out.println("Dataset Carregado");
			
			PokerClassification poker = new PokerClassification();
			Sampling s = Sampling.SubSampling;
			Pair<Dataset, Dataset> data = s.sample(dataset, (int)(dataset.size()*((double)3/10)), 7);
			
			Classifier classifier = poker.criaArvore(9);
			classifier.buildClassifier(data.x());
			
			for (Instance inst : data.y()) {
				Object classePredita = classifier.classify(inst);
				Object classeReal = inst.classValue();
				
				System.out.println("Classe Real: " + classeReal);
				System.out.println("Classe Predita: " + classePredita);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
