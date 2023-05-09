package Background;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utilz.LoadSave;

public class DataManager {

	private Game game;
	private BufferedImage[] background;
	
	public DataManager(Game game) {
		this.game = game;
		importBackgroundSprites();
		
	}
	
	private void importBackgroundSprites() {
		BufferedImage img = LoadSave.GetPlayerAtlas(LoadSave.Background_Image);
		background = new BufferedImage[48];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 12; j++) {
				int index = i*12 + j;
				background[index] = img.getSubimage(j*32, i * 32, 32, 32);
			}
		
	}

	public void draw(Graphics g) {
		g.drawImage(background[1], 0, 0, null);
	}
	
	public void update() {
		
	}
}
