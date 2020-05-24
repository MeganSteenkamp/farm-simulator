package test;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import farm.game.Farmer;

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

  /**
   * Create a test farmer and defines expected attributes.
   */
  @BeforeEach
  void init() {
    testFarmer = new Farmer(tName, tAge)
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
  void testSetAgeInvalid() {
    assertThrows(IllegalArgumentException.class, () -> {
      testFarmer.setAge(-1);
    });
  }

  // TODO: FarmItem testing in the Farmer class
}