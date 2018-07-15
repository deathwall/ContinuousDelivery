package com.fr.training.data.initialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fr.training.data.mongodb.GameRepository;
import com.fr.training.entities.Game;

import lombok.Data;

@Data
public class DataLoader {

	@Autowired
	private static GameRepository gameRepository;
	
	File file;
	
	/**
	 * DataLoader constructor
	 * @param file, the file that you want to load
	 */
	public DataLoader(String filePath) {
		super();
		this.file = new File(filePath);
	}

	public void loadFile() {
		
		BufferedReader bufferedReader = null;
		try{
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "iso-8859-1"));
			bufferedReader.lines().forEach(DataLoader::parseAndSaveData);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (null != bufferedReader) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void parseAndSaveData(String line) {
		Optional<Game> newGame = mapStringToGame(line);
		if (newGame.isPresent()) {			
			gameRepository.save(newGame.get());
		}
	}
	
	public static Optional<Game> mapStringToGame(String line) {
		String[] rowData = line.split(",");
		String name = (rowData.length>0) ? rowData[0] : null;
		String platform = (rowData.length==2) ? rowData[1] : "PC";
		return Optional.of(new Game(name, platform));
	}
	
}
