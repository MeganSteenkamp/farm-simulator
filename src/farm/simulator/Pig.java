package farm.simulator;

/**
 * This class instantiates a Pig.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Pig extends Animal {
	private static float price = 50.00f;
	private static String type = "Pig";
	private static int happiness = 5;
	private static int health = 5;
	
	/**
	 * Construct a pig.
	 */
	public Pig() {
		super(price, type, happiness, health);
	}
	
	/**
	 * Prints a description of the animal.
	 */
	public static void printDescription() {
		System.out.println("Type: " + type);
		System.out.println("Price: $" + price);
		System.out.println("Happiness: " + happiness);
		System.out.println("Health: " + health);
	}
}
