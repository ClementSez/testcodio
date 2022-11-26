package com.hemebiotech.analytics;

import java.util.Map;
import java.io.FileWriter;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter
{

  public void writeSymptoms(Map<String, Integer> symptoms) throws Exception {

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
  }
}