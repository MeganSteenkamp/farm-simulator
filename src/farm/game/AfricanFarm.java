package farm.game;

import java.text.DecimalFormat;

/**
 * This class represents a type of Farm in Africa.
 * This farm has quick crop growth with an average cash bonus
 * and animal happiness.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 * @version 1.0
 */
public class AfricanFarm extends Farm {
	private static String type = "African Farm";
	private static float balance = 800.00f;
	private static int cropDelay = -1;
	private static int animalHappinessBonus = 3;

	/**
	 * Constructs an African Farm.
	 */
	public AfricanFarm() {
		super(type, balance, cropDelay, animalHappinessBonus);
	}
	
	/**
	 * Returns a default description of an African farm.
	 * @return African farm description.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Starting balance: $" + df.format(balance) + "\nCrop growth delay: " + cropDelay + 
				" day(s)\nAnimal happiness bonus: " + animalHappinessBonus + " points";
	}
}
