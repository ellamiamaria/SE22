package de.buw.se4de;

import java.util.LinkedList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		CSVScanner scanni = new CSVScanner();
		List<String> newVoc = new LinkedList<String>();
		newVoc = scanni.readFile("src/main/resources/testfile.csv");

		Trainer John = new Trainer();
		John.greeting();
		scanni.freshStart();
		
		
		John.firstTraining(newVoc);
		
		
		List<String> unkownVoc = new LinkedList<String>();
		List<String> repeatVoc = new LinkedList<String>();
		unkownVoc = scanni.readFile("src/main/resources/unknown.csv");	
		John.unkownTraining(unkownVoc);
		repeatVoc = scanni.readFile("src/main/resources/repeat.csv");
		John.repeatTraining(repeatVoc);
		

		
	}
}

