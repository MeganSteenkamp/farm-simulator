package farm.game;

import java.text.DecimalFormat;

/**
 * This class represents a type of Farm in the Mediterranean. This farm has a
 * generous starting bonus but the Mediterranean Farm does not improve crop
 * growth.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 * @version 1.0
 */
public class MediterraneanFarm extends Farm {
	private static String type = "Mediterranean Farm";
	private static float balance = 1600.00f;
	private static int cropDelay = 0;
	private static int animalHappinessBonus = 2;

	/**
	 * Constructs a Mediterranean Farm.
	 */
	public MediterraneanFarm() {
		super(type, balance, cropDelay, animalHappinessBonus);
	}

	/**
	 * Returns a default description of the Mediterranean farm type.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Starting balance: $" + df.format(balance) + "\nCrop growth delay: " + cropDelay
				+ " day(s)\nAnimal happiness bonus: " + animalHappinessBonus + " points";
	}
}
