package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will read symptom data from a source and write symptoms with their occurrence in a destination
 * The important part is, the return value from the operation, which is a Map of string keys and Integer values,
 * that does not contain duplications
 * 
 * The implementation needs to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty Map
	 * 
	 * @return an ordered Map of all Symptoms obtained from a data source as keys with their occurrence as values
	 */
	Map<String, Integer> GetSymptoms ();
	
	/**
	 * 
	 * @param sortedResult an ordered Map of all Symptoms obtained from a data source as keys with their occurrence as values
	 */
	void SetSymptoms (Map<String, Integer> sortedResult);
}
