import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class CSVReader {

List <String> voc;

public CSVReader(String fileName) {
	
		// create scanner
		try {
			Scanner sc = new Scanner (new File(fileName), "UTF-8");
			voc = readFile(sc);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

public List<String> readFile(Scanner sc) {
	
	sc.useDelimiter(",");
	// create hashtable
	List <String> listOfVoc = new LinkedList<String>();
	String x;
	// add CSV data to Hashtable
	while (sc.hasNextLine()) {
			x = sc.nextLine();
			String[] parts = x.split(";");
			listOfVoc.add(parts[0]);
			listOfVoc.add(parts[1]);
			}
	sc.close();				
	return listOfVoc;
}



public List <String> getVoc(){
	return voc;
	}
}
