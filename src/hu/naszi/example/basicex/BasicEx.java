package hu.naszi.example.basicex;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

class Surface extends JPanel {
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString("Java 2D", 50, 50);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
}

public class BasicEx {
	
}
