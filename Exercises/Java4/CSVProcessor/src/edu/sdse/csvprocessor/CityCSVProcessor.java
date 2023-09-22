package edu.sdse.csvprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;


public class CityCSVProcessor {
	
	public void readAndProcess(File file) {
		//Try with resource statement (as of Java 8)
                
                //FLAG FOR PRINTING
                boolean printLoadedValues = true;
                List<CityRecord> allRecords = new ArrayList<>();
                Map<String,List<CityRecord>> recordsByCity = new HashMap<>();
                
                
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			//Discard header row
			br.readLine();
			
			String line;
			
                        
			while ((line = br.readLine()) != null) {
				// Parse each line
				String[] rawValues = line.split(",");
				
				int id = convertToInt(rawValues[0]);
				int year = convertToInt(rawValues[1]);
				String city = convertToString(rawValues[2]);
				int population = convertToInt(rawValues[3]);
				
				System.out.println("id: " + id + ", year: " + year + ", city: " + city + ", population: " + population);
				
				//TODO: Extend the program to process entries!
<<<<<<< Updated upstream:Exercises/Java4/CSVProcessor/src/edu/sdse/csvprocessor/CityCSVProcessor.java
=======
                                CityRecord cityRecord = new CityRecord(id,year,city,population);
                                if(printLoadedValues)
                                    System.out.println(cityRecord);
                                
                                allRecords.add(cityRecord);
                                //if new city, add it to the hashmap
                                if(!recordsByCity.containsKey(city))
                                    recordsByCity.put(city, new ArrayList<>());
                                recordsByCity.get(city).add(cityRecord);
>>>>>>> Stashed changes:Exercises/Java4/CSVProcessor/CSVProcessor/src/edu/sdse/csvprocessor/CityCSVProcessor.java
			}

		} catch (Exception e) {
			System.err.println("An error occurred:");
			e.printStackTrace();
		}                              
                process(recordsByCity);
	}
	
        private void process(Map<String,List<CityRecord>> recordsByCity){
            for(Entry<String, List<CityRecord>> entry: recordsByCity.entrySet()){
                String city = entry.getKey();
                int entryCount = 0;
                Set<Integer> yearsList = new HashSet<>();
                int populationSum = 0;
                for(CityRecord record : entry.getValue()){
                    entryCount++;
                    yearsList.add(record.getYear());
                    populationSum+=record.getPopulation();
                }
                System.out.println("Average population of "+city+" ("+
                        Collections.min(yearsList)+"-"+Collections.max(yearsList)+
                        "; "+entryCount+" entries): "+(populationSum/entryCount));
            }
        }        
        
	private String cleanRawValue(String rawValue) {
		return rawValue.trim();
	}
	
	private int convertToInt(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		return Integer.parseInt(rawValue);
	}
	
	private String convertToString(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		
		if (rawValue.startsWith("\"") && rawValue.endsWith("\"")) {
			return rawValue.substring(1, rawValue.length() - 1);
		}
		
		return rawValue;
	}
	
	public static final void main(String[] args) {
		CityCSVProcessor reader = new CityCSVProcessor();
		
		File dataDirectory = new File("data/");
		File csvFile = new File(dataDirectory, "Cities.csv");
		
		reader.readAndProcess(csvFile);
	}
}
