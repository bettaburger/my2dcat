package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	//Screen settings
	final int originalTileSize = 16; //16by16 title, size of player character, map titles
	final int scale = 3; 
	
	final int tileSize = originalTileSize * scale; // 48x48
	final int maxScreenCol = 16;
	final int maxScreenRow = 12; 
	final int screenWidth = tileSize * maxScreenCol; //768 pixels 
	final int screenHeight = tileSize * maxScreenRow; //576 pixels size of game screen
	
	Thread gameThread; //something you can start and stop - it will keep going - 60FPS
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered((true));
	}
	
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start(); //automatically call run method
	}

	@Override
	public void run() {
		//creating game loop
		while(gameThread != null) {
			
			
//			System.out.print("The game loop is running"); 
			//1. UPDATE INFROMATION SUCH AS CHARACTER POSITIONS
			update();
			
			//2. DRAW THE SCREEN  WITH THE UPDATE INFROMATION - XY CORD OF CHAR - IF HIT KEY UPDATE XY
			repaint();
		}
	}
	public void update() {
		
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
	}
}
