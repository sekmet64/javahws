package lab3;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

@SuppressWarnings("serial")
public class Pushme extends Frame {
	private Button pullMe;
	private Random random;
	
	public Pushme() {
		// Frame
		super("Checkboxes");
		this.setLayout(null);
		this.setSize(800, 500);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		random = new Random();
		
		pullMe = new Button("Push me");
		
		pullMe.setSize(65, 24);
		pullMe.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				randomizeButtonPosition();
			}
		});
		this.add(pullMe);
		
		randomizeButtonPosition();
		this.setVisible(true);
	}
	public void randomizeButtonPosition() {
		Point point = new Point(random.nextInt(735), random.nextInt(476));
		if (!pullMe.contains(point) &&
			!pullMe.contains(point.x + 65, point.y + 24) &&
			!pullMe.contains(point.x + 65, point.y) &&
			!pullMe.contains(point.x, point.y + 24))
			pullMe.setLocation(random.nextInt(735), random.nextInt(476));
		else
			randomizeButtonPosition();			
	}
	
	public static void main(String[] args) {
		new Pushme();
	}

}
