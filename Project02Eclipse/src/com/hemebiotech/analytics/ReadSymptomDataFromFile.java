package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * reads symptoms from a file and save them into a Map with their occurrences to write them in another file
 * Simple brute force implementation to the interface with methods to override
 *@author Ladmia
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private String inputFilepath;
	private String outputFilepath;
	
	/**
	 * 
	 * @param inputFilepath a path to file with symptom strings in it, one per line
	 * @param outputFilepath a path to file for writing symptoms in it with their occurrence
	 */
	public ReadSymptomDataFromFile (String inputFilepath, String outputFilepath) {
		this.inputFilepath = inputFilepath;
		this.outputFilepath = outputFilepath;
	}
	
	@Override
	/**
	 * @return an ordered Map of String keys and Integer values
	 * @see TreeMap
	 */
	public Map<String, Integer> GetSymptoms() {
		Map<String, Integer> result = new HashMap<String, Integer>();

			try {
				BufferedReader reader = new BufferedReader (new FileReader(inputFilepath));
				String line = reader.readLine();
				
				// if the symptom exists in result we increment it otherwise we add a new key to result
				while (line != null) {
					if(result.containsKey(line)) {
						result.put(line, result.get(line) + 1);
					} else {
						result.put(line, 1);
					}
					
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		Map<String, Integer> sortedResult = new TreeMap<>(result);
		return sortedResult;
	}
	
	@Override
	public void SetSymptoms(Map <String, Integer> sortedReslut) {
		try {
			FileWriter writer = new FileWriter (outputFilepath);
			
	        for (Map.Entry<String, Integer> m : sortedReslut.entrySet()) {
	            writer.write(m.getKey()+": "+m.getValue()+"\n");
	            System.out.println(m.getKey()+": "+m.getValue());
	        }
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
