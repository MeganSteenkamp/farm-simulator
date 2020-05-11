package farm.simulator;

/**
 * Implements a Silage item.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Silage extends Item {
	private static int id = 6;
	private static String name = "Silage";
	private static String description = "A medium priced food for a medium increase in happiness.";
	private static float price = 80.00f;
	private static int cropGrowthFactor = 0;
	private static int animalHealthFactor = 2;
	
	/**
	 * Instantiate Silage.
	 */
	public Silage() {
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
