import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Character> enemies = new ArrayList<Character>();
		enemies = setUp();
		System.out.print("\nWhat is your name?: ");
		Scanner scanKey = new Scanner(System.in);
		String name = scanKey.next();
		Player p = new Player(1, 100, 10, 15, 100, name);
		run(p, enemies);
	}
	
	public static ArrayList<Character> setUp() {
		return Game.populate(15);
	}
	
	public static ArrayList<Character> lvl1(ArrayList<Character> e){
		ArrayList<Character> lvl1 = new ArrayList<Character>();
		for(Character enemy : e) 
			if(enemy.getLevel() == 1)
				lvl1.add(enemy);
		return lvl1;
	}
	
	public static ArrayList<Character> lvl2(ArrayList<Character> e){
		ArrayList<Character> lvl2 = new ArrayList<Character>();
		for(Character enemy : e) 
			if(enemy.getLevel() == 2)
				lvl2.add(enemy);
		return lvl2;
	}
	
	public static ArrayList<Character> lvl3(ArrayList<Character> e){
		ArrayList<Character> lvl3 = new ArrayList<Character>();
		for(Character enemy : e) 
			if(enemy.getLevel() == 3)
				lvl3.add(enemy);
		return lvl3;
	}
	
	public static void run(Character p, ArrayList<Character> e) {
		Character enemy;
		Scanner scanKey = new Scanner(System.in);
		ArrayList<Character> lvl1 = lvl1(e);
		ArrayList<Character> lvl2 = lvl2(e);
		ArrayList<Character> lvl3 = lvl3(e);
		
		while(!p.isDead()) {
			int enemyHealth;
			if(p.getLevel() == 1) {
				int rand = (int) (Math.random() * (lvl1.size()));
				enemy = lvl1.get(rand);
				enemyHealth = enemy.getHealth();
				System.out.println("Your enemy is a " + enemy);
				while(!enemy.isDead() && !p.isDead()) {
					int dodgeChance = (int) (Math.random() * 99) + 1;
					int attChance = (int) (Math.random() * 3) + 1;
					System.out.print("1 for a light attack, 2 for a heavy attack: ");
					int att = scanKey.nextInt();
					if(att == 1) 
						p.lightAttack(enemy);
					if(att == 2) {
						p.heavyAttack(enemy);
					}
					System.out.println("Enemies health is now: " + enemy.getHealth());
				}
				if(enemy.isDead()) {
					p.increaseEXP(enemyHealth);
					p.levelUp();
				}
			}
			
			if(p.getLevel() == 2) {
				int rand = (int) (Math.random() * (lvl2.size() - 1));
				enemy = lvl2.get(rand);
				System.out.println("Your enemy is a " + enemy);
				while(!enemy.isDead()) {
					
				}
			}
			
			if(p.getLevel() == 3) {
				int rand = (int) (Math.random() * (lvl3.size() - 1));
				enemy = lvl3.get(rand);
				System.out.println("Your enemy is a " + enemy);
				while(!enemy.isDead()) {
					
				}
			}
		}
	}

}
