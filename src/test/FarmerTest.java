package test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import farm.game.FarmItem;
import farm.game.Farmer;
import farm.game.Item;

/**
 * This class performs unit tests on the Farmer class.
 * 
 * @author Lewis Marshall
 *
 */
public class FarmerTest {
  
  private Farmer testFarmer;
  private String tName = "John";
  private int tAge = 45;
  
  private int tId = 1;
  private String itemName = "Special Test Juice";
  private String tDescription = "An item for testing";
  private float tPrice = 400.0f;
  private int tCropGrowthFactor = -2;
  private int tAnimalHealthFactor = 0;

  /**
   * Create a test farmer and defines expected attributes.
   */
  @BeforeEach
  void init() {
    testFarmer = new Farmer(tName, tAge);
  }
  
  FarmItem initItem() {
	  FarmItem testItem = new Item(tId, tName, tDescription, tPrice, tCropGrowthFactor, tAnimalHealthFactor);
	  return testItem;
  }

  /**
   * Test getting farmer name.
   */
  @Test
  void testGetName() {
    assertEquals(tName, testFarmer.getName());
  }

  /**
   * Test getting farmer age.
   */
  @Test
  void testGetAge() {
    assertEquals(tAge, testFarmer.getAge());
  }

  /**
   * Test setting valid farmer age
   */
  @Test
  void testSetAgeValid() {
    testFarmer.setAge(50);
    assertEquals(50, testFarmer.getAge());
  }

  /**
   * Test setting invalid farmer age
   */
  @Test
  void testSetAgeInvalid() {
    assertThrows(IllegalArgumentException.class, () -> {
      testFarmer.setAge(-1);
    });
  }

  // TODO: FarmItem testing in the Farmer class
  @Test
  void testAddItem() {
	  FarmItem testItem = initItem();
	  //Get a list for assertions as that is what get items returns
	  ArrayList<FarmItem> testItems = new ArrayList<FarmItem>();
	  testItems.add(testItem);
	  
	  testFarmer.addItem(testItem);
	  assertEquals(testItems, testFarmer.getItems());
  }
  
}