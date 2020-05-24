package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import farm.game.FarmItem;
import farm.game.GeneralStore;

/**
 * This class performs unit tests on the GeneralStore class.
 * 
 * @author Megan Steenkamp
 */
class GeneralStoreTest {
	
	GeneralStore g;
	
	/**
	 * Initialize a new general store before each test
	 */
	@BeforeEach
	void init() {
		g = new GeneralStore();
	}

	/**
	 * Test with a valid item type ID. Expect an item to be returned.
	 */
	@Test
	void testGetItemValid() {
		FarmItem item = g.getItem(1);
		assertNotNull(item);
	}
	
	/**
	 * Test with an invalid item type ID. Expect to get null.
	 */
	@Test
	void testGetItemInvalid() {
		FarmItem item = g.getItem(-1);
		assertNull(item);
	}

	/**
	 * Test with a valid item type ID. Expect an item to be returned.
	 */
	@Test
	void testSellItemValid() {
		FarmItem item = g.sellItem(1);
		assertNotNull(item);
	}
	
	/**
	 * Test with an invalid item type ID. Expect to get null.
	 */
	@Test
	void testSellItemInvalid() {
		FarmItem item = g.sellItem(-1);
		assertNull(item);
	}


	/**
	 * Test with a valid item type ID. Expect an item to be returned.
	 */
	@Test
	void testGetItemDetailsValid() {
		String details = g.getItemDetails(1);
		assertNotNull(details);
	}
	
	/**
	 * Test with an invalid item type ID. Expect to get null.
	 */
	@Test
	void testGetItemDetailsInvalid() {
		String details = g.getItemDetails(-1);
		assertEquals("", details);
	}
}
