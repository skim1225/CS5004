package problem2;

import java.util.Objects;

/**
 * This class represents a locker which has maximum allowed dimensions and a mail item.
 */
public class Locker {

  private static final Integer MAX_WIDTH = 15;
  private static final Integer MAX_HEIGHT = 25;
  private static final Integer MAX_DEPTH = 10;
  private Integer maxWidth;
  private Integer maxHeight;
  private Integer maxDepth;
  private MailItem mailItem;

  /**
   * Constructs a locker object with the given max dimensions
   * @param maxWidth the max width for mail items
   * @param maxHeight the max height for mail items
   * @param maxDepth the max depth for mail items
   * @throws InvalidDimensionsException if the given max dimensions exceed the maximum allowed dimensions
   */
  public Locker(Integer maxWidth, Integer maxHeight, Integer maxDepth)
      throws InvalidDimensionsException {
    if (maxWidth <= MAX_WIDTH && maxHeight <= MAX_HEIGHT && maxDepth <= MAX_DEPTH) {
      this.maxWidth = maxWidth;
      this.maxHeight = maxHeight;
      this.maxDepth = maxDepth;
    } else {
      throw new InvalidDimensionsException("Locker dimensions cannot be greater than W: 15, H: 25, D: 10");
    }
  }

  /**
   * Adds a mail item to the locker
   * @param mailItem The mail item to be added
   * @throws LockerAlreadyOccupiedException if a mail item already exists in the locker
   * @throws InvalidDimensionsException if the mail item is too large to fit in the locker
   */
  public void addMail(MailItem mailItem)
      throws LockerAlreadyOccupiedException, InvalidDimensionsException {
    if (this.mailItem == null) {
      if (mailItem.getWidth() <= this.maxWidth && mailItem.getHeight() <= this.maxHeight &&
          mailItem.getDepth() <= this.maxDepth) {
        this.mailItem = mailItem;
      } else {
        throw new InvalidDimensionsException("Mail item exceeds max dimensions of the locker.");
      }
    } else {
      throw new LockerAlreadyOccupiedException("There is already a package in the locker.");
    }
  }

  /**
   * Removes and returns the mail item in the locker
   * @param recipient the recipient for the mail item
   * @return the mail item in the locker
   * @throws NonMatchedRecipientException if the recipient does not match the recipient of the mail item
   * @throws NoMailItemException if there is no mail item in the locker
   */
  public MailItem pickupMail(Recipient recipient)
      throws NonMatchedRecipientException, NoMailItemException {
    if (this.mailItem != null) {
      if (this.mailItem.getRecipient().equals(recipient)) {
        MailItem temp = this.mailItem;
        this.mailItem = null;
        return temp;
      } else {
        throw new NonMatchedRecipientException("Recipient does not match the mail item's recipient");
      }
    } else {
      throw new NoMailItemException("There is no mail item to pick up.");
    }
  }

  /**
   * returns the max width of the locker
   * @return the max width of the locker
   */
  public Integer getMaxWidth() {
    return maxWidth;
  }

  /**
   * returns the max height of the locker
   * @return the max height of the locker
   */
  public Integer getMaxHeight() {
    return maxHeight;
  }

  /**
   * returns the max depth of the locker
   * @return the max depth of the locker
   */
  public Integer getMaxDepth() {
    return maxDepth;
  }

  /**
   * returns the mail item in the locker
   * @return the mail item in the locker
   */
  public MailItem getMailItem() {
    return mailItem;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Locker locker = (Locker) o;
    return Objects.equals(maxWidth, locker.maxWidth) && Objects.equals(maxHeight,
        locker.maxHeight) && Objects.equals(maxDepth, locker.maxDepth)
        && Objects.equals(mailItem, locker.mailItem);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxWidth, maxHeight, maxDepth, mailItem);
  }
}
