package problem1;

/**
 * Interface donation represents expected behavior of all Donation objects.
 */
public interface Donation {

  /**
   * Returns the total amount of this donation made in a year, as a double.
   * @param year - The year of the donations to be counted, as an Integer.
   * @return the total amount of this donation made in a year, as a double.
   */
  Double getYearlyDonation(Integer year);
}
