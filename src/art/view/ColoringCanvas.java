package art.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.io.File; 

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import art.controller.Controller;

public class ColoringCanvas extends JPanel	//ColoringCanvas that contains ploygon drawings. TODO: Add more drawings, and buttons to mess with variables within. 
{
	private BufferedImage canvasImage; 
	private int previousX; 
	private int previousY; 
	private Color currentColor; 
	private Controller app; 
	
	public ColoringCanvas(Controller app)
	{
		super(); 
		this.app = app; 
		this.currentColor = Color.YELLOW;
		this.canvasImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		
		this.setMinimumSize(new Dimension(800,800));
		this.setMaximumSize(new Dimension(800,800));
		this.setPreferredSize(new Dimension(800,800));

		resetPoint(); 
		updateCanvas();
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.drawImage(canvasImage, 0, 0, null);
	}
	
	private void resetPoint()
	{
		this.previousX = Integer.MIN_VALUE;
		this.previousY = Integer.MIN_VALUE;
	}
	
	private Polygon drawShapeThing()
	{
		int [] xPoints = {100,200};
		int [] yPoints = {100,200};
		
		Polygon thing = new Polygon(xPoints, yPoints, 2);
		return thing; 
	}
	
	private Polygon drawRandomShape()
	{
		Random random = new Random(); 
		
		int arraySize = random.nextInt(8);
		System.out.println(arraySize);

		int [] xPoints = new int[arraySize];
		int [] yPoints = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++)
		{
			xPoints[i] = random.nextInt(800);
			System.out.println(xPoints[i] + "X");
			yPoints[i] = random.nextInt(800);
			System.out.println(yPoints[i] + "y");
		} 
		
		Polygon randomShape = new Polygon(xPoints, yPoints, arraySize);
		return randomShape;
	}
	
	private void updateCanvas()
	{
		Graphics2D drawingGraphics = (Graphics2D) canvasImage.getGraphics();
		drawingGraphics.setColor(Color.CYAN);
		drawingGraphics.drawRect(0, 0, 800, 800);
		drawingGraphics.setStroke(new BasicStroke(5.5f));
		drawingGraphics.draw(drawShapeThing());
		drawingGraphics.draw(drawRandomShape());
	}
	
	public void save()
	{
		try
		{
			JFileChooser saveDialog = new JFileChooser(".");
			saveDialog.showSaveDialog(this);
			String savePath = saveDialog.getSelectedFile().getPath();
			if (savePath.indexOf(".png") == -1)
			{
				savePath += ".png";
			}
			ImageIO.write(canvasImage, "PNG", new File(savePath));
		}
		catch(IOException | NullPointerException e)
		{
			app.handleError(e);
		}
	}
	
	public void loadImage()
	{
		BufferedImage source = null;
		
		try 
		{
			JFileChooser picker = new JFileChooser(".");
			picker.addChoosableFileFilter(new FileNameExtensionFilter("Pictures!", "png"));
			
			if (picker.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				String filepath = picker.getSelectedFile().getPath();
				source = ImageIO.read(new File(filepath));
				canvasImage = source;
				repaint(); 
			}
		}
		catch(Exception error)
		{
			app.handleError(error);
		}
	}
}
