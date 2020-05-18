package farm.simulator;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This abstract class implements the base class for all farms.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */

public abstract class Farm {
	private String name;
	private String type;
	private Farmer farmer;
	private float balance;
	private int numAvailableCrops = 4;
	private ArrayList<FarmItem> crops = new ArrayList<FarmItem>();
	private ArrayList<FarmItem> animals = new ArrayList<FarmItem>();
	private int cropGrowthFactor;
	private int animalHappinessFactor;

	/**
	 * Class constructor for the Farm class
	 * 
	 * @param name                  Name of farm.
	 * @param type                  Type of farm selected.
	 * @param balance               Starting monetary balance for farm.
	 * @param cropGrowthFactor      Scale factor to apply to growth time of crops.
	 * @param animalHappinessFactor Scale factor to apply to happiness of animals.
	 */
	public Farm(String type, float balance, int cropGrowthFactor, int animalHappinessFactor) {
		this.type = type;
		this.balance = balance;
		this.cropGrowthFactor = cropGrowthFactor;
		this.animalHappinessFactor = animalHappinessFactor;
	}

	/**
	 * String representation of a farm.
	 * 
	 * @return String representation of farm attributes.
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Name: " + this.name + "\nType: " + this.type + "\n" + farmer.toString() + "\nBalance: $"
				+ df.format(this.balance) + "\nCrop growth bonus: " + this.cropGrowthFactor
				+ " days(s)\nAnimal happiness bonus: " + this.animalHappinessFactor
				+ " point(s)\nAvailable crop plots: " + this.numAvailableCrops;
	}

	/**
	 * Sets the name of the farm.
	 * 
	 * @param name Name of farm.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the farmer of the farm.
	 * 
	 * @param farmer Farmer object representing the farm's farmer.
	 */
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	/**
	 * Returns the farmer of the farm.
	 * 
	 * @param farmer Farmer object associated with farm.
	 */
	public Farmer getFarmer() {
		return this.farmer;
	}

	/**
	 * Returns the number of available crop plots
	 * 
	 * @return Number of available crop plots
	 */
	public int getNumAvailableCrops() {
		return this.numAvailableCrops;
	}

	/**
	 * Adds to the number of free crops available on the farm.
	 * 
	 * @param num The number of newly available crops.
	 */
	public void addToAvailableCrops(int num) {
		this.numAvailableCrops += num;
	}

	/**
	 * Returns the status of the farm's crops and animals. This includes viewing a
	 * crop's time growing, the time left until crop's harvest and an animal's
	 * happiness levels.
	 */
	public String getCropAndAnimalStatus() {
		return getCropStatus() + "\n" + getAnimalStatus();
	}

	/**
	 * Returns the name of a farm.
	 * 
	 * @return Name of the farm.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the balance of a farm.
	 * 
	 * @return Name of the farm.
	 */
	public float getBalance() {
		return this.balance;
	}

	/**
	 * Withdraws money from the farm
	 * 
	 * @return Name of the farm.
	 */
	public float withdrawMoney(float amount) {
		if (amount < getBalance()) {
			this.balance -= amount;
			return amount;
		} else {
			// TODO: Should raise insufficient funds error
			return 0;
		}
	}

	/**
	 * Adds to monetary balance of the farm.
	 * 
	 * @param amount Amount of money to add.
	 */
	public float addToBalance(float amount) {
		this.balance += amount;
		return this.balance;
	}

	/**
	 * Adds a new crop to the farm.
	 * 
	 * @param crop Crop to be added.
	 */
	public void addCrop(FarmItem crop) {
		// Scale crop growth according to farm
		((Crop) crop).addDaysToGrow(cropGrowthFactor);
		this.crops.add(crop);
		this.numAvailableCrops -= 1;
	}

	/**
	 * Removes a crop from the farm. Will be called if a crop is harvested.
	 * 
	 * @param crop Crop to be removed.
	 */
	public void removeCrop(Crop crop) {
		for (int i = 0; i < crops.size(); i++) {
			if (crops.get(i) == crop) {
				crops.remove(i);
				break;
			}
		}
	}

	/**
	 * Adds a new animal to the farm.
	 * 
	 * @param animal Animal to be added.
	 */
	public void addAnimal(FarmItem animal) {
		((Animal) animal).addToHappiness(animalHappinessFactor);
		this.animals.add(animal);
	}

	/**
	 * Returns the farm's crops.
	 * 
	 * @return the farm's crops.
	 */
	public ArrayList<FarmItem> getCrops() {
		return this.crops;
	}

	/**
	 * Returns the farm's animals.
	 * 
	 * @return the farm's animals.
	 */
	public ArrayList<FarmItem> getAnimals() {
		return this.animals;
	}

	/**
	 * Prints the details of the animals on the farm.
	 */
	public String getAnimalStatus() {
		String s = "Number of animals owned: " + this.animals.size() + "\n";
		for (FarmItem a : animals) {
			s += a.toString() + "\n\n";
		}
		return s;
	}

	/**
	 * Prints the details of the crops on the farm.
	 * 
	 * @param currentDay Current day number.
	 */
	public String getCropStatus() {
		String s = "Number of crops owned: " + this.crops.size() + "\n";
		for (FarmItem c : crops) {
			s += c.toString() + "\n\n";
		}
		return s;
	}

	/**
	 * Prints the details of the crops on the farm.
	 * 
	 * @param currentDay Current day number.
	 */
	public String getCropsReadyForHarvest() {
		String s = "";
		for (FarmItem c : crops) {
			if (((Crop) c).getTimeUntilHarvest() == 0) {
				s += c.toString() + "\n\n";
			}
		}
		return s;
	}

	/**
	 * Gets an crop of a given type, specified by an integer.
	 * 
	 * @param type Type of crop, identified with an integer.
	 * @return Crop if it is in the list of crops. Otherwise will return null.
	 */
	public FarmItem getCrop(int type) {
		FarmItem crop = null;
		for (int i = 0; i < crops.size(); i++) {
			if (crops.get(i).getId() == type) {
				crop = crops.get(i);
				break;
			}
		}
		return crop;
	}

	/**
	 * Whether the farm has a crop of a given type.
	 * 
	 * @param type Identifier of crop type.
	 * @return True if crop is in stock. Else false.
	 */
	public boolean ownsCrop(int type) {
		FarmItem crop = getCrop(type);
		if (crop == null) {
			return false;
		}
		return true;
	}
}
