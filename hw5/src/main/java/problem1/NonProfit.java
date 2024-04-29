package problem1;


import java.util.ArrayList;
import java.util.Objects;

/**
 * A class which represents a nonprofit as its name and the donations received.
 */

public class NonProfit {
  private String organizationName;
  private ArrayList<AbstractDonation> donations;

  /**
   * Constructor for creating a new nonprofit with the given name.
   * @param organizationName - The name to be set, as a String.
   */
  public NonProfit(String organizationName) {
    this.organizationName = organizationName;
    this.donations = new ArrayList<AbstractDonation>();
  }

  /**
   * Returns the organization's name.
   * @return the organization's name.
   */
  public String getOrganizationName() {
    return organizationName;
  }

  /**
   * Returns the list of donations.
   * @return the list of donations.
   */
  public ArrayList<AbstractDonation> getDonations() {
    return donations;
  }

  /**
   * Returns the sum of all donations processed in the specified year.
   * @param year The year to find the sum of all donations from.
   * @return the sum of all donations processed in the specified year, as a Double.
   */
  public Double getTotalDonationsForYear(Integer year) {
    Double totalDonations = 0.0;
    for (Donation donation : this.donations) {
      totalDonations += donation.getYearlyDonation(year);
    }
    return totalDonations;
  }

  /**
   * Adds the given donation to the nonprofit's donations
   * @param donation - The donation to be added
   */
  public void addDonation(AbstractDonation donation) {
    this.donations.add(donation);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(organizationName, nonProfit.organizationName)
        && Objects.equals(donations, nonProfit.donations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(organizationName, donations);
  }

  @Override
  public String toString() {
    return "NonProfit{" +
        "organizationName='" + organizationName + '\'' +
        ", donations=" + donations +
        '}';
  }
}
