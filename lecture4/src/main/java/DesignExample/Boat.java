package DesignExample;

public class Boat extends Vessel {
  private Float length;
  private Integer numPassengers;
  private PropulsionType propulsionType;
  private BoatType boatType;

  public Boat(Float length, Integer numPassengers, PropulsionType propulsionType,
      BoatType boatType) {
    this.length = length;
    this.numPassengers = numPassengers;
    this.propulsionType = propulsionType;
    this.boatType = boatType;
  }

  public Float getLength() {
    return length;
  }

  public Integer getNumPassengers() {
    return numPassengers;
  }

  public PropulsionType getPropulsionType() {
    return propulsionType;
  }

  public BoatType getBoatType() {
    return boatType;
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
    Boat boat = (Boat) object;
    return java.util.Objects.equals(length, boat.length) && java.util.Objects.equals(numPassengers,
        boat.numPassengers) && java.util.Objects.equals(propulsionType, boat.propulsionType)
        && java.util.Objects.equals(boatType, boat.boatType);
  }

  public int hashCode() {
    return Objects.hash(super.hashCode(), length, numPassengers, propulsionType, boatType);
  }

  @java.lang.Override
  public java.lang.String toString() {
    return "Boat{" +
        "length=" + length +
        ", numPassengers=" + numPassengers +
        ", propulsionType=" + propulsionType +
        ", boatType=" + boatType +
        '}';
  }
}