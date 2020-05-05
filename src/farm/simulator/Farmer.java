package farm.simulator;

import java.util.ArrayList;

/**
 *
 * This abstract class implements a farmer, the user's character.
 *
 * @author Lewis Marshall
 * @author Megan Steenkamp
 */

public abstract class Farmer {
    private String name;
    private int age;
    private ArrayList<item> items = new ArrayList<~>();

    /**
     * Class constructor for the Farmer class
     *
     * @param name                  The name of the farmer
     * @param age                   The age of the farmer
     * @param items                 The items the farmer is in possession of
     */

    /**
     * Sets the name of the farmer
     *
     * @param name of the farmer
     */
    public void setName(String name) {this.name = name;    }

    /**
     * Returns the name of a farmer.
     *
     * @return name of the farmer
     */
    public String getName() {return name;}

    /**
     * Sets the name of the farmer
     *
     * @param name of the farmer
     */
    public void setAge(int age) {this.age = age;}

    /**
     * Returns the age of a farmer.
     *
     * @return age of the farmer
     */
    public int getAge() {return age;}

    public void setItems(ArrayList<item> items) {this.items = items;}

    /**
     * Returns the inventory of the farmer's items.
     *
     * @return age of the farmer
     */

    public ArrayList<item> getItems() {return items;}

    public void tendToCrop(item) {

    }

    public void feedAnimals(item) {

    }

    public void playWithAnimals() {

    }

    public void harvestCrops() {

    }

    public void tendToCrops() {

    }
}
