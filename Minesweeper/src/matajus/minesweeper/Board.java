package matajus.minesweeper;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Board extends Canvas implements Runnable {
	public static final int rows = 15;
	public static final int cols = 15;
	public int flagLimit, minesLeft;
	public Cell[][] cell = new Cell[cols][rows];
	private boolean running;
	private boolean gameWon, gameLost;
	
	public Board() {
		addMouseListener(new MouseEvents());
		for(int col = 0; col < cols; col++) {
			for(int row = 0; row < rows; row++) {
				cell[col][row] = new Cell();
				cell[col][row].isCovered = true;
				cell[col][row].setPos(col, row);
			}
		}
		setMines(20);
	}
	
	private void setMines(int mines) { 
		Random random = new Random();
		for(int i = 0; i < mines;) {
			int col = random.nextInt(cols);
			int row = random.nextInt(rows);
			flagLimit = mines;
			minesLeft = flagLimit;
			if(!cell[col][row].isBomb) {
				cell[col][row].isBomb = true;
				if(col+1 < cols) cell[col+1][row].minesAround++;
				if(col-1 >= 0) cell[col-1][row].minesAround++;
				if(row+1 < rows) cell[col][row+1].minesAround++;
				if(row-1 >= 0) cell[col][row-1].minesAround++;
				if(col+1 < cols && row+1 < rows) cell[col+1][row+1].minesAround++;
				if(col+1 < cols && row-1 >= 0) cell[col+1][row-1].minesAround++;
				if(col-1 >= 0 && row-1 >= 0) cell[col-1][row-1].minesAround++;
				if(col-1 >= 0 && row+1 < rows) cell[col-1][row+1].minesAround++;
				i++;
			}
		}
	}
	
	public void uncover(int col, int row) {
		if(!cell[col][row].isFlagged) {
			if(cell[col][row].isCovered && !cell[col][row].isBomb) {
				cell[col][row].isCovered = false;
				if(cell[col][row].minesAround == 0) {
					if(col+1 < cols) uncover(col+1, row);
					if(col-1 >= 0) uncover(col-1, row);
					if(row+1 < rows) uncover(col, row+1);
					if(row-1 >= 0) uncover(col, row-1);
					if(col+1 < cols && row+1 < rows) uncover(col+1, row+1);
					if(col+1 < cols && row-1 >= 0) uncover(col+1, row-1);
					if(col-1 >= 0 && row-1 >= 0) uncover(col-1, row-1); 
					if(col-1 >= 0 && row+1 < rows) uncover(col-1, row+1);
				}
			}
			else if(cell[col][row].isBomb) {
				for(int i = 0; i < cols; i++) {
					for(int j = 0; j < rows; j++) {
						cell[i][j].isCovered = false;
					}
				}
				gameLost = true;
			}
		}
	}
	
	public void flag(int col, int row) {
		if(cell[col][row].isCovered) {
			if(!cell[col][row].isFlagged && flagLimit > 0) {
				cell[col][row].isFlagged = true;
				if(cell[col][row].isBomb) {
					minesLeft--;
				}
				flagLimit--;
			}
			else if(cell[col][row].isFlagged) {
				cell[col][row].isFlagged = false;
				if(cell[col][row].isBomb) {
					minesLeft++;
				}
				flagLimit++;
			}
		}
		if(minesLeft == 0) {
			for(int i = 0; i < cols; i++) {
				for(int j = 0; j < rows; j++) {
					cell[i][j].isCovered = false;
				}
			}
			gameWon = true;
		}
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();	
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				g.drawImage(Driver.image[12], i*50, j*50, 50, 50, null);
			}
		}
		for(int col = 0; col < cols; col++) {
			for(int row = 0; row < rows; row++) {
				cell[col][row].drawCell(g);
			}
		}
		Font font = new Font("Consolas", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Mines Left: " + flagLimit, 50, 40);
		if(gameWon) {
			g.setColor(Color.GREEN);
			g.drawString("You Won", 50, 665);
		}
		else if(gameLost) {
			g.setColor(Color.RED);
			g.drawString("You Lost", 50, 665);
		}
		g.dispose();
		bs.show();
	}
	
	public void start() {
		if(running) return;
		running = true;
		new Thread(this, "Matajus").start();
	}
	
	public void stop() {
		if(!running) return;
		running = false;
		System.exit(0);
	}

	@Override
	public void run() {
		while(running) {
			render();
			try {
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
