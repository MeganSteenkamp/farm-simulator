package farm.simulator;

import java.text.DecimalFormat;

/**
 * Implements Fertilizer.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Fertilizer extends Item {
	private static int id = 1;
	private static String name = "Fertilizer";
	private static String description = "Increase the crop fertility for a quick harvest.";
	private static float price = 800.00f;
	private static int cropGrowthFactor = -2;
	private static int animalHealthFactor = 0;
	
	/**
	 * Instantiate Fertilizer.
	 */
	public Fertilizer() {
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
