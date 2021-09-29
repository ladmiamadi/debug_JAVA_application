package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String inputFilepath;
	private String outputFilepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String inputFilepath, String outputFilepath) {
		this.inputFilepath = inputFilepath;
		this.outputFilepath = outputFilepath;
	}
	
	@Override
	public Map<String, Integer> GetSymptoms() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		
		if (inputFilepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(inputFilepath));
				String line = reader.readLine();
				
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
