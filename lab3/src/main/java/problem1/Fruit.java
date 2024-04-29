package problem1;

public class Fruit extends PerishableFood {

  public Fruit(String name, Double currPrice, Integer qtyAvailable,
      Integer orderDate,
      Integer expirationDate) {
    super(name, currPrice, qtyAvailable, orderDate, expirationDate);
  }
}
