package problem1;

public abstract class NonPerishableFood extends FoodItem {

  protected static final Integer MAX_QTY = 250;

  public NonPerishableFood(String name, Double currPrice, Integer qtyAvailable) {
    super(name, currPrice, qtyAvailable, MAX_QTY);
  }
}
