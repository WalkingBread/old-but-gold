package matajus.snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W && Snake.direction != "DOWN") {
			Snake.direction = "UP";
		}
		else if(e.getKeyCode() == KeyEvent.VK_S && Snake.direction != "UP") {
			Snake.direction = "DOWN";
		}
		else if(e.getKeyCode() == KeyEvent.VK_A && Snake.direction != "RIGHT") {
			Snake.direction = "LEFT";
		}
		else if(e.getKeyCode() == KeyEvent.VK_D && Snake.direction != "LEFT") {
			Snake.direction = "RIGHT";
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
