1. Please include a code snippet showing how have you used inheritance and
   composition in your code.

Inheritance:
I have not used inheritance in my code because there are no is-a relationships in my code.
I was unable to use inheritance to make Moving and NonMoving violations child classes of Violation
because enums cannot be child classes. Therefore, I used interfaces instead.

Composition:
```
public class Driver {
  private Name name;
  private Date date;
  private DriversLicense license;
  private Vehicle vehicle;
  private Insurance insurance;
  private List<Violation> drivingHistory;
  private VehicleHistory vehicleHistory;
  ...
  }
```

2. Please include a code snippet showing how have you used an interface or an abstract
   class in your code.

```
public enum MovingViolation implements ViolationType {
```

3. Please include code example of a method overriding and method overloading from
   your code, or explain why you have not used any overloading or overriding.
```
@Override
  public String toString() {
    return year + " " + make + " " + model;
  }
```

4. Please include a code example showing how have you used encapsulation, or explain
   why you did not need encapsulation in your code.
```
public class Driver {
private Name name;
```
I decided to encapsulate the name of the driver as its own Name class instead of a String.

5. Please include a code example of subtype polymorphism from your code, or explain
   why you did not need subtype polymorphism.

I did not need subtype polymorphism in my code because as mentioned previously, there are no valid 
is-a relationships. Therefore, there are no child classes which are subtypes of parent classes.

6. Please include a code snippet of generics from your code.

I did not use generics in my code because there was no requirement to extend class Collection. I 
instead used a List containing a known class rather than a generic.

7. Please include a code snippet showing how have you used some of the built-in data
   collections from the Java Collections Framework, or explain why you had no need for
   any data collections.
```
public class VehicleHistory {
  private List<Crash> crashes;
  private List<Violation> violations;
```

8. Please include a code snippet showing how have you used interfaces Iterable and
   Iterator, or explain why you had no need for these two interfaces.

I did not use Iterable and Iterator because I did not create my own class which extends Collection.
The built-in data collection that I used already implements the iterator.

9. Please include a code snippet showing how have you used interfaces Comparable and
   Comparator, or explain why you had no need for these two interfaces.

I did not need the Comparable or Comparator interfaces because I decided to make all of the dates
LocalDate objects which has built-in support for comparing dates chronologically.

10. Please include a code snippet showing how have you used regular expressions, or
    explain why you had no need for it.
```
private static Driver parseDriverData(String line) {
    String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    for (String value : values) {
```

11. Please include a code snippet showing how have you used nested classes, or justify
    why you had no need for nested classes.

I did not use nested classes because there are no classes that are only used in the 
context of one other class. Additionally, it would make the code less readable if for instance I
made the VehicleHistory class an inner class of the Driver class because of the size of the 
VehicleHistory class.

12. Please include code example showing how have you used components of functional
    programming, such as lambdas and streams, or explain why you had no need for it in
    your code.

```
public static void provideDriverInfo(String lastName) {
    List<Driver> matches = acceptedDrivers.stream().filter(x -> x.getName().getLastName().equals(lastName))
        .toList();
```

13. Please include code snippet(s) showing how have you used creational, structural
    and/or behavioral design patterns. Please list which design patterns have you used,
    or explain why you had no need for design patterns in your solution.

I did not use design patters in my solution because I did not see any appropriate creational,
behavioral, or structural design patterns which would be appropriate. The complicated nature of the
Driver class made creating new instances quite complex and none of the descriptions of the 
creational patterns on the lecture slides seemed to fit my needs, and same with the structural.
I could have used the observer behavioral patterns but since the only user input we needed to observe
was the user entering a file path and potentially last names, it seemed overkill and I was able to
implement the MVC model without the use of the Observer pattern.

14. Please include code snippets showing examples of MVC architecture, or justify why
    you had no need for MVC architecture in your design.

Model:
```
    String input = "";
    while (!Objects.equals(input, "quit")) {
      System.out.println(MENU);
      input = scanner.nextLine();
      switch (input) {
        case "search":
          System.out.println("Enter the last name to search: ");
          String lastName = scanner.nextLine();
          RideshareDriverValidator.provideDriverInfo(lastName);
          break;
        case "quit":
          System.out.println("Quitting the program.");
          break;
        default:
          System.out.println("Invalid option. Try again.");
      }
```

View/Controller:

```
public static void provideDriverInfo(String lastName) {
    List<Driver> matches = acceptedDrivers.stream().filter(x -> x.getName().getLastName().equals(lastName))
        .toList();
    if (matches.isEmpty()) {
      System.out.println("No registered driver found");
    } else {
      for (Driver driver:matches) {
        System.out.println(driver.getVehicle());
        for (Violation violation:driver.getDrivingHistory()) {
          System.out.println("Driving violations: ");
          System.out.println("\t" + violation);
        }
      }
    }
  }
```

15. Please include code examples showing data and stamp coupling in your code

```
  public Driver(Name name, LocalDate birthday, DriversLicense license, Vehicle vehicle,
      Insurance insurance, List<Violation> drivingHistory, VehicleHistory vehicleHistory) {
    this.name = name;
    this.birthday = birthday;
    this.license = license;
    this.vehicle = vehicle;
    this.insurance = insurance;
    this.drivingHistory = drivingHistory;
    this.vehicleHistory = vehicleHistory;
  }
```


Other questions:

1. How to run the program:

Once prompted, enter the absolute file path of the CSV file into the console.
Then, enter "search" if you wish to search for a driver. Then enter the last name of the driver to search.
The console will output information about all of the drivers with that last name or an error message
if there are none. Enter "quit" to exit the program.

2. Overview of the chosen problem, and high-level overview of the solution.

Problem 2 was about developing the driver validation portion of the rideshare app. This portion would
receive information about a prospective driver and determine whether the driver is suitable to be added
to the rideshare app's driver pool.

My solution takes in the CSV file containing driver data, parses and converts it into a list of Drivers,
checks to see which drivers are suitable based on a variety of checks, and adds those drivers to a 
collection. The menu then prompts users to be able to query this pool by last name and displays information
about those drivers.

3. Description of key challenges encountered during design and implementation, and how those challenges were addressed.

- Writing the CSV file of drivers: there is so much information needed to create one driver and it was difficult
and tedious to create the file.
- Writing the parser: since the CSV file contained so many "columns" of data it was difficult to parse
the data cleanly.
- Design: figuring out what classes are needed to encapsulate different information such as the violations.
- I was unable to figure out the solution to many of these difficulties.

4. Sources and resources used in the project:

Information from lecture slides, tried to use ChatGPT to generate CSV files for drivers but it did not work,
looked at HW 8 to help with parsing data, geeks4geeks to answers to Java related questions.
