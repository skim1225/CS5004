package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class Pledge represents a pledge to donate in the future as its processing date.
 */

public class Pledge extends AbstractDonation {

  private LocalDateTime processingDate;

  /**
   * Constructor for creating a new Pledge object with the given amount, creation date,
   * and processing date.
   * @param amount - The amount of the donation, as a Double.
   * @param creationDate - The date/time of the donation, as a LocalDateTime.
   * @param processingDate - The date/time to process the donation, as a LocalDateTime.
   */
  public Pledge(Double amount, LocalDateTime creationDate, LocalDateTime processingDate) {
    super(amount, creationDate);
    this.processingDate = processingDate;
  }

  /**
   * Constructor for creating a new Pledge object with the given amount, creation date, and no
   * processing date.
   * @param amount - The amount of the donation, as a Double.
   * @param creationDate - The date/time of the donation, as a LocalDateTime.
   */
  public Pledge(Double amount, LocalDateTime creationDate) {
    super(amount, creationDate);
  }

  /**
   * Returns the processing date time of the pledge.
   * @return the processing date time of the pledge.
   */
  public LocalDateTime getProcessingDate() {
    return processingDate;
  }

  /**
   * Sets the processing date of the pledge.
   * @param processingDate - The processing date to be set, as a LocalDateTime.
   * @throws InvalidDateException if the processing set is prior to the creation date.
   */
  public void setProcessingDate(LocalDateTime processingDate) throws InvalidDateException {
    if (processingDate.isAfter(this.getCreationDate())) {
      this.processingDate = processingDate;
    } else {
      throw new InvalidDateException("The processing date must be after the creation date.");
    }
  }

  /**
   * Returns the total amount of this donation made in a year, as a Double.
   * @param year - The year of the donations to be counted, as an Integer.
   * @return the total amount of this donation made in a year, as a Double.
   */
  @Override
  public Double getYearlyDonation(Integer year) {
    if (this.processingDate != null && this.processingDate.getYear() == year) {
      return this.getAmount();
    } else {
      return 0.0;
    }
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
    Pledge pledge = (Pledge) o;
    return Objects.equals(processingDate, pledge.processingDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), processingDate);
  }
}
