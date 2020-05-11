package farm.simulator;

/**
 * Instantiates a crop of type Olive.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Olive extends Crop {
	private static int id = 11;
	private static String name = "Olive";
	private static String description = "This small, wild tree could prove profitable if you're willing to wait.";
	private static float purchasePrice = 160.00f;
	private static float sellingPrice = 1120.00f;
	private static int daysToGrow = 6;
	
	/**
	 * Instantiate an Olive Crop.
	 */
	public Olive() {
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
