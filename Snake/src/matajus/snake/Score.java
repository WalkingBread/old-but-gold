package matajus.snake;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Score {
	private File file;
	public static int score;
	private static final String fileName = "BestScores.txt";
	
	public Score() {
		file = new File(fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveToFile() {
		if(score > findBestScore()) {
			try {
				PrintWriter writer = new PrintWriter(file);
				writer.println(score);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int findBestScore() {
		List<Integer> lines = new ArrayList<Integer>();
		Scanner input;
		int bestScore = 0;
		try {
			input = new Scanner(file);
			if(linesNumber() > 0) {
				for(int i = 0; i < linesNumber(); i++) {
					String readLine = input.nextLine();
					int line = Integer.parseInt(readLine);
					lines.add(line);
				}
				bestScore = Collections.max(lines);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bestScore;
	}
	
	private int linesNumber() throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line;
		int lines = 0;
		try {
			while((line = reader.readLine()) != null) {
				lines++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}
}
