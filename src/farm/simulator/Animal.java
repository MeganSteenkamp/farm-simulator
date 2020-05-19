package farm.simulator;

import java.text.DecimalFormat;

/**
 * This abstract class implements the base class for all animals.
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public class Animal implements FarmItem {
	private int id;
	private float price;
	private String type;
	private String description;
	private int happiness;
	private int health;

	/**
	 * Class constructor for the Animal class
	 * 
	 * @param id 		 the id of the animal type
	 * @param price      the price of the animal
	 * @param animalType the breed of the animal
	 * @param happiness  the happiness status of the animal
	 * @param health     the health status of the animal
	 */
	public Animal(int id, float price, String type, String description, int happiness, int health) {
		this.id = id;
		this.price = price;
		this.type = type;
		this.description = description;
		this.happiness = happiness;
		this.health = health;
	}
	
	/**
	 * Returns the description for an animal.
	 *
	 * @return description for an animal.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Returns the id of a given type of animal.
	 * @return Id of animal type.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * String representation of an animal.
	 * 
	 * @return String representation of animal attributes.
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return "Type: " + this.type + "\nDescription: " + this.description +"\nPrice: $" + df.format(this.price)
		+ "\nHappiness: " + this.happiness + "\nHealth: " + this.health;
	}

	/**
	 * Sets the price of an animal.
	 * 
	 * @param Price of the animal.
	 */
	public void setPrice(float price) {
		if (price > 0) {
			this.price = price;
		} else {
			throw new IllegalArgumentException("A price cannot be negative");
		}
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
	 * A duplicate of returning the type of animal to be able to
	 * implement the FarmItem() interface.
	 * 
	 * @return Type of the animal.
	 */
	public String getName() {
		return this.type;
	}

	/**
	 * Returns the purchase price of an animal.
	 * 
	 * @return Price of the animal.
	 */
	public float getPurchasePrice() {
		return this.price;
	}

	/**
	 * Sets the happiness of an animal.
	 * 
	 * @param Happiness of the animal.
	 */
	public void setHappiness(int happiness) {
		if (happiness > 0) {
			this.happiness = happiness;
		} else {
			throw new IllegalArgumentException("Happiness cannot be negative");
		}
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
		if (health > 0) {
			this.health = health;
		} else {
			throw new IllegalArgumentException("Health cannot be negative");
		}
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
	 * Adds to the health of an animal by a given amount.
	 * Health can be deducted but cannot fall below zero.
	 * 
	 * @param bonus the amount by which to change the animal's health.
	 */
	public void addToHealth(int bonus) {
		if ((this.health + bonus) < 0) {
			this.health = 0;
		} else {
			this.health += bonus;
		}
	}

	/**
	 * Adds to the happiness of an animal by a given amount.
	 * Happiness can be deducted but cannot fall below zero.
	 * 
	 * @param bonus the amount by which to change the animal's happiness.
	 */
	public void addToHappiness(int bonus) {
		if ((this.happiness + bonus) < 0) {
			this.happiness = 0;
		} else {
			this.happiness += bonus;
		};
	}
}
