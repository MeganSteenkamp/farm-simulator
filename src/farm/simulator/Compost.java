package farm.simulator;

public class Compost extends Item {
	private static String name = "Compost";
	private static String description = "Take one day off the growth of a type of crop.";
	private static float price = 20.00f;
	private static int cropGrowthFactor = 1;
	private static int animalHealthFactor = 0;
	
	/**
	 * Instantiate Compost.
	 */
	public Compost() {
		super(name, description, price, cropGrowthFactor, animalHealthFactor);
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
