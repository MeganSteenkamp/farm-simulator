package farm.simulator;

/**
 * This interface declares the functions that must be implemented by all farm items (animals, crops, items).
 * 
 * @author Megan Steenkamp
 * @author Lewis Marshall
 */
public interface FarmItem {
	public String toString();
	public String getName();
	public int getId();
	public float getPurchasePrice();
	public String getDescription();
}
