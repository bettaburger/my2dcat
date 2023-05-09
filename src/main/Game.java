package main;

import java.awt.Graphics;

import Background.DataManager;
import entities.Player;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread; //passes code through thread
	private final int FPS_SET = 120; 
	private final int UPS_SET = 200;
	
	private Player player; 
	private DataManager dataManager;
	
	//background
	public final static int tilesDefault = 32;
	public final static float scale = 1.5f;
	public final static int tilesWidth = 26; 
	public final static int tilesHeight = 14; 
	public final static int tilesSize = (int) (tilesDefault * scale); 
	public final static int gamesWidth = tilesSize * tilesWidth;
	public final static int gamesHeight = tilesSize * tilesHeight;
	
	
	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();
		
		startGameLoop();
	
	}

	private void initClasses() {
		player = new Player(200, 200, 80, 60);
		dataManager = new DataManager(this);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	
	public void update() {
		player.update();
		dataManager.update();
	}
	
	public void render(Graphics g) {
		dataManager.draw(g);
		player.render(g);

	}
	
	//checks for lags and frame drops
	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET; //nanoseconds
		double timePerUpdate = 1000000000.0 / UPS_SET;

		
		long previousTime = System.nanoTime();
		
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
	
		double deltaU = 0;
		double deltaF = 0;
		
		while(true) {
			
			long currentTime = System.nanoTime();
			
			deltaU += (currentTime - previousTime) / timePerUpdate; 
			deltaF += (currentTime - previousTime) / timePerFrame;
			
			previousTime = currentTime;
			
			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			
			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
			
			
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS " + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	public Player getPlayer() {
		return player; 
	}

	public void windowFocusLost() {
		player.resetDirectionBoolean();
		
	}
}
