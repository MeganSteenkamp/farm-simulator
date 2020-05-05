package farm.simulator;

public class Rice extends Crop {
	private static String name = "Rice";
	private static String description = "This grain may make a small profit but it grows quickly.";
	private static float purchasePrice = 20.00f;
	private static float sellingPrice = 40.00f;
	private static int daysToGrow = 2;
	
	/**
	 * Instantiate an Rice Crop.
	 */
	public Rice() {
		super(name, description, purchasePrice, sellingPrice, daysToGrow);
	}
	
	/**
	 * Prints a description of the crop without being instantiated.
	 */
	public static void printDescription() {
		System.out.println("Name: " + name);
		System.out.println("Description: " + description);
		System.out.println("Purchase price: " + purchasePrice);
		System.out.println("Selling price: " + sellingPrice);
		System.out.println("Growth: " + daysToGrow + " day(s)");
	}
}
