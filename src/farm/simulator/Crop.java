package farm.simulator;

/**
 * The abstract class implementing the base class for all crops.
 *
 * @author Lewis Marshall
 * @author Megan Steenkamp
 */

public abstract class Crop {
	private int id;
	private String name;
	private String description;
	private float purchasePrice;
	private float sellingPrice;
	private int daysToGrow;
	private int daysGrowing;

	/**
	 * Class constructor for the Crop class
	 *
	 * @param id  			id associated with type of crop
	 * @param name          name of the crop
	 * @param description   description for the item
	 * @param purchasePrice cost of crop to purchase
	 * @param sellingPrice  price received for the sale of crop
	 * @param daysToGrow    amount of days a crop takes to fully grow
	 * @param daysGrowing   the number of days the crop has been growing for
	 */
	public Crop(int id, String name, String description, float purchasePrice, float sellingPrice, int daysToGrow) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.daysToGrow = daysToGrow;
		this.daysGrowing = 0;
	}

	/**
	 * Return string representation of a crop.
	 */
	@Override
	public String toString() {
		return "Type ID: " + this.id + "\nName: " + this.name + "\nDays growing: " + getDaysGrowing() + " days(s)\nTime until harvest: "
				+ getTimeUntilHarvest() + " days(s)";
	}
	
	/**
	 * Returns the id of a given type of crop.
	 * @return Id of crop type.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the name of a crop.
	 *
	 * @param name of a crop.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the name of a crop.
	 *
	 * @return name of a crop.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the description for a crop.
	 *
	 * @param description for a crop.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the description for a crop.
	 *
	 * @return description for a crop.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the purchase price of a crop.
	 *
	 * @param purchasePrice of a crop.
	 */
	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/**
	 * Returns the purchase price of a crop.
	 *
	 * @return purchasePrice of a crop.
	 */
	public float getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * Sets the selling price of a crop.
	 *
	 * @param sellingPrice of a crop.
	 */
	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	/**
	 * Returns the selling price of a crop.
	 *
	 * @return sellingPrice of a crop.
	 */
	public float getSellingPrice() {
		return sellingPrice;
	}

	/**
	 * Scales the selling price of a crop by an external factor.
	 *
	 * @param scaleFactor of a crop determined by an external factor.
	 */
	public void scaleSellingPrice(float scaleFactor) {
		this.sellingPrice *= scaleFactor;
	}

	/**
	 * Adds to the days a crop will day to grow.
	 *
	 * @param addedDays Amount of days to increase growth by.
	 */
	public void addDaysToGrow(int addedDays) {
		this.daysToGrow += addedDays;
	}

	/**
	 * Returns the time taken (in days) for a crop to grow.
	 *
	 * @return daysToGrow of a crop.
	 */
	public int getDaysToGrow() {
		return daysToGrow;
	}

	/**
	 * Returns the amount of time a crop has been growing for.
	 *
	 * @return the number of days the crop has been growing
	 */
	public int getDaysGrowing() {
		return daysGrowing;
	}

	/**
	 * Returns the time remaining until the harvest of a crop.
	 *
	 * @return daysToGrow - number of days crop has been growing.
	 */
	public int getTimeUntilHarvest() {
		return (this.daysToGrow - this.daysGrowing);
	}

	/**
	 * Updates the growth of a crop by a given number of days.
	 * 
	 * @param days The days to be added to the number of days the crop has been
	 *             growing for.
	 */
	public void updateCropGrowth(int days) {
		this.daysGrowing += days;
	}
}
