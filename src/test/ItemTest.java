package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import farm.game.Item;

/**
 * This class performs unit tests on the Item class. It also checks the
 * initialization of the Compost, Fertilizer, Hoe, Silage, and Steroid subclasses work as intended.
 * 
 * @author Lewis Marshall
 *
 */
public class ItemTest {
  private Item testItem;
  private int tId = 1;
  private String tName = "Special Test Juice";
  private String tDescription = "An item for testing";
  private float tPrice = 400.0f;
  private int tCropGrowthFactor = -2;
  private int tAnimalHealthFactor = 0;

  /**
   * Create a test item and define expected attributes.
   */
  @BeforeEach
  void init() {
    testItem = new Item(tId, tName, tDescription, tPrice, tCropGrowthFactor, tAnimalHealthFactor);
  }

  /**
   * Test getting item ID.
   */
  @Test
  void testGetId() {
    assertEquals(tId, testItem.getId());
  }

  /**
   * Test getting item name.
   */
  @Test
  void testGetName() {
    assertEquals(tName, testItem.getName());
  }

  /**
   * Test getting item description.
   */
  @Test
  void testGetDescription() {
    assertEquals(tDescription, testItem.getDescription());
  }

  /**
   * Test getting item price.
   */
  @Test
  void testGetPrice() {
    assertEquals(tPrice, testItem.getPurchasePrice());
  }

  /**
   * Test getting item's Crop Growth Factor.
   */
  @Test
  void testGetCropGrowthFactor() {
    assertEquals(tCropGrowthFactor, testItem.getCropGrowthFactor());
  }

  /**
   * Test getting item' Animal Health Factor.
   */
  @Test
  void testGetAnimalHealthFactor() {
    assertEquals(tAnimalHealthFactor, testItem.getAnimalHealthFactor());
  }

  /**
   * Test setting valid price of item.
   */
  @Test
  void testSetPriceValid() {
    testItem.setPrice(550.0f);
    assertEquals(550.0f, testItem.getPurchasePrice());
  }

  /**
   * Test setting invalid price of item.
   */
  @Test
  void testSetPriceInvalid() {
    assertThrows(IllegalArgumentException.class, () -> {
      testItem.setPrice(-1.0f);
    });
  }

  /**
   * Test setting valid Crop Growth Factor of the item.
   */
  @Test
  void testSetCropGrowthFactorValid() {
    testItem.setCropGrowthFactor(-2);
    assertEquals(-2, testItem.getPurchasePrice());
  }

  /**
   * Test setting invalid Crop Growth Factor of the item.
   */
  @Test
  void testSetCropGrowthFactorInvalid() {
    assertThrows(IllegalArgumentException.class, () -> {
      testItem.setCropGrowthFactor("Negative two");
    });
  }

  /**
   * Test setting valid Animal Health Factor of the item.
   */
  @Test
  void testSetAnimalHealthFactorValid() {
    testItem.setAnimalHealthFactor(2);
    assertEquals(2, testItem.getPurchasePrice());
  }

  /**
   * Test setting invalid Animal Health Factor of the item.
   */
  @Test
  void testSetAnimalHealthFactorInvalid() {
    assertThrows(IllegalArgumentException.class, () -> {
      testItem.setCropGrowthFactor("Two");
    });
  }

  /**
	 * Test string contains initialized strings
	 */  
  @Test
  void testToString() {
    DecimalFormat df = new DecimalFormat("#.00");
    String testItemString = testItem.toString();
    assertTrue((testItemString).contains(tName));
    assertTrue((testItemString).contains(tDescription));
    assertTrue((testItemString).contains(df.format(tPrice)));
  }
}