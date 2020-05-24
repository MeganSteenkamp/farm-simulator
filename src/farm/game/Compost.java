package farm.game;

import java.text.DecimalFormat;

/**
 * Implements Compost.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Compost extends Item {
	private static int id = 2;
	private static String name = "Compost";
	private static String description = "Take one day off the growth of a type of crop.";
	private static float price = 20.00f;
	private static int cropGrowthFactor = -1;
	private static int animalHealthFactor = 0;
	
	/**
	 * Instantiate Compost.
	 */
	public Compost() {
		super(id, name, description, price, cropGrowthFactor, animalHealthFactor);
	}
	
	/**
	 * Returns a default description of the item type.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Name: " + name + "\nPrice: $" + df.format(price) + "\nDescription: " + description + 
				"\nCrop growth bonus: " + cropGrowthFactor + " day(s)";
	}
}
