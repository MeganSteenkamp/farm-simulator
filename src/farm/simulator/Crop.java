package farm.simulator;

/**
 * The abstract class implementing the base class for all crops.
 *
 * @author Lewis Marshall
 * @author Megan Steenkamp
 */

public abstract class Crop {

	private String name;
	private String description;
	private float purchasePrice;
	private float sellingPrice;
	private int daysToGrow;
	// Game instance should set this
	private int dayOfPurchase;

	/**
	 * Class constructor for the Crop class
	 *
	 * @param name          name of the crop
	 * @param description   description for the item
	 * @param purchasePrice cost of crop to purchase
	 * @param sellingPrice  price received for the sale of crop
	 * @param daysToGrow    amount of days a crop takes to fully grow
	 * @param dayOfPurchase the day of crop purchase
	 */
	public Crop(String name, String description, float purchasePrice, float sellingPrice, int daysToGrow) {
		this.name = name;
		this.description = description;
		this.purchasePrice = purchasePrice;
		this.sellingPrice = sellingPrice;
		this.daysToGrow = daysToGrow;
	}

	// TODO: toString() method
	
	
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
	 * Sets the duration of time (in days) for a crop to grow.
	 *
	 * @param daysToGrow for a crop.
	 */
	public void setDaysToGrow(int daysToGrow) {
		this.daysToGrow = daysToGrow;
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
	 * Sets the day of purchase of a crop.
	 *
	 * @param dayOfPurchase of a crop.
	 */
	public void setDayOfPurchase(int dayOfPurchase) {
		this.dayOfPurchase = dayOfPurchase;
	}

	/**
	 * Returns the day of purchase of a crop.
	 *
	 * @return dayOfPurchase of a crop.
	 */
	public int getDayOfPurchase() {
		return dayOfPurchase;
	}

	/**
	 * Returns the amount of time a crop has been growing for.
	 *
	 * @return the number of days the crop has been growing
	 */
	public int getTimeGrowing(int currentDay) {
		return currentDay - this.dayOfPurchase;
	}

	/**
	 * Returns the time remaining until the harvest of a crop.
	 *
	 * @return daysToGrow - number of days crop has been growing.
	 */
	public int getTimeUntilHarvest(int currentDay) {
		return (this.daysToGrow - getTimeGrowing(currentDay));
	}

	// TODO: scaleGrowthTime() method
}
