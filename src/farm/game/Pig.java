package farm.game;

import java.text.DecimalFormat;

/**
 * This class instantiates a Pig.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 * @version 1.0
 */
public class Pig extends Animal {
	private static int id = 14;
	private static float price = 50.00f;
	private static String type = "Pig";
	private static String description = "A highly intelligent, social animal found all over the world.";
	private static int happiness = 5;
	private static int health = 5;
	
	/**
	 * Construct a pig.
	 */
	public Pig() {
		super(id, price, type, description, happiness, health);
	}
	
	/**
	 * Returns a default description of a Pig.
	 * @return Description of a pig.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Type: " + type + "\nPrice: $" + df.format(price) + "\nDescription: " + description + "\nHappiness: " + happiness +
				"\nHealth: " + health;
	}
}
