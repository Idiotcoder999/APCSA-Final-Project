import java.util.ArrayList;

public class Game {

	public static ArrayList<Character> populate(int num) {
		boolean lvl1 = false;
		boolean lvl2 = false;
		boolean lvl3 = false;
		int lvl1Count = 0, lvl2Count = 0, lvl3Count = 0;
		ArrayList<Character> enemies = new ArrayList<Character>();
		for(int i = 0; i < num; i++) {
			int type = (int) (Math.random() * 3) + 1;
			int lvl = (int) (Math.random() * 3) + 1;
			int lightAttack = (int) (Math.random() * (lvl * 3)) + (lvl * 10);
			int heavyAttack = (int) (Math.random() * (lvl * 5)) + (lvl * 15);
			int h = (int) (Math.random() * (100 * lvl)) + 1;
			if(type == 1) {
				enemies.add(new Knight(lvl, h, lightAttack, heavyAttack));
			} else if(type == 2) {
				enemies.add(new Dragon(lvl, h, lightAttack, heavyAttack));
			} else if(type == 3) {
				enemies.add(new Wizard(lvl, h, lightAttack, heavyAttack));
			}
		}
		for(Character e : enemies) {
			if(e.getLevel() == 1) {
				lvl1 = true;
				lvl1Count++;
			}
			if(e.getLevel() == 2) {
				lvl2 = true;
				lvl2Count++;
			}
			if(e.getLevel() == 3) {
				lvl3 = true;
				lvl3Count++;
			}
		}

		if(!lvl1 || lvl1Count < 4) {
			for(int i = 0; i < 10; i++) {
				int type = (int) (Math.random() * 3) + 1;
				int lightAttack = (int) (Math.random() * (1 * 3)) + 10;
				int heavyAttack = (int) (Math.random() * (1 * 5)) + 15;
				int h = (int) (Math.random() * (100 * 1)) + 1;
				if(type == 1) {
					enemies.add(new Knight(1, h, lightAttack, heavyAttack));
				} else if(type == 2) {
					enemies.add(new Dragon(1, h, lightAttack, heavyAttack));
				} else if(type == 3) {
					enemies.add(new Wizard(1, h, lightAttack, heavyAttack));
				}
			}
		}

		if(!lvl2 || lvl2Count < 5) {
			for(int i = 0; i < 10; i++) {
				int type = (int) (Math.random() * 3) + 1;
				int lightAttack = (int) (Math.random() * (2 * 3)) + 20;
				int heavyAttack = (int) (Math.random() * (2 * 5)) + 30;
				int h = (int) (Math.random() * (100 * 2)) + 1;
				if(type == 1) {
					enemies.add(new Knight(2, h, lightAttack, heavyAttack));
				} else if(type == 2) {
					enemies.add(new Dragon(2, h, lightAttack, heavyAttack));
				} else if(type == 3) {
					enemies.add(new Wizard(2, h, lightAttack, heavyAttack));
				}
			}
		}

		if(!lvl3 || lvl3Count < 6) {
			for(int i = 0; i < 10; ) {
				int type = (int) (Math.random() * 3) + 1;
				int lightAttack = (int) (Math.random() * (3 * 3)) + 20;
				int heavyAttack = (int) (Math.random() * (3 * 5)) + 45;
				int h = (int) (Math.random() * (100 * 3)) + 1;
				if(type == 1) {
					enemies.add(new Knight(3, h, lightAttack, heavyAttack));
				} else if(type == 2) {
					enemies.add(new Dragon(3, h, lightAttack, heavyAttack));
				} else if(type == 3) {
					enemies.add(new Wizard(3, h, lightAttack, heavyAttack));
				}
			}
		}
		return enemies;
	}
}
