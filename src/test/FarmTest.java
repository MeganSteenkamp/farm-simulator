package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import farm.simulator.Animal;
import farm.simulator.Crop;
import farm.simulator.Farm;
import farm.simulator.FarmItem;
import farm.simulator.Farmer;

/**
 * This class performs unit tests on the Farm class. It also checks the
 * initialization of Farm's subclasses work as intended.
 * 
 * @author Megan Steenkamp
 *
 */
class FarmTest {

	// Initialize values used for test objects
	Farm testFarm;
	String tType = "Test";
	float tBalance = 1000.00f;
	int tCropGrowthFactor = 0;
	int tAnimalHappinessFactor = 0;

	String farmerName = "Farmer";
	int farmerAge = 24;

	int cropId = 1;
	String cropName = "Crop";
	String cropDescription = "A test crop";
	float cropPurchasePrice = 100.00f;
	float cropSellingPrice = 200.00f;
	int cropDaysToGrow = 2;

	int animalId = 1;
	float animalPrice = 20.0f;
	String animalType = "Test";
	String animalDescription = "An animal for testing";
	int animalHealth = 5;
	int animalHappiness = 5;

	/**
	 * Create a test farm and define expected attributes.
	 */
	@BeforeEach
	void init() {
		testFarm = new Farm(tType, tBalance, tCropGrowthFactor, tAnimalHappinessFactor);
	}

	/**
	 * Initializes a default crop for testing
	 */
	Crop initCrop() {
		return new Crop(cropId, cropName, cropDescription, cropPurchasePrice, cropSellingPrice, cropDaysToGrow);
	}

	/**
	 * Initializes a default animal for testing
	 */
	Animal initAnimal() {
		return new Animal(animalId, animalPrice, animalType, animalDescription, animalHealth, animalHappiness);
	}

	/**
	 * Test farm name is set as intended.
	 */
	@Test
	void testSetName() {
		testFarm.setName("Test name");
		assertEquals("Test name", testFarm.getName());
	}

	/**
	 * Create and set the farmer. Assert returned farmer equals set farmer.
	 */
	@Test
	void testSetandGetFarmer() {
		Farmer f = new Farmer(farmerName, farmerAge);
		testFarm.setFarmer(f);
		assertEquals(f, testFarm.getFarmer());
	}

	/**
	 * Tests number of crop plots available. Should be 4 on initialization.
	 */
	@Test
	void testGetNumAvailableCropsInit() {
		assertEquals(4, testFarm.getNumAvailableCrops());
	}

	/**
	 * Check there are no crops on initialization
	 */
	@Test
	void testGetCropsInit() {
		assertEquals(0, testFarm.getCrops().size());
	}

	/**
	 * Test adding one crop to a new farm is valid. Check get crops returns the crop
	 */
	@Test
	void testAddAndGetCropValid() {
		Crop c = initCrop();
		testFarm.addCrop(c);
		assertTrue((testFarm.getCrops()).contains(c));
	}

	/**
	 * Test adding more crops than plots available
	 */
	@Test
	void testAddCropInvalid() {
		assertEquals(4, testFarm.getNumAvailableCrops());
		for (int i = 0; i < 4; i++) {
			testFarm.addCrop(initCrop());
		}
		assertThrows(IllegalArgumentException.class, () -> {
			testFarm.addCrop(initCrop());
		});
	}

	/**
	 * Check available crop plots decrease when a crop is added.
	 */
	@Test
	void testGetNumAvailableCropsDecrease() {
		assertEquals(4, testFarm.getNumAvailableCrops());
		testFarm.addCrop(initCrop());
		assertEquals(3, testFarm.getNumAvailableCrops());
	}

	/**
	 * Test validly adding to available crop plots.
	 */
	@Test
	void testAddToAvailableCropsValid() {
		assertEquals(4, testFarm.getNumAvailableCrops());
		testFarm.addToAvailableCrops(1);
		assertEquals(5, testFarm.getNumAvailableCrops());
	}

	/**
	 * Test invalid add to available crop plots. This function should not accept a
	 * negative number
	 */
	@Test
	void testAddToAvailableCropsInvalid() {
		assertEquals(4, testFarm.getNumAvailableCrops());
		assertThrows(IllegalArgumentException.class, () -> {
			testFarm.addToAvailableCrops(-1);
		});
	}

	/**
	 * Get valid crop status containing added crop
	 */
	@Test
	void testGetCropStatus() {
		Crop c = initCrop();
		testFarm.addCrop(c);
		String status = testFarm.getCropStatus();
		assertTrue((status).contains(c.toString()));
	}

	/**
	 * Remove a crop that exists in the farm.
	 */
	@Test
	void testRemoveCropValid() {
		Crop c = initCrop();
		testFarm.addCrop(c);
		Crop returned = (Crop) testFarm.getCrop(c.getId());
		assertEquals(c, returned);
	}

	/**
	 * Remove a crop that does not exist in the farm.
	 */
	@Test
	void testRemoveCropInvalid() {
		Crop c = initCrop();
		assertThrows(RuntimeException.class, () -> {
			testFarm.removeCrop(c);
		});
	}

	/**
	 * Check ownership of a crop that has been added
	 */
	@Test
	void testOwnsCropTrue() {
		Crop c = initCrop();
		testFarm.addCrop(c);
		assertTrue(testFarm.ownsCrop(c.getId()));
	}

	/**
	 * Check ownership of a crop that has not been added
	 */
	@Test
	void testOwnsCropFalse() {
		Crop c = initCrop();
		assertFalse(testFarm.ownsCrop(c.getId()));
	}

	/**
	 * Add a crop that has 0 days left to grow. Expect to be returned.
	 */
	@Test
	void testGetCropsReadyForHarvestOne() {
		Crop c = new Crop(cropId, cropName, cropDescription, cropPurchasePrice, cropSellingPrice, 0);
		testFarm.addCrop(c);
		String readyCrops = testFarm.getCropsReadyForHarvest();
		String cropString = c.toString();
		assertTrue((readyCrops).contains(cropString));
	}

	/**
	 * Add a crop that has > 0 days left to grow. Expect to be returned.
	 */
	@Test
	void testGetCropsReadyForHarvestNone() {
		Crop c = initCrop();
		testFarm.addCrop(c);
		String readyCrops = testFarm.getCropsReadyForHarvest();
		String cropString = c.toString();
		assertFalse((readyCrops).contains(cropString));
	}

	/**
	 * Test getting balance set on initialization
	 */
	@Test
	void testGetBalance() {
		assertEquals(tBalance, testFarm.getBalance());
	}

	/**
	 * Test withdrawing an amount less than balance
	 */
	@Test
	void testWithdrawMoneyValid() {
		float withdrawalAmount = tBalance / 2.0f;
		float money = testFarm.withdrawMoney(withdrawalAmount);
		assertEquals(withdrawalAmount, money);
	}

	/**
	 * Test withdrawing an amount more than balance Expect to return no money for
	 * payment
	 */
	@Test
	void testWithdrawMoneyInvalid() {
		float withdrawalAmount = tBalance * 2;
		float money = testFarm.withdrawMoney(withdrawalAmount);
		assertEquals(0, money);
	}

	/**
	 * Add a positive balance to the account
	 */
	@Test
	void testAddToBalanceValid() {
		float amount = 100.0f;
		assertEquals(tBalance + amount, testFarm.addToBalance(amount));
	}

	/**
	 * Add a negative balance to the account. Expected to throw an exception
	 */
	@Test
	void testAddToBalanceInvalid() {
		assertThrows(RuntimeException.class, () -> {
			testFarm.addToBalance(-100.0f);
		});
	}

	/**
	 * Test valid adding an animal then getting animals
	 */
	@Test
	void testAddAndGetAnimal() {
		Animal a = initAnimal();
		testFarm.addAnimal(a);
		assertTrue((testFarm.getAnimals()).contains(a));
	}

	/**
	 * Get valid animal status containing added animal
	 */
	@Test
	void testGetAnimalStatus() {
		Animal a = initAnimal();
		testFarm.addAnimal(a);
		String status = testFarm.getAnimalStatus();
		assertTrue((status).contains(a.toString()));
	}

	/**
	 * Test getting status of a crop and an animal
	 */
	@Test
	void testGetCropAndAnimalStatus() {
		Crop c = initCrop();
		Animal a = initAnimal();
		testFarm.addCrop(c);
		testFarm.addAnimal(a);

		String status = testFarm.getCropAndAnimalStatus();
		assertTrue((status).contains(c.toString()));
		assertTrue((status).contains(a.toString()));
	}

	/**
	 * Test the crop growth factor of a farm changes the growth of a crop added
	 */
	void testCropGrowthFactor() {
		int cropGrowthFactor = 2;
		testFarm = new Farm(tType, tBalance, cropGrowthFactor, tAnimalHappinessFactor);
		Crop c = initCrop();
		testFarm.addCrop(c);
		Crop returned = (Crop) testFarm.getCrop(c.getId());
		assertEquals(cropDaysToGrow + 2, returned.getDaysToGrow());
	}

	/**
	 * Test the animal happiness factor of a farm changes the happiness of an animal
	 * added
	 */
	void testAnimalHappinessFactor() {
		int animalHappiness = 2;
		testFarm = new Farm(tType, tBalance, tCropGrowthFactor, animalHappiness);
		Animal a = initAnimal();
		a.addToHappiness(2);
		testFarm.addAnimal(a);
		ArrayList<FarmItem> status = testFarm.getAnimals();
		assertTrue((status).contains(a));
	}
}
