import java.util.ArrayList;

public abstract class Character {
	private int level;
	private int health;
	private int exp;
	private int lAtt;
	private int hAtt;
	private ArrayList Enemies;
	
	
	public Character(int l, int h, int light, int heavy) {
		level = l;
		health = h;
		exp = 0;
		lAtt = light;
		hAtt = heavy;
	}
	
	public ArrayList populate(int num) {
		for(int i = 0; i < num; i++) {
			int type = (int) (Math.random() * 3) + 1;
			int lvl = (int) (Math.random() * 3) + 1;
			int lightAttack = (int) (Math.random() * (lvl * 3)) + lvl;
			int heavyAttack = (int) (Math.random() * (lvl * 5)) + lvl;
			int h = 
			if(type == 1) {
				Enemies.add(new Player(lvl, ))
			}
		}
	}

	public abstract void heal();
	
	public void levelUp() {
		//to be implemented
	}
	
	public void takeDamage(int damage) {
		//to be implemented
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int addition) {
		health += addition;
	}
	
	public abstract void lightAttack(Character c);		//to be implemented
	
	public abstract void heavyAttack(Character c);		//to be implemented

	public int getExp() {
		return exp;
	}

	public void increaseEXP(int xp) {
		this.exp += xp;
	}
}
