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

	private ArrayList<Item> fertilizer = new ArrayList<Item>();
	private ArrayList<Item> compost = new ArrayList<Item>();
	private ArrayList<Item> hoes = new ArrayList<Item>();
	private ArrayList<Item> steroids = new ArrayList<Item>();
	private ArrayList<Item> barns = new ArrayList<Item>();
	private ArrayList<Item> grain = new ArrayList<Item>();

	private ArrayList<Crop> rice = new ArrayList<Crop>();
	private ArrayList<Crop> wheat = new ArrayList<Crop>();
	private ArrayList<Crop> cotton = new ArrayList<Crop>();
	private ArrayList<Crop> coffee = new ArrayList<Crop>();
	private ArrayList<Crop> olive = new ArrayList<Crop>();
	private ArrayList<Crop> avocado = new ArrayList<Crop>();

	private ArrayList<Animal> chickens = new ArrayList<Animal>();
	private ArrayList<Animal> pigs = new ArrayList<Animal>();
	private ArrayList<Animal> horses = new ArrayList<Animal>();

	/**
	 * Class constructor for the General Store class Begins with 2 of each Item,
	 * Crop and Animal.
	 */
	public GeneralStore() {
		for (int i = 0; i < 2; i++) {
			// Items
			fertilizer.add(new Fertilizer());
			compost.add(new Compost());
			hoes.add(new Hoe());
			steroids.add(new Steroid());
			barns.add(new Barn());
			grain.add(new Grain());

			// Crops
			rice.add(new Rice());
			wheat.add(new Wheat());
			cotton.add(new Cotton());
			coffee.add(new Coffee());
			olive.add(new Olive());
			avocado.add(new Avocado());

			// Animals
			chickens.add(new Chicken());
			pigs.add(new Pig());
			horses.add(new Horse());
		}
	}

//======================================== ANIMAL FUNCTIONALITY ========================================

	/**
	 * Processes a list of animals to assess whether the animal is in stock and can
	 * be sold.
	 * 
	 * @param animals The list of animals to be processed.
	 * @return The animal to be sold if it is in stock. Otherwise it will return a
	 *         null object.
	 */
	private Animal processAnimals(ArrayList<Animal> animals) {
		Animal animal = null;
		if (animals.isEmpty()) {
			System.out.println("Sorry, we do not have that animal in stock.");
		} else {
			animal = animals.remove(0);
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
	public Animal sellAnimal(String type) {
		Animal animal = null;
		switch (type.toUpperCase()) {
		case "CHICKEN":
			animal = processAnimals(chickens);
			break;
		case "PIG":
			animal = processAnimals(pigs);
			break;
		case "HORSE":
			animal = processAnimals(horses);
			break;
		default:
			System.out.println("Sorry, we do not sell the '" + type + "' animal type.");
		}
		return animal;
	}

	/**
	 * Prints the number of each type of animal available for purchase.
	 */
	public void printAnimalStock() {
		System.out.println("Chickens: " + chickens.size());
		System.out.println("Pigs: " + pigs.size());
		System.out.println("Horses: " + horses.size());
	}

	/**
	 * Prints the details for a given type of animal, given it is in stock.
	 * 
	 * @param type Type of animal.
	 */
	public void printAnimalDetails(String type) {
		String result = "Sorry, we do not have that animal in stock.";
		switch (type.toUpperCase()) {
		case "CHICKEN":
			if (!chickens.isEmpty()) {
				result = chickens.get(0).toString();
			}
			break;
		case "PIG":
			if (!pigs.isEmpty()) {
				result = pigs.get(0).toString();
			}
			break;
		case "HORSE":
			if (!horses.isEmpty()) {
				result = horses.get(0).toString();
			}
			break;
		}
		System.out.println(result);
	}

//======================================== ITEM FUNCTIONALITY ========================================

	/**
	 * TODO  ---- tidy implementation
	 * @param type
	 * @return
	 */
	public Item getItem(int type) {
		Item item = null;
		switch (type) {
		case 1:
			item = fertilizer.get(0);
			break;
		case 2:
			item = compost.get(0);
			break;
		case 3:
			item = hoes.get(0);
			break;
		case 4:
			item = steroids.get(0);
			break;
		case 5:
			item = grain.get(0);
			break;
		case 6:
			item = barns.get(0);
			break;
		}
		return item;
	}
	
	/**
	 * Processes a list of items to assess whether the item is in stock and can be
	 * sold.
	 * 
	 * @param items The list of items to be processed.
	 * @return The item to be sold if it is in stock. Otherwise it will return a
	 *         null object.
	 */
	private Item processItems(ArrayList<Item> items) {
		Item item = null;
		if (items.isEmpty()) {
			System.out.println("Sorry, we do not have that item in stock.");
		} else {
			item = items.remove(0);
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
		Item item = null;
		switch (type) {
		case 1:
			item = processItems(fertilizer);
			break;
		case 2:
			item = processItems(compost);
			break;
		case 3:
			item = processItems(hoes);
			break;
		case 4:
			item = processItems(steroids);
			break;
		case 5:
			item = processItems(grain);
			break;
		case 6:
			item = processItems(barns);
			break;
		default:
			System.out.println("Sorry, we do not sell that item.");
		}
		return item;
	}

	/**
	 * Prints the number of each type of item available for purchase.
	 */
	public void printItemStock() {
		System.out.println("We sell the following items. Please enter a number to find out more about an item.");
		System.out.println("[1] - Fertilizer stock: " + fertilizer.size());
		System.out.println("[2] - Compost stock: " + compost.size());
		System.out.println("[3] - Hoes stock: " + hoes.size());
		System.out.println("[4] - Steriods stock:" + steroids.size());
		System.out.println("[5] - Barns stock:" + barns.size());
		System.out.println("[6] - Grain stock:" + grain.size());
		System.out.println("[7] - Return to main store");
	}

	/**
	 * Prints the details of a given item if it is in stock.
	 * 
	 * @param type Type of item.
	 * @return True if the item is in stock
	 */
	public boolean processItemDetails(int type) {
		boolean inStock = false;
		String result = "Sorry, we do not have that item in stock.";
		switch (type) {
		case 1:
			if (!fertilizer.isEmpty()) {
				inStock = true;
				result = fertilizer.get(0).toString();
			}
			break;
		case 2:
			if (!compost.isEmpty()) {
				inStock = true;
				result = compost.get(0).toString();
			}
			break;
		case 3:
			if (!hoes.isEmpty()) {
				inStock = true;
				result = hoes.get(0).toString();
			}
			break;
		case 4:
			if (!steroids.isEmpty()) {
				inStock = true;
				result = steroids.get(0).toString();
			}
			break;
		case 5:
			if (!barns.isEmpty()) {
				inStock = true;
				result = barns.get(0).toString();
			}
			break;
		case 6:
			if (!grain.isEmpty()) {
				inStock = true;
				result = grain.get(0).toString();
			}
			break;
		}

		System.out.println(result);
		return inStock;
	}

//======================================== CROP FUNCTIONALITY ========================================

	/**
	 * Processes a list of crops to assess whether the crop is in stock and can be
	 * sold.
	 * 
	 * @param items The list of crops to be processed.
	 * @return The crop to be sold if it is in stock. Otherwise it will return a
	 *         null object.
	 */
	private Crop processCrops(ArrayList<Crop> crops) {
		Crop crop = null;
		if (crops.isEmpty()) {
			System.out.println("Sorry, we do not have that crop in stock.");
		} else {
			crop = crops.remove(0);
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
	public Crop sellCrop(String type) {
		Crop crop = null;
		;
		switch (type.toUpperCase()) {
		case "RICE":
			crop = processCrops(rice);
			break;
		case "WHEAT":
			crop = processCrops(wheat);
			break;
		case "COTTON":
			crop = processCrops(coffee);
			break;
		case "OLIVE":
			crop = processCrops(olive);
			break;
		case "AVOCADO":
			crop = processCrops(avocado);
			break;
		default:
			System.out.println("Sorry, we do not sell the '" + type + "' item type.");
		}
		return crop;
	}

	/**
	 * Prints the number of each type of crop available for purchase.
	 */
	public void printCropStock() {
		System.out.println("Rice: " + rice.size());
		System.out.println("Wheat: " + wheat.size());
		System.out.println("Cotton: " + cotton.size());
		System.out.println("Coffee: " + coffee.size());
		System.out.println("Olive: " + olive.size());
		System.out.println("Avocado: " + avocado.size());
	}

	/**
	 * Prints the details for a given type of crop, given it is in stock.
	 * 
	 * @param type Type of crop.
	 */
	public void printCropDetails(String type) {
		String result = "Sorry, we do not have that crop in stock.";
		switch (type.toUpperCase()) {
		case "RICE":
			if (!rice.isEmpty()) {
				result = rice.get(0).toString();
			}
			break;
		case "WHEAT":
			if (!wheat.isEmpty()) {
				result = wheat.get(0).toString();
			}
			break;
		case "COTTON":
			if (!cotton.isEmpty()) {
				result = cotton.get(0).toString();
			}
			break;
		case "COFFEE":
			if (!coffee.isEmpty()) {
				result = coffee.get(0).toString();
			}
			break;
		case "OLIVE":
			if (!olive.isEmpty()) {
				result = olive.get(0).toString();
			}
			break;
		case "AVOCADO":
			if (!avocado.isEmpty()) {
				result = avocado.get(0).toString();
			}
			break;
		}
		System.out.println(result);
	}
}
