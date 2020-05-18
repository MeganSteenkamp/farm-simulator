package farm.simulator;

import java.util.ArrayList;

/**
 *
 * This abstract class implements a farmer, the user's character.
 *
 * @author Lewis Marshall
 * @author Megan Steenkamp
 */

public class Farmer {
	private String name;
	private int age;
	private Farm farm;
	private ArrayList<FarmItem> items;

	/**
	 * Class constructor for the Farmer class
	 *
	 * @param name  The name of the farmer
	 * @param age   The age of the farmer
	 * @param items The items the farmer is in possession of
	 */
	public Farmer(String name, int age) {
		this.name = name;
		this.age = age;
		this.items = new ArrayList<FarmItem>();
	}

	/**
	 * String representation of a farm.
	 * 
	 * @return String representation of farm attributes.
	 */
	@Override
	public String toString() {
		return "Farmer: " + this.name + " (" + this.age + ")";
	}

	/**
	 * Set the farm that the farmer has.
	 * 
	 * @param farm The farm that the farmer is a part of.
	 */
	public void setFarm(Farm farm) {
		this.farm = farm;
	}

	/**
	 * Sets the name of the farmer
	 *
	 * @param name of the farmer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of a farmer.
	 *
	 * @return name of the farmer
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the farmer
	 *
	 * @param name of the farmer
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the age of a farmer.
	 *
	 * @return age of the farmer
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the items owned by the farmer.
	 * 
	 * @param items
	 */
	public void setItems(ArrayList<FarmItem> items) {
		this.items = items;
	}

	/**
	 * Add an item to the items owned.
	 * 
	 * @param item The item to be added.
	 */
	public void addItem(FarmItem item) {
		this.items.add(item);
	}

	/**
	 * Returns the inventory of the farmer's items.
	 *
	 * @return the items the farmer owns.
	 */
	public ArrayList<FarmItem> getItems() {
		return items;
	}

	/**
	 * Returns a stock count of currently owned items
	 */
	public String getItemStock() {
		String str = "";
		int fertilizer = 0;
		int compost = 0;
		int hoe = 0;
		int steroids = 0;
		int grain = 0;
		int silage = 0;

		for (FarmItem item : items) {
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
		if (fertilizer > 0) {
			str += "Fertilizer: " + fertilizer + "\n";
		}
		if (compost > 0) {
			str += "Compost: " + compost + "\n";
		}
		if (hoe > 0) {
			str += "Hoes: " + hoe + "\n";
		}
		if (steroids > 0) {
			str += "Steriods:" + steroids + "\n";
		}
		if (grain > 0) {
			str += "Grain:" + grain + "\n";
		}
		if (silage > 0) {
			str += "Silage:" + silage + "\n";
		}
		return str;
	}

	/**
	 * Tend to crop using 'water'. This will decrease crop growth by one day.
	 * 
	 * @param variety Variety of crop to be tended to.
	 */
	public void tendToCrop(int cropType) {
		for (FarmItem crop : this.farm.getCrops()) {
			if (crop.getId() == cropType) {
				// Decrease the days to grow by one
				((Crop) crop).addDaysToGrow(-1);
			}
		}
	}

	/**
	 * Tend to crop using an item. This will decrease crop growth by the factor
	 * given by the item.
	 * 
	 * @param variety Variety of crop to be tended to.
	 */
	public void tendToCrop(int cropType, Item item) {
		for (FarmItem crop : this.farm.getCrops()) {
			if (crop.getId() == cropType) {
				// Add to the growth based on the growth factor
				((Crop) crop).addDaysToGrow(item.getCropGrowthFactor());
			}
		}
	}

	/**
	 * Feed all animals in the farm using an item, adding to the animal's health.
	 * 
	 * @param item Item used to feed the animal.
	 */
	public void feedAnimals(Item item) {
		for (FarmItem animal : this.farm.getAnimals()) {
			((Animal) animal).addToHealth(item.getAnimalHealthFactor());
		}
	}

	/**
	 * Adds one point to each animal's happiness as the farmer plays with the
	 * animals.
	 */
	public void playWithAnimals() {
		for (FarmItem animal : this.farm.getAnimals()) {
			((Animal) animal).addToHappiness(1);
		}
	}

	/**
	 * Harvests crops. Crops are sold for their selling price property. Allows
	 * another crop to become available on the farm.
	 * 
	 * @return Money earned from harvesting crops.
	 */
	public float harvestCrops() {
		float moneyEarned = 0.0f;
		ArrayList<Crop> cropsToHarvest = new ArrayList<Crop>();
		for (FarmItem crop : this.farm.getCrops()) {
			Crop c = (Crop) crop;
			if (c.getTimeUntilHarvest() == 0) {
				moneyEarned += c.getSellingPrice();
				cropsToHarvest.add(c);
			}
		}
		for (Crop crop : cropsToHarvest) {
			this.farm.removeCrop(crop);
			// Free a plot up for a new crop to be planted
			this.farm.addToAvailableCrops(1);
		}
		return moneyEarned;
	}

	/**
	 * Increase the number of crops available on the farm by 1 and increase the
	 * happiness of all animals by 1.
	 */
	public void tendToFarmland() {
		this.farm.addToAvailableCrops(1);
		for (FarmItem animal : this.farm.getAnimals()) {
			((Animal) animal).addToHappiness(1);
		}
	}

	/**
	 * Gets an item of a given type, specified by an integer.
	 * 
	 * @param type Type of item, identified with an integer.
	 * @return Item if it is in the list of crops. Otherwise will return null.
	 */
	public FarmItem getItem(int type) {
		FarmItem item = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == type) {
				item = items.get(i);
				break;
			}
		}
		return item;
	}

	/**
	 * Whether the farmer has a item of a given type.
	 * 
	 * @param type Identifier of item type.
	 * @return True if item is owned. Else false.
	 */
	public boolean ownsItem(int type) {
		FarmItem item = getItem(type);
		if (item == null) {
			return false;
		}
		return true;
	}

	/**
	 * Gets an item of a given type and removes it from the available items.
	 * 
	 * @param type Type of item, identified with an integer.
	 * @return Item if it is in the list of items. Otherwise will return null.
	 */
	public FarmItem removeItem(int type) {
		FarmItem item = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getId() == type) {
				item = items.remove(i);
				break;
			}
		}
		return item;
	}
}
