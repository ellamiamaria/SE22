package de.buw.se4de;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Trainer {

// HIER IRGENDWELCHE VARIABLEN EINFÜHREN? VERMUTLICH FALSCH
Scanner console = new Scanner(System.in);
List <String> known = new LinkedList<String>();
List <String> unknown = new LinkedList<String>();

//GENERAL GREETING
public void greeting() {
	System.out.println("Hello! Welcome to your daily training!\n");
	System.out.println("What do you want to do?");

	}

//START OVER CONFIG
public void freshStart() {
	try {
		Files.deleteIfExists(Paths.get("src/main/resources/repeat.csv"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		Files.deleteIfExists(Paths.get("src/main/resources/unknown.csv"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public void train(List<String> voc) {

	for (int i = 0; i < voc.size(); i++) {
		String [] trainVoc = voc.get(i).split(",");
		System.out.println("Was heißt: "+ trainVoc[0]);
		String inputString = console.nextLine();
		
		if (inputString.toLowerCase().equals(trainVoc[1].toLowerCase())) {
			System.out.println("Sehr gut!\n");
			known.add(trainVoc[0]+","+trainVoc[1]);
			}
		else {
			System.out.println("Leider falsch!");
			System.out.println("Die korrekte Antwort wäre " + trainVoc[1] + "\n");
			unknown.add(trainVoc[0]+","+trainVoc[1]);
			}
		}
	}

public void firstTraining(List<String> voc) {
	
	train(voc);
	CSVScanner write = new CSVScanner();
	write.writeFile(unknown, "unknown");
	write.writeFile(known, "repeat");
	
	//RESET LISTS
	unknown.clear();
	known.clear();
}

public void repeatTraining(List<String> voc) {
	
	train(voc);
	
	CSVScanner write = new CSVScanner();
	//Delete repeat - replace by current
	write.deleteFile("repeat");
	write.writeFile(unknown, "repeat");
	//Ads correctly repeated words to known	
	write.writeFile(known, "known");
	
	//RESET LISTS
	unknown.clear();
	known.clear();
	

}
public void unkownTraining(List<String> voc) {
	
	train(voc);
	
	//UPDATE FILES
	CSVScanner write = new CSVScanner();
	//Delete unknown - replace by current
	write.deleteFile("unknown");
	write.writeFile(unknown, "unknown");
	//Adds known words to "Repeat" file
	write.addToFile(known, "repeat");
	
	//RESET LISTS
	unknown.clear();
	known.clear();
	}

}
