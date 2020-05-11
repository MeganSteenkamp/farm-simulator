package farm.simulator;

import java.util.ArrayList;

/**
 * This class implements the General Store.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */

public class GeneralStore {

	private ArrayList<FarmItem> stock = new ArrayList<FarmItem>();

	/**
	 * Class constructor for the General Store class Begins with 2 of each Item,
	 * Crop and Animal.
	 */
	public GeneralStore() {
		for (int i = 0; i < 2; i++) {
			// Items
			stock.add(new Fertilizer());
			stock.add(new Compost());
			stock.add(new Hoe());
			stock.add(new Steroid());
			stock.add(new Silage());
			stock.add(new Grain());

			// Crops
			stock.add(new Rice());
			stock.add(new Wheat());
			stock.add(new Cotton());
			stock.add(new Coffee());
			stock.add(new Olive());
			stock.add(new Avocado());

			// Animals
			stock.add(new Chicken());
			stock.add(new Pig());
			stock.add(new Horse());
		}
	}

	/**
	 * Gets an item of a given type, specified by an integer.
	 * 
	 * @param type Type of item, identified with an integer.
	 * @return Item if it is in the list of items. Otherwise will return null.
	 */
	public FarmItem getItem(int type) {
		FarmItem item = null;
		for (int i = 0; i < stock.size(); i++) {
			if (stock.get(i).getId() == type) {
				item = stock.get(i);
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
	public FarmItem removeItem(int type) {
		FarmItem item = null;
		for (int i = 0; i < stock.size(); i++) {
			if (stock.get(i).getId() == type) {
				item = stock.remove(i);
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
	public FarmItem sellItem(int type) {
		FarmItem item = removeItem(type);
		if (item == null) {
			// TODO: Should give an error here
			System.out.println("Sorry, we do not sell that item.");
		}
		return item;
	}

	/**
	 * Whether farm item is in stock.
	 * 
	 * @param type Type ID of farm item.
	 * @return True if item is in stock. Else false.
	 */
	public boolean itemIsInStock(int type) {
		FarmItem item = getItem(type);
		if (item == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * Prints the details of a given farm item if it is in stock.
	 * 
	 * @param type Type ID of farm item.
	 */
	public void printItemDetails(int type) {
		FarmItem item = getItem(type);
		if (item == null) {
			// TODO: Should throw error here.
			System.out.println("Sorry, we do not have that item in stock.");
		} else {
			System.out.println(item.toString());
		}
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
		int silage = 0;

		for (FarmItem item : stock) {
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
			if (Silage.class.isInstance(item)) {
				silage += 1;
			}
		}
		System.out.println("We sell the following items. Please enter a number to find out more about an item.");
		System.out.println("[1] - Fertilizer stock: " + fertilizer);
		System.out.println("[2] - Compost stock: " + compost);
		System.out.println("[3] - Hoe stock: " + hoe);
		System.out.println("[4] - Steriod stock: " + steroids);
		System.out.println("[5] - Grain stock: " + grain);
		System.out.println("[6] - Silage stock: " + silage);
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

		for (FarmItem crop : stock) {
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
		System.out.println("[7] - Rice stock: " + rice);
		System.out.println("[8] - Wheat stock: " + wheat);
		System.out.println("[9] - Cotton stock: " + cotton);
		System.out.println("[10] - Coffee stock: " + coffee);
		System.out.println("[11] - Olive stock: " + olive);
		System.out.println("[12] - Avocado stock: " + avocado);
	}
	
	/**
	 * Prints a stock count of animal types for sale in the store.
	 */
	public void printAnimalStock() {
		int chicken = 0;
		int pig = 0;
		int horse = 0;

		for (FarmItem animal : stock) {
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
		System.out.println("[13] - Chicken stock: " + chicken);
		System.out.println("[14] - Pig stock: " + pig);
		System.out.println("[15] - Horse stock: " + horse);
	}
}