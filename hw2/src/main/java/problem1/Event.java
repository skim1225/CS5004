package problem1;

import java.util.Objects;

/**
 * Event is an abstract class that stores information about an event including the name of the
 * client and the number of people attending.
 */

public abstract class Event {

  protected String clientName;
  protected Integer numPeople;

  /**
   * Constructor creating a new Event object with provided client name and number of people.
   * @param clientName - Client name as a string.
   * @param numPeople - Number of people as an integer.
   */
  public Event(String clientName, Integer numPeople) {
    this.clientName = clientName;
    this.numPeople = numPeople;
  }

  /**
   * Returns the client's name.
   * @return client name
   * */
  public String getClientName() {
    return clientName;
  }

  /**
   * Returns the number of people
   * @return number of people
   */
  public Integer getNumPeople() {
    return numPeople;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(clientName, event.clientName) && Objects.equals(
        numPeople, event.numPeople);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientName, numPeople);
  }
}
