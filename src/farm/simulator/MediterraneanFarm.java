package farm.simulator;

import java.text.DecimalFormat;

/**
 * This class instantiates a Mediterranean Farm.
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class MediterraneanFarm extends Farm {
	private static String type = "Mediterranean Farm";
	private static float balance = 8000.00f;
	private static int cropDelay = 0;
	private static int animalHappinessBonus = 2;

	/**
	 * Constructs a Mediterranean Farm.
	 * @param name Name of farm.
	 */
	public MediterraneanFarm() {
		super(type, balance, cropDelay, animalHappinessBonus);
	}
	
	/**
	 * Returns a default description of the farm type.
	 */
	public static String getTypeDescription() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Type: " + type + "\nStarting balance: $" + df.format(balance) + "\nCrop crowth delay: " + cropDelay + 
				" day(s)\nAnimal happiness bonus: " + animalHappinessBonus + " points";
	}
}
