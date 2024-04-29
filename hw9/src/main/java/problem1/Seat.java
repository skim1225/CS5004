package problem1;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Class Seat represents a seat in a row in a movie theater as its name and the name of who
 * it's reserved for.
 */
public class Seat {
  private final Pattern NAME_PATTERN = Pattern.compile("[A-Z]");
  private String name;
  private String reservedFor;

  /**
   * Constructor for creating a new unreserved Seat object with the given name.
   * @param name - The name of the seat to be created as a capital letter.
   * throws new IllegalArgumentException if the given name is not a capital letter.
   */
  public Seat(String name) {
    if (NAME_PATTERN.matcher(name).matches()) {
      this.name = name;
      this.reservedFor = null;
    } else {
      throw new IllegalArgumentException("Seat name must be a capital letter A-Z.");
    }
  }

  /**
   * Returns the name of the seat, as a String.
   * @return the name of the seat, as a String.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the name of the person this seat is reserved for, or null if it is unreserved.
   * @return the name of the person this seat is reserved for, or null if it is unreserved.
   */
  public String getReservedFor() {
    return reservedFor;
  }

  /**
   * Reserves the seat for the person with the given name.
   * @param reservedFor - The name of the person to reserve the seats for.
   */
  public void setReservedFor(String reservedFor) {
    this.reservedFor = reservedFor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Seat seat = (Seat) o;
    return Objects.equals(name, seat.name) && Objects.equals(reservedFor,
        seat.reservedFor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, reservedFor);
  }

  @Override
  public String toString() {
    if (reservedFor == null) {
      return null;
    } else {
      return "X ";
    }
  }
}
