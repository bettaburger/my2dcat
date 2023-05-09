package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;

public class LoadSave {

	public static final String Player_Image = "game.png"; //cat sprite sheet
	public static final String Background_Image = "BACKGRUND.png"; //background	
	
	
	public static BufferedImage GetPlayerAtlas(String fileName) {
		BufferedImage img = null;
		InputStream is = LoadSave.class.getResourceAsStream("/" + fileName);
		//use to free up resources and close input
		try {
			img = ImageIO.read(is);
		
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	
}
	
	
	/*public static int[][] GetBackgroundData() {
		int[][] lvlData = new int[Game.tilesHeight][Game.tilesWidth];
	 BufferedImage img = 
	}*/
	}

