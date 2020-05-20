package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import farm.simulator.Animal;

/**
 * This class performs unit tests on the Animal class. It also checks the
 * initialization of the Chicken, Pig and Horse subclasses work as intended.
 * 
 * @author Megan Steenkamp
 *
 */
class AnimalTest {

	private Animal testAnimal;
	private int tId = 1;
	private float tPrice = 20.0f;
	private String tType = "Test";
	private String tDescription = "An animal for testing";
	private int tHealth = 5;
	private int tHappiness = 5;

	/**
	 * Create a test animal and define expected attributes.
	 */
	@BeforeEach
	void init() {
		testAnimal = new Animal(tId, tPrice, tType, tDescription, tHealth, tHappiness);
	}

	// Test all getters are working as intended
	/**
	 * Test getting animal ID.
	 */
	@Test
	void testGetId() {
		assertEquals(tId, testAnimal.getId());
	}

	/**
	 * Test getting animal price.
	 */
	@Test
	void testGetPrice() {
		assertEquals(tPrice, testAnimal.getPurchasePrice());
	}

	/**
	 * Test getting animal type.
	 */
	@Test
	void testGetType() {
		assertEquals(tType, testAnimal.getType());
	}

	/**
	 * Test getting animal name. This function is expected to return the type of the
	 * animal. It was implemented so Animal could implement the FarmItem interface
	 * and meet assignment spec requirements.
	 */
	@Test
	void testGetName() {
		assertEquals(tType, testAnimal.getName());
	}

	/**
	 * Test getting animal description.
	 */
	@Test
	void testGetDescription() {
		assertEquals(tDescription, testAnimal.getDescription());
	}

	/**
	 * Test getting animal happiness.
	 */
	@Test
	void testGetHappiness() {
		assertEquals(tHappiness, testAnimal.getHappiness());
	}

	/**
	 * Test getting animal health.
	 */
	@Test
	void testGetHealths() {
		assertEquals(tHealth, testAnimal.getHealth());
	}

	// Validate setters
	/**
	 * Test setting valid price of animal.
	 */
	@Test
	void testSetPriceValid() {
		testAnimal.setPrice(40.0f);
		assertEquals(40.0f, testAnimal.getPurchasePrice());
	}

	@Test
	/**
	 * Test setting invalid price of animal throws an exception.
	 */
	void testSetPriceInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			testAnimal.setPrice(-1.0f);
		});
	}

	/**
	 * Test setting valid happiness.
	 */
	@Test
	void testSetHappinessValid() {
		testAnimal.setHappiness(1);
		assertEquals(1, testAnimal.getHappiness());
	}

	/**
	 * Test setting invalid happiness throws exception.
	 */
	@Test
	void testSetHappinessInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			testAnimal.setHappiness(-1);
		});
	}
	
	/**
	 * Test string contains initialized strings
	 */
	@Test
	void testToString() {
		String animal = testAnimal.toString();
		assertTrue((animal).contains(tType));
		assertTrue((animal).contains(tDescription));
	}

	/**
	 * Test setting valid health.
	 */
	@Test
	void testSetHealthValid() {
		testAnimal.setHealth(1);
		assertEquals(1, testAnimal.getHealth());
	}

	/**
	 * Test setting invalid health throws exception.
	 */
	@Test
	void testSetHealthInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			testAnimal.setHealth(-1);
		});
	}

	/**
	 * Test adding positive valid amount to health.
	 */
	@Test
	void testAddToHealth() {
		testAnimal.addToHealth(5);
		assertEquals(tHealth + 5, testAnimal.getHealth());
	}

	/**
	 * Test deducting an amount smaller than current health.
	 */
	@Test
	void testDeductFromHealthSmall() {
		testAnimal.addToHealth(-2);
		assertEquals(tHealth - 2, testAnimal.getHealth());
	}

	/**
	 * Test deducting an amount larger than current health.
	 */
	@Test
	void testDeductFromHealthLarge() {
		testAnimal.addToHealth(-10);
		assertEquals(0, testAnimal.getHealth());
	}

	/**
	 * Test adding positive valid amount to happiness.
	 */
	@Test
	void testAddToHappiness() {
		testAnimal.addToHappiness(5);
		assertEquals(tHappiness + 5, testAnimal.getHappiness());
	}

	/**
	 * Test deducting an amount smaller than current happiness.
	 */
	@Test
	void testDeductFromHappinessSmall() {
		testAnimal.addToHappiness(-2);
		assertEquals(tHappiness - 2, testAnimal.getHappiness());
	}

	/**
	 * Test deducting an amount larger than current happiness.
	 */
	@Test
	void testDeductFromHappinessLarge() {
		testAnimal.addToHappiness(-10);
		assertEquals(0, testAnimal.getHappiness());
	}
}
