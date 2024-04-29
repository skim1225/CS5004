package problem1;

import java.util.Objects;

public abstract class PerishableFood extends FoodItem {
  protected Integer orderDate;
  protected Integer expirationDate;
  protected static final Integer MAX_QTY = 100;

  public PerishableFood(String name, Double currPrice, Integer qtyAvailable,
      Integer orderDate, Integer expirationDate) {
    super(name, currPrice, qtyAvailable, MAX_QTY);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  public Integer getOrderDate() {
    return orderDate;
  }

  public Integer getExpirationDate() {
    return expirationDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    PerishableFood that = (PerishableFood) o;
    return Objects.equals(orderDate, that.orderDate) && Objects.equals(
        expirationDate, that.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), orderDate, expirationDate);
  }

  @Override
  public String toString() {
    return "PerishableFood{" +
        "orderDate=" + orderDate +
        ", expirationDate=" + expirationDate +
        ", name='" + name + '\'' +
        ", currPrice=" + currPrice +
        ", qtyAvailable=" + qtyAvailable +
        ", maxQty=" + maxQty +
        '}';
  }
}
