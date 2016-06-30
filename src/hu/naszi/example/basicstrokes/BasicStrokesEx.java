package hu.naszi.example.basicstrokes;

import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		float[] dash1 = { 2f, 0f, 2f };
		float[] dash2 = { 1f, 1f, 1f };
		float[] dash3 = { 4f, 0f, 2f };
		float[] dash4 = { 4f, 4f, 1f };

		g2d.drawLine(20, 40, 250, 40);

		BasicStroke basicStroke1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
		BasicStroke basicStroke2 = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);
		BasicStroke basicStroke3 = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);
		BasicStroke basicStroke4 = new BasicStroke(1, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);

		g2d.setStroke(basicStroke1);
		g2d.drawLine(20, 80, 250, 80);

		g2d.setStroke(basicStroke2);
		g2d.drawLine(20, 120, 250, 120);

		g2d.setStroke(basicStroke3);
		g2d.drawLine(20, 160, 250, 160);

		g2d.setStroke(basicStroke2);
		g2d.drawLine(20, 200, 250, 200);

		g2d.dispose();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}

}

public class BasicStrokesEx extends JFrame {
	
	public BasicStrokesEx() {
		
		initUI();
	}

	private void initUI() {
		
		add(new Surface());
		
		setTitle("Basick strokes");
		setSize(280, 270);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				BasicStrokesEx ex = new BasicStrokesEx();
				ex.setVisible(true);
			}
		});
	}

}
