public class Player extends Character{
	private int money;
	private String name;
	private int heavy = 2;

	public Player(int l, int h, int light, int heavy, int mon, String n) {
		super(l, h, light, heavy);
		startingHealth = h;
		money = mon;
		name = n;
	}

	@Override
	public void heal() {
		if(super.getHealth() >= startingHealth/2) {
			if(money >= 50) {
				super.setHealth(startingHealth); 
				money-=50;
				System.out.println("You have " + money + " money remaining. Your health is now " + super.getHealth());
			} else if(money >= 25) {
				super.setHealth(startingHealth); 
				money-=25;
				System.out.println("You have " + money + " money remaining. Your health is now " + super.getHealth());
			}
		} else {
			if(money >= 50) {
				super.incHealth(startingHealth/2); 
				money-=50;
				System.out.println("You have " + money + " money remaining. Your health is now " + super.getHealth());
			} else if(money >= 25) {
				super.incHealth(startingHealth/3); 
				money-=25;
				System.out.println("You have " + money + " money remaining. Your health is now " + super.getHealth());
			}
		}
	}

	public void lightAttack(Character c) {
		c.takeDamage(super.getlAtt());
		System.out.println("Player dealt " + super.getlAtt() + " damage from a light attack");
	}

	@Override
	public void heavyAttack(Character c) {
		c.takeDamage(super.gethAtt());
		System.out.println("Player dealt " + super.gethAtt() + " damage from a heavy attack");
	}
	
	public void incMoney(int m) {
		money+=m;
		System.out.println("Your money is now " + money);
	}
	
	public void reset() {
		heavy = 2;
	}
	
	public int heavysLeft() {
		return heavy;
	}
	
	public void decHeavys() {
		heavy--;
	}
	
	public String toString() {
		return "Name: " + name + " Player Level: " + super.getLevel() + " Attack Damages: " + super.getlAtt() + " " + super.gethAtt();
	}
}
