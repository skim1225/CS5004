package Option2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {
  private Date testDate;
  private Integer expectedDay;
  private Integer expectedMonth;
  private Integer expectedYear;

  @BeforeEach
  void setUp() {
    testDate = new Date(22, 4, 2024);
    expectedDay = 22;
    expectedMonth = 4;
    expectedYear = 2024;
  }

  @Test
  void getDay() {
    assertEquals(expectedDay, testDate.getDay());
  }

  @Test
  void getMonth() {
    assertEquals(expectedMonth, testDate.getMonth());
  }

  @Test
  void getYear() {
    assertEquals(expectedYear, testDate.getYear());
  }
}