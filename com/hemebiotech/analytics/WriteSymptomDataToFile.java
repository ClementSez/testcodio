package com.hemebiotech.analytics;

import java.util.Map;
import java.io.FileWriter;
import java.util.Map.Entry;
import java.io.IOException;

public class WriteSymptomDataToFile implements ISymptomWriter
{
  	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}

  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {

    FileWriter writer = new FileWriter ("result.out");
		// Boucle qui ecrit chaque ligne reçu, jusqu'à entry=null
		for(Entry<String, Integer> entry : symptoms.entrySet()){
				String symptom = entry.getKey();
				Integer count = entry.getValue();
				// Methode write pour ecrire le fichier et methode format pour formater la sortie string et integer
				writer.write(String.format(symptom +" : "+count));
				writer.write(System.lineSeparator());
		}
		System.out.println("WriteSymptomDataToFile Finished...");
		// ferme le writer
		writer.close();
    
    } catch (IOException e) {
			e.printStackTrace();
		}
  }
}