package art.view;

import javax.swing.*;
import art.controller.Controller;

public class ArtFrame extends JFrame //The Frame class. TODO: finish the menu setup
{
	
	private Controller app;
	private ArtPanel panel; 
	private ColoringArtPanel coloringPanel; 
	private JTabbedPane tabbedPane; 
	private JMenuBar menuBar;
	
	public ArtFrame(Controller controller)
	{
		super(); 
		this.app = controller; 
		this.panel = new ArtPanel(controller);
		this.tabbedPane = new JTabbedPane();
		this.menuBar = new JMenuBar(); 
		
		setupMenu(); 
		setupFrame(); 
	}
	
	private void setupFrame()
	{
		tabbedPane.add("Drawings", panel);
		tabbedPane.add("Coloring", coloringPanel);
		
		this.setContentPane(panel);
		 this.setSize(1200, 900);
		 this.setTitle("Java Artwork");
		 this.setResizable(false);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.setVisible(true);
	}
	
	private void setupMenu()
	{
		
	}

}
