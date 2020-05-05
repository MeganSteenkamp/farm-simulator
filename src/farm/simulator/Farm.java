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
	 * @param name Name of farm.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the farmer of the farm.
	 * @param farmer Farmer object representing the farm's farmer.
	 */
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	
	/**
	 * Returns the farmer of the farm.
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
		return "Name: " + this.name + "\nType: " + this.type + "\nBalance: $" + this.balance + "\nAvailable crop plots: "
				+ this.numAvailableCrops;
	}
	
	/**
	 * Prints the status of the farm's crops and animals. This includes viewing a crop's time growing, the time left
	 * until crop's harvest and an animal's happiness levels
	 */
	public void printCropAndAnimalStatus() {
		// TODO: Iterate over crops and animals and use their toString method.
		System.out.println("Testing: printing crop and animal status");
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
		this.crops.add(crop);
	}

	/**
	 * Adds a new animal to the farm.
	 * 
	 * @param animal Animal to be added.
	 */
	public void addAnimal(Animal animal) {
		animal.scaleHappiness(this.animalHappinessFactor);
		this.animals.add(animal);
	}
	
	/**
	 * Returns the farm's crops.
	 * @return the farm's crops.
	 */
	public ArrayList<Crop> getCrops() {
		return this.crops;
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
