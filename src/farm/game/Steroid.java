package farm.game;

import java.text.DecimalFormat;

/**
 * Implements Steroids.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Steroid extends Item {
	private static int id = 4;
	private static String name = "Steroids";
	private static String description = "Let's bulk - fork out a little for some extra plump farmlife.";
	private static float price = 200.00f;
	private static int cropGrowthFactor = 0;
	private static int animalHealthFactor = 4;
	
	/**
	 * Instantiate a Barn.
	 */
	public Steroid() {
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
