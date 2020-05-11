package farm.simulator;

/**
 * Implements a crop of type Coffee.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */

public class Coffee extends Crop {
	private static int id = 10;
	private static String name = "Coffee";
	private static String description = "This small evergreen plant will make a moderate profit for a moderate growth time.";
	private static float purchasePrice = 80.00f;
	private static float sellingPrice = 320.00f;
	private static int daysToGrow = 4;
	
	/**
	 * Instantiate an Coffee Crop.
	 */
	public Coffee() {
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
