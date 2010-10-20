package lab4;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Shapes extends Frame {
	private Panel optionsPanel;
	private Choice shapeChoice;
	private TextField rText;
	private TextField gText;
	private TextField bText;
	private Checkbox fillCheckbox;
	private ShapeCanvas canvas;
	
	public Shapes() {
		super("Shapes");
		
		this.setSize(500, 550);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		
		optionsPanel = new Panel();
		shapeChoice = new Choice();
		rText = new TextField("0");
		gText = new TextField("0");
		bText = new TextField("0");
		fillCheckbox = new Checkbox("Fill");
		canvas = new ShapeCanvas();
		
		shapeChoice.addItem("circle");
		shapeChoice.addItem("rectangle");
		optionsPanel.add(shapeChoice);
		optionsPanel.add(rText);
		optionsPanel.add(gText);
		optionsPanel.add(bText);
		optionsPanel.add(fillCheckbox);
		
		canvas.setColor(new Color(Integer.parseInt(rText.getText()), 
				Integer.parseInt(gText.getText()), Integer.parseInt(bText.getText())));
		canvas.setFill(false);
		canvas.setShape("circle");
		
		shapeChoice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				canvas.setShape(shapeChoice.getSelectedItem());
				canvas.repaint();
			}
		});
		
		ActionListener colorListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setColor(new Color(Integer.parseInt(rText.getText()), 
						Integer.parseInt(gText.getText()), Integer.parseInt(bText.getText())));
				canvas.repaint();
			}
		};
		
		rText.addActionListener(colorListener);
		gText.addActionListener(colorListener);
		bText.addActionListener(colorListener);
		
		fillCheckbox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				canvas.setFill(fillCheckbox.getState());
				canvas.repaint();
			}
		});
		this.add(canvas);
		this.add(optionsPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Shapes();
	}

}
