package farm.simulator;

/**
 * This class instantiates a Chicken.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Chicken extends Animal {
	private static float price = 20.00f;
	private static String type = "Chicken";
	private static int happiness = 3;
	private static int health = 3;

	/**
	 * Construct a pig.
	 */
	public Chicken() {
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
