package Problem2;

/**
 * Interface IPolynomial gives information about the functionality support by the
 * Polynomial ADT
 */

public interface IPolynomial {

  Integer getDegree();
  Integer getCoefficient(Integer power);
  void addTerm(Integer coefficient, Integer power) throws InvalidCoefficientException;
  void removeTerm(Integer power);
  Boolean isSame(Polynomial other);
  Polynomial add(Polynomial other) throws InvalidCoefficientException;
  String printPolynomial();

}
