package farm.game;

import java.text.DecimalFormat;

/**
 * Implements a crop of type Cotton.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Cotton extends Crop {
	private static int id = 9;
	private static String name = "Cotton";
	private static String description = "The harvested soft, fluffy fiber will make a moderate profit for a moderate growth time.";
	private static float purchasePrice = 60.00f;
	private static float sellingPrice = 240.00f;
	private static int daysToGrow = 4;
	
	/**
	 * Instantiate an Cotton Crop.
	 */
	public Cotton() {
		super(id, name, description, purchasePrice, sellingPrice, daysToGrow);
	}
	
	/**
	 * Prints a description of the crop without being instantiated.
	 * @return Description of cotton.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Name: " + name + "\nDescription: " + description + "\nPurchase price: $" + df.format(purchasePrice) +
				"\nSelling price: $" + df.format(sellingPrice) + "\nGrowth time: " + daysToGrow + " day(s)";
	}
}
