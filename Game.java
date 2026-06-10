import java.util.ArrayList;

public class Game {
	
	public static ArrayList<Character> populate(int num) {
		ArrayList<Character> enemies = new ArrayList<Character>();
		for(int i = 0; i < num; i++) {
			int type = (int) (Math.random() * 3) + 1;
			int lvl = (int) (Math.random() * 3) + 1;
			int lightAttack = (int) (Math.random() * (lvl * 3)) + lvl;
			int heavyAttack = (int) (Math.random() * (lvl * 5)) + lvl;
			int h = (int) (Math.random() * (100 * lvl)) + 1;
			if(type == 1) {
				enemies.add(new Knight(lvl, h, lightAttack, heavyAttack));
			} else if(type == 2) {
				enemies.add(new Dragon(lvl, h, lightAttack, heavyAttack));
			} else if(type == 3) {
				enemies.add(new Wizard(lvl, h, lightAttack, heavyAttack));
			}
		}
		return enemies;
	}
}
