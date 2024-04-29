package problem3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerAccountTest {

  private CustomerAccount testAccount;
  private UniqueIdentifier expectedID;
  private Amount expectedCurrentBalance;

  @BeforeEach
  void setUp() {
    testAccount = new CustomerAccount(new UniqueIdentifier(2023,"Korea"), new Amount(1000000, 0));
    expectedID = new UniqueIdentifier(2023, "Korea");
    expectedCurrentBalance = new Amount(1000000, 0);
  }

  @Test
  void getId() {
    assertEquals(expectedID, testAccount.getId());
  }

  @Test
  void getCurrentBalance() {
    assertEquals(expectedCurrentBalance, testAccount.getCurrentBalance());
  }

  @Test
  void deposit() {
    Amount amountToDeposit = new Amount(1,1);
    Amount expectedAmount = new Amount(1000001, 1);
    CustomerAccount expectedAccount = new CustomerAccount(testAccount.getId(), expectedAmount);
    CustomerAccount afterDepositAccount = testAccount.deposit(amountToDeposit);
    assertEquals(expectedAccount, afterDepositAccount);
  }

  @Test
  void withdraw() {
    Amount amountToWithdraw = new Amount(1,0);
    Amount expectedAmount = new Amount(999999, 0);
    CustomerAccount expectedAccount = new CustomerAccount(testAccount.getId(), expectedAmount);
    CustomerAccount afterWithdrawalAccount = testAccount.withdraw(amountToWithdraw);
    assertEquals(expectedAccount, afterWithdrawalAccount);
  }

  @Test
  void convert() {
    double expectedBTC = 25.0;
    assertEquals(expectedBTC, testAccount.convert(testAccount.getCurrentBalance()));
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testAccount.equals(testAccount));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testAccount.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testAccount.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectsSameID() {
    UniqueIdentifier otherID = new UniqueIdentifier(2023, "Korea");
    Amount otherCurrentBalance = new Amount(1, 1);
    CustomerAccount otherAccount = new CustomerAccount(otherID, otherCurrentBalance);
    assertNotEquals(otherAccount, testAccount);
  }

  @Test
  void testEquals_DifferentObjectsSameAmount() {
    UniqueIdentifier otherID = new UniqueIdentifier(2024, "Japan");
    Amount otherCurrentBalance = new Amount(1000000, 0);
    CustomerAccount otherAccount = new CustomerAccount(otherID, otherCurrentBalance);
    assertNotEquals(otherAccount, testAccount);
  }

  @Test
  void testEquals_DifferentObjectsSameValues() {
    UniqueIdentifier otherID = new UniqueIdentifier(2023, "Korea");
    Amount otherCurrentBalance = new Amount(1000000, 0);
    CustomerAccount otherAccount = new CustomerAccount(otherID, otherCurrentBalance);
    assertEquals(otherAccount, testAccount);
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testAccount.getId(), testAccount.getCurrentBalance());
    assertEquals(expectedHashCode, testAccount.hashCode());
  }
}