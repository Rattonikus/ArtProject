package art.view;

import java.awt.Color;
import java.awt.Component; 
import java.awt.Dimension; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import art.controller.Controller;
import java.awt.GridLayout;

public class ColoringArtPanel extends JPanel //Coloring art panel TODO: Add mouse listeners, and setup layout. First figure out menu switcher.
{
	private Controller ArtController;
	private SpringLayout layout;
	private JPanel buttonPanel; 
	private JButton saveButton; 
	private ColoringCanvas canvas; 
	
	private Color brown; 
	private Color purple; 
		
	private JButton blackButton; 
	private JButton blueButton;
	private JButton brownButton;
	private JButton redButton;
	private JButton greenButton; 
	private JButton purpleButton; 
	private JButton yellowButton;
	private JButton choiceButton; 
	private JButton loadButton; 
	private JButton clearButton; 
	
	public ColoringArtPanel(Controller app)
	{
		super(); 
		this.layout = new SpringLayout(); 
		this.buttonPanel = new JPanel(new GridLayout(0,1));
		this.ArtController = app;
		this.canvas = new ColoringCanvas(app);
		
		this.blackButton = new JButton("Black Button");
		this.blueButton = new JButton("Blue Button");
		this.brownButton = new JButton("Brown Button");
		this.redButton = new JButton("Red Button");
		this.greenButton = new JButton("Green Button");
		this.purpleButton = new JButton("Purple Button");
		this.yellowButton = new JButton("Yellow Button");
		this.choiceButton = new JButton("Choice Button");
		this.loadButton = new JButton("Load Image");
		this.clearButton = new JButton("Clear Image");
		this.saveButton = new JButton("Save Image");
		
		this.purple = new Color(153, 50, 204);
		this.brown = new Color(139,69,19);		
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.LIGHT_GRAY);
		this.setPreferredSize(new Dimension(1200,900));
		this.add(canvas);
		this.add(buttonPanel);
		
		buttonPanel.add(blackButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(brownButton);
		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(purpleButton);
		buttonPanel.add(yellowButton);
		buttonPanel.add(choiceButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(saveButton);
		
		for(Component current : buttonPanel.getComponents())
		{
			if (current instanceof JButton)
			{
				JButton currentButton = (JButton) current; 
				currentButton.setBorderPainted(false);
				currentButton.setOpaque(true);
			}
		}
		
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, canvas, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, canvas, 20, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, canvas, -20, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -50, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -20, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 20, SpringLayout.EAST, canvas);
	
	}

	private void setupListeners()
	{
		
	}
}
