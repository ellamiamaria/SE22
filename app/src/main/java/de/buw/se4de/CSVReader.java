package de.buw.se4de;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;


public class CSVReader {
	
// Declaration at this point?
List <String> voc = new LinkedList<String>();

public List <String> readFile(String path) {
	
	try (Reader reader = Files.newBufferedReader(Paths.get(path));
			@SuppressWarnings("deprecation")
			CSVParser csvParser = new CSVParser(reader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
		for (CSVRecord csvRecord : csvParser) {
			voc.add(csvRecord.get("german") + "," + csvRecord.get("english"));
			}
	} catch (IOException e) {
		
		e.printStackTrace();
			}
	
	return voc;
}

//Code based on https://www.tutorialspoint.com/Check-if-a-file-exists-in-Java
//and 
public void writeFile(List<String> vocList, String state) {	
	
	File f = new File("src/main/resources/"+state+".csv");
	
	if(!f.exists()) {	
		
	    try {
			CSVPrinter printer = new CSVPrinter(new FileWriter("src/main/resources/"+state+".csv"),CSVFormat.DEFAULT);
			printer.printRecord("german", "english");
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
	    
	else {
		
		List <String> alreadyKnown = readFile("src/main/resources/repeat.csv");
		
		try {
			CSVPrinter printer = new CSVPrinter(new FileWriter("src/main/resources/repeat.csv"),CSVFormat.DEFAULT);
			
			printer.printRecord("german", "english");
			for (String voc : alreadyKnown) {			
				String[] addVoc = voc.split(",");
				printer.printRecord(addVoc[0], addVoc[1]);
			}
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
}


public List <String> getVoc(){
	return voc;
	}
}

