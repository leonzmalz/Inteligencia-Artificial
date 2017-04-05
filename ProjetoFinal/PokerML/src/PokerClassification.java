
import java.io.File;
import java.io.IOException;
import java.util.Random;

import be.abeel.util.Pair;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.tree.RandomTree;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.sampling.Sampling;
import net.sf.javaml.tools.data.FileHandler;


public class PokerClassification implements Classification {

	@Override
	public Classifier criaArvore(int numeroDeAtributos) {
		return new RandomTree(numeroDeAtributos, new Random());
	}

	@Override
	public double calculaTempoDeTreino(Classifier classificador, Dataset dataset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculaPerformanceSimples(Classifier classificador, Dataset dataset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculaPerformance(Classifier classificador, Dataset dataset) {
		// TODO Auto-generated method stub
		return 0;
	}

}
