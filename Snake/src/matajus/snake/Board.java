package matajus.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private Timer timer;
	private Snake snake;
	private Score scoreTools;
	private int speed = 70;
	public static final int cellSize = 30;
	
	public Board() {
		timer = new Timer(speed, this);
		timer.start();
		snake = new Snake();
		scoreTools = new Score();
		Apple.spawnApple();
		Apple.setAppleSpawned(true);
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		scoreTools.score = snake.getLength()-snake.defaultLength;
		Font font = new Font("Consolas", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.fillRect(0, 600, getWidth(), getHeight());
		if(Apple.getAppleSpawned()) {
			g.setColor(Color.RED);
			g.fillRect(Apple.getPosX() * cellSize, Apple.getPosY() * cellSize, cellSize, cellSize);
		}
		g.setColor(Color.GREEN);
		g.fillRect(snake.getPosX() * cellSize, snake.getPosY() * cellSize, cellSize, cellSize);
		for(int i = 0; i < snake.tailPosX.size(); i++) {
			g.fillRect(snake.tailPosX.get(i) * cellSize, snake.tailPosY.get(i) * cellSize, cellSize, cellSize);
		}
		g.setColor(Color.BLACK);
		g.drawString("Score: " + (scoreTools.score), 10, 620);
		g.drawString("Best Score: " + scoreTools.findBestScore(), 440, 620);
		if(!snake.getIsAlive()) {
			gameOver(g);
		}
	}
	
	private void gameOver(Graphics g) {
		timer.stop();
		g.setColor(Color.RED);
		g.drawString("You Lost", 240, 620);
		scoreTools.saveToFile();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		snake.move();
		snake.checkCollision();
		snake.eatApple();
		repaint();
	}
	
	public static void main(String[] args) {
		Window window = new Window(); 
		window.add(new Board());
	}
	
	
}
