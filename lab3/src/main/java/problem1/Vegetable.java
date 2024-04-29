package problem1;

public class Vegetable extends PerishableFood {

  public Vegetable(String name, Double currPrice, Integer qtyAvailable,
      Integer orderDate, Integer expirationDate) {
    super(name, currPrice, qtyAvailable, orderDate, expirationDate);
  }
}
