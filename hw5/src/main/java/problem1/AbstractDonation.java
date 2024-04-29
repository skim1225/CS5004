package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Abstract class AbstractDonation represents a donation to a nonprofit in terms of the amount
 * and the creation date of the donation.
 */

public abstract class AbstractDonation implements Donation {

  private Double amount;
  private LocalDateTime creationDate;

  /**
   * Constructor for creating a new donation with the given amount and creation date.
   * @param amount - The amount of the donation, as a Double.
   * @param creationDate - The date of creation of the donation, as a LocalDateTime.
   */
  public AbstractDonation(Double amount, LocalDateTime creationDate) {
    this.amount = amount;
    this.creationDate = creationDate;
  }

  /**
   * Returns the amount of the donation.
   * @return the amount of the donation.
   */
  public Double getAmount() {
    return amount;
  }

  /**
   * Returns the date time of creation of the donation.
   * @return the date time of creation of the donation.
   */
  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractDonation that = (AbstractDonation) o;
    return Objects.equals(amount, that.amount) && Objects.equals(creationDate, that.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, creationDate);
  }

  @Override
  public String toString() {
    return "AbstractDonation{" +
        "amount=" + amount +
        ", date=" + creationDate +
        '}';
  }
}
