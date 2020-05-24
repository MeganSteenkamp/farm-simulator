package test;

import static org.junit.jupiter.api.Assertions.*;

import farm.game.Crop;

public class CropTest {
  private Crop testCrop
  private int tId = 1;
  private String tName = "Special test beans";
  private String tDescription = "A crop for testing";
  private float tPurchasePrice = 10.0f;
  private float tSellingPrice = 50.0f;
  private int tDaysToGrow = 3;
  private int tDaysGrowing = 0;
}

/**
   * Create a test crop and define expected attributes.
   */
  @BeforeEach
  void init() {
    testCrop = new Crop(tId, tName, tDescription, tPurchasePrice, tSellingPrice, tDaysToGrow);
  }

  /**
   * Test getting crop ID.
   */
  @Test
  void testGetId() {
    assertEquals(tId, testCrop.getId());
  }


  /**
   * Test getting crop name.
   */
  @Test
  void testGetName() {
    assertEquals(tName, testCrop.getName());
  }

  /**
   * Test getting crop description.
   */
  @Test
  void testGetDescription() {
    assertEquals(tDescription, testCrop.getDescription());
  }

  /**
   * Test getting crop purchase price.
   */
  @Test
  void testGetPurchasePrice() {
    assertEquals(tPurchasePrice, testCrop.getPurchasePrice());
  }

  /**
   * Test getting crop selling price.
   */
  @Test
  void testGetSellingPrice() {
    assertEquals(tSellingPrice, testCrop.getSellingPrice());
  }

  /**
   * Test getting crop's number of days taken for growth.
   */
  @Test
  void testGetDaysToGrow() {
    assertEquals(tDaysToGrow, testCrop.getDaysToGrow());
  }

  /**
   * Test getting crop's number of days it has been growing for.
   */
  @Test
  void testGetDaysGrowing() {
    assertEquals(tDaysGrowing, testCrop.getDaysGrowing());
  }

  /**
   * Test getting crop's number of days remaining when tDaysGrowing < tDaysToGrow.
   */
  @Test
  void testGetTimeUnitlHarvestRemains() {
    testCrop.updateCropGrowth(1);
    assertEquals(2, testCrop.getTimeUntilHarvest())
  }

  /**
   * Test getting crop's number of days remaining when tDaysGrowing > tDaysToGrow, .
   */
  @Test
  void testGetNoTimeUnitlHarvestRemains() {
    testCrop.updateCropGrowth(5);
    assertEquals(0, testCrop.getTimeUntilHarvest())
  }

  /**
   * Test setting valid purchase price of crop.
   */
  @Test
  void testSetPurchasePriceValid() {
    testCrop.setPurchasePrice(50.0f);
    assertEquals(550.0f, testCrop.getPurchasePrice());
  }

  /**
   * Test setting invalid purchase price of crop.
   */
  @Test
  void testSetPurchasePriceInvalid() {
    assertThrows(IllegalArgumentException.class, () -> {
      testCrop.setPurchasePrice(-50.0f);
    });
  }

  /**
   * Test setting valid selling price of crop.
   */
  @Test
  void testSetSellingPriceValid() {
    testCrop.setSellingPricePrice(50.0f);
    assertEquals(550.0f, testCrop.getSellingPrice());
  }

  /**
   * Test setting invalid selling price of crop.
   */
  @Test
  void testSetSellingPriceInvalid() {
    assertThrows(IllegalArgumentException.class, () -> {
      testCrop.setSellingPrice(-50.0f);
    });
  }

  /**
   * Test adding positive days to crop's days to grow count.
   */
  @Test
  void testAddToDaysToGrow() {
    testCrop.addDaysToGrow(3);
    assertEquals(tDaysToGrow + 3, testCrop.getDaysToGrow());
  }

  /**
   * Test deducting an amount of days smaller than crop's days to grow count.
   */
  @Test
  void testSmallDeductDaysToGrow() {
    testCrop.addDaysToGrow(-2);
    assertEquals(tDaysToGrow -2, testCrop.getDaysToGrow());
  }

  /**
   * Test deducting an amount of days larger than crop's days to grow count.
   */
  @Test
  void testLargeDeductDaysToGrow() {
    testCrop.addDaysToGrow(-10);
    assertEquals(0, testCrop.getDaysToGrow());
  }

  /**
   * Test adding an amount of days to crop's current growth time
   */
  @Test
  void testAddToDaysGrowing() {
    testCrop.updateCropGrowth(3);
    assertEquals(tDaysGrowing + 3, testCrop.getDaysGrowing());
  }

  /**
	 * Test string contains initialized and calculated strings
	 */  
  @Test
  void testToString() {
    String testCropString = testCrop.toString();
    assertTrue((testCropString).contains(tName));
    assertTrue((testCropString).contains(Integer.toString(tDaysGrowing));
    assertTrue((testCropString).contains(Integer.toString(testCrop.getTimeUntilHarvest())));
  }
}