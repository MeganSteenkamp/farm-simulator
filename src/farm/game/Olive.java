package farm.game;

import java.text.DecimalFormat;

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
	 * @return Description of an Olive crop.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Name: " + name + "\nDescription: " + description + "\nPurchase price: $" + df.format(purchasePrice) +
				"\nSelling price: $" + df.format(sellingPrice) + "\nGrowth time: " + daysToGrow + " day(s)";
	}
}
