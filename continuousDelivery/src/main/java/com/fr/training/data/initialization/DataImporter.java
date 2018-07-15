package com.fr.training.data.initialization;

public class DataImporter {
	
	public static void importData() {
		
		DataLoader dataLoader =new DataLoader("D:/jeux.txt");
		
		try {
			dataLoader.loadFile();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
