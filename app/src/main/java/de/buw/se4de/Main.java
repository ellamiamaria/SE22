import java.util.HashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//Get Vocabulary
	CSVReader read = new CSVReader("C:\\Users\\ellag\\eclipse-workspace\\VocTrain\\testfile.csv");
	List <String> voc = read.getVoc();

	//Start Training
	Trainer John = new Trainer();
	John.greeting();
	John.train(voc);
	
	//Show words
	
	}
}
