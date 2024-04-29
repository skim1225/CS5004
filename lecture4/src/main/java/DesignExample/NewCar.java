package DesignExample;

public class NewCar extends Car {
  private Integer numAvailable;
`
  public NewCar(String id, Integer year, MakeModel makeModel, Float msrp, BodyType bodyType, Integer numAvailable) {
  super(String id, Integer year, MakeModel makeModel, Float msrp, BodyType bodyType);
    this.numAvailable = numAvailable;
  }

  public Integer getNumAvailable() {
    return numAvailable;
  }

  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    NewCar newCar = (NewCar) object;
    return Objects.equals(this.id, newCar.id) && Objects.equals(this.year, newCar.year) &&
        Objects.equals(this.makeModel, newCar.makeMoedl) && Objects.equals(this.msrp, newCar.msrp) &&
        Objects.equals(this.bodyType, newCar.bodyType) && java.util.Objects.equals(numAvailable, newCar.numAvailable);
  }

  public int hashCode() {
    return Objects.hash(id, year, makeModel, msrp, bodyType, numAvailable);
  }
}
