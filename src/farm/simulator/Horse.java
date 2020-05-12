package farm.simulator;

import java.text.DecimalFormat;

/**
 * This class implements a Horse.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Horse extends Animal {
	private static int id = 15;
	private static float price = 100.00f;
	private static String type = "Horse";
	private static String description = "This elegant mammal will bring happiness and health to the farm.";
	private static int happiness = 7;
	private static int health = 7;

	/**
	 * Construct a horse.
	 */
	public Horse() {
		super(id, price, type, description, happiness, health);
	}

	/**
	 * Returns a default description of the animal type.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Type: " + type + "\nPrice: $" + df.format(price) + "\nDescription: " + description + "\nHappiness: " + happiness +
				"\nHealth: " + health;
	}
}
