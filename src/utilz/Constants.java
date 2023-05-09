package utilz;

public class Constants {
	public static class Directions {
		public static final int LEFT = 1;
		public static final int RIGHT = 2;
		public static final int UP = 3;
		public static final int DOWN = 4;
	}
	public static class PlayerConstants {
		public static final int IDLE = 0; 
		public static final int WALKINGLEFT = 1;
		public static final int WALKINGRIGHT = 2;
		public static final int PETTING = 3;
		//public static final int EATING;
		//public static final int DRINKING;
		public static final int SLEEPING = 4;
		
		
		public static int GetSpriteAmount(int player_action) {
			switch(player_action) {
			
			//prevents out of bounds 
			case WALKINGLEFT:
				return 3;
			case IDLE:
				return 3;
			case PETTING:
				return 3;
			case WALKINGRIGHT:
				return 3;
			case SLEEPING:
				return 4;
			default:
				return 1;
			}
			
		}
	}
}
