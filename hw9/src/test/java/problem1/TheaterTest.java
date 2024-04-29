package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TheaterTest {
  private Theater testTheater;
  private ArrayList<Row> expectedRows;

  @BeforeEach
  void setUp() {
    testTheater = Theater.getInstance();
    expectedRows = new ArrayList<>();
    for (int i = 0; i < 15; i++) {
      if (i == 0) {
        expectedRows.add(new Row(i + 1, Boolean.TRUE));
      } else {
        expectedRows.add(new Row(i + 1, Boolean.FALSE));
      }
    }
    for (Row row : expectedRows) {
      for (int i = 0; i < 10; i++) {
        row.add(new Seat(Character.toString ((char) i + 65)));
      }
    }
  }

  @Test
  void getRows() {
    assertEquals(expectedRows, testTheater.getRows());
  }

  @Test
  void testToString() {
    String expectedString = "1  = = = = = = = = = = \n"
        + "2  _ _ _ _ _ _ _ _ _ _ \n"
        + "3  _ _ _ _ _ _ _ _ _ _ \n"
        + "4  _ _ _ _ _ _ _ _ _ _ \n"
        + "5  _ _ _ _ _ _ _ _ _ _ \n"
        + "6  _ _ _ _ _ _ _ _ _ _ \n"
        + "7  _ _ _ _ _ _ _ _ _ _ \n"
        + "8  _ _ _ _ _ _ _ _ _ _ \n"
        + "9  _ _ _ _ _ _ _ _ _ _ \n"
        + "10 _ _ _ _ _ _ _ _ _ _ \n"
        + "11 _ _ _ _ _ _ _ _ _ _ \n"
        + "12 _ _ _ _ _ _ _ _ _ _ \n"
        + "13 _ _ _ _ _ _ _ _ _ _ \n"
        + "14 _ _ _ _ _ _ _ _ _ _ \n"
        + "15 _ _ _ _ _ _ _ _ _ _ \n";
    assertEquals(expectedString, testTheater.toString());
  }
}