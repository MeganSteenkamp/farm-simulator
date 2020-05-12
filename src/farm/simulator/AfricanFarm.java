package farm.simulator;

/**
 * This class instantiates an African Farm.
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class AfricanFarm extends Farm {
	private static String type = "African Farm";
	private static float balance = 4000.00f;
	private static int cropDelay = -1;
	private static int animalHappinessBonus = 3;

	/**
	 * Constructs an African Farm.
	 * @param name Name of farm.
	 */
	public AfricanFarm() {
		super(type, balance, cropDelay, animalHappinessBonus);
	}
	
	/**
	 * Prints a description of the farm
	 */
	public static String getDescription() {
		return "Type: " + type + "\nStarting balance: $" + balance + "\nCrop crowth delay: " + cropDelay + 
				" day(s)\nAnimal happiness bonus: " + animalHappinessBonus + " points";
	}
}
