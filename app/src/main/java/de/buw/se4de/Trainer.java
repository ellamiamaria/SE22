package de.buw.se4de;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Trainer {

Scanner console = new Scanner(System.in);
	
public void greeting() {
	System.out.println("Hello! Welcome to your daily training!\n");
	System.out.println("What do you want to do?");

	}

public void train(List<String> voc) {
	
	
	List <String> repeat = new LinkedList<String>();
	List <String> unknown = new LinkedList<String>();
	
	for (int i = 0; i < voc.size(); i++) {
		String [] trainVoc = voc.get(i).split(",");
		System.out.println("Type the english word for: "+ trainVoc[0]);
		String inputString = console.nextLine();
		
		if (inputString.toLowerCase().equals(trainVoc[1].toLowerCase())) {
			System.out.println("Yea, good job!\n");
			repeat.add(trainVoc[0]+","+trainVoc[1]);
			}
		else {
			System.out.println("Nope, thats wrong!");
			System.out.println("The right answer would be: " + trainVoc[1] + "\n");
			unknown.add(trainVoc[0]+","+trainVoc[1]);
			}
		}
	
	CSVReader write = new CSVReader();
	write.writeFile(repeat, "repeat");
	write.writeFile(unknown, "unknown");
	
	console.close();
	}
}
