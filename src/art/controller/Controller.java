package art.controller;

import javax.swing.JOptionPane; 
import art.view.ArtFrame;


public class Controller 
{
	private ArtFrame frame; 
	
	public Controller()
	{
		
	}
	
	public void start()
	{
		JOptionPane.showMessageDialog(frame, "Welcome to Java Art");
		this.frame = new ArtFrame(this); 
	}
	
	public void handleError(Exception error) 
	{ 
		JOptionPane.showMessageDialog(frame, error.getMessage(), "Java art Error!", JOptionPane.ERROR_MESSAGE);
	}
}
