package problem1;

import java.util.Objects;

/**
 * LunchEvent is a simple class that is a child of Event which stores information about a lunch
 * event including the number of sandwiches provided.
 */

public class LunchEvent extends Event{

  protected static final Integer MIN_PEOPLE = 15;
  protected static final Integer MAX_PEOPLE = 90;
  private static final double SANDWICH_RATIO = 1.05;
  private int numSandwiches;

  /**
   * Constructor to create a new lunch event with the appropriate number of sandwiches.
   * @param clientName - The client's name as a String
   * @param numPeople - The number of attendees as an Integer
   */
  public LunchEvent(String clientName, int numPeople) {
    super(clientName, numPeople);
    this.numSandwiches = (int) (Math.round(numPeople * SANDWICH_RATIO));
  }

  /**
   * Returns the number of sandwiches for the lunch event
   * @return the number of sandwiches
   */
  public int getNumSandwiches() {
    return numSandwiches;
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
    LunchEvent that = (LunchEvent) o;
    return Double.compare(SANDWICH_RATIO, that.SANDWICH_RATIO) == 0
        && numSandwiches == that.numSandwiches;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numSandwiches);
  }
}
