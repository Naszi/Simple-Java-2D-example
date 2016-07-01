package hu.naszi.example.caps;

import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1588378424647000805L;

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g.create();

		RenderingHints renderingHints = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		renderingHints.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(renderingHints);

		BasicStroke basicStroke1 = new BasicStroke(8, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_BEVEL);
		g2d.setStroke(basicStroke1);
		g2d.drawLine(20, 30, 250, 30);

		BasicStroke basicStroke2 = new BasicStroke(8, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_BEVEL);
		g2d.setStroke(basicStroke2);
		g2d.drawLine(20, 80, 250, 80);

		BasicStroke basicStroke3 = new BasicStroke(8, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_BEVEL);
		g2d.setStroke(basicStroke3);
		g2d.drawLine(20, 130, 250, 130);

		BasicStroke basicStroke4 = new BasicStroke();
		g2d.setStroke(basicStroke4);

		g2d.drawLine(20, 20, 20, 140);
		g2d.drawLine(250, 20, 250, 140);
		g2d.drawLine(254, 20, 254, 140);

		g2d.dispose();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

}

public class Caps extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9121107948550619418L;

	public Caps() {

		initUI();
	}

	private void initUI() {

		add(new Surface());

		setTitle("Cups");
		setSize(280, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				Caps caps = new Caps();
				caps.setVisible(true);
			}
		});
	}
}
