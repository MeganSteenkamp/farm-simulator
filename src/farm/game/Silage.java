package farm.game;

import java.text.DecimalFormat;

/**
 * Implements a Silage item.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Silage extends Item {
	private static int id = 6;
	private static String name = "Silage";
	private static String description = "A medium priced food for a medium increase in happiness.";
	private static float price = 80.00f;
	private static int cropGrowthFactor = 0;
	private static int animalHealthFactor = 2;
	
	/**
	 * Instantiate Silage.
	 */
	public Silage() {
		super(id, name, description, price, cropGrowthFactor, animalHealthFactor);
	}
	
	/**
	 * Returns a default description of the item type.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Name: " + name + "\nPrice: $" + df.format(price) + "\nDescription: " + description + 
				"\nAnimal health bonus: " + animalHealthFactor + " point(s)";
	}
}
