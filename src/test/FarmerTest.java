package test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import farm.game.Compost;
import farm.game.FarmItem;
import farm.game.Farmer;
import farm.game.Fertilizer;
import farm.game.Grain;
import farm.game.Hoe;
import farm.game.Item;
import farm.game.Silage;
import farm.game.Steroid;

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

  /**
   * Test setting and getting the farmer's item inventory
   */
  @Test
  void testSetItems() {
    FarmItem testItem = initItem();
    ArrayList<FarmItem> testItems = new ArrayList<FarmItem>();
    testItems.add(testItem);

    testFarmer.setItems(testItems);
    assertEquals(testItems, testFarmer.getItems())
  }

  /**
   * Test the returned string detailing Farmer's item stock
   */
  @Test
  void testReturnedItemStock() {
    Fertilizer testFertilizer = new Fertilizer();
    Compost testCompost = new Compost();
    Hoe testHoe = new Hoe();
    Steroid testSteroid = new Steroid();
    Grain testGrain = new Grain();
    Silage testSilage = new Silage();

    ArrayList<FarmItem> testItems = new ArrayList<FarmItem>();
    testItems.add(testFertilizer);
    testItems.add(testCompost);
    testItems.add(testHoe);
    testItems.add(testSteroid);
    testItems.add(testGrain);
    testItems.add(testSilage);

    testFarmer.setItems(testItems);
    String str = "Fertilizer: " + 1 + "\n" 
                + "Compost" + 1 + "\n"
                + "Hoes" + 1 + "\n"
                + "Steroids" + 1 + "\n"
                + "Grain" + 1 + "\n"
                + "Silage" + 1 + "\n";
    
    testFarmer.setItems(testItems);
    assertTrue((testFarmer.getItemStock() == str));
  }

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