package art.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import art.controller.*;


public class ArtPanel extends JPanel
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
	
	 
	
	
	
	public ArtPanel(Controller app)
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
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(1200, 900));
	
		this.buttonPanel.add(blackButton);
		this.buttonPanel.add(blueButton);
		this.buttonPanel.add(brownButton);
		this.buttonPanel.add(redButton);
		this.buttonPanel.add(greenButton);
		this.buttonPanel.add(purpleButton);
		this.buttonPanel.add(yellowButton);
		this.buttonPanel.add(choiceButton);
		this.buttonPanel.add(loadButton);
		this.buttonPanel.add(clearButton);
		this.buttonPanel.add(saveButton);
		this.blackButton.setBackground(Color.LIGHT_GRAY);
		this.blueButton.setBackground(Color.LIGHT_GRAY);
		this.brownButton.setBackground(Color.LIGHT_GRAY);
		this.redButton.setBackground(Color.LIGHT_GRAY);
		this.greenButton.setBackground(Color.LIGHT_GRAY);
		this.purpleButton.setBackground(Color.LIGHT_GRAY);
		this.yellowButton.setBackground(Color.LIGHT_GRAY);
		this.choiceButton.setBackground(Color.LIGHT_GRAY);
		this.loadButton.setBackground(Color.LIGHT_GRAY);
		this.clearButton.setBackground(Color.LIGHT_GRAY);
		this.saveButton.setBackground(Color.LIGHT_GRAY);
				
		for(Component current : buttonPanel.getComponents())
		{
			if (current instanceof JButton)
			{
				JButton currentButton = (JButton) current; 
				currentButton.setBorderPainted(false);
				currentButton.setOpaque(true);
			}
		}
		
		this.add(buttonPanel);
		this.add(canvas);
	}
	
	private void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, canvas, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, canvas, 20, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, canvas, -20, SpringLayout.SOUTH, this);


		
		
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -20, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -20, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 20, SpringLayout.EAST, canvas);
	}
	
	private void setupListeners()
	{
		saveButton.addActionListener(click -> canvas.save());
		loadButton.addActionListener(click -> canvas.loadImage());
	}
	

}
