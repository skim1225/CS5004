## Example of inheritance
I have not used inheritance in my design for problem 2 because there are no
is-a relationships between the components of the problem. Lockers, mail items, and
recipients are not more specialized versions of each other; they are
unique objects which interact with one another.


## Example of exceptions
```angular2html
  public MailItem(Double width, Integer height, Integer depth, Recipient recipient)
      throws InvalidDimensionsException {
    if (width >= MIN_WIDTH && height >= MIN_HEIGHT && depth >= MIN_DEPTH) {
      this.width = width;
      this.height = height;
      this.depth = depth;
      this.recipient = recipient;
    } else {
      throw new InvalidDimensionsException("Mail item dimensions must be greater than or equal to W: 1.5, H: 2, D: 1");
    }
  }
```