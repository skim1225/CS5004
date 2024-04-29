package Option2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DriversLicenseTest {
  private DriversLicense testLicense;
  private Integer expectedLicenseNumber;
  private Name expectedName;
  private String expectedAddress;
  private Date expectedBirthday;
  private String expectedIssuingCountry;
  private String expectedIssuingState;
  private Date expectedIssuedDate;
  private Date expectedExpirationDate;

  @BeforeEach
  void setUp() {
    testLicense = new DriversLicense(12345, new Name("Diver", "McDriverton"),
        "225 Terry Ave N, Seattle, WA 98109", LocalDate.of(1999,12,25),
        "US", "WA", LocalDate.of(2015,6,19),
        LocalDate.of(2027,12,25));
    expectedLicenseNumber = 12345;
    expectedName = new Name("Diver", "McDriverton");
    expectedAddress = "225 Terry Ave N, Seattle, WA 98109";
    expectedBirthday =  new Date(25, 12, 1999);
    expectedIssuingCountry = "US";
    expectedIssuingState = "WA";
    expectedIssuedDate = new Date(19, 6, 2015);
    expectedExpirationDate = new Date(25, 12, 2027);
  }

  @Test
  void getLicenseNumber() {
    assertEquals(expectedLicenseNumber, testLicense.getLicenseNumber());
  }

  @Test
  void getName() {
    assertEquals(expectedName, testLicense.getName());
  }

  @Test
  void getAddress() {
    assertEquals(expectedAddress, testLicense.getAddress());
  }

  @Test
  void getBirthday() {
    assertEquals(expectedBirthday, testLicense.getBirthday());
  }

  @Test
  void getIssuingCountry() {
    assertEquals(expectedIssuingCountry, testLicense.getIssuingCountry());
  }

  @Test
  void getIssuingState() {
    assertEquals(expectedIssuingState, testLicense.getIssuingState());
  }

  @Test
  void getIssuedDate() {
    assertEquals(expectedIssuedDate, testLicense.getIssuedDate());
  }

  @Test
  void getExpirationDate() {
    assertEquals(expectedExpirationDate, testLicense.getExpirationDate());
  }
}