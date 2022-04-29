package de.buw.se4de;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CSVScanner {

	List <String> listOfVoc;
	Scanner sc;
	
//READ ALL CSV FILES BASED ON PATH
public List<String> readFile(String path){		
	
	try {
		sc = new Scanner (new File(path));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	sc.useDelimiter(",");
	// create hashtable
	List <String> listOfVoc = new LinkedList<String>();
	String x;
	// add CSV data to List
	while (sc.hasNextLine()) {
			x = sc.nextLine();
			listOfVoc.add(x);
			}
	
	sc.close();
	return listOfVoc;
}

// CEATES NEW FILE 
public void writeFile(List<String> vocList, String state) {
	
	File f = new File("src/main/resources/"+state+".csv");
		
	    try {
			CSVPrinter printer = new CSVPrinter(new FileWriter("src/main/resources/"+state+".csv"),CSVFormat.DEFAULT);
			for (String voc : vocList) {
				String[] addVoc = voc.split(",");
				printer.printRecord(addVoc[0], addVoc[1]);
			}
			printer.flush();
			printer.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
}

//COPYS CURRENT FILE & ADDS ALL TO FILE
public void addToFile(List<String> vocList, String state) {
	
	List<String> copyFile = new LinkedList<String>();	
	copyFile = readFile("src/main/resources/"+state+".csv");
	vocList.addAll(copyFile);
	
	writeFile(vocList, state);

}
	    
//DELETE FILE 
public void deleteFile(String fileToDelete) {
	
	try {
		Files.deleteIfExists(Paths.get("src/main/resources/"+fileToDelete+".csv"));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Cant delete");
	}
	
}

//RESET ON START CONFIG - ALL FILES ARE DELETED 

public void freshStart() {
	deleteFile("repeat");
	deleteFile("unknown");
	deleteFile("known");

}
	
public List <String> getVoc(){
		return listOfVoc;
	}
}


