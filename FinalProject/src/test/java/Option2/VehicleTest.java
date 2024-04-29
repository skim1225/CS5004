package Option2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleTest {
  private Vehicle testVehicle;
  private String expectedMake;
  private String expectedModel;
  private Integer expectedYear;
  private Driver expectedDriver;

  @BeforeEach
  void setUp() {
    testVehicle = new Vehicle("Lexus", "RX300", 1999, new Driver());
    expectedMake = "Lexus";
    expectedModel = "RX300";
    expectedYear = 1999;
    expectedDriver = new Driver();
  }

  @Test
  void getMake() {
    assertEquals(expectedMake, testVehicle.getMake());
  }

  @Test
  void getModel() {
    assertEquals(expectedModel, testVehicle.getModel());
  }

  @Test
  void getYear() {
    assertEquals(expectedYear, testVehicle.getYear());
  }

  @Test
  void getOwner() {
    assertEquals(expectedDriver, testVehicle.getOwner());
  }
}