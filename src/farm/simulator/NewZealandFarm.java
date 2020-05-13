package farm.simulator;

import java.text.DecimalFormat;

/**
 * This class instantiates a New Zealand Farm.
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class NewZealandFarm extends Farm {
	private static String type = "New Zealand Farm";
	private static float balance = 12000.00f;
	private static int cropDelay = 1;
	private static int animalHappinessBonus = 3;
	
	/**
	 * Constructs a New Zealand Farm.
	 * @param name Name of farm.
	 */
	public NewZealandFarm() {
		super(type, balance, cropDelay, animalHappinessBonus);
	}
	
	/**
	 * Returns a default description of the farm type.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Starting balance: $" + df.format(balance) + "\nCrop growth delay: " + cropDelay + 
				" day(s)\nAnimal happiness bonus: " + animalHappinessBonus + " points";
	}

}
