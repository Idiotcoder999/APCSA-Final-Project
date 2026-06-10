public class Wizard extends Character{
	private int healsLeft;

	public Wizard(int l, int h, int light, int heavy) {
		super(l, h, light, heavy);
		healsLeft = 3;
	}

	@Override
	public void lightAttack(Character c) {
		c.takeDamage(super.getlAtt());
		System.out.println("Dragon dealt " + super.getlAtt() + " damage from a light attack");
	}

	@Override
	public void heavyAttack(Character c) {
		c.takeDamage(super.gethAtt());
	}

	@Override
	public void heal() {
		if(super.getHealth() <= (super.getHealth()/2)) {
			int rand = (int) (Math.random() * 4) + 1;
			if(rand == 1) {
				super.incHealth(super.getHealth()/3);
			}
		}
	}
	
	public String toString() {
		return "Wizard Level: " + super.getLevel() + " Attack Damages: " + super.getlAtt() + " " + super.gethAtt() + " Health: " + super.getHealth();
	}

}
