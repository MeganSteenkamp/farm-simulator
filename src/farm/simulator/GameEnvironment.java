package farm.simulator;

import java.util.Scanner;
import java.util.regex.*;

/**
 * This abstract class implements the game environment.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */

public class GameEnvironment {
	Scanner in = new Scanner(System.in);
	private int numDays;
	private Farm farm;
	private GeneralStore generalStore = new GeneralStore();

	/**
	 * Initialize Game Environment
	 */
	public GameEnvironment() {
	}

	/**
	 * Gets an input string to name a given item. Iterates until a valid string is
	 * provided.
	 * 
	 * @param item The string of the item the user is naming.
	 * @return A valid string.
	 */
	private String getInputString(String item) {
		String str = null;

		// Regex to check for no numbers of special characters
		String pattern = "^[a-zA-Z\\s]+$";
		Pattern r = Pattern.compile(pattern);

		// Get a name
		boolean isValid = false;
		System.out.println("Please give your " + item + " a name.");
		while (!isValid && in.hasNext()) {
			str = in.nextLine();
			Matcher m = r.matcher(str);
			if (m.matches()) {
				if (str.length() >= 3 && str.length() <= 15) {
					isValid = true;
				} else {
					System.out.println("Please keep the name between 3 and 15 letters inclusive.");
					System.out.println("Please give your " + item + " a name.");
				}
			} else {
				System.out.println("Numbers or special characters are not valid.");
				System.out.println("Please give your " + item + " a name.");
			}
		}
		return str;
	}

	/**
	 * Gets an input integer to name a given item. Iterates until a valid string is
	 * provided.
	 * 
	 * @param item The string of the item the user is naming.
	 * @return The valid integer.
	 */
	private int getInputInt(String item) {
		System.out.println("Please enter " + item + " as a whole number.");
		while (in.hasNext()) {
			try {
				return Integer.valueOf(in.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter a valid number.");
			}
		}
		return 0;
	}

	/**
	 * Instantiates a new farmer once a valid name and age have been given
	 * 
	 * @return The farmer object.
	 */
	private Farmer createFarmer() {
		Farmer farmer = null;

		String name = getInputString("farmer");
		int age = getInputInt("the farmer's age");

		// Initialize Farmer
		farmer = new Farmer(name, age);
		return farmer;
	}

	/**
	 * Prints the farm types and the numbers associated with picking them.
	 */
	private static void printFarmTypes() {
		System.out.println("[1]");
		NorthKoreanFarm.printDescription();
		System.out.println();
		System.out.println("[2]");
		AfricanFarm.printDescription();
		System.out.println();
		System.out.println("[3]");
		MediterraneanFarm.printDescription();
		System.out.println();
		System.out.println("[4]");
		NewZealandFarm.printDescription();
	}

	/**
	 * Instantiates a new farm of the chosen type.
	 */
	private void setFarm() {
		System.out.println("Please enter the number corresponding to your choice of farm.");
		printFarmTypes();

		boolean isValid = false;
		while (!isValid) {
			int farm = getInputInt("your choice of farm");
			switch (farm) {
			case 1:
				this.farm = new NorthKoreanFarm();
				isValid = true;
				break;
			case 2:
				this.farm = new AfricanFarm();
				isValid = true;
				break;
			case 3:
				this.farm = new MediterraneanFarm();
				isValid = true;
				break;
			case 4:
				this.farm = new NewZealandFarm();
				isValid = true;
				break;
			default:
				System.out.println("Please enter a valid number between 1 and 4.");
			}
		}
	}

	/**
	 * Sets the number of days for the game to last
	 */
	private void setNumDays() {
		boolean isValid = false;
		while (!isValid) {
			int days = getInputInt("the number of days [5-10] you would like the game to continue");
			switch (days) {
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				this.numDays = days;
				isValid = true;
				break;
			default:
				System.out.println("Please enter a valid number between 5 and 10.");
			}
		}
	}

	/**
	 * Initialize the game
	 */
	public void initializeGame() {
		System.out.println("Welcome to 'Mowing before Hoeing'.");
		System.out.println("In this game you will start a new life on your country farm.");
		System.out.println();

		setNumDays();
		Farmer farmer = createFarmer();
		setFarm();
		this.farm.setFarmer(farmer);
		this.farm.getFarmer().setFarm(this.farm);
		String farmName = getInputString("farm");
		this.farm.setName(farmName);

		System.out.println("===========================================================================");
		System.out.println("Welcome to your new farm " + this.farm.getFarmer().getName() + ".");
		System.out.println("It is a beautiful day on '" + this.farm.getName() + "'.");
		System.out.println();
		System.out.println("Here are the details of your new farm:");
		System.out.println(this.farm.toString());
		System.out.println("===========================================================================");
	}

	/**
	 * Prints the default options and associated numbers for actions players can do.
	 */
	public void printDefaultOptions() {
		System.out.println("Please enter the number corresponding to what you would like to do.");
		System.out.println("[1] - View status of the farm's crops and animals");
		System.out.println("[2] - View status of the farm");
		System.out.println("[3] - Visit general store");
		System.out.println("[4] - Perform an action on the farm");
		System.out.println("[5] - Move on to the next day");
	}

	public void printGeneralStoreOptions() {
		System.out.println("Please enter the number corresponding to what you would like to do.");
		System.out.println("[1] - View or buy farming supplies (items)");
		System.out.println("[2] - View or buy crops");
		System.out.println("[3] - View or buy animals");
		System.out.println("[4] - View currently owned items and balance");
		System.out.println("[5] - Exit the store");
	}

	private void displayCurrentlyOwnedItems() {
		System.out.println("Current balance: $" + this.farm.getBalance());
		if (this.farm.getFarmer().getItems().size() == 0) {
			System.out.println("You currently do not own any items.");
		}
		this.farm.getFarmer().printItemStock();
	}

	public Item processItemSale(int itemReference) {
		Item item = null;
		System.out.println("Would you like to buy this item?");
		System.out.println("[1] - yes");
		System.out.println("[2] - no");

		boolean transactionGoing = true;
		while (transactionGoing) {
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				// TODO: Fix withdrawls
				this.farm.withdrawMoney(generalStore.getItem(itemReference).getPrice());
				item = generalStore.sellItem(itemReference);
				transactionGoing = false;
				break;
			case 2:
				transactionGoing = false;
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}

		}
		return item;

	}

	public Item browseItems() {
		Item item = null;
		boolean browsingItems = true;
		while (browsingItems) {
			generalStore.printItemStock();
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				boolean inStock = generalStore.processItemDetails(choice);
				if (inStock) {
					item = processItemSale(choice);
					browsingItems = false;
				}
				break;
			case 7: 
				browsingItems = false;
			default:
				System.out.println("Please enter a valid choice.");
			}

		}
		return item;
	}

	public void visitGeneralStore() {
		boolean inStore = true;
		while (inStore) {
			printGeneralStoreOptions();
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				Item item = browseItems();
				if (item != null) {
					this.farm.getFarmer().addItem(item);
				}
				break;
			case 2:
				generalStore.printCropStock();
				break;
			case 3:
				generalStore.printAnimalStock();
				break;
			case 4:
				displayCurrentlyOwnedItems();
				break;
			case 5:
				inStore = false;
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}

		}

	}

	/**
	 * Runs the entirety of a day on the farm.
	 * 
	 * @param dayNum The number of the day in the game.
	 */
	public void runDay(int dayNum) {
		int numActions = 2;
		float dailyBonus = 0;
		boolean isDayEnd = false;

		// Update crop growth by 1 day
		for (Crop c : this.farm.getCrops()) {
			c.updateCropGrowth(1);
		}
		
		// Harvest any ready crops and add money to farm's balance
		float harvestBonus = farm.getFarmer().harvestCrops();
		this.farm.addToBalance(harvestBonus);

		// Show available actions
		while (!isDayEnd) {
			printDefaultOptions();
			boolean isValid = false;
			while (!isValid) {
				int choice = getInputInt("your choice of activity");
				switch (choice) {
				case 1:
					this.farm.printCropAndAnimalStatus();
					isValid = true;
					break;
				case 2:
					System.out.println(this.farm.toString());
					isValid = true;
					break;
				case 3:
					visitGeneralStore();
					isValid = true;
					break;
				case 4:
					System.out.println("Number of actions remaining for the day: " + numActions);
					// TODO: Implement performing an action
					isValid = true;
					break;
				case 5:
					isDayEnd = true;
					isValid = true;
					break;
				default:
					System.out.println("Please enter a valid choice.");
				}
			}
		}

		// TODO: Give daily bonus
	}

	public void run() {
		initializeGame();
		for (int i = 1; i <= numDays; i++) {
			System.out.println("Welcome to day " + i + " on the farm.");
			runDay(i);
		}
	}
}
