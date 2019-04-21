package matajus.minesweeper;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import matajus.minesweeper.graphics.ImageLoader;

public class Driver {
	public static Window window;
	public static Board board;
	public static final BufferedImage[] image = new BufferedImage[14];
	private static final String path = "/matajus/minesweeper/graphics/textures/";
	
	public static void main(String[] args) {
		window = new Window();
		window.setVisible(true);
		board = new Board();
		window.add(board);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				board.stop();
			}
		});
		board.start();
		getGraphics();
	}
	
	public static void getGraphics() {
		ImageLoader loader = new ImageLoader();
		try {
			image[0] = loader.loadImage(path + "empty.png");
			image[1] = loader.loadImage(path + "onearound.png");
			image[2] = loader.loadImage(path + "twoaround.png");
			image[3] = loader.loadImage(path + "threearound.png");
			image[4] = loader.loadImage(path + "fouraround.png");
			image[5] = loader.loadImage(path + "fivearound.png");
			image[6] = loader.loadImage(path + "sixaround.png");
			image[7] = loader.loadImage(path + "sevenaround.png");
			image[8] = loader.loadImage(path + "eightaround.png");
			image[9] = loader.loadImage(path + "flagged.png");
			image[10] = loader.loadImage(path + "hidden.png");
			image[11] = loader.loadImage(path + "bomb.png");
			image[12] = loader.loadImage(path + "bg.png");
			image[13] = loader.loadImage(path + "saper.png");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
