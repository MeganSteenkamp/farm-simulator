package farm.game;

import java.text.DecimalFormat;

/**
 * Instantiates a crop of type Rice.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Rice extends Crop {
	private static int id = 7;
	private static String name = "Rice";
	private static String description = "This grain may make a small profit but it grows quickly.";
	private static float purchasePrice = 20.00f;
	private static float sellingPrice = 40.00f;
	private static int daysToGrow = 2;
	
	/**
	 * Instantiate an Rice Crop.
	 */
	public Rice() {
		super(id, name, description, purchasePrice, sellingPrice, daysToGrow);
	}
	
	/**
	 * Prints a description of the crop without being instantiated.
	 * @return Description of a rice crop.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Name: " + name + "\nDescription: " + description + "\nPurchase price: $" + df.format(purchasePrice) +
				"\nSelling price: $" + df.format(sellingPrice) + "\nGrowth time: " + daysToGrow + " day(s)";
	}
}
