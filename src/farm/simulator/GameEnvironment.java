package farm.simulator;

import java.util.ArrayList;
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
	private int numDayActions;
	private int numDays;
	private Farm farm;
	private GeneralStore generalStore = new GeneralStore();

	/**
	 * Initialize Game Environment
	 */
	public GameEnvironment() {
	}

//===================================================== INPUT PARSING =====================================================

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

//===================================================== GAME INITIALIZATION =====================================================

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

		System.out.println("Welcome to your new farm " + this.farm.getFarmer().getName() + ".");
		System.out.println("It is a beautiful day on '" + this.farm.getName() + "'.");
	}

//===================================================== MAIN MENU =====================================================

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

//===================================================== GENERAL STORE =====================================================

	public void printGeneralStoreOptions() {
		System.out.println("Please enter the number corresponding to what you would like to do.");
		System.out.println("[1] - View or buy items / farming supplies");
		System.out.println("[2] - View or buy crops");
		System.out.println("[3] - View or buy animals");
		System.out.println("[4] - View currently owned items and balance");
		System.out.println("[5] - Exit the store");
	}

	private void displayCurrentlyOwnedItems() {
		System.out.println("Current balance: $" + this.farm.getBalance());
		if (this.farm.getFarmer().getItems().size() == 0) {
			System.out.println("You currently do not own any items.");
		} else {
			this.farm.getFarmer().printItemStock();
		}
	}

	public FarmItem processSale(int itemReference) {
		FarmItem item = null;
		System.out.println("Would you would like to buy this item?");
		System.out.println("[1] - yes");
		System.out.println("[2] - no");

		boolean transactionGoing = true;
		while (transactionGoing) {
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				this.farm.withdrawMoney(generalStore.getItem(itemReference).getPurchasePrice());
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

	public FarmItem browseItems() {
		FarmItem item = null;
		boolean browsing = true;
		while (browsing) {
			generalStore.printItemStock();
			int choice = getInputInt("your choice of activity");
			System.out.println("Enter [0] to return to the main store menu.");
			switch (choice) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				generalStore.printItemDetails(choice);
				boolean inStock = generalStore.itemIsInStock(choice);
				if (inStock) {
					item = processSale(choice);
					browsing = false;
				}
				break;
			case 0:
				browsing = false;
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}

		}
		return item;
	}

	public FarmItem browseCrops() {
		FarmItem crop = null;
		boolean browsing = true;
		while (browsing) {
			generalStore.printCropStock();
			int choice = getInputInt("your choice of activity");
			System.out.println("Enter [0] to return to the main store menu.");
			switch (choice) {
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				generalStore.printItemDetails(choice);
				boolean inStock = generalStore.itemIsInStock(choice);
				if (inStock) {
					crop = processSale(choice);
					browsing = false;
				}
				break;
			case 0:
				browsing = false;
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}

		}
		return crop;
	}

	public FarmItem browseAnimals() {
		FarmItem animal = null;
		boolean browsing = true;
		while (browsing) {
			generalStore.printAnimalStock();
			int choice = getInputInt("your choice of activity");
			System.out.println("Enter [0] to return to the main store menu.");
			switch (choice) {
			case 13:
			case 14:
			case 15:
				generalStore.printItemDetails(choice);
				boolean inStock = generalStore.itemIsInStock(choice);
				if (inStock) {
					animal = processSale(choice);
					browsing = false;
				}
				break;
			case 0:
				browsing = false;
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}

		}
		return animal;
	}

	public void visitGeneralStore() {
		boolean inStore = true;
		while (inStore) {
			printGeneralStoreOptions();
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				FarmItem item = browseItems();
				if (item != null) {
					this.farm.getFarmer().addItem(item);
				}
				break;
			case 2:
				FarmItem crop = browseCrops();
				if (crop != null) {
					this.farm.addCrop(crop);
				}
				break;
			case 3:
				FarmItem animal = browseAnimals();
				if (animal != null) {
					this.farm.addAnimal(animal);
				}
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

//===================================================== FARMER ACTIONS =====================================================

	public void printActionOptions() {
		System.out.println("Please enter the number corresponding to the action you would like to learn more about.");
		System.out.println("[1] - Tend to crops");
		System.out.println("[2] - Feed animals");
		System.out.println("[3] - Play with animals");
		System.out.println("[4] - Harvest crops");
		System.out.println("[5] - Tend to the farm land");
	}

	public int selectCropVariety() {
		int cropType = 0;
		System.out.println("You own the following crops:");
		this.farm.printCrops();

		boolean choosing = true;
		while (choosing) {
			System.out.println("Enter [0] to return to the main menu.");
			int choice = getInputInt("the ID of the crop you would like to tend to");
			switch (choice) {
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
				if (this.farm.ownsCrop(choice)) {
					cropType = choice;
					choosing = false;
					break;
				} else {
					System.out.println("You do not own a crop with this ID.");
					break;
				}
			case 0:
				choosing = false;
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
		return cropType;
	}

	public void processTendingToCrop(int cropType) {
		int itemType = 0;
		ArrayList<FarmItem> items = this.farm.getFarmer().getItems();
		if (items.size() > 0) {
			System.out.println("The following items are available for use on the crop:");

			for (FarmItem item : items) {
				Item i = (Item) item;
				if (i.getCropGrowthFactor() != 0) {
					System.out.println(item.toString());
				}
			}
			System.out.println("Please enter the ID of the item you would like to use on the crop.");
			System.out.println("Enter [4] if you would like to use water.");
			boolean choosing = true;
			while (choosing) {
				System.out.println("Enter [0] to return to the main actions menu.");
				int choice = getInputInt("the ID of the item you would like to use");
				switch (choice) {
				case 1:
				case 2:
				case 3:
					if (this.farm.getFarmer().ownsItem(choice)) {
						itemType = choice;
						choosing = false;
						break;
					} else {
						System.out.println("You do not own an item with this ID.");
						break;
					}
				case 4:
					choosing = false;
					break;
				case 0:
					return;
				default:
					System.out.println("Please enter a valid choice.");
				}
			}
		} else {
			System.out.println(
					"You have no items available for use on the crop. Therefore, water will be used to tend to the crop.");
		}

		System.out.println("Are you sure you would like to perform this action?");
		System.out.println("[1] - yes");
		System.out.println("[2] - no");

		boolean performingAction = true;
		while (performingAction) {
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				// Tend to crop
				if (itemType != 0) {
					Item item = (Item) this.farm.getFarmer().removeItem(itemType);
					this.farm.getFarmer().tendToCrop(cropType, item);
					// Action has been successfully completed so remove number of actions remaining
				} else {
					this.farm.getFarmer().tendToCrop(cropType); // Use water
				}

				// Print updated crop details
				this.numDayActions -= 1;
				System.out.println(
						"Your selected crops have been successfully tended to. Here is the current status of your crops:");
				this.farm.printCrops();
				performingAction = false;
				break;
			case 2:
				return;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}

	public void processFeedingAnimals() {
		int itemType = 0;
		
		System.out.println("Here is the current status of your animals:");
		this.farm.printAnimals();

		ArrayList<FarmItem> items = this.farm.getFarmer().getItems();
		if (items.size() > 0) {
			System.out.println("The following items are available for use on the crop:");

			for (FarmItem item : items) {
				Item i = (Item) item;
				if (i.getAnimalHealthFactor() != 0) {
					System.out.println(item.toString());
				}
			}
			System.out.println("Please enter the ID of the item you would like to use to feed the animals.");
			boolean choosing = true;
			while (choosing) {
				System.out.println("Enter [0] to return to the main actions menu.");
				int choice = getInputInt("the ID of the item you would like to use");
				switch (choice) {
				case 4:
				case 5:
				case 6:
					if (this.farm.getFarmer().ownsItem(choice)) {
						itemType = choice;
						choosing = false;
						break;
					} else {
						System.out.println("You do not own an item with this ID.");
						break;
					}
				case 0:
					return;
				default:
					System.out.println("Please enter a valid choice.");
				}
			}
		} else {
			// TODO: Could raise a custom error here?
			System.out.println(
					"You have no items available to feed animals. Therefore, you are unable to perform this action.");
			return;
		}

		System.out.println("Are you sure you would like to perform this action?");
		System.out.println("[1] - yes");
		System.out.println("[2] - no");

		boolean performingAction = true;
		while (performingAction) {
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				// Feed the animals
				Item item = (Item) this.farm.getFarmer().getItem(itemType);
				this.farm.getFarmer().feedAnimals(item);

				// Print updated crop details
				this.numDayActions -= 1;
				System.out.println(
						"Your animals have been successfully fed. Here is their updated status:");
				this.farm.printAnimals();
				performingAction = false;
				break;
			case 2:
				return;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}
	
	public void processPlayingWithAnimals() {
		System.out.println("Here is the current status of your animals:");
		this.farm.printAnimals();

		System.out.println("Are you sure you would like to perform this action?");
		System.out.println("[1] - yes");
		System.out.println("[2] - no");

		boolean performingAction = true;
		while (performingAction) {
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				// Play with animals
				this.farm.getFarmer().playWithAnimals();

				// Print updated animal details
				this.numDayActions -= 1;
				System.out.println(
						"Your animals love spending time with you! Here is their updated status:");
				this.farm.printAnimals();
				performingAction = false;
				break;
			case 2:
				return;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}
	
	public void processHarvestingCrops() {
		System.out.println("Here is the current status of your crops:");
		this.farm.printCrops();
		System.out.println("Remember that crops with 0 days of growth remaining can be harvested.");
		
		System.out.println("Are you sure you would like to perform this action?");
		System.out.println("[1] - yes");
		System.out.println("[2] - no");

		boolean performingAction = true;
		while (performingAction) {
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				// Harvest crops
				float harvestBonus = farm.getFarmer().harvestCrops();
				if (harvestBonus > 0) {
					System.out.println("Good job! You have made $" + harvestBonus +" from harvesting your crop.");
				} else {
					System.out.println("Oh no - perhaps it isn't a good decision to harvest crops that aren't ready...");
				}
				this.farm.addToBalance(harvestBonus);

				// Print updated crop details
				this.numDayActions -= 1;
				System.out.println(
						"Here is your updated crop status:");
				this.farm.printCrops();
				performingAction = false;
				break;
			case 2:
				return;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}
	
	public void processTendingToFarmland() {
		System.out.println("Here is the current status of your farm and animals:");
		this.farm.toString();
		this.farm.printAnimals();
		
		System.out.println("Are you sure you would like to perform this action?");
		System.out.println("[1] - yes");
		System.out.println("[2] - no");

		boolean performingAction = true;
		while (performingAction) {
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				// Tend to farmland
				farm.getFarmer().tendToFarmland();

				// Print updated farm and animals details
				this.numDayActions -= 1;
				System.out.println(
						"That is one tidy farm! Here is your updated farm and animal status:");
				this.farm.toString();
				this.farm.printAnimals();
				performingAction = false;
				break;
			case 2:
				return;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}

	/**
	 * Implements performing action when choice to perform action has been confirmed.
	 * @param choice
	 */
	public void performAction(int choice) {
		switch (choice) {
		case 1:
			// Tending to crops
			if (this.farm.getCrops().size() == 0) {
				System.out.println("You do not own any crops. Therefore, you are unable to perform this activity.");
				return;
			}
			int cropType = selectCropVariety();
			processTendingToCrop(cropType);
			break;
		case 2:
			// Feeding animals
			if (this.farm.getAnimals().size() == 0) {
				System.out.println("You do not own any animals. Therefore, you are unable to perform this activity.");
				return;
			}
			processFeedingAnimals();
			break;
		case 3:
			// Play with animals
			if (this.farm.getAnimals().size() == 0) {
				System.out.println("You do not own any animals. Therefore, you are unable to perform this activity.");
				return;
			}
			processPlayingWithAnimals();
			break;
		case 4:
			// Harvest crops
			if (this.farm.getCrops().size() == 0) {
				System.out.println("You do not own any crops. Therefore, you are unable to perform this activity.");
				return;
			}
			processHarvestingCrops();
			break;
		case 5:
			// Tend to farm land 
			if (this.farm.getAnimals().size() == 0) {
				System.out.println("WARNING: You do not own any crops. Tending to farm land will only make an extra plot available");
			} 
			processTendingToFarmland();
			break;
		}
	}

	public void confirmAction(int action) {
		System.out.println("Would you would like continue with this action?");
		System.out.println("[1] - yes");
		System.out.println("[2] - no");

		boolean performingAction = true;
		while (performingAction) {
			int choice = getInputInt("your choice of activity");
			switch (choice) {
			case 1:
				performAction(action);
				System.out.println("Number of actions remaining for the day: " + this.numDayActions);
				performingAction = false;
				break;
			case 2:
				performingAction = false;
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}

	public void visitActionsMainScreen() {
		boolean viewingActions = true;
		while (viewingActions) {
			printActionOptions();
			System.out.println("Enter [0] to return to the main menu.");
			int choice = getInputInt("your choice of action");
			switch (choice) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				this.farm.getFarmer().printDescription(choice);
				confirmAction(choice);
				viewingActions = false;
				break;
			case 0:
				viewingActions = false;
				break;
			default:
				System.out.println("Please enter a valid choice.");
			}
		}
	}

//===================================================== DAY IMPLEMENTATION =====================================================

	/**
	 * Runs the entirety of a day on the farm.
	 * 
	 * @param dayNum The number of the day in the game.
	 */
	public void runDay(int dayNum) {
		this.numDayActions = 2;
		float dailyBonus = 0;
		boolean isDayEnd = false;

		// Update crop growth by 1 day
		for (FarmItem c : this.farm.getCrops()) {
			((Crop) c).updateCropGrowth(1);
		}

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
					System.out.println("Number of actions remaining for the day: " + this.numDayActions);
					if (this.numDayActions > 0) {
						visitActionsMainScreen();
					} else {
						System.out.println("Not allowed: You have no actions remaining for today.");
					}
					isValid = true;
					break;
				case 5:
					if (this.numDayActions > 0) {
						System.out.println("You still have " + this.numDayActions + " available actions you could perform today.");
						System.out.println("Are you sure you would like to move to the next day?");
						System.out.println("[1] - yes");
						System.out.println("[2] - no");

						boolean performingAction = true;
						while (performingAction) {
							int decision = getInputInt("your choice of activity");
							switch (decision) {
							case 1:
								isValid = true;
								performingAction = false;
								isDayEnd = true;
								break;
							case 2:
								isValid = true;
								performingAction = false;
								break;
							default:
								System.out.println("Please enter a valid choice.");
							}
						}
					}
					break;
				default:
					System.out.println("Please enter a valid choice.");
				}
			}
		}

		// TODO: Calculate and give daily bonus
	}

//===================================================== MAIN LOOP =====================================================

	public void run() {
		initializeGame();
		for (int i = 1; i <= numDays; i++) {
			System.out.println("===========================================================================");
			System.out.println("Welcome to day " + i + " of " + numDays + " on the farm.");
			System.out.println();
			System.out.println("Here is your daily farm update:");
			System.out.println(this.farm.toString());
			System.out.println("===========================================================================");
			runDay(i);
		}

		// TODO: Finish game, print final score

		in.close();
	}
}
