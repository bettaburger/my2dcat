package entities;

import static utilz.Constants.Directions.DOWN;
import static utilz.Constants.Directions.LEFT;
import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.Directions.UP;
import static utilz.Constants.PlayerConstants.GetSpriteAmount;
import static utilz.Constants.PlayerConstants.IDLE;
import static utilz.Constants.PlayerConstants.WALKINGLEFT;
import static utilz.Constants.PlayerConstants.WALKINGRIGHT;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilz.LoadSave;

import static utilz.Constants.PlayerConstants.PETTING;


public class Player extends Entity {

	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 25;
	private int playerAction = IDLE; 
	private int animationNumber = 2; //controls movement speed

	private int playerDirection = -1; // not moving, moving is 0
	private boolean moving = false, petting = false, moving2 = false;
	
	
	private boolean left, up, right, down;
	
	public Player(float x, float y, int width, int height) {
		super(x, y, width, height);
		loadAnimations();
	}

	public void update() {
		updatePosition();
		updateHitbox();
		updateAnimationTick();
		setAnimation();
	
	}
	
	public void render(Graphics g) {
		g.drawImage(animations[playerAction][animationIndex], (int)x, (int)y, 87, 63, null); //cat is 29by21
		drawHitbox(g);
	}
	


	
	private void updateAnimationTick() {
		animationTick++;
		if(animationTick >= animationSpeed) {
			animationTick = 0;
			animationIndex++;
			
			//stopping animation here 
			if (animationIndex >= GetSpriteAmount(playerAction)) { //different index animations
				animationIndex = 0;
				petting = false;
			}
		}
	}
	private void setAnimation() {
		
		int startAnimation = playerAction;
		
		if (isLeft()) 
			playerAction = WALKINGLEFT;
		else 
			playerAction = IDLE;
		
	if (petting)
		playerAction = PETTING; 
	
	
	if (isRight())
		playerAction = WALKINGRIGHT;
	
		
	if(startAnimation != playerAction)
		resetAnimationTick();
	}
	private void resetAnimationTick() {
		animationTick = 0;
		animationIndex = 0;
		
	}

	//update constants
	private void updatePosition() {
		moving = false;
		
		if(left && !right) {
			x-=animationNumber;
			moving = true;
		} else if (right && !left) {
			x+=animationNumber;
			moving = true; 
		}
		if (up&& !down) {
			y-=animationNumber;
			moving = true; 
		} else if (down && !up) {
			y+=animationNumber;
			moving = true; 
		}
		
	}
	public void resetDirectionBoolean() {
		left = false;
		right = false;
		up = false;
		down = false;
				
		
	}
	
	public void setPetting(boolean petting) {
		this.petting = petting;
		
	}
	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	private void loadAnimations() {
			BufferedImage img = LoadSave.GetPlayerAtlas(LoadSave.Player_Image);
			
			animations = new BufferedImage[5][5]; //sprite image 3by3
			for(int r = 0; r < animations.length; r++)
			for(int c = 0; c < animations[0].length; c++) 
				animations[r][c] = img.getSubimage(c * 29, r * 21, 29, 21);
			
	
		}
	}
	


