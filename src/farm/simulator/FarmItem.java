package farm.simulator;

/**
 * This interface declares the functions that must be implemented by all Farm Items (Animals, Crops, Items).
 * 
 * @author Megan Steenkamp
 * @version 1.0
 */
public interface FarmItem {
	public String toString();
	public String getName();
	public int getId();
	public float getPurchasePrice();
	public String getDescription();
}
