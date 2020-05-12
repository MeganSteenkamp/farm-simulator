package farm.simulator;

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
	 * Prints a description of the farm.
	 */
	public static String getDescription() {
		return "Type: " + type + "\nStarting balance: $" + balance + "\nCrop crowth delay: " + cropDelay + 
				" day(s)\nAnimal happiness bonus: " + animalHappinessBonus + " points";
	}

}
