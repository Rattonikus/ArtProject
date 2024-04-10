package art.view;

import javax.swing.JFrame;

import art.controller.Controller;

public class ArtFrame extends JFrame
{
	
	private Controller app;
	private ArtPanel panel; 
	
	public ArtFrame(Controller controller)
	{
		super(); 
		this.app = controller; 
		this.panel = new ArtPanel(controller);
		setupFrame(); 
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		 this.setSize(1200, 900);
		 this.setTitle("Java Artwork");
		 this.setResizable(false);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.setVisible(true);
	}

}
