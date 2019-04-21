package matajus.minesweeper;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window() {
		setSize(700, 700);
		setTitle("Minesweeper");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(Driver.image[13]);
		setResizable(false);
	}
}
