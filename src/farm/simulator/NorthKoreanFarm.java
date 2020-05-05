package farm.simulator;

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
	 * Prints a description of the farm with a number for selection.
	 */
	public static void printDescription() {
		System.out.println("Type: " + type);
		System.out.println("Starting balance: $" + balance);
		System.out.println("Crop crowth delay: " + cropDelay + " day(s)");
		System.out.println("Animal happiness bonus: " + animalHappinessBonus + " points");
	}
}
