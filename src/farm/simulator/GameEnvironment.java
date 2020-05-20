package farm.simulator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This abstract class implements the game environment which contains all of the
 * game logic. This environment implements all of the functions required to play
 * the farm simulation game, whilst keeping track of a farm and the elapsed
 * days. The game instantiates all classes used.
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */

public class GameEnvironment {
	Scanner in = new Scanner(System.in);
	public float initialBalance;
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

//===================================================== GAME INITIALIZATION =====================================================

	/**
	 * Create a Farmer object.
	 * 
	 * @param name Name of farmer.
	 * @param age  Age of farmer.
	 * @return The farmer object.
	 */
	public Farmer createFarmer(String name, int age) {
		Farmer farmer = new Farmer(name, age);
		return farmer;
	}

	/**
	 * Returns the description of how crop growth delay bonuses and animal happiness
	 * bonuses work in the game.
	 * 
	 * @return A description of crop growth and animal happiness bonuses for a farm.
	 */
	public static String getBonusesDescription() {
		return "Crop growth delay will delay the growth of all crops by a given number of days. A crop can only be harvested for money once"
				+ " it is fully grown. If this delay is negative, it means your crops will grow faster.\n\nAn animal happiness bonus adds to the happiness all animals, which"
				+ " contributes to the amount of money earned at the end of a day.\n\nThese bonuses are applied on purchase of the crop or animal.";
	}

	/**
	 * Returns a welcome message for a player at the beginning of a game.
	 * 
	 * @return A welcome message for the player.
	 */
	public String getWelcomeMessage() {
		return "Welcome to your new farm, " + this.farm.getFarmer().getName()
				+ ". It is a beautiful day to get to work on '" + this.farm.getName()
				+ "'.\nWe suggest visiting the General Store.\nA farm isn't much fun without crops or animals.";
	}

	/**
	 * Returns the main instructions on how to play the farm simulation game.
	 * 
	 * @return Instructions on how to play the farm simulation game.
	 */
	public String getGameInstructions() {
		return "Welcome to 'Mowing Before Hoeing'.\n\n"
				+ "The goal of this game is to maximise profit and asset aquisition whilst keeping your animals happy and healthy.\n\n"
				+ "Money can be earned during the day from harvesting crops.\nAt the end of each day bonus money is given based "
				+ "on the health and happiness of animals.\n\n" + "Your final score is based on game duration, money, number of crops "
				+ "and animals, and animal status.\n\n"
				+ "Let's set up the farm before we get to work!";
	}

	/**
	 * Initialize the game.
	 * 
	 * @param numDays    Chosen duration of the game in days.
	 * @param farmType   The name of the selected farm subclass.
	 * @param farmerName The name of the farmer.
	 * @param farmerAge  The age of the farmer.
	 * @param farmName   The name of the farm.
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
		this.initialBalance = this.farm.getBalance();
		this.farm.setName(farmName);
		this.farm.setFarmer(createFarmer(farmerName, farmerAge));
		this.farm.getFarmer().setFarm(farm);
	}

//===================================================== DAY IMPLEMENTATION =====================================================	

	/**
	 * Begins a new day on the farm by incrementing the current day and resetting
	 * the allowed actions. Crop growth is also updated by one day.
	 */
	public void beginNewDay() {
		this.currentDay++;
		this.numDayActions = 2;

		// Update crop growth by 1 day
		for (FarmItem c : this.farm.getCrops()) {
			((Crop) c).updateCropGrowth(1);
		}
	}

	/**
	 * Returns a welcome message for the beginning of a day.
	 * 
	 * @return A message to begin a new day on the farm.
	 */
	public String getDayWelcomeMessage() {
		return "Welcome to day " + currentDay + " on '" + this.farm.getName() + "', " + this.farm.getFarmer().getName()
				+ ".";
	}

	/**
	 * Calculates a daily bonus for the farm depending on animal happiness and
	 * health and adds this to the balance of the farm. A description of the bonus
	 * earned is returned.
	 * 
	 * @return A String representation of the monetary bonus for the day.
	 */
	public String getDailyBonus() {
		DecimalFormat df = new DecimalFormat("#.00");
		float bonus = 0;
		String str = "Daily Bonuses for today:\n\n";

		ArrayList<FarmItem> animals = this.farm.getAnimals();
		for (FarmItem a : animals) {
			float healthBonus = ((Animal) a).getHealth() * 5;
			float happinessBonus = ((Animal) a).getHappiness() * 5;
			str += "Bonus from " + ((Animal) a).getName() + ": $" + df.format(happinessBonus + healthBonus) + "\n";
			bonus += (happinessBonus + healthBonus);
		}
		if (bonus == 0) {
			str += "\nTotal bonus money: $0.00";
		} else {
			this.farm.addToBalance(bonus);
			str += "\nTotal bonus money: $" + df.format(bonus);
		}
		return str;
	}

	/**
	 * Sets the number of days the game will last for.
	 * 
	 * @param days The number of days the game should last.
	 */
	public void setNumDays(int days) {
		this.daysTotal = days;
	}

	/**
	 * Returns the total number of days the game will last for.
	 * 
	 * @return Total game duration in days.
	 */
	public int getDaysTotal() {
		return this.daysTotal;
	}

	/**
	 * Returns the number of 'days' the game has been played for.
	 * 
	 * @return The current day of the game.
	 */
	public int getCurrentDay() {
		return this.currentDay;
	}

//===================================================== MAIN MENU =====================================================	

	/**
	 * Returns the status of the farm's crops and animals.
	 * 
	 * @return The status of the farm's crops and animals.
	 */
	public String getCropAndAnimalStatus() {
		return this.farm.getCropAndAnimalStatus();
	}

	/**
	 * Returns the status of the farm which includes all set attributes, including
	 * the balance.
	 * 
	 * @return The status of the farm.
	 */
	public String getFarmStatus() {
		return this.farm.toString();
	}

	/**
	 * Returns the number of actions that the player still has for the given day.
	 * 
	 * @return Number of allowed actions remaining.
	 */
	public int getNumActions() {
		return this.numDayActions;
	}

	/**
	 * Moves to the next day of the game if the game is not finished. If the game is
	 * finished, the function will return false indicating that the game is
	 * completed.
	 * 
	 * @return Returns true if a new day has begun. Returns false if the game is
	 *         completed.
	 */
	public boolean moveToNextDay() {
		if (this.currentDay < this.daysTotal) {
			beginNewDay();
			return true;
		} else {
			return false;
		}
	}

//===================================================== FARMER ACTIONS =====================================================	

	/**
	 * Returns a description of the 'tend to crops' action, performed by a farmer.
	 * 
	 * @return The description of tending to crops.
	 */
	public String getCropTendingDescription() {
		return "Tending to the crops speeds up their growing process by a small amount, decreasing the amount of time until they can be harvested.\n"
				+ "Only one type of crop can be harvested at a time.\n"
				+ "An item or water can be used to tend to the crops.\n\n" + "You current own the following crops:\n"
				+ this.farm.getCropStatus() + "\n" + "Click yes to to pick which crop type and item.";
	}

	/**
	 * Returns a description of the 'feed animals' action, performed by a farmer.
	 * 
	 * @return The description of feeding animals.
	 */
	public String getFeedingAnimalsDescription() {
		return "Feeding your animals will increase their health.\n" + "A food item must be used to do this.\n\n"
				+ "Click yes to pick the food to feed your animals with.";
	}

	/**
	 * Returns a description of the 'play with animals' action, performed by a
	 * farmer.
	 * 
	 * @return The description of playing with animals.
	 */
	public String getPlayWithAnimalsDescription() {
		return "Playing with animals makes their happiness increase.\n"
				+ "The happiness of all animals will increase by 1 point.\n\n"
				+ "Here is the status of your current animals:\n" + this.farm.getAnimalStatus()
				+ "\nClick yes to play with the animals.";
	}

	/**
	 * Returns a description of the 'harvest crops' action, performed by a farmer.
	 * 
	 * @return A description of harvesting crops.
	 */
	public String getHarvestCropsDescription() {
		return "Any crops that have fully grown can be harvested for a money bonus.\n\n"
				+ "Here are your current crops ready for harvest:\n" + this.farm.getCropsReadyForHarvest()
				+ "\nClick yes to harvest these crops.";
	}

	/**
	 * Returns a description of the 'tend to the farm land' action, performed by a
	 * farmer.
	 * 
	 * @return A description of tending to farmland.
	 */
	public String getTendToFarmLandDescription() {
		return "Tending to the farm's land keeps the farm tidy and well maintained.\n"
				+ "This allows for more crops to be grown and keeps animals happier for longer.\n\n"
				+ "Here is the status of your current animals:\n" + this.farm.getAnimalStatus() + "\nYou have "
				+ this.farm.getNumAvailableCrops() + " available crop plots.\n\n"
				+ "Click yes to tend to the land, adding 1 point to the happiness of all of your animals, and adding 1 available crop plot.";
	}

	/**
	 * Returns true if a farmer is able to tend to the crops. This will be true if
	 * there are crops on the farm.
	 * 
	 * @return True if the crops can be tended to. Else, false.
	 */
	public boolean canTendToCrops() {
		if (this.farm.getCrops().size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true is a farmer can feed the animals. This will be true if there are
	 * animals on the farm and the farmer has some food items.
	 * 
	 * @return True if the animals can be fed. Else, false.
	 */
	public boolean canFeedAnimals() {
		if (this.farm.getAnimals().size() > 0 && getFoodItems().size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if a farmer can play with the animals. This requires the farm to
	 * have animals.
	 * 
	 * @return True if there are animals on the farm. Else, false.
	 */
	public boolean canPlayWithAnimals() {
		if (this.farm.getAnimals().size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if a farmer has crops that are ready to be harvested.
	 * 
	 * @return True if there are crops ready to harvest. Else, false.
	 */
	public boolean canHarvestCrops() {
		for (FarmItem crop : this.farm.getCrops()) {
			Crop c = (Crop) crop;
			if (c.getTimeUntilHarvest() == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns food items owned by the farmer.
	 * 
	 * @return Food items owned by the farmer.
	 */
	public ArrayList<FarmItem> getFoodItems() {
		ArrayList<FarmItem> food = new ArrayList<FarmItem>();
		for (FarmItem i : this.farm.getFarmer().getItems()) {
			if (((Item) i).getAnimalHealthFactor() != 0) {
				food.add(i);
			}
		}
		return food;
	}

	/**
	 * Returns items used for tending to crops owned by the farmer.
	 * 
	 * @return Items used for tending to crops owned by the farmer.
	 */
	public ArrayList<FarmItem> getToolItems() {
		ArrayList<FarmItem> tools = new ArrayList<FarmItem>();
		for (FarmItem i : this.farm.getFarmer().getItems()) {
			if (((Item) i).getCropGrowthFactor() != 0) {
				tools.add(i);
			}
		}
		return tools;
	}

	/**
	 * Returns all crops on the farm.
	 * 
	 * @return Crops on the farm.
	 */
	public ArrayList<FarmItem> getCrops() {
		return this.farm.getCrops();
	}

	/**
	 * Implements the 'tend to crops' action using an item.
	 * 
	 * @param cropId The type ID of the crop to be tended to.
	 * @param itemId The type ID of the item to be used for tending to the crops.
	 * @return The updated status of the crops.
	 */
	public String tendToCrops(int cropId, int itemId) {
		String str = "";

		// Remove item to use
		Item item = (Item) this.farm.getFarmer().removeItem(itemId);
		this.farm.getFarmer().feedAnimals(item);

		this.farm.getFarmer().tendToCrop(cropId, item);
		str += "Good job on a hard day's work on the crops.\n" + "Here is the updated status of the crops:\n";
		str += this.farm.getCropStatus();

		this.numDayActions -= 1;
		return str;
	}

	/**
	 * Implements the 'tend to crops' action using the free option, 'water'. This
	 * deducts one day off the required crop growth.
	 * 
	 * @param cropId The type ID of the crop to be tended to.
	 * @return The updated status of the crops.
	 */
	public String tendToCrops(int cropId) {
		String str = "";

		this.farm.getFarmer().tendToCrop(cropId);
		str += "Good job on a hard day's work on the crops.\n" + "Here is the updated status of the crops:\n";
		str += this.farm.getCropStatus();

		this.numDayActions -= 1;
		return str;
	}

	/**
	 * Implements the 'feed animals' action using a food item. This improves the
	 * health of all animals.
	 * 
	 * @param itemId The Type ID of the food item to use to feed the animals.
	 * @return The updated status of all animals.
	 */
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

	/**
	 * Implements the 'play with animals' action which improves the happiness of
	 * animals.
	 * 
	 * @return The updated status of all animals.
	 */
	public String playWithAnimals() {
		String str = "";
		this.farm.getFarmer().playWithAnimals();
		str += "Your animals love spending time with you! Here is their updated status:\n";
		str += this.farm.getAnimalStatus();

		this.numDayActions -= 1;
		return str;
	}

	/**
	 * Implements the 'harvest crops' action which adds the selling price of
	 * harvested crops to the balance of the farm, and frees a crop plot up for
	 * every harvested crop. Harvested crops are removed from the crop list.
	 * 
	 * @return An updated status of the crops.
	 */
	public String harvestCrops() {
		String str = "";
		float moneyEarned = this.farm.getFarmer().harvestCrops();
		DecimalFormat df = new DecimalFormat("#.00");
		str += "Score!! You have just added $" + df.format(moneyEarned) + " to the balance of the farm.\n"
				+ "You now have " + this.farm.getNumAvailableCrops() + " available crop plots.\n\n"
				+ "Here is the updated status of your crops:\n";
		str += this.farm.getCropStatus();

		this.numDayActions -= 1;
		return str;
	}

	/**
	 * Implements the 'tend to the farm land' action which adds to animal happiness.
	 * 
	 * @return The updated status of the animals.
	 */
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

//===================================================== GENERAL STORE =====================================================

	/**
	 * Returns the balance of the farm and items currently owned by the farmer.
	 * 
	 * @return The balance of the farm and items currently owned by the farmer.
	 */
	public String displayCurrentlyOwnedItems() {
		String str = "";
		DecimalFormat df = new DecimalFormat("#.00");
		str += "Current balance: $" + df.format(this.farm.getBalance()) + "\n\n";
		if (this.farm.getFarmer().getItems().size() == 0) {
			str += "You currently do not own any items.";
		} else {
			str += "You own the following items:\n";
			str += this.farm.getFarmer().getItemStock();
		}
		return str;
	}

	/**
	 * Returns the number of available crop plots on the farm.
	 * 
	 * @return Number of available crop plots on the farm.
	 */
	public int getNumAvailableCrops() {
		return this.farm.getNumAvailableCrops();
	}

	/**
	 * Processes the purchase of an animal from the store. This involves firstly
	 * withdrawing money from the farm. If this is successful the animal will be
	 * purchased and added to the farm's animal list.
	 * 
	 * @param itemId The Type ID of the animal to be sold.
	 * @return The animal if it has been successfully purchased. Otherwise it will
	 *         return null.
	 */
	public FarmItem processAnimalSale(int itemId) {
		FarmItem animal = null;
		float payment = this.farm.withdrawMoney(generalStore.getItem(itemId).getPurchasePrice());
		// Check withdrawal was successful
		if (payment != 0) {
			animal = generalStore.getItem(itemId);
			this.farm.addAnimal(animal);
		}
		return animal;
	}

	/**
	 * Processes the purchase of a crop from the store. This involves firstly
	 * withdrawing money from the farm. If this is successful the crop will be
	 * purchased and added to the farm's crop list.
	 * 
	 * @param itemId The Type ID of the crop to be sold.
	 * @return The crop if it has been successfully purchased. Otherwise it will
	 *         return null.
	 */
	public FarmItem processCropSale(int itemId) {
		FarmItem crop = null;
		float payment = this.farm.withdrawMoney(generalStore.getItem(itemId).getPurchasePrice());
		// Check withdrawal was successful
		if (payment != 0) {
			crop = generalStore.sellItem(itemId);
			this.farm.addCrop(crop);
		}
		return crop;
	}

	/**
	 * Processes the purchase of a farming item from the store. This involves
	 * firstly withdrawing money from the farm. If this is successful the item will
	 * be purchased and added to the farmer's list of items.
	 * 
	 * @param itemId The Type ID of the item to be sold.
	 * @return The item if it has been successfully purchased. Otherwise it will
	 *         return null.
	 */
	public FarmItem processItemSale(int itemId) {
		FarmItem item = null;
		float payment = this.farm.withdrawMoney(generalStore.getItem(itemId).getPurchasePrice());
		// Check withdrawal was successful
		if (payment != 0) {
			item = generalStore.getItem(itemId);
			this.farm.getFarmer().addItem(item);
		}
		return item;
	}

	/**
	 * Returns the default description of an item.
	 * 
	 * @param itemId The type ID of the item to be described.
	 * @return The description of the given item.
	 */
	public String getFarmItemDescription(int itemId) {
		String str = "";
		switch (itemId) {
		case 1:
			str += Fertilizer.getTypeDescription();
			break;
		case 2:
			str += Compost.getTypeDescription();
			break;
		case 3:
			str += Hoe.getTypeDescription();
			break;
		case 4:
			str += Steroid.getTypeDescription();
			break;
		case 5:
			str += Grain.getTypeDescription();
			break;
		case 6:
			str += Silage.getTypeDescription();
			break;
		case 7:
			str += Rice.getTypeDescription();
			break;
		case 8:
			str += Wheat.getTypeDescription();
			break;
		case 9:
			str += Cotton.getTypeDescription();
			break;
		case 10:
			str += Coffee.getTypeDescription();
			break;
		case 11:
			str += Olive.getTypeDescription();
			break;
		case 12:
			str += Avocado.getTypeDescription();
			break;
		case 13:
			str += Chicken.getTypeDescription();
			break;
		case 14:
			str += Pig.getTypeDescription();
			break;
		case 15:
			str += Horse.getTypeDescription();
			break;
		}
		return str;
	}

	/**
	 * Returns a generic success message when any farm item is purchased.
	 * 
	 * @param item The item that has been successfully purchased.
	 * @return A success message.
	 */
	public String getSuccessMessage(FarmItem item) {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Congratulations, " + this.farm.getFarmer().getName() + "!\n" + "Your purchase is completed"
				+ " and your new item has been modified according to your farm type.\n\n"
				+ "You are now the new owner of:\n" + item.toString() + "\n\nYour remaining balance is $"
				+ df.format(this.farm.getBalance());
	}

	/**
	 * Returns a default error message if a purchase has been unsuccessful.
	 * 
	 * @return A default error message.
	 */
	public String getErrorMessage() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Oh no, it appears you cannot afford this right now.\n" + "Your current balance is $"
				+ df.format(this.farm.getBalance());
	}

// ===================================================== FINAL SCORE IMPLEMENTATION =====================================================

	/**
	 * Returns the profit that has been made throughout the duration of the game.
	 * 
	 * @return The total profit made during the game.
	 */
	public float getTotalProfit() {
		return this.farm.getBalance() - this.initialBalance;
	}

	/**
	 * Calculate a final score based on game duration, number of crops and animals,
	 * animal status and money earned
	 * 
	 * @return Final game score.
	 */
	public int calculateFinalScore() {
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

	/**
	 * Return a string summarizing the final results for a game.
	 * 
	 * @return The final summary of the game.
	 */
	public String getFinalResults() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Well done, " + this.farm.getFarmer().getName() + ", you have made it through life as a farmer!"
				+ "\nFarm name: " + this.farm.getName() + "\nGame duration: " + this.getDaysTotal() + " days"
				+ "\nProfit made: $" + df.format(getTotalProfit())
				+ "\n\nYour final score is calculated based on game duration, "
				+ "crops and animals owned, animal status and money earned";
	}

}
