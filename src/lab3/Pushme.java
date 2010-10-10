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
	private Button pushMeButton;
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
		
		pushMeButton = new Button("Push me");
		pushMeButton.setSize(65, 24);
		pushMeButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent event) {
				randomizeButtonPosition();
			}
		});
		this.add(pushMeButton);
		
		randomizeButtonPosition();
		this.setVisible(true);
	}
	public void randomizeButtonPosition() {
		Point point = new Point(random.nextInt(735), random.nextInt(476));
		if (!pushMeButton.contains(point) &&
			!pushMeButton.contains(point.x + 65, point.y + 24) &&
			!pushMeButton.contains(point.x + 65, point.y) &&
			!pushMeButton.contains(point.x, point.y + 24))
			pushMeButton.setLocation(random.nextInt(735), random.nextInt(476));
		else
			randomizeButtonPosition();			
	}
	
	public static void main(String[] args) {
		new Pushme();
	}

}
