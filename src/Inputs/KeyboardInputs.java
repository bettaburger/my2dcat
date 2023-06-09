package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;
import static utilz.Constants.Directions.*;


public class KeyboardInputs implements KeyListener{
	private GamePanel gamePanel;
	
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W: //up
			gamePanel.getGame().getPlayer().setUp(false);
			break;
		case KeyEvent.VK_A: //left
			gamePanel.getGame().getPlayer().setLeft(false);
			break;
		case KeyEvent.VK_S: //down
			gamePanel.getGame().getPlayer().setDown(false);
			break;
		case KeyEvent.VK_D: //right
			gamePanel.getGame().getPlayer().setRight(false);
			break;	
	}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) { 
		case KeyEvent.VK_W: //up
			gamePanel.getGame().getPlayer().setUp(true);
			break;
		case KeyEvent.VK_A: //left
			gamePanel.getGame().getPlayer().setLeft(true);
			break;
		case KeyEvent.VK_S: //down
			gamePanel.getGame().getPlayer().setDown(true);
			break;
		case KeyEvent.VK_D: //right
			gamePanel.getGame().getPlayer().setRight(true);
			break;	
	}
		
	}

	
}

