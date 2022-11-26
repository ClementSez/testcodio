package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
public class Main {


public static void main(String args[]) throws Exception {
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
    ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		AnalyticsCounter analyse = new AnalyticsCounter(reader, writer);
    List<String> listSymptoms = analyse.getSymptoms();
    Map<String, Integer> countedSymptoms = analyse.countSymptoms(listSymptoms);
    Map<String, Integer> sortedSymptoms = analyse.sortSymptoms(countedSymptoms);
    analyse.writeSymptoms(sortedSymptoms);
	}
}