package farm.simulator;

import java.util.ArrayList;

/**
 * This class implements the General Store.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */

//TODO: Implement showing the items the farmer owns once the Farmer class is made

public class GeneralStore {

	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Crop> crops = new ArrayList<Crop>();
	private ArrayList<Animal> animals = new ArrayList<Animal>();

	/**
	 * Class constructor for the General Store class Begins with 2 of each Item,
	 * Crop and Animal.
	 */
	public GeneralStore() {
		for (int i = 0; i < 2; i++) {
			// Items
			items.add(new Fertilizer());
			items.add(new Compost());
			items.add(new Hoe());
			items.add(new Steroid());
			items.add(new Barn());
			items.add(new Grain());

			// Crops
			crops.add(new Rice());
			crops.add(new Wheat());
			crops.add(new Cotton());
			crops.add(new Coffee());
			crops.add(new Olive());
			crops.add(new Avocado());

			// Animals
			animals.add(new Chicken());
			animals.add(new Pig());
			animals.add(new Horse());
		}
	}

//======================================== ITEM FUNCTIONALITY ========================================

	/**
	 * Gets an item of a given type, specified by an integer.
	 * 
	 * @param type Type of item, identified with an integer.
	 * @return Item if it is in the list of items. Otherwise will return null.
	 */
	public Item getItem(int type) {
		Item item = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == type) {
				item = items.get(i);
				break;
			}
		}
		return item;
	}

	/**
	 * Gets an item of a given type and removes it from the available items.
	 * 
	 * @param type Type of item, identified with an integer.
	 * @return Item if it is in the list of items. Otherwise will return null.
	 */
	public Item removeItem(int type) {
		Item item = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == type) {
				item = items.remove(i);
				break;
			}
		}
		return item;
	}

	/**
	 * Sells an item and removes it from inventory.
	 * 
	 * @param type Type of item to be purchased.
	 * @return The item that has been purchased. Returns a null object if the item
	 *         is out of stock.
	 */
	public Item sellItem(int type) {
		Item item = removeItem(type);
		if (item == null) {
			// TODO: Should give an error here
			System.out.println("Sorry, we do not sell that item.");
		}
		return item;
	}

	/**
	 * Whether item is in stock.
	 * 
	 * @param type Identifier of item type.
	 * @return True if item is in stock. Else false.
	 */
	public boolean itemIsInStock(int type) {
		Item item = getItem(type);
		if (item == null) {
			return false;
		}
		return true;
	}

	/**
	 * Prints a stock count of items in the store.
	 */
	public void printItemStock() {
		int fertilizer = 0;
		int compost = 0;
		int hoe = 0;
		int steroids = 0;
		int grain = 0;
		int barn = 0;

		for (Item item : items) {
			if (Fertilizer.class.isInstance(item)) {
				fertilizer += 1;
			}
			if (Compost.class.isInstance(item)) {
				compost += 1;
			}
			if (Hoe.class.isInstance(item)) {
				hoe += 1;
			}
			if (Steroid.class.isInstance(item)) {
				steroids += 1;
			}
			if (Grain.class.isInstance(item)) {
				grain += 1;
			}
			if (Barn.class.isInstance(item)) {
				barn += 1;
			}
		}
		System.out.println("We sell the following items. Please enter a number to find out more about an item.");
		System.out.println("[1] - Fertilizer stock: " + fertilizer);
		System.out.println("[2] - Compost stock: " + compost);
		System.out.println("[3] - Hoe stock: " + hoe);
		System.out.println("[4] - Steriod stock: " + steroids);
		System.out.println("[5] - Grain stock: " + grain);
		System.out.println("[6] - Barn stock: " + barn);
	}

	/**
	 * Prints the details of a given item if it is in stock.
	 * 
	 * @param type Type of item.
	 */
	public void printItemDetails(int type) {
		Item item = getItem(type);
		if (item == null) {
			// TODO: Should throw error here.
			System.out.println("Sorry, we do not have that item in stock.");
		} else {
			System.out.println(item.toString());
		}
	}

// ======================================== CROP FUNCTIONALITY ========================================

	/**
	 * Gets an crop of a given type, specified by an integer.
	 * 
	 * @param type Type of crop, identified with an integer.
	 * @return Crop if it is in the list of crops. Otherwise will return null.
	 */
	public Crop getCrop(int type) {
		Crop crop = null;
		for (int i = 0; i < crops.size(); i++) {
			if (crops.get(i).getId() == type) {
				crop = crops.get(i);
				break;
			}
		}
		return crop;
	}

	/**
	 * Gets a crop of a given type and removes it from the available items.
	 * 
	 * @param type Type of crop, identified with an integer.
	 * @return Crop if it is in the list of crops. Otherwise will return null.
	 */
	public Crop removeCrop(int type) {
		Crop crop = null;
		for (int i = 0; i < crops.size(); i++) {
			if (crops.get(i).getId() == type) {
				crop = crops.remove(i);
				break;
			}
		}
		return crop;
	}

	/**
	 * Sells a crop and removes it from inventory.
	 * 
	 * @param type Type of crop to be purchased.
	 * @return The crop that has been purchased. Returns a null object if the crop
	 *         is out of stock.
	 */
	public Crop sellCrop(int type) {
		Crop crop = removeCrop(type);
		if (crop == null) {
			// TODO: Should give an error here
			System.out.println("Sorry, we do not sell that item.");
		}
		return crop;
	}

	/**
	 * Whether a crop is in stock.
	 * 
	 * @param type Identifier of crop type.
	 * @return True if crop is in stock. Else false.
	 */
	public boolean cropIsInStock(int type) {
		Crop crop = getCrop(type);
		if (crop == null) {
			return false;
		}
		return true;
	}

	/**
	 * Prints a stock count of crop types for sale in the store.
	 */
	public void printCropStock() {
		int rice = 0;
		int wheat = 0;
		int cotton = 0;
		int coffee = 0;
		int olive = 0;
		int avocado = 0;

		for (Crop crop : crops) {
			if (Rice.class.isInstance(crop)) {
				rice += 1;
			}
			if (Wheat.class.isInstance(crop)) {
				wheat += 1;
			}
			if (Cotton.class.isInstance(crop)) {
				cotton += 1;
			}
			if (Coffee.class.isInstance(crop)) {
				coffee += 1;
			}
			if (Olive.class.isInstance(crop)) {
				olive += 1;
			}
			if (Avocado.class.isInstance(crop)) {
				avocado += 1;
			}
		}
		System.out.println("We sell the following crops. Please enter a number to find out more about a crop.");
		System.out.println("[1] - Rice stock: " + rice);
		System.out.println("[2] - Wheat stock: " + wheat);
		System.out.println("[3] - Cotton stock: " + cotton);
		System.out.println("[4] - Coffee stock: " + coffee);
		System.out.println("[5] - Olive stock: " + olive);
		System.out.println("[6] - Avocado stock: " + avocado);
	}

	/**
	 * Prints the details of a given crop if it is in stock.
	 * 
	 * @param type Type of crop.
	 */
	public void printCropDetails(int type) {
		Crop crop = getCrop(type);
		if (crop == null) {
			// TODO: Should throw error here.
			System.out.println("Sorry, we do not have that item in stock.");
		} else {
			System.out.println(crop.toString());
		}
	}

// ======================================== ANIMAL FUNCTIONALITY ========================================

	/**
	 * Gets an animal of a given type, specified by an integer.
	 * 
	 * @param type Type of animal, identified with an integer.
	 * @return Animal if it is in the list of animals. Otherwise will return null.
	 */
	public Animal getAnimal(int type) {
		Animal animal = null;
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getId() == type) {
				animal = animals.get(i);
				break;
			}
		}
		return animal;
	}

	/**
	 * Gets an animal of a given type and removes it from the available items.
	 * 
	 * @param type Type of animal, identified with an integer.
	 * @return Animal if it is in the list of animals. Otherwise will return null.
	 */
	public Animal removeAnimal(int type) {
		Animal animal = null;
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getId() == type) {
				animal = animals.remove(i);
				break;
			}
		}
		return animal;
	}

	/**
	 * Sells an animal and removes it from inventory.
	 * 
	 * @param type Type of animal to be purchased.
	 * @return The animal that has been purchased. Returns a null object if the
	 *         animal is out of stock.
	 */
	public Animal sellAnimal(int type) {
		Animal animal = removeAnimal(type);
		if (animal == null) {
			// TODO: Should give an error here
			System.out.println("Sorry, we do not sell that item.");
		}
		return animal;
	}

	/**
	 * Whether an animal is in stock.
	 * 
	 * @param type Identifier of animal type.
	 * @return True if animal is in stock. Else false.
	 */
	public boolean animalIsInStock(int type) {
		Animal animal = getAnimal(type);
		if (animal == null) {
			return false;
		}
		return true;
	}

	/**
	 * Prints a stock count of animal types for sale in the store.
	 */
	public void printAnimalStock() {
		int chicken = 0;
		int pig = 0;
		int horse = 0;

		for (Animal animal : animals) {
			if (Chicken.class.isInstance(animal)) {
				chicken += 1;
			}
			if (Pig.class.isInstance(animal)) {
				pig += 1;
			}
			if (Horse.class.isInstance(animal)) {
				horse += 1;
			}
		}
		System.out.println("We sell the following animals. Please enter a number to find out more about an animal.");
		System.out.println("[1] - Chicken stock: " + chicken);
		System.out.println("[2] - Pig stock: " + pig);
		System.out.println("[3] - Horse stock: " + horse);
	}

	/**
	 * Prints the details of a given crop if it is in stock.
	 * 
	 * @param type Type of crop.
	 */
	public void printAnimalDetails(int type) {
		Animal animal = getAnimal(type);
		if (animal == null) {
			// TODO: Should throw error here.
			System.out.println("Sorry, we do not have that item in stock.");
		} else {
			System.out.println(animal.toString());
		}
	}

}
