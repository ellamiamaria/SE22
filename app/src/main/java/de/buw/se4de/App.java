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
		John.freshStart();
		
		
		
		John.train(newVoc);
		
		
		List<String> unkownVoc = new LinkedList<String>();
		unkownVoc = scanni.readFile("src/main/resources/unknown.csv");
		John.train(unkownVoc);
		

		
	}
}

