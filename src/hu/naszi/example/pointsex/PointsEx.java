package hu.naszi.example.pointsex;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Surface extends JPanel implements ActionListener {

	private final int DELAY = 150;
	private Timer timer;

	public Surface() {

		initTimer();
	}

	private void initTimer() {

		timer = new Timer(DELAY, this);
		timer.start();
	}

	public Timer getTimer() {
		return timer;
	}
	
	private final Color randomColor() {
		Random random = new Random();
		int red = Math.abs(random.nextInt(256));
		int green = Math.abs(random.nextInt(256));
		int blue = Math.abs(random.nextInt(256));
		Color color = new Color(red, green, blue);
		return color;
	}

	private void doDrawing(Graphics g) {

		Random random = new Random();
		Graphics2D g2d = (Graphics2D) g;

		g2d.setPaint(Color.blue);

		int w = getWidth();
		int h = getHeight();

		for (int i = 0; i < 2000; i++) {
			int x = Math.abs(random.nextInt()) % w;
			int y = Math.abs(random.nextInt()) % h;
			g2d.setColor(randomColor());
			g2d.drawLine(x, y, x+2, y+2);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();
	}

}

public class PointsEx extends JFrame {

	public PointsEx() {
		initUI();
	}

	private void initUI() {

		final Surface surface = new Surface();
		add(surface);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				Timer timer = surface.getTimer();
				timer.stop();
			}

		});

		setTitle("Points");
		setSize(350, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				PointsEx ex = new PointsEx();
				ex.setVisible(true);
			}
		});
	}

}
