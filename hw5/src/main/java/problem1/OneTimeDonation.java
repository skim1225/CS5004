package problem1;

import java.time.LocalDateTime;

/**
 * Class OneTimeDonation represents a donation which occurs once at the given date and time.
 */

public class OneTimeDonation extends AbstractDonation {

  /**
   * Constructor for creating a one time donation.
   * @param amount - The amount of the donation, as a Double.
   * @param creationDate - The date/time of the donation, as a LocalDateTime.
   */
  public OneTimeDonation(Double amount, LocalDateTime creationDate) {
    super(amount, creationDate);
  }

  /**
   * Returns the total amount of this donation made in a year, as a double.
   * @param year - The year of the donations to be counted, as an Integer.
   * @return the total amount of this donation made in a year, as a double.
   */
  @Override
  public Double getYearlyDonation(Integer year) {
    if (this.getCreationDate().getYear() == year) {
      return this.getAmount();
    } else {
      return 0.0;
    }
  }
}
