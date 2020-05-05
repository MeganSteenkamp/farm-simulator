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
	private ArrayList<Item> items;

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
		this.items = new ArrayList<Item>();
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
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * Returns the inventory of the farmer's items.
	 *
	 * @return the items the farmer owns.
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Tend to crop using 'water'. This will decrease crop growth by one day.
	 * 
	 * @param variety Variety of crop to be tended to.
	 */
	public void tendToCrop(Crop variety) {
		for (Crop crop : this.farm.getCrops()) {
			if (crop.getName().equals(variety.getName())) {
				// Decrease the days to grow by one
				crop.setDaysToGrow(crop.getDaysToGrow() - 1);
			}
		}

	}

	/**
	 * Tend to crop using an item. This will decrease crop growth by the factor
	 * given by the item.
	 * 
	 * @param variety Variety of crop to be tended to.
	 */
	public void tendToCrop(Crop variety, Item item) {
		for (Crop crop : this.farm.getCrops()) {
			if (crop.getName().equals(variety.getName())) {
				// Decrease the growth based on the growth factor
				crop.setDaysToGrow(crop.getDaysToGrow() - item.getCropGrowthFactor());
			}
		}
	}

	public void feedAnimals(Item item) {

	}

	public void playWithAnimals() {

	}

	public void harvestCrops() {

	}

	public void tendToCrops() {

	}
}
