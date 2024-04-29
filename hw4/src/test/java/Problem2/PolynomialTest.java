package Problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PolynomialTest {

  private Polynomial testPolynomial;
  private TermNode expectedHead;
  private Integer expectedSize;

  @BeforeEach
  void setUp() throws InvalidCoefficientException {
    testPolynomial = new Polynomial();
    testPolynomial.addTerm(2,2);
    testPolynomial.addTerm(3,1);
    testPolynomial.addTerm(4,0);
    expectedHead = new TermNode(2,2);
    expectedSize = 3;
  }

  @Test
  void getHead() {
    assertEquals(expectedHead, testPolynomial.getHead());
  }

  @Test
  void getSize() {
    assertEquals(expectedSize, testPolynomial.getSize());
  }

  @Test
  void getDegree() {
    assertEquals(testPolynomial.getDegree(), 2);
  }

  @Test
  void getCoefficient() {
    assertEquals(testPolynomial.getCoefficient(1), 3);
  }

  @Test
  void getCoefficient_TermDoesNotExist() {
    assertEquals(testPolynomial.getCoefficient(10), 0);
  }

  @Test
  void addTerm_ExistingPower() throws InvalidCoefficientException {
    testPolynomial.addTerm(2,2);
    assertEquals(testPolynomial.getCoefficient(2), 4);
  }

  @Test
  void addTerm_NewPower() throws InvalidCoefficientException {
    testPolynomial.addTerm(3,3);
    assertEquals(4, testPolynomial.getSize());
  }

  @Test
  void addTerm_InvalidCoefficient() throws InvalidCoefficientException {
    Assertions.assertThrows(InvalidCoefficientException.class, () -> {
      testPolynomial.addTerm(0,0);
    });
  }

  @Test
  void removeTerm_Head() {
    testPolynomial.removeTerm(2);
    assertEquals(2, testPolynomial.getSize());
  }

  @Test
  void isSame() throws InvalidCoefficientException {
    Polynomial other = new Polynomial();
    other.addTerm(2,2);
    other.addTerm(3,1);
    other.addTerm(4,0);
    assertTrue(testPolynomial.isSame(other));
  }

  @Test
  void isSame_DifferentSizes() throws InvalidCoefficientException {
    Polynomial other = new Polynomial();
    other.addTerm(2,2);
    assertFalse(testPolynomial.isSame(other));
  }

  @Test
  void isSame_DifferentPolynomials() throws InvalidCoefficientException {
    Polynomial other = new Polynomial();
    other.addTerm(10,2);
    other.addTerm(10,1);
    other.addTerm(10,0);
    assertFalse(testPolynomial.isSame(other));
  }

  @Test
  void add() throws InvalidCoefficientException {
    Polynomial other = new Polynomial();
    other.addTerm(4,3);
    other.addTerm(1,1);
    Polynomial sum = testPolynomial.add(other);
    Polynomial expected = new Polynomial();
    expected.addTerm(4,3);
    expected.addTerm(2,2);
    expected.addTerm(4,1);
    expected.addTerm(4,0);
    assertEquals(sum, expected);
  }

  @Test
  void printPolynomial() {
    String expectedString = "2x^2 + 3x^1 + 4x^0";
    assertEquals(expectedString, testPolynomial.printPolynomial());
  }
}