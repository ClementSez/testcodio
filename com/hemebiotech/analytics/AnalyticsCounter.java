package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
	 }

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> counter = new HashMap<String,Integer>();

				Integer InitialCount = 1;
				// Cree une boucle de lecture listSymptoms pour recuperer toutes les lignes
				for (String symptom : symptoms)
				{
					// Si la clé n'est pas presente
					if (!counter.containsKey(symptom))
					{
					// Ajoute chaque ligne à ma TreeMap counter
					counter.put(symptom,InitialCount);
					}
					// Si la clé est presente
					else if (counter.containsKey(symptom))
					{
						// Ajoute +1 au symptom
					counter.put(symptom,counter.get(symptom)+1);
					}
				}
		System.out.println("Count Finished...");
		// retourne la liste triee et comptee
		return counter;
	 }

	 public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		 	Map<String, Integer> sortedSymptoms = new TreeMap<>();
    	sortedSymptoms.putAll(symptoms);
		 return sortedSymptoms;
	  }

		public void writeSymptoms(Map<String, Integer> symptoms){
			this.writer.writeSymptoms(symptoms);
		 }
	
}