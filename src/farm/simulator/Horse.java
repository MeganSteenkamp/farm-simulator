package farm.simulator;

/**
 * This class implements a Horse.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Horse extends Animal {
	private static float price = 100.00f;
	private static String type = "Horse";
	private static int happiness = 7;
	private static int health = 7;

	/**
	 * Construct a horse.
	 */
	public Horse() {
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
