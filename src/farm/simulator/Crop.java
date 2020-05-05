package farm.simulator;

/**
 * The abstract class implementing the base class for all crops.
 *
 * @author Lewis Marshall
 * @author Megan Steenkamp
 */

public class Crop {

    public String name;
    public String description:
    public float purchasePrice;
    public float sellingPrice;
    public float daysToGrow;
    public int dayOfPurchase;

    /**
     * Class constructor for the Crop class
     *
     * @param name                  name of the crop
     * @param description           description for the item
     * @param purchasePrice         cost of crop to purchase
     * @param sellingPrice          price received for the sale of crop
     * @param daysToGrow            amount of days a crop takes to fully grow
     * @param dayOfPurchase         the day of crop purchase
     */

    // TODO: toString() method

    /**
     * Sets the name of a crop.
     *
     * @param name of a crop.
     */
    public void setName(String name) {this.name = name;}

    /**
     * Returns the name of a crop.
     *
     * @return name of a crop.
     */
    public String getName() {return name;}

    /**
     * Sets the description for a crop.
     *
     * @param description for a crop.
     */
    public void setDescription(String description) {this.description = description;}

    /**
     * Returns the description for a crop.
     *
     * @return description for a crop.
     */
    public String getDescription() {return description;}

    /**
     * Sets the purchase price of a crop.
     *
     * @param purchasePrice of a crop.
     */
    public void setPurchasePrice(float purchasePrice) {this.purchasePrice = purchasePrice;}

    /**
     * Returns the purchase price of a crop.
     *
     * @return purchasePrice of a crop.
     */
    public float getPurchasePrice() {return purchasePrice;}

    /**
     * Sets the selling price of a crop.
     *
     * @param sellingPrice of a crop.
     */
    public void setSellingPrice(float sellingPrice) {this.sellingPrice = sellingPrice;}

    /**
     * Returns the selling price of a crop.
     *
     * @return sellingPrice of a crop.
     */
    public float getSellingPrice() {return sellingPrice;}

    /**
     * scales the selling price of a crop by an external factor.
     *
     * @param scaleFactor of a crop determined by an external factor.
     */
    public void scaleSellingPrice(float scaleFactor) {this.sellingPrice *= scaleFactor;}

    /**
     * Sets the duration of time (in days) for a crop to grow.
     *
     * @param daysToGrow for a crop.
     */
    public void setDaysToGrow(float daysToGrow) {this.daysToGrow = daysToGrow;}

    /**
     * Returns the time taken (in days) for a crop to grow.
     *
     * @return daysToGrow of a crop.
     */
    public float getDaysToGrow() {return daysToGrow;}

    /**
     * Sets the day of purchase of a crop.
     *
     * @param dayOfPurchase of a crop.
     */
    public void setDayOfPurchase(int dayOfPurchase) {this.dayOfPurchase = dayOfPurchase;}

    /**
     * Returns the day of purchase of a crop.
     *
     * @return dayOfPurchase of a crop.
     */
    public int getDayOfPurchase() {return dayOfPurchase;}

    /**
     * Returns the amount of time a crop has been growing for.
     *
     * @return currentDay - dayOfPurchase for a crop.
     */
    public int getTimeGrowing() {
        // requires Day class implementation}
    }

    /**
     * Returns the time remaining until the harvest of a crop.
     *
     * @return daysToGrow - currentDay of a crop.
     */
    public int getTimeUntilHarvest() {
        // requires Day class implentation}
    }

    // TODO: scaleGrowthTime() method
}
