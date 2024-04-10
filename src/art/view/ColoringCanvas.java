package art.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import art.controller.Controller;

public class ColoringCanvas extends JPanel
{
	private BufferedImage canvasImage; 
	private int previousX; 
	private int previousY; 
	private Color currentColor; 
	private Controller controller; 
	
	public ColoringCanvas(Controller app)
	{
		super(); 
		this.controller = app; 
		this.currentColor = Color.YELLOW;
		this.canvasImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		
		this.setMinimumSize(new Dimension(800,800));
		this.setMaximumSize(new Dimension(800,800));
		this.setPreferredSize(new Dimension(800,800));
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(canvasImage, 0, 0, null);
	}
}
