package farm.simulator;

/**
 * This class instantiates a Chicken.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Chicken extends Animal {
	private static int id = 13;
	private static float price = 20.00f;
	private static String type = "Chicken";
	private static String description = "A domesticated bird raised for its meat and eggs.";
	private static int happiness = 3;
	private static int health = 3;

	/**
	 * Construct a pig.
	 */
	public Chicken() {
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
