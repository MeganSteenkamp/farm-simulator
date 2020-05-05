package farm.simulator;

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
	 * Prints a description of the farm with a number for selection.
	 */
	public static void printDescription() {
		System.out.println("Type: " + type);
		System.out.println("Starting balance: $" + balance);
		System.out.println("Crop crowth delay: " + cropDelay + " day(s)");
		System.out.println("Animal happiness bonus: " + animalHappinessBonus + " points");
	}
}