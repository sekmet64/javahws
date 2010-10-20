package lab4;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class ShapeCanvas extends Canvas {
	private Color color;
	private boolean fill;
	private String shape;
	
	public void setColor(Color color) {
		this.color = color;		
	}

	public void setFill(boolean b) {
		fill = b;
	}

	public void setShape(String string) {
		shape = string;		
	}
	
	public void paint(Graphics g) {
		if (shape == "circle") {
			g.setColor(color);
			if (fill)
				g.fillOval(150, 150, 200, 200);
			else 
				g.drawOval(150, 150, 200, 200);
		} else {
			g.setColor(color);
			if (fill)
				g.fillRect(150, 150, 200, 200);
			else 
				g.drawRect(150, 150, 200, 200);
			
		}
	}

	
}
