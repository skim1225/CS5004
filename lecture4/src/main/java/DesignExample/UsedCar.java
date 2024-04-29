package DesignExample;

public class UsedCar extends Car{
  private Integer mileage;
  private Integer numPreviousOwners;
  private Integer numAccidents;
  private Boolean certifiedPreowned;

  public UsedCar(String id, Integer year, MakeModel makeModel, Float msrp, BodyType bodyType,
      Integer mileage, Integer numPreviousOwners, Integer numAccidents, Boolean certifiedPreowned) {
    super(String id, Integer year, MakeModel makeModel, Float msrp, BodyType bodyType);
    this.mileage = mileage;
    this.numPreviousOwners = numPreviousOwners;
    this.numAccidents = numAccidents;
    this.certifiedPreowned = certifiedPreowned;
  }

  public Integer getMileage() {
    return mileage;
  }

  public Integer getNumPreviousOwners() {
    return numPreviousOwners;
  }

  public Integer getNumAccidents() {
    return numAccidents;
  }

  public Boolean getCertifiedPreowned() {
    return certifiedPreowned;
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "UsedCar{" +
        "mileage=" + mileage +
        ", numPreviousOwners=" + numPreviousOwners +
        ", numAccidents=" + numAccidents +
        ", certifiedPreowned=" + certifiedPreowned +
        '}';
  }
}
