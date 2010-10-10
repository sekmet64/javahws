package lab3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Mouse extends Frame  {
	private Panel mainPanel;
	private Panel coordinatesPanel;
	private Label coordinatesLabel;
	private Label eventTypeLabel;
		
	public Mouse() {
		// Frame
		super("Mouse");
		this.setLayout(new BorderLayout());
		this.setBounds(10, 10, 500, 400);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
				
		// Main Panel
		mainPanel = new Panel();
		mainPanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				coordinatesLabel.setText(e.getPoint().getX() + "," + e.getPoint().getY());
				eventTypeLabel.setText("clicked");
			}
		});
		
		mainPanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				coordinatesLabel.setText(e.getPoint().getX() + "," + e.getPoint().getY());
				eventTypeLabel.setText("dragged");
			}

			public void mouseMoved(MouseEvent e) {
				coordinatesLabel.setText(e.getPoint().getX() + "," + e.getPoint().getY());
				eventTypeLabel.setText("moved");
			}
		});
		
		mainPanel.setBackground(Color.lightGray);
		this.add(mainPanel, BorderLayout.CENTER);
		
	
		// Coordinates Panel
		coordinatesPanel = new Panel();
		coordinatesPanel.setLayout(new GridLayout());
		
		coordinatesPanel.add(new Label("cursor coordinates: "));
		
		coordinatesLabel = new Label();
		coordinatesPanel.add(coordinatesLabel);
		
		coordinatesPanel.add(new Label("event type: "));
		
		eventTypeLabel = new Label();
		coordinatesPanel.add(eventTypeLabel);
		
		this.add(coordinatesPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Mouse();
	}	
}
