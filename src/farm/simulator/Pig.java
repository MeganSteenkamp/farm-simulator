package farm.simulator;

/**
 * This class instantiates a Pig.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Pig extends Animal {
	private static int id = 14;
	private static float price = 50.00f;
	private static String type = "Pig";
	private static String description = "A highly intelligent, social animal found all over the world.";
	private static int happiness = 5;
	private static int health = 5;
	
	/**
	 * Construct a pig.
	 */
	public Pig() {
		super(id, price, type, description, happiness, health);
	}
	
	/**
	 * Prints a description of the animal.
	 */
	public static void printDescription() {
		System.out.println("Type: " + type);
		System.out.println("Price: $" + price);
		System.out.println("Description: " + description);
		System.out.println("Happiness: " + happiness);
		System.out.println("Health: " + health);
	}
}
