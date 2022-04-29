package de.buw.se4de;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class App {

	public static void main(String[] args) {
		
		CSVReader read = new CSVReader();
		List<String> startVoc = read.readFile("src/main/resources/testfile.csv");
		
		Trainer John = new Trainer();
		John.greeting();
		John.train(startVoc);

		
	}
}

