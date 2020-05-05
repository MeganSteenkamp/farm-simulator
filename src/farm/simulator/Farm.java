package farm.simulator;

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
	private int numAvailableCrops = 6;
	private ArrayList<Crop> crops = new ArrayList<Crop>();
	private ArrayList<Animal> animals = new ArrayList<Animal>();
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
	 * String representation of a farm.
	 * 
	 * @return String representation of farm attributes.
	 */
	@Override
	public String toString() {
		return "Name: " + this.name + "\nType: " + this.type + "\nBalance: $" + this.balance
				+ "\nAvailable crop plots: " + this.numAvailableCrops;
	}

	/**
	 * Prints the status of the farm's crops and animals. This includes viewing a
	 * crop's time growing, the time left until crop's harvest and an animal's
	 * happiness levels.
	 */
	public void printCropAndAnimalStatus() {
		printCrops();
		printAnimals();
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
	 * Returns the balance of a farm.
	 * 
	 * @return Name of the farm.
	 */
	public void withdrawMoney(float amount) {
		if (amount < getBalance()) {
			this.balance -= amount;
		} else {
			// TODO: Should raise insufficient funds error
			System.out.println("Cannot afford");
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
	public void addCrop(Crop crop) {
		// Scale crop growth according to farm
		crop.addDaysToGrow(cropGrowthFactor);
		this.crops.add(crop);
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
	public void addAnimal(Animal animal) {
		animal.addToHappiness(animalHappinessFactor);
		this.animals.add(animal);
	}

	/**
	 * Returns the farm's crops.
	 * 
	 * @return the farm's crops.
	 */
	public ArrayList<Crop> getCrops() {
		return this.crops;
	}

	/**
	 * Returns the farm's animals.
	 * 
	 * @return the farm's animals.
	 */
	public ArrayList<Animal> getAnimals() {
		return this.animals;
	}

	/**
	 * Prints the details of the animals on the farm.
	 */
	public void printAnimals() {
		System.out.println("Number of animals owned: " + this.animals.size());
		System.out.println();
		for (Animal a : animals) {
			System.out.println(a.toString());
			System.out.println();
		}
	}

	/**
	 * Prints the details of the crops on the farm.
	 * 
	 * @param currentDay Current day number.
	 */
	public void printCrops() {
		System.out.println("Number of crops owned: " + this.crops.size());
		System.out.println();
		for (Crop c : crops) {
			System.out.println(c.toString());
			System.out.println();
		}
	}
}
