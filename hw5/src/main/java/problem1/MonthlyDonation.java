package problem1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Class MonthlyDonation represents a recurring donation every month which can be canceled.
 */

public class MonthlyDonation extends AbstractDonation {

  private static final Integer MONTHS_IN_YEAR = 12;

  private static final Integer NUM_DONO_ADJUSTMENT = 1;
  private LocalDateTime cancellationDateTime;

  /**
   * Constructor for creating a new MonthlyDonation object which does not yet have  a
   * cancellation date.
   * @param amount - The amount of the donation, as a Double.
   * @param creationDate - The date of creation of the donation, as a LocalDateTime.
   */
  public MonthlyDonation(Double amount, LocalDateTime creationDate) {
    super(amount, creationDate);
  }

  /**
   * Returns the cancellation date time of the donation.
   * @return the cancellation date time of the donation.
   */
  public LocalDateTime getCancellationDateTime() {
    return cancellationDateTime;
  }

  /**
   * Sets the cancellation date time of the donation.
   * @param cancellationDateTime - The cancellation date time to be set, as a LocalDateTime.
   * @throws InvalidDateException if the given cancellation date is prior to the creation date.
   */
  public void setCancellationDateTime(LocalDateTime cancellationDateTime)
      throws InvalidDateException {
    if (cancellationDateTime.isAfter(this.getCreationDate())) {
      this.cancellationDateTime = cancellationDateTime;
    } else {
      throw new InvalidDateException("The cancellation date cannot be prior to the creation date.");
    }
  }

  /**
   * Returns the total amount of this donation made in a year, as a double.
   * @param year - The year of the donations to be counted, as an Integer.
   * @return the total amount of this donation made in a year, as a double.
   */
  @Override
  public Double getYearlyDonation(Integer year) {
    int numMonths;
    int creationYear = this.getCreationDate().getYear();
    // case 0: if given year is before donation was created, no donations.
    if (creationYear > year) {
      numMonths = 0;
    } else {
      // case 1: cancellation date doesn't exist
      if (cancellationDateTime == null) {
        // case 1a: given year is same as creation year (calculate # of months x donation)
        if (creationYear == year) {
          LocalDateTime end = LocalDateTime.of(year, 12, 31, 23, 59, 59);
          long months = this.getCreationDate().until(end, ChronoUnit.MONTHS);
          numMonths = (int) months + NUM_DONO_ADJUSTMENT;
        } else  {
          // case 1b: given year is after creation year (donation x 12)
          numMonths = MONTHS_IN_YEAR;
        }
      } else {
        // case 2: cancellation date exists
        int cancellationYear = this.getCancellationDateTime().getYear();
        // case 2a: cancel year before given year
        if (cancellationYear < year) {
          numMonths = 0;
        } else if (creationYear < year && cancellationYear > year) {
          // case 2b: creation year before given year and cancel year after given year
          numMonths = MONTHS_IN_YEAR;
        } else if (creationYear < year && cancellationYear == year) {
          // case 2c: creation year before given year and cancel year same as given year
          // 1 = january, didn't see need to create constant for this
          LocalDateTime start = this.getCreationDate().withMonth(1).withYear(year);
          long months = start.until(this.getCancellationDateTime(), ChronoUnit.MONTHS);
          numMonths = (int) months + NUM_DONO_ADJUSTMENT;
        } else {
          // case 2d: creation year and cancel year same as given year
          long months = this.getCreationDate().until(this.getCancellationDateTime(), ChronoUnit.MONTHS);
          numMonths = (int) months + NUM_DONO_ADJUSTMENT;
        }
      }
    }
    return numMonths * this.getAmount();
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
    MonthlyDonation that = (MonthlyDonation) o;
    return Objects.equals(cancellationDateTime, that.cancellationDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), cancellationDateTime);
  }
}
