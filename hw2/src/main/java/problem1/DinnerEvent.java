package problem1;

import java.util.Objects;

/**
 * This class represents a Dinner Event which includes the number of vegetarian and non-vegetarian
 * entrées. Dinner Event is a child of Event.
 */

public class DinnerEvent extends Event {

  protected static final Integer MIN_PEOPLE = 10;
  protected static final Integer MAX_PEOPLE = 50;
  private static final Double VEG_RATIO = 0.2;
  private Integer numNonVegEntree;
  private Integer numVegEntree;

  /**
   * Constructs a Dinner Event object with the provided client name and number of people.
   * @param clientName
   * @param numPeople
   */
  public DinnerEvent(String clientName, int numPeople) {
    super(clientName, numPeople);
    this.numNonVegEntree = (int) Math.round(numPeople * (1 - VEG_RATIO));
    this.numVegEntree = (int) Math.round(numPeople * VEG_RATIO);
  }

  /**
   * Returns the number of non-vegetarian entrees.
   * @return the number of non-vegetarian entrees.
   */
  public int getNumNonVegEntree() {
    return numNonVegEntree;
  }

  /**
   * Returns the number of vegetarian entrees.
   * @return the number of vegetarian entrees.
   */
  public int getNumVegEntree() {
    return numVegEntree;
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
    DinnerEvent that = (DinnerEvent) o;
    return numNonVegEntree == that.numNonVegEntree && numVegEntree == that.numVegEntree;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numNonVegEntree, numVegEntree);
  }
}