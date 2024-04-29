package problem1;

public class Meat extends PerishableFood {

  public Meat(String name, Double currPrice, Integer qtyAvailable,
      Integer orderDate, Integer expirationDate) {
    super(name, currPrice, qtyAvailable, orderDate, expirationDate);
  }
}
