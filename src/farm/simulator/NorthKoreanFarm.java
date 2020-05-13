package farm.simulator;

import java.text.DecimalFormat;

/**
 * This class instantiates a North Korean Farm.
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class NorthKoreanFarm extends Farm {
	private static String type = "North Korean Farm";
	private static float balance = 2000.00f;
	private static int cropDelay = -2;
	private static int animalHappinessBonus = 2;

	/**
	 * Constructs a North Korean Farm.
	 * @param name Name of farm.
	 */
	public NorthKoreanFarm() {
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
