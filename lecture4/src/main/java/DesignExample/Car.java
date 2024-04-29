package DesignExample;

public abstract class Car extends AbstractVehicle {
  protected BodyType bodyType;

  public Car(String id, Integer year, MakeModel makeModel, Float msrp, BodyType bodyType) {
    super(String id, Integer year, MakeModel makeModel, Float msrp);
    this.bodyType = bodyType;
  }

  public BodyType getBodyType() {
    return bodyType;
  }
}
