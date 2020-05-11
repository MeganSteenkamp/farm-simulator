package farm.simulator;

/**
 * Implements Fertilizer.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Fertilizer extends Item {
	private static int id = 1;
	private static String name = "Fertilizer";
	private static String description = "Increase the crop fertility for a quick harvest.";
	private static float price = 800.00f;
	private static int cropGrowthFactor = -2;
	private static int animalHealthFactor = 0;
	
	/**
	 * Instantiate Fertilizer.
	 */
	public Fertilizer() {
		super(id, name, description, price, cropGrowthFactor, animalHealthFactor);
	}
	
	/**
	 * Prints a description of the crop without being instantiated.
	 */
	public static void printDescription() {
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Price: " + price);
		System.out.println("Crop growth bonus: " + cropGrowthFactor);
	}
}
