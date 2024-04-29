package problem3;

import java.util.Objects;

/**
 * Class CustomerAccount stores information about a Customer's Bank Account
 */

public class CustomerAccount {

  private final Double USD_TO_BTC = 0.000025;
  private final UniqueIdentifier id;
  private final Amount currentBalance;

  /**
   * Constructor for the class Customer Account
   * @param id - UniqueIdentifier, representing the unique identifier for the customer's account
   * @param currentBalance - Amount, representing the current balance for the customer's account
   */
  public CustomerAccount(UniqueIdentifier id, Amount currentBalance) {
    this.id = id;
    this.currentBalance = currentBalance;
  }

  /**
   * @return id, giving the unique id of the customer account
   */
  public final UniqueIdentifier getId() {
    return id;
  }

  /**
   * @return currentBalance, giving the current amount in the customer's acount
   */
  public final Amount getCurrentBalance() {
    return currentBalance;
  }

  /**
   * Method for adding money to the user's balance
   * @param amountDeposited - Amount, giving the amount of money to be deposited.
   * @return - a new CustomerAccount object with the updated balance.
   */
  public final CustomerAccount deposit(Amount amountDeposited) {
    int currDollars = this.currentBalance.getDollars();
    int currCents = this.currentBalance.getCents();
    int dollarsDeposited = amountDeposited.getDollars();
    int centsDeposited = amountDeposited.getCents();
    Amount newBalance;
    if (currCents + centsDeposited >= 100) {
       newBalance = new Amount(currDollars + dollarsDeposited + 1, currCents + centsDeposited - 100);
    } else {
      newBalance = new Amount(currDollars + dollarsDeposited, currCents + centsDeposited);
    }
    return new CustomerAccount(this.id, newBalance);
  }

  /**
   * Method for subtracting money from the user's balance.
   * @param amountWithdrawn - Amount, giving the amount of money to be withdrawn.
   * @return - a new CustomerAccount object with the updated balance.
   */
  public final CustomerAccount withdraw(Amount amountWithdrawn) {
    int currDollars = this.currentBalance.getDollars();
    int currCents = this.currentBalance.getCents();
    int dollarsWithdrawn = amountWithdrawn.getDollars();
    int centsWithdrawn = amountWithdrawn.getCents();
    Amount newBalance;
    // todo: handle cents becoming negative
    if (currCents - centsWithdrawn < 0) {
      newBalance = new Amount(currDollars - dollarsWithdrawn - 1, currCents - centsWithdrawn + 100);
    } else {
      newBalance = new Amount(currDollars - dollarsWithdrawn, currCents - centsWithdrawn);
    }
    return new CustomerAccount(this.id, newBalance);
  }

  /**
   * A method for converting the current balance of the account from USD to BTC.
   * @param amount - The amount to be converted
   * @return - Double, giving the amount of money in BTC
   */
  public final Double convert(Amount amount) {
    double usd = amount.getDollars() + (double) amount.getCents()/100;
    return usd *  USD_TO_BTC;
  }

  /**
   * @param o - the CustomerAccount object to be compared to
   * @return - Boolean, giving whether the 2 athletes have the same field values
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerAccount that = (CustomerAccount) o;
    return Objects.equals(id, that.id) && Objects.equals(currentBalance,
        that.currentBalance);
  }

  /**
   * @return int, giving the CustomerAccount object's hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, currentBalance);
  }
}
