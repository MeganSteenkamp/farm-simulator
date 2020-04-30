package farm.simulator;

import java.util.ArrayList;

/**
 * This class implements the General Store.
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */

enum AnimalType {
	CHICKEN,
	PIG, 
	HORSE
}

public class GeneralStore {
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Crop> crops = new ArrayList<Crop>();
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	
	/**
	 * Class constructor for the General Store class
	 * Begins with 2 of each item, crop and animal.
	 */
	public GeneralStore() {
		for (int i = 0; i < 2; i++) {
			// TODO: Add animals and crops
			animals.add(new Chicken());
			animals.add(new Pig());
			animals.add(new Horse());
		}
	}
	
	/**
	 * Sells an animal and removes it from inventory.
	 * @param type Type of animal to be purchased.
	 * @return The animal that has been purchased.
	 */
	public Animal sellAnimal(String type) {
		Animal newAnimal = null; // Will return if request is invalid
		try {
			AnimalType animalType = AnimalType.valueOf(type.toUpperCase()); // This line will throw if it is not valid
			boolean inStock = false;
			for (Animal a: animals) {
				if (a.getType().toUpperCase().matches(animalType.toString())) {
					inStock = true;
					animals.remove(a);
					newAnimal = a;
					break;
				}
			}
			if (!inStock) {
				System.out.println("Sorry, this animal is out of stock.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Error: The animal type provided is invalid.");
		}
		return newAnimal;
	}
	
	/**
	 * Sells an item and removes it from inventory.
	 * @param type Type of item to be purchased.
	 * @return The item that has been purchased.
	 */
	
	//TODO: Implement this
	/*
	public Item sellItem(String type) {}
	*/
	
	/**
	 * Sells a crop and removes it from inventory.
	 * @param type Type of crop to be purchased.
	 * @return The crop that has been purchased.
	 */
	
	//TODO: Implement this
	/*
	public Crop sellCrop(String type) {}
	*/
	
	/**
	 * Prints the number of each type of animal available for purchase.
	 */
	public void printAnimalStock() {
		for (AnimalType type : AnimalType.values()) {
			String line = "";
			line += type.toString() + ": ";
			int count = 0;
			for (Animal a: animals) {
				if (a.getType().toUpperCase().matches(type.toString())) {
					count++;
				}
			}
			line += count;
			if (count > 0) {
				
			}
			System.out.println(line);
		}
	}
	
	/**
	 * Prints the number of each type of item available for purchase.
	 */
	//TODO: Implement this
	public void printItemStock() {}

	/**
	 * Prints the number of each type of crop available for purchase.
	 */
	//TODO: Implement this
	public void printCropStock() {}
	
	/**
	 * Prints the details of the animals available for purchase.
	 */
	public void printAnimalDetails() {
		for (Animal a : animals) {
			System.out.println(a.toString());
			System.out.println();
		}
	}
	
	/**
	 * Prints the details of the crops available for purchase.
	 */
	public void printCropDetails() {
		for (Crop c : crops) {
			System.out.println(c.toString());
			System.out.println();
		}
	}
	
	/**
	 * Prints the details of the items available for purchase.
	 */
	public void printItemDetails() {
		for (Item i : items) {
			System.out.println(i.toString());
			System.out.println();
		}
	}
	
	// TODO: Implement showing the items the farmer owns once the Farmer class is made
	
	
	public static void main(String[] args) {
		// TODO: Remove this after testing
		GeneralStore g = new GeneralStore();
		g.printAnimalStock();
		g.sellAnimal("Chicken");
		g.printAnimalStock();
		g.sellAnimal("Chicken");
		g.printAnimalStock();
		g.sellAnimal("Chicken");
		g.sellAnimal("Chicksdfen");
	}
	
	
	
	
	
	
}
