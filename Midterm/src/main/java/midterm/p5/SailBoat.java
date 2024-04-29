package midterm.p5;

public class SailBoat extends CharterBoat {

  private final Double LARGE_MULTIPLIER = 1.15;
  private final Double MIN_SIZE = 45.0;

  public SailBoat(String boatID, Double boatLength, Double pricePerDay, Integer manufacturingYear,
      Integer numCabins, boolean skipperNeeded) {
    super(boatID, boatLength, pricePerDay, manufacturingYear, numCabins, skipperNeeded);
  }

  @Override
  public Double getAnnualEstimation() {
    if (isLarge()) {
      return super.getAnnualEstimation() * LARGE_MULTIPLIER;
    } else {
      return super.getAnnualEstimation();
    }
  }

  private boolean isLarge() {
    return this.boatLength > MIN_SIZE;
  }
}
