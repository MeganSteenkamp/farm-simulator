package farm.simulator;

/**
 * Implements Steroids.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Steroid extends Item {
	private static int id = 4;
	private static String name = "Steroids";
	private static String description = "Let's bulk - fork out a little for some extra plump farmlife.";
	private static float price = 200.00f;
	private static int cropGrowthFactor = 0;
	private static int animalHealthFactor = 4;
	
	/**
	 * Instantiate a Barn.
	 */
	public Steroid() {
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
