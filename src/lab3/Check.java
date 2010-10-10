package lab3;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Check extends Frame implements ItemListener {
	private Label label;
	private CheckboxGroup checkboxGroup;
	private Checkbox checkbox1;
	private Checkbox checkbox2;
	private Checkbox checkbox3;
	private Panel mainPanel;
	
	public Check() {
		// Frame
		super("Checkboxes");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		// Label
		label = new Label("one");
		this.add(label, BorderLayout.NORTH);
		
		// Checkboxes
		mainPanel = new Panel();
		mainPanel.setLayout(new FlowLayout());
		
		checkboxGroup = new CheckboxGroup();
		checkbox1 = new Checkbox("one", checkboxGroup, true);
		checkbox2 = new Checkbox("two", checkboxGroup, false);
		checkbox3 = new Checkbox("three", checkboxGroup, false);
		
		checkbox1.addItemListener(this);
		checkbox2.addItemListener(this);
		checkbox3.addItemListener(this);
		
		mainPanel.add(checkbox1);
		mainPanel.add(checkbox2);
		mainPanel.add(checkbox3);
		
		this.add(mainPanel, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Check();
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		label.setText(checkboxGroup.getSelectedCheckbox().getLabel());
	}
}
