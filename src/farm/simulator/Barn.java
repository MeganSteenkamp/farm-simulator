package farm.simulator;

public class Barn extends Item {
	private static int id = 6;
	private static String name = "Barn";
	private static String description = "This shelter is expensive but your animals will be very happy.";
	private static float price = 400.00f;
	private static int cropGrowthFactor = 0;
	private static int animalHealthFactor = 5;
	
	/**
	 * Instantiate a Barn.
	 */
	public Barn() {
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
