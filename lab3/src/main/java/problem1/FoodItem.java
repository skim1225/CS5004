package problem1;

import java.util.Objects;

public abstract class FoodItem {
  protected String name;
  protected Double currPrice;
  protected Integer qtyAvailable;
  protected Integer maxQty;

  public FoodItem(String name, Double currPrice, Integer qtyAvailable, Integer maxQty) {
    this.name = name;
    this.currPrice = currPrice;
    this.qtyAvailable = qtyAvailable;
    this.maxQty = maxQty;
  }

  public String getName() {
    return name;
  }

  public Double getCurrPrice() {
    return currPrice;
  }

  public Integer getQtyAvailable() {
    return qtyAvailable;
  }

  public Integer getMaxQty() {
    return maxQty;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodItem foodItem = (FoodItem) o;
    return Objects.equals(name, foodItem.name) && Objects.equals(currPrice,
        foodItem.currPrice) && Objects.equals(qtyAvailable, foodItem.qtyAvailable)
        && Objects.equals(maxQty, foodItem.maxQty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, currPrice, qtyAvailable, maxQty);
  }

  @Override
  public String toString() {
    return "FoodItem{" +
        "name='" + name + '\'' +
        ", currPrice=" + currPrice +
        ", qtyAvailable=" + qtyAvailable +
        ", maxQty=" + maxQty +
        '}';
  }
}
