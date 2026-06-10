import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		ArrayList<Character> enemies = new ArrayList<Character>();
		enemies = setUp();
		System.out.println(enemies);
	}
	
	public static ArrayList<Character> setUp() {
		Scanner scanKey = new Scanner(System.in);
		System.out.print("How many enemies would you like?: ");
		int n = scanKey.nextInt();
		System.out.print("\nWhat is your name?: ");
		String name = scanKey.next();
		Game.populate(n);
		Player p1 = new Player(1, 100, 2, 4, 100, name);
		System.out.println(p1);
		System.out.println();
		return Game.populate(n);
	}

}
