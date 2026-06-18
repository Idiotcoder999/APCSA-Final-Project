import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Character> enemies = new ArrayList<Character>();
		enemies = setUp();
		System.out.print("What is your name?: ");
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
			boolean stop = false;
			int enemyHealth;
			if(p.getLevel() == 1) {
				((Player) p).reset();
				int rand = (int) (Math.random() * (lvl1.size()));
				enemy = lvl1.get(rand);
				enemyHealth = enemy.getHealth();
				System.out.println("\nYour enemy is a " + enemy + "\n");
				while(!enemy.isDead() && !p.isDead()) {
					System.out.println("Your health is " + p.getHealth());
					System.out.println("The enemy's health is " + enemy.getHealth());
					System.out.println("You have " + ((Player) p).heavysLeft() + " heavy attacks left");
					System.out.println("Would you like to heal? Enter Yes or No");
					String heal = scanKey.next().toLowerCase();
					boolean HealTrue = heal.equals("yes");
					int dodgeChance = (int) (Math.random() * 5) + 1;
					int attChance = (int) (Math.random() * 3) + 1;
					if(!HealTrue) {
						System.out.print("\n1 for a light attack, 2 for a heavy attack: ");
						int att = scanKey.nextInt();
						if(att == 1) 
							p.lightAttack(enemy);
						else if(att == 2 && ((Player) p).heavysLeft() > 0) {
							p.heavyAttack(enemy);
							((Player) p).decHeavys();
						} else {
							p.lightAttack(enemy);
						}
					} else {
						p.heal();
					}
					System.out.println("\nEnemies health is now: " + enemy.getHealth());
					if(dodgeChance != 1 && enemy.getHealth() > 0) {
						if(attChance == 1)
							enemy.heavyAttack(p);
						else 
							enemy.lightAttack(p);
					} else
						System.out.println("\nYou dodged the enemy's attack");
				}
				if(enemy.isDead()) {
					System.out.println("\nThe enemy is dead!");
					p.increaseEXP(enemyHealth);
					p.levelUp();
					((Player) p).incMoney(enemyHealth);
					for(int i = lvl1.size() - 1; i >= 0; i--) {
						if(lvl1.get(i).getHealth() <= 0)
							lvl1.remove(i);
					}
				}
			}

			if(p.getLevel() == 2) {
				((Player) p).reset();
				int rand = (int) (Math.random() * (lvl2.size()));
				enemy = lvl2.get(rand);
				enemyHealth = enemy.getHealth();
				System.out.println("\nYour enemy is a " + enemy + "\n");
				while(!enemy.isDead() && !p.isDead()) {
					System.out.println("Your health is " + p.getHealth());
					System.out.println("The enemy's health is " + enemy.getHealth());
					System.out.println("You have " + ((Player) p).heavysLeft() + " heavy attacks left");
					System.out.println("Would you like to heal? Enter Yes or No");
					String heal = scanKey.next().toLowerCase();
					boolean HealTrue = heal.equals("yes");
					int dodgeChance = (int) (Math.random() * 6) + 1;
					int attChance = (int) (Math.random() * 3) + 1;
					if(!HealTrue) {
						System.out.print("\n1 for a light attack, 2 for a heavy attack: ");
						int att = scanKey.nextInt();
						if(att == 1) 
							p.lightAttack(enemy);
						else if(att == 2 && ((Player) p).heavysLeft() > 0) {
							p.heavyAttack(enemy);
							((Player) p).decHeavys();
						} else {
							p.lightAttack(enemy);
						}
					} else {
						p.heal();
					}
					if(dodgeChance != 1 && enemy.getHealth() > 0) {
						if(attChance == 1)
							enemy.heavyAttack(p);
						else 
							enemy.lightAttack(p);
					} else
						System.out.println("\nYou dodged the enemy's attack");
				}
				if(enemy.isDead()) {
					System.out.println("\nThe enemy is dead!");
					p.increaseEXP(enemyHealth);
					p.levelUp();
					((Player) p).incMoney(enemyHealth);
					for(int i = lvl2.size() - 1; i >= 0; i--) {
						if(lvl2.get(i).getHealth() <= 0)
							lvl2.remove(i);
					}
				}
			}

			if(p.getLevel() == 3 && !stop) {
				((Player) p).reset();
				if(lvl3.isEmpty()) {
					System.out.println("You Win!");
					stop = true;
				}
				int rand = (int) (Math.random() * (lvl3.size()));
				enemy = lvl3.get(rand);
				enemyHealth = enemy.getHealth();
				System.out.println("\nYour enemy is a " + enemy + "\n");
				while(!enemy.isDead() && !p.isDead() && !stop) {
					System.out.println("Your health is " + p.getHealth());
					System.out.println("The enemy's health is " + enemy.getHealth());
					System.out.println("You have " + ((Player) p).heavysLeft() + " heavy attacks left");
					System.out.println("Would you like to heal? Enter Yes or No");
					String heal = scanKey.next().toLowerCase();
					boolean HealTrue = heal.equals("yes");
					int dodgeChance = (int) (Math.random() * 7) + 1;
					int attChance = (int) (Math.random() * 3) + 1;
					if(!HealTrue) {
						System.out.print("\n1 for a light attack, 2 for a heavy attack: ");
						int att = scanKey.nextInt();
						if(att == 1) 
							p.lightAttack(enemy);
						else if(att == 2 && ((Player) p).heavysLeft() > 0) {
							p.heavyAttack(enemy);
							((Player) p).decHeavys();
						} else {
							p.lightAttack(enemy);
						}
					} else {
						p.heal();
					}
					System.out.println("\nEnemies health is now: " + enemy.getHealth());
					if(dodgeChance != 1 && enemy.getHealth() > 0) {
						if(attChance == 1)
							enemy.heavyAttack(p);
						else 
							enemy.lightAttack(p);
					} else
						System.out.println("\nYou dodged the enemy's attack");
				}
				if(enemy.isDead() && !stop) {
					System.out.println("\nThe enemy is dead!");
					p.increaseEXP(enemyHealth);
					p.levelUp();
					((Player) p).incMoney(enemyHealth);
					for(int i = lvl3.size() - 1; i >= 0; i--) {
						if(lvl3.get(i).getHealth() <= 0)
							lvl3.remove(i);
					}
				}
			}
		}
	}
}
