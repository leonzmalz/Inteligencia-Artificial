

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.core.Dataset;

public interface Classification {

	public Classifier criaArvore(int numeroDeAtributos);
	public double calculaTempoDeTreino(Classifier classificador, Dataset dataset);
	public double calculaPerformanceSimples(Classifier classificador, Dataset dataset);
	public double calculaPerformance(Classifier classificador, Dataset dataset);
	
}
