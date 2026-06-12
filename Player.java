public class Player extends Character{
	private int money;
	private String name;

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
	}
	
	public String toString() {
		return "Name: " + name + " Player Level: " + super.getLevel() + " Attack Damages: " + super.getlAtt() + " " + super.gethAtt();
	}
}
