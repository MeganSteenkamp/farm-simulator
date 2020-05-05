package farm.simulator;

/**
 * The abstract class implementing the base class for all items.
 *
 * @author Lewis Marshall
 * @author Megan Steenkamp
 */

public abstract class Item {
	private int id;
	private String name;
	private String description;
	private float price;
	private int cropGrowthFactor;
	private int animalHealthFactor;

	/**
	 * Class constructor for the Item class
	 *
	 * @param id 				 identification number of item type
	 * @param name               name of the item
	 * @param description        description of the item
	 * @param price              price of the item
	 * @param cropGrowthFactor   scaling factor for crop growth
	 * @param animalHealthFactor scaling factor for animal health
	 * 
	 */
	public Item(int id, String name, String description, float price, int cropGrowthFactor, int animalHealthFactor) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.cropGrowthFactor = cropGrowthFactor;
		this.animalHealthFactor = animalHealthFactor;
	}

	/**
	 * String representation of an item.
	 * 
	 * @return String representation of item attributes.
	 */
	@Override
	public String toString() {
		return "Name: " + this.name + "\nDescription: " + this.description + "\nPrice: " + this.price + "\nAdded crop growth: " 
				+ this.cropGrowthFactor + " day(s)" + "\nAnimal health bonus: "+ this.animalHealthFactor + " point(s)";
	}
	
	/**
	 * Returns the id of a given type of item.
	 * @return Id of item type.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the price of an item.
	 *
	 * @param price of an item.
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Returns the price of an item.
	 *
	 * @return price of an item.
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Sets the name of an item.
	 *
	 * @param name of an item.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of an item.
	 *
	 * @return name of an item.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the factor for scaling crop growth for an item.
	 *
	 * @param cropGrowthFactor of an item.
	 */
	public void setCropGrowthFactor(int cropGrowthFactor) {
		this.cropGrowthFactor = cropGrowthFactor;
	}

	/**
	 * Returns the factor to scale crop growth time by when using an item.
	 *
	 * @return cropGrowthFactor of an item.
	 */
	public int getCropGrowthFactor() {
		return cropGrowthFactor;
	}

	/**
	 * Sets the factor for scaling animal health for an item.
	 *
	 * @param animalHealthFactor of an item.
	 */
	public void setAnimalHealthFactor(int animalHealthFactor) {
		this.animalHealthFactor = animalHealthFactor;
	}

	/**
	 * Returns the factor to scale animal health by when using an item.
	 *
	 * @return animalHealthFactor of an item.
	 */
	public int getAnimalHealthFactor() {
		return animalHealthFactor;
	}

	/**
	 * Sets the description for an item.
	 *
	 * @param description for an item.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the description for an item.
	 *
	 * @return description for an item.
	 */
	public String getDescription() {
		return description;
	}
}
