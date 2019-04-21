package matajus.snake;

import javax.swing.JFrame;

public class Window extends JFrame {
	public static final int width = 610;
	public static final int height = 650;
	
	public Window() {
		setTitle("Snake");
		setVisible(true);
		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(new KeyboardListener());
	}
}
