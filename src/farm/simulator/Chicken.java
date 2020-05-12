package farm.simulator;

import java.text.DecimalFormat;

/**
 * This class instantiates a Chicken.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Chicken extends Animal {
	private static int id = 13;
	private static float price = 20.00f;
	private static String type = "Chicken";
	private static String description = "A domesticated bird raised for its meat and eggs.";
	private static int happiness = 3;
	private static int health = 3;

	/**
	 * Construct a chicken.
	 */
	public Chicken() {
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
