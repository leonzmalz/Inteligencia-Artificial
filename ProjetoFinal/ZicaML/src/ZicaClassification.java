

import java.io.File;
import java.io.IOException;

import net.sf.javaml.core.Dataset;
import net.sf.javaml.tools.data.FileHandler;

public class ZicaClassification {

	public static void main(String[] args) {
		try {
			Dataset dataset = FileHandler.loadDataset(new File("src/datasets/cdc_zika.csv"), 4, ",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
