package lab3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Text extends Frame implements ActionListener {
	private Panel northPanel;
	private TextArea textArea;
	private TextField textField;
	private Button enterButton;
	
	public Text() {
		super("Text");
		this.setLayout(new BorderLayout());
		this.setBounds(10, 10, 500, 400);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		
		northPanel = new Panel();
		northPanel.setLayout(new BorderLayout());
		
		textField = new TextField();
		textField.addActionListener(this);
		northPanel.add(textField, BorderLayout.CENTER);
		
		enterButton = new Button("Enter");
		enterButton.addActionListener(this);
		northPanel.add(enterButton, BorderLayout.EAST);
		
		
		
		textArea = new TextArea();
		this.add(northPanel, BorderLayout.NORTH);
		this.add(textArea, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Text();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		textArea.append(textField.getText() + '\n');
		textField.setText("");
	}

}
