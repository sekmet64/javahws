package lab3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

@SuppressWarnings("serial")
public class Colors extends Frame {
	ColorPanel panel1;
	ColorPanel panel2;
	ColorPanel panel3;
	Random random;

	public class ColorPanel extends Panel {
		public void randomizeBackgroundColor() {
			this.setBackground(new Color(random.nextInt()));
		}
		
		public ColorPanel() {
			this.randomizeBackgroundColor();
		}
	}
	
	public Colors() {
		super("Colors");
		this.setSize(483, 300);
		this.setLayout(new GridLayout());
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		random = new Random();
		
		panel1 = new ColorPanel();
		panel2 = new ColorPanel();
		panel3 = new ColorPanel();
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				((ColorPanel) e.getSource()).randomizeBackgroundColor();			
			}
		};
			
		panel1.addMouseListener(mouseAdapter);
		panel2.addMouseListener(mouseAdapter);
		panel3.addMouseListener(mouseAdapter);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);

		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		new Colors();
	}

}
