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
		
		this.purple = new Color(153, 50, 204);
		this.brown = new Color(139,69,19);
		
		this.saveButton = new JButton("Save Image");
		
		
	}
	
	private void setupPanel()
	{
		this.layout = new SpringLayout(); 
		this.setBackground(Color.lightGray);
		this.setPreferredSize(new Dimension(1200, 900));
		
		this.add(canvas);
		this.add(buttonPanel);
		
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
		
	}
	
	private void setupListeners()
	{
		
	}

}
