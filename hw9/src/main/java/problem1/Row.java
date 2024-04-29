package problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class row represents a row in a theater as its row number and whether it is accessible. Row
 * is a subclass of ArrayList.
 */
public class Row extends ArrayList<Seat> {
  private Integer rowNum;
  private Boolean accessible;

  /**
   * Constructor for creating a new row with the given number and accessibility.
   */
  public Row(Integer rowNum, Boolean accessible) {
    this.rowNum = rowNum;
    this.accessible = accessible;
  }

  /**
   * Helper method which returns the number of unreserved seats in this row.
   * @return the number of unreserved seats in this row.
   */
  public int seatsAvailable() {
    int numSeatsAvailable = 0;
    for (Seat seat:this) {
      if (seat.getReservedFor() == null) {
        numSeatsAvailable += 1;
      }
    }
    return numSeatsAvailable;
  }

  /**
   * Returns the row number, as an Integer.
   * @return the row number, as an Integer.
   */
  public Integer getRowNum() {
    return rowNum;
  }

  /**
   * Returns whether the row is accessible, as a Boolean.
   * @return whether the row is accessible, as a Boolean.
   */
  public Boolean getAccessible() {
    return accessible;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Row seats = (Row) o;
    return Objects.equals(rowNum, seats.rowNum) && Objects.equals(accessible,
        seats.accessible);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rowNum, accessible);
  }

  @Override
  public String toString() {
    StringBuilder rowString = new StringBuilder();
    if (rowNum < 10) {
      rowString.append(rowNum).append("  ");
    } else {
      rowString.append(rowNum).append(" ");
    }
    for (Seat seat : this) {
      String seatString = seat.toString();
      if (seatString != null) {
        rowString.append(seatString);
      } else {
        if (this.accessible) {
          rowString.append("= ");
        } else {
          rowString.append("_ ");
        }
      }
    }
    return rowString.toString();
  }
}
