import java.util.List;
import java.util.Scanner;

public class Trainer {
	
public void greeting() {
	System.out.println("Hello! Welcome to your daily training!\n");
	}
public void congrats() {
	System.out.println("Good Job!");
}
public void train(List<String> voc) {
	
	Scanner console = new Scanner(System.in);
	System.out.println("Press Enter to move forward..\n");
	
	for (int i = 0; i < voc.size(); i+=2) {
		System.out.println("Whats the english word for: "+ voc.get(i)+" ?");
		console.nextLine();
		System.out.print("The answer is: "+ voc.get(i+1));
		console.nextLine();
		System.out.println("Did you get that right?");
		console.nextLine();
	}
}

}

