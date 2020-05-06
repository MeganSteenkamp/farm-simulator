package farm.simulator;

/**
 * The abstract class implementing an Avocado crop.
 *
 * @author Lewis Marshall
 * @author Megan Steenkamp
 */
public class Avocado extends Crop {
	private static int id = 12;
	private static String name = "Avocado";
	private static String description = "The Avocado tree is a slow going tree that can make a real profit.";
	private static float purchasePrice = 200.00f;
	private static float sellingPrice = 1400.00f;
	private static int daysToGrow = 6;
	
	/**
	 * Instantiate an Avocado Crop.
	 */
	public Avocado() {
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
