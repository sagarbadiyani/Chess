package chess;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Table {
	private final JFrame gameFrame;
	private static Dimension OUTER_FRAME_DIM = new Dimension(800, 800);
	
	public Table() {
		this.gameFrame = new JFrame("chess");
		this.gameFrame.setSize(OUTER_FRAME_DIM);
		this.gameFrame.setVisible(true);
	}
	
	
	
}
