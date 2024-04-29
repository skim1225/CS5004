package midterm.p5;

public class MotorBoat extends CharterBoat {

  private final Double YOUNG_MULTIPLIER = 1.35;
  private final Integer MIN_YEAR = 2010;
  private Double enginePower;

  public MotorBoat(String boatID, Double boatLength, Double pricePerDay, Integer manufacturingYear,
      Integer numCabins, boolean skipperNeeded, Double enginePower) {
    super(boatID, boatLength, pricePerDay, manufacturingYear, numCabins, skipperNeeded);
    this.enginePower = enginePower;
  }

  @Override
  public Double getAnnualEstimation() {
    if (isYoung()) {
      return super.getAnnualEstimation() * YOUNG_MULTIPLIER;
    } else {
      return super.getAnnualEstimation();
    }
  }

  private boolean isYoung() {
    return this.manufacturingYear > MIN_YEAR;
  }
}
