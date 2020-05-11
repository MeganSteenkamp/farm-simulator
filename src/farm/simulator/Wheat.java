package farm.simulator;

/**
 * Instantiates a crop of type Wheat.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Wheat extends Crop {
	private static int id = 8;
	private static String name = "Wheat";
	private static String description = "This grass grows like wildfire for a small profit.";
	private static float purchasePrice = 30.00f;
	private static float sellingPrice = 60.00f;
	private static int daysToGrow = 2;

	/**
	 * Instantiate an Wheat Crop.
	 */
	public Wheat() {
		super(id, name, description, purchasePrice, sellingPrice, daysToGrow);
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
