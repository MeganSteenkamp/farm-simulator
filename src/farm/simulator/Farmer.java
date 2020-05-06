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
	 * Add an item to the items owned.
	 * 
	 * @param item The item to be added.
	 */
	public void addItem(Item item) {
		this.items.add(item);
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
	 * Prints the details of the items owned by the farmer.
	 */
	public void printItems() {
		System.out.println("Number of items owned: " + this.items.size());
		System.out.println();
		for (Item i : items) {
			System.out.println(i.toString());
			System.out.println();
		}
	}

	/**
	 * Prints a stock count of currently owned items
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
		System.out.println("Fertilizer: " + fertilizer);
		System.out.println("Compost: " + compost);
		System.out.println("Hoes: " + hoe);
		System.out.println("Steriods:" + steroids);
		System.out.println("Barns:" + barn);
		System.out.println("Grain:" + grain);
	}

	/**
	 * Tend to crop using 'water'. This will decrease crop growth by one day.
	 * 
	 * @param variety Variety of crop to be tended to.
	 */
	public void tendToCrop(int cropType) {
		for (Crop crop : this.farm.getCrops()) {
			if (crop.getId() == cropType) {
				// Decrease the days to grow by one
				crop.addDaysToGrow(-1);
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
		for (Crop crop : this.farm.getCrops()) {
			if (crop.getId() == cropType) {
				// Add to the growth based on the growth factor
				crop.addDaysToGrow(item.getCropGrowthFactor());
			}
		}
	}

	public void feedAnimals(Item item) {
		for (Animal animal : this.farm.getAnimals()) {
			animal.addToHealth(item.getAnimalHealthFactor());
		}
	}

	public void playWithAnimals() {
		for (Animal animal : this.farm.getAnimals()) {
			animal.addToHappiness(1);
		}
	}

	public float harvestCrops() {
		float moneyEarned = 0.0f;
		ArrayList<Crop> cropsToHarvest = new ArrayList<Crop>();
		for (Crop crop : this.farm.getCrops()) {
			if (crop.getTimeUntilHarvest() == 0) {
				System.out.println("Well done, your " + crop.getName() + " is ready for harvest");
				System.out.println("It has sold for $" + crop.getSellingPrice());
				moneyEarned += crop.getSellingPrice();
				cropsToHarvest.add(crop);
			}
		}

		for (Crop crop : cropsToHarvest) {
			this.farm.removeCrop(crop);
		}

		return moneyEarned;
	}
	
	// TODO
	public void tendToFarmland() {}

	/**
	 * Prints a description of an action the farmer can perform and its benefits
	 */
	public void printDescription(int actionChoice) {
		switch (actionChoice) {
		case 1: 
			System.out.println("Tending to the crops speeds up their growing process by a small amount, decreasing the amount of time until they can be harvested.");
			System.out.println("Only one type of crop can be harvested at a time.");
			System.out.println("An item or water can be used to tend to the crops.");
			break;
		case 3:
			System.out.println("Feeding your animals will increase their health.");
			System.out.println("An item must be used to do this.");
			break;
		case 4:
			System.out.println("Playing with animals makes their happiness increase.");
			break;
		case 5:
			System.out.println("Any crops that have fully grown can be harvested for a money bonus");
			break;
		case 6:
			System.out.println("Tending to the farm's land keeps the farm tidy and well maintained.");
			System.out.println("This allows for more crops to be grown and keeps animals happier for longer.");
			break;
		}
	}
	
	/**
	 * Gets an item of a given type, specified by an integer.
	 * 
	 * @param type Type of item, identified with an integer.
	 * @return Item if it is in the list of crops. Otherwise will return null.
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
	 * Whether the farmer has a item of a given type.
	 * 
	 * @param type Identifier of item type.
	 * @return True if item is in stock. Else false.
	 */
	public boolean ownsItem(int type) {
		Item item = getItem(type);
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
}
