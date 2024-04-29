package DesignExample;

public abstract class AbstractVehicle implements Vehicle {
  protected String id;
  protected Integer year;
  protected MakeModel makeModel;
  protected Float msrp;

  public AbstractVehicle(String id, Integer year, MakeModel makeModel, Float msrp) {
    this.id = id;
    this.year = year;
    this.makeModel = makeModel;
    this.msrp = msrp;
  }

  public String getId() {
    return id;
  }

  public Integer getYear() {
    return year;
  }

  public MakeModel getMakeModel() {
    return makeModel;
  }

  public Float getMsrp() {
    return msrp;
  }
}
