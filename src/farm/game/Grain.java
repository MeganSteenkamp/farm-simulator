package farm.game;

import java.text.DecimalFormat;

/**
 * Implements a crop of type Grain.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Grain extends Item {
	private static int id = 5;
	private static String name = "Grain";
	private static String description = "This cheap feed will keep your animal's health up.";
	private static float price = 30.00f;
	private static int cropGrowthFactor = 0;
	private static int animalHealthFactor = 1;
	
	/**
	 * Instantiate a Grain object.
	 */
	public Grain() {
		super(id, name, description, price, cropGrowthFactor, animalHealthFactor);
	}
	
	/**
	 * Returns a default description of the item type.
	 * @return Description of grain.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Name: " + name + "\nPrice: $" + df.format(price) + "\nDescription: " + description + 
				"\nAnimal health bonus: " + animalHealthFactor + " point(s)";
	}
}
