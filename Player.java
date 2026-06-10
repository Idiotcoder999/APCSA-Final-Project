
public class Player extends Character{
	private int money;
	
	public Player(int l, int h, int light, int heavy, int mon) {
		super(l, h, light, heavy);
		money = mon;
	}
	
	@Override
	public void heal() {
		//to be implemented
	}

	@Override
	public void lightAttack(Character c) {
		//to be implemented
	}

	@Override
	public void heavyAttack(Character c) {
		//to be implemented
	}
}
