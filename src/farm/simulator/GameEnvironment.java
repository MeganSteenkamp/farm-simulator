package farm.simulator;

import java.text.DecimalFormat;
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
	private int daysTotal;
	private int currentDay;
	private Farm farm;
	private GeneralStore generalStore = new GeneralStore();

	/**
	 * Initialize Game Environment
	 */
	public GameEnvironment() {
		this.currentDay = 0;
	}

// HERE BELOW IS CURRENT IMPLEMENTATION (GUI)
//===================================================== GAME INITIALIZATION =====================================================

	public Farmer createFarmer(String name, int age) {
		Farmer farmer = new Farmer(name, age);
		return farmer;
	}

	public static String getBonusesDescription() {
		return "Crop growth delay will delay the base growth rate of a crop by a given number of days. A crop can only be harvested for money once"
				+ " it is fully grown. If this delay is negative, it means your crops will grow faster. An animal happiness bonus adds the given number of points to the happiness of an animal, which"
				+ " contributes to the amount of money earned at the end of a day.";
	}

	public String getWelcomeMessage() {
		return "Welcome to your new farm, " + this.farm.getFarmer().getName()
				+ ". It is a beautiful day to get to work on '" + this.farm.getName()
				+ "'.\nWe suggest going to the General Store.\nA farm isn't much fun without crops or animals.";
	}

	public String getGameInstructions() {
		return "Welcome to 'Mowing Before Hoeing'.\n\n"
				+ "The goal of 'Mowing before Hoeing' is to earn as much money as possible \n"
				+ "whilst keeping your animals happy and healthy.\n\n"
				+ "Money can be earned from harvesting crops or owning items at the end of the game.\n"
				+ "At the end of each day a bonus is given based on the health and happiness of animals.\n\n"
				+ "Let's set up the farm before we get to work.";
	}

	/**
	 * Initialize the game
	 */
	public void setUpGame(int numDays, String farmType, String farmerName, int farmerAge, String farmName) {
		setNumDays(numDays);

		switch (farmType) {
		case "North Korea":
			this.farm = new NorthKoreanFarm();
			break;
		case "Africa":
			this.farm = new AfricanFarm();
			break;
		case "Mediterranean":
			this.farm = new MediterraneanFarm();
			break;
		case "New Zealand":
			this.farm = new NewZealandFarm();
			break;
		}

		this.farm.setName(farmName);
		this.farm.setFarmer(createFarmer(farmerName, farmerAge));
		this.farm.getFarmer().setFarm(farm);

		// TODO: Remove this code after testing
		this.farm.addAnimal(new Chicken());
		this.farm.addAnimal(new Horse());
		this.farm.addCrop(new Cotton());
		this.farm.addCrop(new Olive());
		this.farm.addCrop(new Avocado());
		this.farm.getFarmer().addItem(new Fertilizer());
		this.farm.getFarmer().addItem(new Steroid());
		this.farm.getFarmer().addItem(new Silage());
		this.farm.getFarmer().addItem(new Hoe());
	}

//===================================================== DAY IMPLEMENTATION =====================================================	

	public void beginNewDay() {
		this.currentDay++;
		this.numDayActions = 2;

		// Update crop growth by 1 day
		for (FarmItem c : this.farm.getCrops()) {
			((Crop) c).updateCropGrowth(1);
		}
	}

	public String getDayWelcomeMessage() {
		return "Welcome to day " + currentDay + " on '" + this.farm.getName() + "', " + this.farm.getFarmer().getName()
				+ ".";
	}

	/**
	 * Returns a daily bonus for the farm depending on animal happiness and health.
	 * 
	 * @return Monetary bonus for the day.
	 */
	public String getDailyBonus() {
		DecimalFormat df = new DecimalFormat("#.00");
		float bonus = 0;
		String str = "Daily Bonuses for today:\n\n";

		ArrayList<FarmItem> animals = this.farm.getAnimals();
		for (FarmItem a : animals) {
			float healthBonus = ((Animal) a).getHealth() * 5;
			float happinessBonus = ((Animal) a).getHappiness() * 5;
			str += "Bonus from " + ((Animal) a).getType() + ": $" + df.format(happinessBonus + healthBonus) + "\n";
			bonus += (happinessBonus + healthBonus);
		}
		this.farm.addToBalance(bonus);
		str += "\nTotal bonus money: $" + df.format(bonus);

		return str;
	}

	public void setNumDays(int days) {
		this.daysTotal = days;
	}

	public int getDaysTotal() {
		return this.daysTotal;
	}

	public int getCurrentDay() {
		return this.currentDay;
	}

//===================================================== MAIN MENU =====================================================	

	public String getCropAndAnimalStatus() {
		return this.farm.getCropAndAnimalStatus();
	}

	public String getFarmStatus() {
		return this.farm.toString();
	}

	public int getNumActions() {
		return this.numDayActions;
	}

	public void moveToNextDay() {
		beginNewDay();
	}

//===================================================== FARMER ACTIONS =====================================================	

	public String getCropTendingDescription() {
		return "Tending to the crops speeds up their growing process by a small amount, decreasing the amount of time until they can be harvested.\n"
				+ "Only one type of crop can be harvested at a time.\n"
				+ "An item or water can be used to tend to the crops.\n\n"
				+ "Click yes to to pick which crop type and item.";
	}

	public String getFeedingAnimalsDescription() {
		return "Feeding your animals will increase their health.\n" + "A food item must be used to do this.\n\n"
				+ "Click yes to pick the food to feed your animals with.";
	}

	public String getPlayWithAnimalsDescription() {
		return "Playing with animals makes their happiness increase.\n"
				+ "The happiness of all animals will increase by 1 point.\n\n"
				+ "Here is the status of your current animals:\n" + this.farm.getAnimalStatus()
				+ "\nClick yes to play with the animals.";
	}

	public String getHarvestCropsDescription() {
		return "Any crops that have fully grown can be harvested for a money bonus.\n\n"
				+ "Here are your current crops ready for harvest:\n" + this.farm.getCropStatus()
				+ "\nClick yes to harvest these crops.";
	}

	public String getTendToFarmLandDescription() {
		return "Tending to the farm's land keeps the farm tidy and well maintained.\n"
				+ "This allows for more crops to be grown and keeps animals happier for longer.\n\n"
				+ "Here is the status of your current animals:\n" + this.farm.getAnimalStatus() + "\nYou have "
				+ this.farm.getNumAvailableCrops() + "available crop plots.\n\n"
				+ "Click yes to tend to the land, adding 1 point to the happiness of all of your animals, and adding 1 available crop plot.";
	}

	public boolean canTendToCrops() {
		if (this.farm.getCrops().size() > 0) {
			return true;
		}
		return false;
	}

	public boolean canFeedAnimals() {
		if (this.farm.getAnimals().size() > 0) {
			return true;
		}
		return false;
	}

	public boolean canPlayWithAnimals() {
		if (this.farm.getAnimals().size() > 0) {
			return true;
		}
		return false;
	}

	public boolean canHarvestCrops() {
		ArrayList<Crop> cropsToHarvest = new ArrayList<Crop>();
		for (FarmItem crop : this.farm.getCrops()) {
			Crop c = (Crop) crop;
			if (c.getTimeUntilHarvest() == 0) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<FarmItem> getFoodItems() {
		ArrayList<FarmItem> food = new ArrayList<FarmItem>();
		for (FarmItem i : this.farm.getFarmer().getItems()) {
			if (((Item) i).getAnimalHealthFactor() != 0) {
				food.add(i);
			}
		}
		return food;
	}

	public ArrayList<FarmItem> getToolItems() {
		ArrayList<FarmItem> tools = new ArrayList<FarmItem>();
		for (FarmItem i : this.farm.getFarmer().getItems()) {
			if (((Item) i).getCropGrowthFactor() != 0) {
				tools.add(i);
			}
		}
		return tools;
	}

	public ArrayList<FarmItem> getCrops() {
		return this.farm.getCrops();
	}

	public String tendToCrops(int cropId, int itemId) {
		String str = "";

		// Remove item to use
		Item item = (Item) this.farm.getFarmer().removeItem(itemId);
		this.farm.getFarmer().feedAnimals(item);
		
		this.farm.getFarmer().tendToCrop(cropId, item);
		str += "Good job on a hard day's work in the farm.\n"
				+ "Here is the updated status of the crops:\n";
		str += this.farm.getCropStatus();

		this.numDayActions -= 1;
		return str;
	}

	public String tendToCrops(int cropId) {
		String str = "";
		
		this.farm.getFarmer().tendToCrop(cropId);
		str += "Good job on a hard day's work in the farm.\n"
				+ "Here is the updated status of the crops:\n";
		str += this.farm.getCropStatus();

		this.numDayActions -= 1;
		return str;
	}

	public String feedAnimals(int itemId) {
		String str = "";

		// Remove item to use
		Item item = (Item) this.farm.getFarmer().removeItem(itemId);
		this.farm.getFarmer().feedAnimals(item);

		// Return updated Animal details
		str += "Your animals have been successfully fed. Here is their updated status:\n";
		str += this.farm.getAnimalStatus();

		this.numDayActions -= 1;
		return str;
	}

	public String playWithAnimals() {
		String str = "";
		this.farm.getFarmer().playWithAnimals();
		str += "Your animals love spending time with you! Here is their updated status:\n";
		str += this.farm.getAnimalStatus();

		this.numDayActions -= 1;
		return str;
	}

	public String harvestCrops() {
		String str = "";
		float moneyEarned = this.farm.getFarmer().harvestCrops();
		DecimalFormat df = new DecimalFormat("#.00");
		str += "Score!! You have just added $" + df.format(moneyEarned) + " to the balance of the farm.\n"
				+ "Here is the updated status of the crops:\n";
		str += this.farm.getCropStatus();

		this.numDayActions -= 1;
		return str;
	}

	public String tendToFarmland() {
		String str = "";
		farm.getFarmer().tendToFarmland();

		// Print updated farm and animals details
		str += "That is one tidy farm! Here is your updated farm and animal status:\n\n";
		str += this.farm.toString() + "\n\n";
		str += this.farm.getAnimalStatus();

		this.numDayActions -= 1;
		return str;
	}

// ===================================================== FINAL SCORE IMPLEMENTATION =====================================================

	/**
	 * Calculate a final score based on game duration, number of crops and animals,
	 * animal status and money earned
	 * 
	 * @return Final score.
	 */
	public int getFinalScore() {
		int score = 0;

		// =================== ASSESS MONEY ===================
		// Sum up monetary value of assets (money, animals, crops)
		float money = this.farm.getBalance();

		ArrayList<FarmItem> animals = this.farm.getAnimals();
		for (FarmItem a : animals) {
			money += a.getPurchasePrice();
		}

		// Crops have not been harvested so calculate value through purchase price
		ArrayList<FarmItem> crops = this.farm.getCrops();
		for (FarmItem c : crops) {
			money += c.getPurchasePrice();
		}

		// 1 points for every $10 earned
		score += Math.floorDiv((int) money, 10);

		// =================== ASSESS ANIMAL STATUS ===================

		// 1 point for every happiness point on an animal, 1 point for health
		for (FarmItem a : animals) {
			score += ((Animal) a).getHealth();
			score += ((Animal) a).getHappiness();
		}

		// Multiply by game duration
		score *= this.daysTotal;
		return score;
	}

//===== BELOW HERE BROKEN!!! ================================	

// HERE BELOW IS COMMAND LINE IMPLEMENTATION (BROKEN)	

//===================================================== GENERAL STORE =====================================================

	/**
	 * Displays user actions avaiable in general store
	 */
	public void printGeneralStoreOptions() {
		System.out.println("Please enter the number corresponding to what you would like to do.");
		System.out.println("[1] - View or buy items / farming supplies");
		System.out.println("[2] - View or buy crops");
		System.out.println("[3] - View or buy animals");
		System.out.println("[4] - View currently owned items and balance");
		System.out.println("[5] - Exit the store");
	}

	/**
	 * Displays balance and items currently owned by the farmer
	 */
	private void displayCurrentlyOwnedItems() {
		System.out.println("Current balance: $" + this.farm.getBalance());
		if (this.farm.getFarmer().getItems().size() == 0) {
			System.out.println("You currently do not own any items.");
		} else {
			this.farm.getFarmer().printItemStock();
		}
	}

	/**
	 * Processes the sale of an item and decreases the stock accordingly.
	 * 
	 * @param itemReference The Item ID of the item to be purchased.
	 * @return The item that has been sold.
	 */
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
				float money = this.farm.withdrawMoney(generalStore.getItem(itemReference).getPurchasePrice());
				// Check withdrawl was successful
				if (money != 0) {
					item = generalStore.sellItem(itemReference);
				}
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

	/**
	 * Displays the available items in the store and their stock number.
	 * 
	 * @return An item if it has been sold. If no item has been sold, the function
	 *         returns null.
	 */
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

	/**
	 * Displays the available crops for purchase in the store and their stock
	 * number.
	 * 
	 * @return A crop if it has been sold. If no item has been sold, the function
	 *         returns null.
	 */
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

	/**
	 * Displays the available animals for purchase in the store and their stock
	 * number.
	 * 
	 * @return An animal if it has been sold. If no item has been sold, the function
	 *         returns null.
	 */
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

	/**
	 * Prints General Store menu options.
	 */
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
}
