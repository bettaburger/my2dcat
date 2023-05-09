package utilz;

import main.Game;

public class HelpMethods {

	public static boolean canMoveHere(float x, float y, int width, int height) {
		if(!isSolid(x,y))
			if (!isSolid(x + width, y + height))
				if(!isSolid(x + width, y) ) 
					if(!isSolid(x, y + height))
						return true;
		return false;
	}
	//if we are inside 
	private static boolean isSolid(float x, float y) {
		if (x < 0 || x >= Game.gamesWidth)
			return true;
		if (y < 0 || y >= Game.gamesHeight)
			return true;
		
		int value =  1248 * 273;
		
		
		return false;
	}
	
}
