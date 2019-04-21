package matajus.snake;

import java.util.Random;

public class Apple {
	private static int posX;
	private static int posY;
	private static boolean appleSpawned;
	
	public static final void spawnApple() {
		Random random = new Random();
		posX = random.nextInt(20);
		posY = random.nextInt(20);
	}
	
	public static boolean getAppleSpawned() {
		return appleSpawned;
	}
	
	public static int getPosX() {
		return posX;
	}
	
	public static int getPosY() {
		return posY;
	}
	
	public static void setAppleSpawned(boolean isSpawned) {
		appleSpawned = isSpawned;
	}
}
