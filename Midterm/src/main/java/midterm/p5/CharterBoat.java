package midterm.p5;

import java.util.Objects;

public abstract class CharterBoat {

  private final Integer NUM_DAYS = 80;

  protected String boatID;
  protected Double boatLength;
  protected Double pricePerDay;
  protected Integer manufacturingYear;
  protected Integer numCabins;
  protected boolean skipperNeeded;

  public CharterBoat(String boatID, Double boatLength, Double pricePerDay,
      Integer manufacturingYear,
      Integer numCabins, boolean skipperNeeded) {
    this.boatID = boatID;
    this.boatLength = boatLength;
    this.pricePerDay = pricePerDay;
    this.manufacturingYear = manufacturingYear;
    this.numCabins = numCabins;
    this.skipperNeeded = skipperNeeded;
  }

  public Double getAnnualEstimation() {
    return NUM_DAYS * this.pricePerDay;
  }

  public String getBoatID() {
    return boatID;
  }

  public Double getBoatLength() {
    return boatLength;
  }

  public Double getPricePerDay() {
    return pricePerDay;
  }

  public Integer getManufacturingYear() {
    return manufacturingYear;
  }

  public Integer getNumCabins() {
    return numCabins;
  }

  public boolean isSkipperNeeded() {
    return skipperNeeded;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharterBoat that = (CharterBoat) o;
    return skipperNeeded == that.skipperNeeded && Objects.equals(boatID, that.boatID)
        && Objects.equals(boatLength, that.boatLength) && Objects.equals(
        pricePerDay, that.pricePerDay) && Objects.equals(manufacturingYear,
        that.manufacturingYear) && Objects.equals(numCabins, that.numCabins);
  }

  @Override
  public int hashCode() {
    return Objects.hash(boatID, boatLength, pricePerDay, manufacturingYear, numCabins,
        skipperNeeded);
  }
}
