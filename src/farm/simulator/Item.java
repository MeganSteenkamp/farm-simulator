package farm.simulator;

/**
 * The abstract class implementing the base class for all items.
 *
 * @author Lewis Marshall
 * @author Megan Steenkamp
 */

public abstract class Item {

    private float price;
    private String name;
    private float cropGrowthFactor;
    private float animalHealthFactor;
    private String description;

    /**
     * Class constructor for the Item class
     *
     * @param price                 price of the item
     * @param name                  name of the item
     * @param cropGrowthFactor      scaling factor for crop growth
     * @param animalHealthFactor    scaling factor for animal health
     * @param description           description of the item
     */

    // TODO: tostring() method

    /**
     * Sets the price of an item.
     *
     * @param price of an item.
     */
    public void setPrice(float price) {this.price = price;}

    /**
     * Returns the price of an item.
     *
     * @return price of an item.
     */
    public float getPrice() {return price;}

    /**
     * Sets the name of an item.
     *
     * @param name of an item.
     */
    public void setName(String name) {this.name = name;}

    /**
     * Returns the name of an item.
     *
     * @return name of an item.
     */
    public String getName() {return name;}

    /**
     * Sets the factor for scaling crop growth for an item.
     *
     * @param cropGrowthFactor of an item.
     */
    public void setCropGrowthFactor(float cropGrowthFactor) {this.cropGrowthFactor = cropGrowthFactor;}

    /**
     * Returns the factor to scale crop growth time by when using an item.
     *
     * @return cropGrowthFactor of an item.
     */
    public float getCropGrowthFactor() {return cropGrowthFactor;}

    /**
     * Sets the factor for scaling animal health for an item.
     *
     * @param animalHealthFactor of an item.
     */
    public void setAnimalHealthFactor(float animalHealthFactor) {this.animalHealthFactor = animalHealthFactor;}

    /**
     * Returns the factor to scale animal health by when using an item.
     *
     * @return animalHealthFactor of an item.
     */
    public float getAnimalHealthFactor() {return animalHealthFactor;}

    /**
     * Sets the description for an item.
     *
     * @param description for an item.
     */
    public void setDescription(String description) {this.description = description;}

    /**
     * Returns the description for an item.
     *
     * @return description for an item.
     */
    public String getDescription() {return description;}
}
