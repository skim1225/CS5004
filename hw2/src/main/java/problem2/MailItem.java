package problem2;

import java.util.Objects;

/**
 * This class represents a mail item which has 3 dimensions and a recipient.
 */
public class MailItem {

  private static final Double MIN_WIDTH = 1.5;
  private static final Integer MIN_HEIGHT = 2;
  private static final Integer MIN_DEPTH = 1;
  private Double width;
  private Integer height;
  private Integer depth;
  private Recipient recipient;

  /**
   * Constructs a MailItem object with the given dimensions and recipient.
   * @param width The width of the mail item to be given
   * @param height The height of the mail item to be given
   * @param depth The depth of the mail item to be given
   * @param recipient The recipient of the mail item to be given
   */
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

  /**
   * Returns the width of the mail item
   * @return the width of the mail item
   */
  public Double getWidth() {
    return width;
  }

  /**
   * Returns the height of the mail item
   * @return the height of the mail item
   */
  public Integer getHeight() {
    return height;
  }

  /**
   * Returns the depth of the mail item
   * @return the depth of the mail item
   */
  public Integer getDepth() {
    return depth;
  }

  /**
   * Returns the recipient of the mail item
   * @return the recipient of the mail item
   */
  public Recipient getRecipient() {
    return recipient;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailItem mailItem = (MailItem) o;
    return Objects.equals(width, mailItem.width) && Objects.equals(height,
        mailItem.height) && Objects.equals(depth, mailItem.depth)
        && Objects.equals(recipient, mailItem.recipient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, height, depth, recipient);
  }
}
