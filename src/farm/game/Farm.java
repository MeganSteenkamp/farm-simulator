package farm.game;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class implements the base class for all farms. A farm has a name, a type
 * and farmer and contains a list of crops, a lost of animals, and the amount of
 * money the farm currently has. The subclass of Farm instantiated will
 * determine the crop growing speed and the animal bonuses.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 * @version 1.0
 */
public class Farm {
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
	 * @param type                  Type of farm, based on geographical location.
	 * @param balance               Starting monetary balance for farm.
	 * @param cropGrowthFactor      Scale factor to add to the growth time of crops
	 *                              on purchase.
	 * @param animalHappinessFactor Scale factor to add to the happiness of animals
	 *                              on purchase.
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
		String str = "";
		DecimalFormat df = new DecimalFormat("#.00");
		if (name != null) {
			str += "Name: " + this.name + "\n";
		}
		if (farmer != null) {
			str += farmer.toString() + "\n";
		}
		str += "Type: " + this.type + "\nBalance: $" + df.format(this.balance) + "\nCrop growth bonus: "
				+ this.cropGrowthFactor + " days(s)\nAnimal happiness bonus: " + this.animalHappinessFactor
				+ " point(s)\nAvailable crop plots: " + this.numAvailableCrops;
		return str;
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
	 * @param farmer Farmer object representing the farmer.
	 */
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	/**
	 * Returns the farmer of the farm.
	 * 
	 * @return farmer Farmer object associated with farm.
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
	 * Adds to the number of free crops available on the farm. Only accepts positive
	 * parameters.
	 * 
	 * @param num The number of newly available crops.
	 */
	public void addToAvailableCrops(int num) {
		if (num > 0) {
			this.numAvailableCrops += num;
		} else {
			throw new IllegalArgumentException("Available crops cannot be deducted from.");
		}

	}

	/**
	 * Returns the status of the farm's crops and animals. This includes viewing a
	 * crop's time growing, the time left until crop's harvest and an animal's
	 * happiness and health levels.
	 * 
	 * @return The status of all crops and animals.
	 */
	public String getCropAndAnimalStatus() {
		return getCropStatus() + getAnimalStatus();
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
	 * @return Monetary balance of the farm.
	 */
	public float getBalance() {
		return this.balance;
	}

	/**
	 * Withdraws money from the farm's balance and returns it. If the amount to be
	 * withdrawn exceeds that of the balance, no money will be returned.
	 * 
	 * @param amount Amount of money to be withdrawn.
	 * @return Money withdrawn.
	 */
	public float withdrawMoney(float amount) {
		if (amount <= getBalance() && amount >= 0) {
			this.balance -= amount;
			return amount;
		} else {
			return 0;
		}
	}

	/**
	 * Adds to monetary balance of the farm. Throws an exception is money is
	 * attempted to be deducted.
	 * 
	 * @param amount Amount of money to add.
	 * @return The current balance of the farm.
	 */
	public float addToBalance(float amount) {
		if (amount >= 0) {
			this.balance += amount;
			return this.balance;
		} else {
			throw new IllegalArgumentException(
					"Cannot add a negative amount to balance. Use withdrawMoney() function.");
		}
	}

	/**
	 * Adds a new crop to the farm if there is a plot available. Throws an exception
	 * if there are no available crop plots left.
	 * 
	 * @param crop Crop to be added.
	 */
	public void addCrop(FarmItem crop) {
		if (this.numAvailableCrops > 0) {
			// Scale crop growth according to farm
			((Crop) crop).addDaysToGrow(this.cropGrowthFactor);
			this.crops.add(crop);
			this.numAvailableCrops -= 1;
		} else {
			throw new IllegalArgumentException("Crops cannot be added to a farm with no available plots.");
		}
	}

	/**
	 * Removes a crop from the farm. This function is used if a crop is harvested.
	 * If the crop given does not exist on the farm an exception will be thrown.
	 * 
	 * @param crop Crop to be removed.
	 */
	public void removeCrop(Crop crop) {
		boolean removedCrop = false;
		for (int i = 0; i < crops.size(); i++) {
			if (crops.get(i) == crop) {
				removedCrop = true;
				crops.remove(i);
				break;
			}
		}
		if (removedCrop == false) {
			throw new RuntimeException("Given crop does not exist in the farm");
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
	 * Returns a list of the farm's crops.
	 * 
	 * @return the farm's crops.
	 */
	public ArrayList<FarmItem> getCrops() {
		return this.crops;
	}

	/**
	 * Returns a list of the farm's animals.
	 * 
	 * @return the farm's animals.
	 */
	public ArrayList<FarmItem> getAnimals() {
		return this.animals;
	}

	/**
	 * Returns the details of all animals on the farm.
	 * 
	 * @return The animals the farm owns.
	 */
	public String getAnimalStatus() {
		String s = "Number of animals owned: " + this.animals.size() + "\n";
		for (FarmItem a : animals) {
			s += a.toString() + "\n\n";
		}
		return s;
	}

	/**
	 * Returns the details of all crops on the farm.
	 * 
	 * @return The crops the farm owns.
	 */
	public String getCropStatus() {
		String s = "Number of crops owned: " + this.crops.size() + "\n";
		for (FarmItem c : crops) {
			s += c.toString() + "\n\n";
		}
		return s;
	}

	/**
	 * Returns the details of all crops ready for harvest. If no crops are ready to
	 * be harvested, an empty string will be returned.
	 * 
	 * @return The crops that are ready for harvest.
	 */
	public String getCropsReadyForHarvest() {
		String s = "";
		for (FarmItem c : crops) {
			int time = ((Crop) c).getTimeUntilHarvest();
			if (time == 0) {
				s += c.toString() + "\n\n";
			}
		}
		return s;
	}

	/**
	 * Gets an crop of a given type, specified the type ID.
	 * 
	 * @param type Type of crop, identified by an ID number.
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
	 * @param type ID number of the crop type.
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
