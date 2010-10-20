package lab5;

import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.net.URL;

@SuppressWarnings("serial")
public class PaintApplet extends Applet {
	private PaintCanvas canvas;
	private Choice actions;
	private TextField param;
	private Button doIt;
	
	private Panel optionsPanel;
	private Panel canvasPanel;
	private Point oldPoint;
	private Point newPoint;
	
	public void init() {
		this.setSize(500, 500);
		canvas = new PaintCanvas();
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				oldPoint = newPoint;
				newPoint = e.getPoint();
				canvas.repaint();
			}
			public void mouseMoved(MouseEvent e) {
			}
		});
		
		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				oldPoint = e.getPoint();
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		this.setLayout(new BorderLayout());
		canvasPanel = new Panel();
		canvasPanel.setLayout(new FlowLayout());
		canvas.setSize(400, 400);
		canvasPanel.add(canvas);
		
		this.add(canvasPanel);
		
		
		optionsPanel = new Panel();
		optionsPanel.setLayout(new FlowLayout());
		actions = new Choice();
		actions.add("clear");
		actions.add("image");
		actions.add("web");
		actions.add("sound");
		param = new TextField(10);
		
		doIt = new Button("Do");
		
		optionsPanel.add(actions);
		optionsPanel.add(param);
		optionsPanel.add(doIt);
		this.add(optionsPanel, BorderLayout.SOUTH);
		
		
		doIt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (actions.getSelectedItem() == "clear") {
					canvas.clear();
				}
				if (actions.getSelectedItem() == "image") {
					canvas.loadImage(param.getText());
				}
				if (actions.getSelectedItem() == "web") {
					 try
					    {
					      AppletContext a = getAppletContext();
					      URL url = new URL("http://www." + param.getText());
					      a.showDocument(url,"_blank");
					    }
					    catch (Exception e){
					    	e.printStackTrace();
					    }
	
				}
				if (actions.getSelectedItem() == "sound") {
					AudioClip clip = getAudioClip(getCodeBase(), param.getText());
					clip.play();
				}
			}
		});
		
	}
	
	public class PaintCanvas extends Canvas {
		private Image image;
		public void paint(Graphics g) {
			
			if (image == null) {
				image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics g2 = image.getGraphics();
		        g2.setColor(Color.lightGray);
		        g2.fillRect(0,0, this.getWidth(), this.getHeight());
		        g2.dispose();
			}
			
			
			if (oldPoint != null) {
				Graphics g2 = image.getGraphics();
				g2.setColor(Color.black);
				g2.drawLine(oldPoint.x, oldPoint.y, newPoint.x, newPoint.y);
			}
			
			g.drawImage(image, 0, 0, this.getHeight(), this.getWidth(), this);
			
			
		}
		public PaintCanvas(ImageProducer imageProducer) {
	         image = createImage(imageProducer);
		}
		public PaintCanvas() {}
		public void loadImage(String name) {
			MediaTracker media = new MediaTracker(this);
			image = Toolkit.getDefaultToolkit().getImage(name);
			media.addImage(image, 0);
			try {
				media.waitForID(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			oldPoint = null;
			this.repaint();
			
		}
		public void clear() {
			image = null;
			oldPoint = null;
			this.repaint();
	        
		}
	}
	public void stop() { }
	 

	public void paint(Graphics g) {
	  
	}
}
