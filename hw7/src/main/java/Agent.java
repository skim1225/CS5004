import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Objects;
>>>>>>> main

public class Agent<P extends Property, C extends Contract> {

  private String agentName;
  private ArrayList<Listing<? extends P, ? extends C>> listings;
  private Double commissionRate;
  private Double totalEarnings;
<<<<<<< HEAD

  public Agent(String agentName, Double commissionRate) {
    this.agentName = agentName;
    this.listings = new ArrayList<>();
    this.commissionRate = commissionRate;
    this.totalEarnings = 0.0;
  }

  public void addListing(Listing<? extends P, ? extends C> listing) {
    this.listings.add(listing);
  }

=======
  private static final Double MIN_RATE = 0.0;
  private static final Double MAX_RATE = 1.0;

 /**
  * Constructor to create new Agent object with given agentName and the commissionRate.
  * @param agentName The name of the Agent
  * @param commissionRate the commission rate the agent charges per listing.
  */
  public Agent(String agentName, Double commissionRate) throws InvalidArgumentException {
    if (this.isValidCommissionRate(commissionRate)) {
      this.agentName = agentName;
      this.listings = new ArrayList<>();
      this.commissionRate = commissionRate;
      this.totalEarnings = 0.0;
    }
  }
 /**
  * Helper method to validate whether the Agent's commission rate is between 0 and 1.
  * @param commissionRate Agent's commission rate
  * @return returns false if it's outside the of the boundaries of 0 or 1 and true if it is
  * within 0 and 1.
  */
  private Boolean isValidCommissionRate(Double commissionRate) throws InvalidArgumentException{
    if (commissionRate >= MIN_RATE && commissionRate <= MAX_RATE) {
      return Boolean.TRUE;
    } else {
      throw new InvalidArgumentException("Commission Rate must be between 0 and 1.");
    }
  }   

 /**
  * Method that adds an appropriate listing to the agent's collection of listing
  * @param listing The listing to be added to the agent's listing. Has wildcard generics that extends
  * P and C
  */
  public void addListing(Listing<? extends P, ? extends C> listing) {
    this.listings.add(listing);
  }
  
 /**
  * Method that allows a listing to be marked as completed. When the method is called, the listing
  * will be moved from the agent's collection of listing and the commission for the listing will be
  * calculated to the agent's total earnings.
  * @param listing The listing to be marked completed and removed from the agent's listing.
  * @throws InvalidListingException If the listing does not exist in the agent's collection
  */
>>>>>>> main
  public void completeListing(Listing<? extends P, ? extends C> listing) throws InvalidListingException {
    if(this.listings.contains(listing)) {
      this.totalEarnings += this.commissionRate*listing.getContract().calculateCommissionEarnings();
      this.listings.remove(listing);
    } else {
      throw new InvalidListingException("Listing does not exist in this agent collection.");
    }
  }
<<<<<<< HEAD

=======
  
 /**
  * Method that removes a specified listing from the agent's listing if the listing exists in the
  * agent's collection
  * @param listing The listing to be removed from the agent's listing. Has Wildcard generics that extends
  * P and C
  * @throws InvalidListingException - If the listing does not exist in the collection
  */
>>>>>>> main
  public void dropListing(Listing<? extends P, ? extends C> listing) throws InvalidListingException {
    if(this.listings.contains(listing)) {
      this.listings.remove(listing);
    } else {
      throw new InvalidListingException("Listing does not exist in this agent collection.");
    }
  }

<<<<<<< HEAD
=======
 /**
  * Method that returns the total value of an agent's listing collection. If they were to complete
  * transaction for all the listings in their portfolio
  * @return returns the Total portfolio value as a double
  */
>>>>>>> main
  public double getTotalPortfolioValue() {
    double totalAmountOfListings = 0.0;
    for (Listing<? extends P, ? extends C> listing : listings) {
      totalAmountOfListings += this.commissionRate*listing.getContract().calculateCommissionEarnings();
    }
    return totalAmountOfListings;
  }
<<<<<<< HEAD

=======
  
 /**
  *Getter method that retrieves the Agent's name
  * @return returns the agent's name as a String
  */
>>>>>>> main
  public String getAgentName() {
    return agentName;
  }

<<<<<<< HEAD
=======
 /**
  * Getter method that retrieves the listings of an Agent
  * @return returns an Arraylist of listings
  */
>>>>>>> main
  public ArrayList<Listing<? extends P, ? extends C>> getListings() {
    return listings;
  }

<<<<<<< HEAD
=======
 /**
  * Getter method that retrieves the CommissionRate of an Agent
  * @return returns the CommissionRate as a double
  */
>>>>>>> main
  public Double getCommissionRate() {
    return commissionRate;
  }

<<<<<<< HEAD
  public Double getTotalEarnings() {
    return totalEarnings;
  }
}
=======
 /**
  * Getter method that retrieves the totalEarnings of an Agent
  * @return returns the totalEarnings as a double
  */
  public Double getTotalEarnings() {
    return totalEarnings;
  }
  
 /**
  * Our team has made the decision to not override the equals method as we only consider two agent
  * objects to be equal if their listing is in the same exact order.
  */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Agent<?, ?> agent = (Agent<?, ?>) o;
    return Objects.equals(agentName, agent.agentName) && Objects.equals(listings,
        agent.listings) && Objects.equals(commissionRate, agent.commissionRate)
        && Objects.equals(totalEarnings, agent.totalEarnings);
  }
    
  @Override
  public int hashCode() {
    return Objects.hash(agentName, listings, commissionRate, totalEarnings);
  }
    
  @Override
  public String toString() {
    return "Agent{" +
        "agentName='" + agentName + '\'' +
        ", listings=" + listings +
        ", commissionRate=" + commissionRate +
        ", totalEarnings=" + totalEarnings +
        '}';
  }
}
>>>>>>> main
