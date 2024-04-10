package art.view;

import java.awt.Color;
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
		this.loadButton = new JButton("Load button");
		this.clearButton = new JButton("Clear Button");
		
	}

}
