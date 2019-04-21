package matajus.minesweeper;

import java.awt.Graphics;

public class Cell {
	public boolean isBomb;
	public boolean isFlagged;
	public boolean isCovered;
	public int minesAround = 0;
	private int posX, posY;
	public static final int cellSize = 40;
	
	public void drawCell(Graphics g) {
		if(isBomb && !isCovered) {
			g.drawImage(Driver.image[11], posX, posY, cellSize, cellSize, null);
		}
		else if(isCovered && !isFlagged) {
			g.drawImage(Driver.image[10], posX, posY, cellSize, cellSize, null);
		}
		else if(isFlagged) {
			g.drawImage(Driver.image[9], posX, posY, cellSize, cellSize, null);
		}
		else if(!isCovered && minesAround > 0) {
			g.drawImage(Driver.image[minesAround], posX, posY, cellSize, cellSize, null);
		}
		else {
			g.drawImage(Driver.image[0], posX, posY, cellSize, cellSize, null);
		}
	}
	
	public void setPos(int posX, int posY) {
		this.posX = 45 + posX * cellSize;
		this.posY = 45 + posY * cellSize;
	}
}
