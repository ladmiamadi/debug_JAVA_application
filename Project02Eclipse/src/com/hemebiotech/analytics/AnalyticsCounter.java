package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile symptom = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt", "result.out");
		
		Map<String, Integer> orderedSymptoms = symptom.GetSymptoms();
		symptom.SetSymptoms(orderedSymptoms);
	}
}
