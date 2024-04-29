package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {

  private static final Integer CUTOFF_YEAR = 1999;
  private List<Vehicle> vehicles = new ArrayList<>();
  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle
      vehicle2, Vehicle vehicle3){
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle2);
  }
  public void filterVWvehicles(){
    // turn into stream
    List<Vehicle> result = vehicles.stream()
        // filter out older vehicles using lambda
        .filter(x -> x.getYear() >= CUTOFF_YEAR)
        // print out vehicles
        .collect(Collectors.toList());
    // prints out all info
    // result.stream().forEach(System.out::println);

    // prints out some info
    result.stream().map(x -> x.getMake() + " " + x.getModel() + " " + x.getYear())
        .forEach(System.out::println);

    // another approach
    result.stream()
        .map(OlderVehiclesFilter::makeToMakeModelYear)
        .forEach(System.out::println);

    // another approach
    result.stream()
        .forEach(x -> OlderVehiclesFilter.printVehicleInfo(x));

    // all together
    vehicles.stream()
        .filter(x -> x.getYear() >= CUTOFF_YEAR)
        .map(y -> y.getMake() + " " + y.getModel() + " " + y.getYear())
        .forEach(System.out::println);
  }

  private static String makeToMakeModelYear(Vehicle vehicle) {
    return new String(vehicle.getMake() + " "  + vehicle.getModel() + " " +  vehicle.getYear());
  }

  private static void printVehicleInfo(Vehicle vehicle) {
    System.out.println(vehicle.getMake() + " "  + vehicle.getModel() + " " +  vehicle.getYear());
  }
}