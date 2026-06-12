public abstract class Character {
	private int level;
	private int health;
	private int exp;
	private int lAtt;
	private int hAtt;
	protected int startingHealth;
	
	
	public Character(int l, int h, int light, int heavy) {
		level = l;
		health = h;
		exp = 0;
		lAtt = light;
		hAtt = heavy;
		startingHealth = h;
	}

	public abstract void heal();
	
	public void levelUp() {
		if(level == 1 && exp >= 100) {
			exp-=100;
			level++;
			lAtt = 20;
			hAtt = 30;
		}
		if(level == 2 && exp >= 200) {
			exp-=200;
			level++;
			lAtt = 26;
			hAtt = 38;
		}
	}
	
	public boolean isDead() {
		return health <= 0;
	}
	
	public void takeDamage(int damage) {
		health-=damage;
	}
	
	public void incHealth(int inc) {
		health+=inc;
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
	
	public void setHealth(int newHealth) {
		health = newHealth;
	}
	
	public abstract void lightAttack(Character c);		//to be implemented
	
	public abstract void heavyAttack(Character c);		//to be implemented

	public int getExp() {
		return exp;
	}

	public void increaseEXP(int xp) {
		exp += xp;
		System.out.println("Your exp is now: " + exp);
	}

	public int getlAtt() {
		return lAtt;
	}

	public int gethAtt() {
		return hAtt;
	}
}
