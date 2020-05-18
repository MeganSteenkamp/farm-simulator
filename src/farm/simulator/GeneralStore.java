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

	/**
	 * Gets an item of a given type, specified by an integer.
	 * This method is also used for selling items as we are using 
	 * a concept of unlimited stock.
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
	 * Sells an item and removes it from inventory.
	 * 
	 * @param type Type of item to be purchased.
	 * @return The item that has been purchased. Returns a null object if the item
	 *         is out of stock.
	 */
	public FarmItem sellItem(int type) {
		FarmItem item = getItem(type);
		return item;
	}

	/**
	 * Prints the details of a given farm item.
	 * 
	 * @param type Type ID of farm item.
	 */
	public String getItemDetails(int type) {
		FarmItem item = getItem(type);
		return item.toString();
	}
}