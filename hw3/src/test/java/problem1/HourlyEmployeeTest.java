package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HourlyEmployeeTest {

  private HourlyEmployee testHourlyEmployee;
  private Double expectedHourlyEarnings;
  private Double expectedProductivity;

  @BeforeEach
  void setUp() {
    testHourlyEmployee = new HourlyEmployee("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 20000.0, 10.0,
        20.0, 1000.0, 10.0);
    expectedHourlyEarnings = 10.0;
  }

  @Test
  void estimateProductivity_HourlyRateBonus() {
    expectedProductivity = 10.4;
    assertEquals(expectedProductivity, testHourlyEmployee.estimateProductivity());
  }

  @Test
  void estimateProductivity_NoHourlyRateBonus() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee("a", new ContactInfo(new Name("a","a"),"a",
        "a","a",new Name("a","a")), LocalDate.of(1,1,1),
        EducationLevel.HIGH_SCHOOL_DIPLOMA, EmploymentLevel.ENTRY_LEVEL, 20000.0, 10.0,
        20.0, 1000.0, 20.0);
    expectedProductivity = 7.4;
    assertEquals(expectedProductivity, otherHourlyEmployee.estimateProductivity());

  }

  @Test
  void getHourlyEarnings() {
    assertEquals(expectedHourlyEarnings, testHourlyEmployee.getHourlyEarnings());
  }
}