package problem1;

import java.util.Objects;

/**
 * Schedule is a class that allows users to schedule a lunch or dinner event by providing the
 * client's name and number of attendees.
 */

public class Schedule {

  private LunchEvent lunchEvent;
  private DinnerEvent dinnerEvent;

  /**
   * Constructor to create a new Schedule object with no events initially.
   */
  public Schedule() {
  }

  /**
   * Create a new lunch object with the given client's name and number of attendees.
   * @param client - The client's name as a string.
   * @param numPeople - The number of people as an integer.
   * @throws EventAlreadyExistsException if a lunch event already exists for this schedule.
   * @throws InvalidNumberOfPeopleException if the number of people is not between 15 and 90.
   */
  public void bookLunchEvent(String client, Integer numPeople) throws EventAlreadyExistsException, InvalidNumberOfPeopleException {
    if (this.lunchEvent == null) {
      if (numPeople >= LunchEvent.MIN_PEOPLE && numPeople <= LunchEvent.MAX_PEOPLE) {
        this.lunchEvent = new LunchEvent(client, numPeople);
      } else {
        throw new InvalidNumberOfPeopleException("Number of people must be between 15 and 90");
      }
    } else {
      throw new EventAlreadyExistsException("A lunch event already exists.");
    }
  }

  /**
   * Create a new dinner object with the given client's name and number of attendees.
   * @param client - The client's name as a string.
   * @param numPeople - The number of people as an integer.
   * @throws EventAlreadyExistsException if a lunch event already exists for this schedule.
   * @throws InvalidNumberOfPeopleException if the number of people is not between 10 and 50.
   */
  public void bookDinnerEvent(String client, Integer numPeople) throws EventAlreadyExistsException, InvalidNumberOfPeopleException {
    if (this.dinnerEvent == null) {
      if (numPeople >= DinnerEvent.MIN_PEOPLE && numPeople <= DinnerEvent.MAX_PEOPLE) {
        this.dinnerEvent = new DinnerEvent(client, numPeople);
      } else {
        throw new InvalidNumberOfPeopleException("Number of people must be between 10 and 50");
      }
    } else {
      throw new EventAlreadyExistsException("A dinner event already exists.");
    }
  }

  /**
   * Returns the lunch event
   * @return the lunchEvent
   */
  public LunchEvent getLunchEvent() {
    return lunchEvent;
  }

  /**
   * Returns the dinner event
   * @return the dinnerEvent
   */
  public DinnerEvent getDinnerEvent() {
    return dinnerEvent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Schedule schedule = (Schedule) o;
    return Objects.equals(lunchEvent, schedule.lunchEvent) && Objects.equals(
        dinnerEvent, schedule.dinnerEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lunchEvent, dinnerEvent);
  }
}
