package matajus.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
	private int posX;
	private int posY;
	private int length;
	private boolean isAlive;
	public static String direction;
	public static final int defaultLength = 3;
	List<Integer> tailPosX;
	List<Integer> tailPosY;
	
	public Snake() {
		tailPosX = new ArrayList<Integer>();
		tailPosY = new ArrayList<Integer>();
		setAlive(true);
		setHeadPosition(5, 5);
		setLength(defaultLength);
	}
	
	public void setHeadPosition(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void move() {
		tailPosX.add(posX);
		tailPosY.add(posY);
		if(direction == "UP") {
			posY--;
		}
		else if(direction == "DOWN") {
			posY++;
		}
		else if(direction == "LEFT") {
			posX--;
		}
		else if(direction == "RIGHT") {
			posX++;
		}
		if(posX > 19) posX -= 20;
		else if(posX < 0) posX += 20;
		else if(posY > 19) posY -= 20;
		else if(posY < 0) posY += 20;
		deleteTail();
	}
	
	private void deleteTail() {
		if(tailPosX.size() > length) {
			tailPosX.remove(0);
			tailPosY.remove(0);
		}
	}
	
	public void eatApple() {
		if(posX == Apple.getPosX() && posY == Apple.getPosY()) {
			length++;
			Apple.spawnApple();
		}
	}
	
	public void checkCollision() {
		if(tailPosX.size() >= 3 && direction != null) {
			for(int tailIndex = 0; tailIndex < length; tailIndex++) {
				if(posX == tailPosX.get(tailIndex) && posY == tailPosY.get(tailIndex)) {
					setAlive(false);
				}
			}
		}
	}

}
