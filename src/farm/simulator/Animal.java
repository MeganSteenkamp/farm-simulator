package farm.simulator;

/**
 * This abstract class implements the base class for all animals.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public abstract class Animal {

	private float price;
	private String type;
	private int happiness;
	private int health;
	private boolean isAlive = true;

	/**
	 * Class constructor for the Animal class
	 * 
	 * @param price      the price of the animal
	 * @param animalType the breed of the animal
	 * @param happiness  the happiness status of the animal
	 * @param health     the health status of the animal
	 */
	public Animal(float price, String type, int happiness, int health) {
		this.price = price;
		this.type = type;
		this.happiness = happiness;
		this.health = health;
	}

	/**
	 * String representation of an animal.
	 * 
	 * @return String representation of animal attributes.
	 */
	@Override
	public String toString() {
		return "Type: " + this.type + "\nPrice: " + this.price + "\nHappiness: " + this.happiness + "\nHealth: "
				+ this.health;
	}

	/**
	 * Sets the price of an animal.
	 * 
	 * @param Price of the animal.
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Returns the type of an animal.
	 * 
	 * @return Type of the animal.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Returns the price of an animal.
	 * 
	 * @return Price of the animal.
	 */
	public float getPrice() {
		return this.price;
	}

	/**
	 * Sets the happiness of an animal.
	 * 
	 * @param Happiness of the animal.
	 */
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	/**
	 * Returns the happiness of an animal.
	 * 
	 * @return Happiness of the animal.
	 */
	public float getHappiness() {
		return this.happiness;
	}

	/**
	 * Sets the health of an animal.
	 * 
	 * @param Health of the animal.
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Returns the health of an animal.
	 * 
	 * @return Health of the animal.
	 */
	public float getHealth() {
		return this.health;
	}

	/**
	 * Adds to the health of an animal by a given amount. If health reaches 0, the
	 * animal dies.
	 * 
	 * @param scaleFactor the amount by which to change the animal's health.
	 * @return the animal's current health status.
	 */
	public int scaleHealth(int scaleFactor) {
		this.health += scaleFactor;
		if (this.health == 0) {
			this.isAlive = false;
		}
		return this.health;
	}

	/**
	 * Adds to the happiness of an animal by a given amount. If happiness reaches 0,
	 * the animal dies.
	 * 
	 * @param scaleFactor the amount by which to change the animal's happiness.
	 * @return the animal's current happiness status.
	 */
	public int scaleHappiness(int scaleFactor) {
		this.happiness += scaleFactor;
		if (this.happiness == 0) {
			this.isAlive = false;
		}
		return this.happiness;
	}
}
