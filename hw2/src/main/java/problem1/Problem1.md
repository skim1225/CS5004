## Example of Inheritance

```
  /**
   * Constructor to create a new lunch event with the appropriate number of sandwiches.
   * @param clientName - The client's name as a String
   * @param numPeople - The number of attendees as an Integer
   */
  public LunchEvent(String clientName, int numPeople) {
    super(clientName, numPeople);
    this.numSandwiches = (int) (Math.round(numPeople * SANDWICH_RATIO));
  }
```

## Example of Exceptions
```
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
```