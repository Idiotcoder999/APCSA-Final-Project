public class Wizard extends Character{
	private int healsLeft;

	public Wizard(int l, int h, int light, int heavy) {
		super(l, h, light, heavy);
		healsLeft = 3;
	}

	@Override
	public void lightAttack(Character c) {
		//to be implemented
	}

	@Override
	public void heavyAttack(Character c) {
		//to be implemented
	}

	@Override
	public void heal() {
		//to be implemented
	}

}
