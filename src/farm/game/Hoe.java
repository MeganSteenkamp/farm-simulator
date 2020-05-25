package farm.game;

import java.text.DecimalFormat;

/**
 * Implements a Hoe item.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Hoe extends Item {
	private static int id = 3;
	private static String name = "Hoe";
	private static String description = "Dramatically decrease the growth on those slow crops.";
	private static float price = 300.00f;
	private static int cropGrowthFactor = -3;
	private static int animalHealthFactor = 0;
	
	/**
	 * Instantiate a Hoe.
	 */
	public Hoe() {
		super(id, name, description, price, cropGrowthFactor, animalHealthFactor);
	}
	
	/**
	 * Returns a default description of the item type.
	 * @return description of Hoe
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Name: " + name + "\nPrice: $" + df.format(price) + "\nDescription: " + description + 
				"\nCrop growth bonus: " + cropGrowthFactor + " day(s)";
	}
}
