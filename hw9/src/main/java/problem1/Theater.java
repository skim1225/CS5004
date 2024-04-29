package problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class theater represents a movie theater as a collection of rows containing seats and a name.
 */
public class Theater {
  private static Theater instance; //Singleton Lazy Allocation
  private static final int[] accessibleRows = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
  protected static final int NUM_ROWS = 15;
  protected static final int NUM_SEATS = 10;
  protected static final String THEATER_NAME = "The Fresh Tomato";
  private ArrayList<Row> rows;

  /**
   * Constructor for creating a new theater object with the default number of rows, seats per row,
   * and name.
   */
  Theater() {
    rows = new ArrayList<>();
    for (int i = 0; i < NUM_ROWS; i++) {
      if (accessibleRows[i] == 1) {
        rows.add(new Row(i + 1, Boolean.TRUE));
      } else {
        rows.add(new Row(i + 1, Boolean.FALSE));
      }
    }
    for (Row row : rows) {
      for (int i = 0; i < NUM_SEATS; i++) {
        row.add(new Seat(Character.toString((char) (i + 65))));
      }
    }
  }

  public static Theater getInstance() {
    if (instance == null) {
        instance = new Theater();
    }
    return instance;
  }

  /**
   * Returns the rows of the theater, as an ArrayList.
   * @return the rows of the theater, as an ArrayList.
   */
  public ArrayList<Row> getRows() {
    return rows;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Theater theater = (Theater) o;
    return Objects.equals(rows, theater.rows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rows);
  }

  @Override
  public String toString() {
    StringBuilder theaterString = new StringBuilder();
    for (Row row : rows) {
      theaterString.append(row.toString()).append('\n');
    }
    return theaterString.toString();
  }
}
