package matajus.minesweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEvents implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int col = (e.getX()-45) / Cell.cellSize;
		int row = (e.getY()-45) / Cell.cellSize;
		if(e.getX() > 45 && e.getX() < 645 && e.getY() > 45 && e.getY() < 645) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				Driver.board.uncover(col, row);
			}
			if(e.getButton() == MouseEvent.BUTTON3) {
				Driver.board.flag(col, row);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

}
