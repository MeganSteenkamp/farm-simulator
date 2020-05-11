package farm.simulator;

/**
 * Implements a Hoe item.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Hoe extends Item {
	private static int id = 3;
	private static String name = "Hoe";
	private static String description = "Dramatically decrease the growth on those slow crops.";
	private static float price = 300.00f;
	private static int cropGrowthFactor = -3;
	private static int animalHealthFactor = 0;
	
	/**
	 * Instantiate a Hoe.
	 */
	public Hoe() {
		super(id, name, description, price, cropGrowthFactor, animalHealthFactor);
	}
	
	/**
	 * Prints a description of the crop without being instantiated.
	 */
	public static void printDescription() {
		System.out.println("[" + id + "]");
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Price: " + price);
		System.out.println("Crop growth bonus: " + cropGrowthFactor);
	}
}
