package farm.simulator;

import java.util.ArrayList;

/**
 * This class implements the General Store, where various farming items can be
 * viewed and purchased.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */

public class GeneralStore {

	private ArrayList<FarmItem> stock = new ArrayList<FarmItem>();

	/**
	 * Class constructor for the General Store class. Stocks one instance of each
	 * Item, Crop and Animal.
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
	 * Gets an item of a given type, specified by a type ID. This method is also
	 * used for selling items as the concept of unlimited stock is used.
	 * 
	 * @param type Type ID of the item.
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
	 * Sells an item. As the concept of unlimited stock is used, this item is not
	 * removed from the class.
	 * 
	 * @param type Type ID of item to be purchased.
	 * @return The item that has been purchased. Returns a null object if the item
	 *         type does not exist in the store.
	 */
	public FarmItem sellItem(int type) {
		FarmItem item = getItem(type);
		return item;
	}

	/**
	 * Returns the details of a given farm item.
	 * 
	 * @param type Type ID of farm item.
	 * @return The details of the given item.
	 */
	public String getItemDetails(int type) {
		FarmItem item = getItem(type);
		if (item != null) {
			return item.toString();
		} else {
			return "";
		}
	}
}