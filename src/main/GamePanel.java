package main;


import java.awt.Graphics;

import java.awt.*;

import javax.swing.JPanel;

import Inputs.MouseInputs;


import static main.Game.gamesWidth;
import static main.Game.gamesHeight;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private Game game; 
	
	public GamePanel(Game game) {
		mouseInputs = new MouseInputs(this);
		this.game = game; 
		
		setPanelSize();
		addKeyListener(new Inputs.KeyboardInputs(this)); //refers to gamePanel
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	


	//creating the window border pixels 
	private void setPanelSize() {
		Dimension size = new Dimension(gamesWidth, gamesHeight);
		setPreferredSize(size);
		//size: 1248 by 672
		System.out.println("size: " + gamesWidth + " | " + gamesHeight);
	}


	//updates animations
	public void updateGame() {
	
		
	}
	
	//graphics allow us to draw on JPanel
	public void paintComponent(Graphics g) {
		//calls from JPanel
		super.paintComponent(g);
		
		game.render(g);
	
}
	public Game getGame() {
		return game;
	}
	
}
