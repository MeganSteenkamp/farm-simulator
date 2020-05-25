package farm.game;

import java.text.DecimalFormat;

/**
 * This class represents a type of farm in North Korea. There is a low cash
 * bonus to start with. However, the crop growth will be hurried and the animals
 * are very happy which will lead to higher revenue growth.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 * @version 1.0
 */
public class NorthKoreanFarm extends Farm {
	private static String type = "North Korean Farm";
	private static float balance = 300.00f;
	private static int cropDelay = -1;
	private static int animalHappinessBonus = 5;

	/**
	 * Constructs a North Korean Farm.
	 */
	public NorthKoreanFarm() {
		super(type, balance, cropDelay, animalHappinessBonus);
	}

	/**
	 * Returns a default description of the North Korean farm type.
	 * @return Description of a North Korean farm.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Starting balance: $" + df.format(balance) + "\nCrop growth delay: " + cropDelay
				+ " day(s)\nAnimal happiness bonus: " + animalHappinessBonus + " points";
	}
}
