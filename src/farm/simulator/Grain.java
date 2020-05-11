package farm.simulator;

/**
 * Implements a crop of type Grain.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Grain extends Item {
	private static int id = 5;
	private static String name = "Grain";
	private static String description = "This cheap feed will keep your animal's health up.";
	private static float price = 30.00f;
	private static int cropGrowthFactor = 0;
	private static int animalHealthFactor = 1;
	
	/**
	 * Instantiate a Grain object.
	 */
	public Grain() {
		super(id, name, description, price, cropGrowthFactor, animalHealthFactor);
	}
	
	/**
	 * Prints a description of the crop without being instantiated.
	 */
	public static void printDescription() {
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Price: " + price);
		System.out.println("Animal health bonus: " + animalHealthFactor);
	}
}
