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

public class ColoringCanvas extends JPanel
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
		resetPoint(); 
		this.currentColor = Color.YELLOW;
		this.canvasImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
		
		this.setMinimumSize(new Dimension(800,800));
		this.setMaximumSize(new Dimension(800,800));
		this.setPreferredSize(new Dimension(800,800));
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
		
		ArrayList<Integer> tempXPoints = new ArrayList<Integer>();
		ArrayList<Integer> tempYPoints = new ArrayList<Integer>();
		
		for(int i = 0; i < arraySize; i++)
		{
			tempXPoints.add(random.nextInt(800));
			tempYPoints.add(random.nextInt(800));
		}
		
		int[] xPoints = tempXPoints.toArray(); 
		
		Polygon randomShape = new Polygon(xPoints.toArray(), yPoints.toArray(), arraySize);
		return null;
	}
	
	private void updateCanvas()
	{
		Graphics2D drawingGraphics = (Graphics2D) canvasImage.getGraphics();
		drawingGraphics.setColor(Color.CYAN);
		drawingGraphics.drawRect(0, 0, 800, 800);
		drawingGraphics.setStroke(new BasicStroke(5.5f));
		drawingGraphics.draw(drawShapeThing());
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
