package matajus.binaryencoder;

import java.awt.EventQueue;

public class Driver {
	public static Window window;
	public static final char[] charset = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray(); 
	public static final int[] mapping = {128, 64, 32, 16, 8, 4, 2, 1};
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				window = new Window();
				window.setVisible(true);
			}
		});
	}
}
