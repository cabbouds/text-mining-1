/*
 * created 12/14/15 (worked from bien cuit; practicing building in eclipse; have been practicing with gradle and maven; cigars with tomo later tonight 
 * 
 * explores opennlp; building with eclipse; loading JARs in eclipse. this application detects sentences.
 * 
 * reference: http://www.programcreek.com/2012/05/opennlp-tutorial/
 * 
 * 1) go to apache and download opennlp (bin not source) from http://apache.arvixe.com/opennlp/
 * 2) grab the three JAR files (jwnl.jar; maxent.jar; and opennlptools.jar) and place into a new "lib" folder
 * 3) add JARs via eclipse
 * 4) download pretrained sentence detector from http://opennlp.sourceforge.net/models-1.5/
 * 
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;


public class application {

	public static void main(String[] args) {
	
		try {
			SentenceDetect();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void SentenceDetect() throws InvalidFormatException, IOException {
		// given some paragraph, print out sentences
		
		String paragraph = "Hi. How are you? This is Mike.";
		
		// always start with a model, a model is learned from training data
		InputStream is = new FileInputStream("en-sent.bin"); // pretrained model 
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);
		
		// call the detector with the sentence
		String sentences[] = sdetector.sentDetect(paragraph);
		
		System.out.println(sentences[0]);
		System.out.println(sentences[1]);
		is.close();
	}

}
