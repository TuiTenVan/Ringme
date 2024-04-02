package JDBC_Hibernate;

import java.util.*;

public class BusManagementSystem {
    private List<Driver> drivers;
    private List<Route> routes;
    private List<Assignment> assignments;
    private Set<Pair<Driver, Route>> assignedPairs;
    private Scanner sc;
    public BusManagementSystem() {
        drivers = new ArrayList<>();
        routes = new ArrayList<>();
        assignments = new ArrayList<>();
        assignedPairs = new LinkedHashSet<>();
        sc = new Scanner(System.in);
    }

    public void addDriver() {
        System.out.print("Enter number of drivers to add: ");
        int numDrivers = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numDrivers; i++) {
            System.out.println("Driver " + (i + 1) + ":");
            System.out.print("Enter driver name: ");
            String name = sc.nextLine();
            System.out.print("Enter driver address: ");
            String address = sc.nextLine();
            System.out.print("Enter driver phone number: ");
            String phoneNumber = sc.nextLine();
            System.out.print("Enter driver qualification: ");
            String qualification = sc.nextLine();
            Driver driver = new Driver(name, address, phoneNumber, qualification);
            drivers.add(driver);
            System.out.println("Driver added successfully: " + driver);
        }
    }
    public void addRoute() {
        System.out.print("Enter number of routes to add: ");
        int numRoutes = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numRoutes; i++) {
            System.out.println("Route " + (i + 1) + ":");
            System.out.print("Enter route distance: ");
            double distance = sc.nextDouble();
            System.out.print("Enter number of stops: ");
            int numberOfStops = sc.nextInt();
            Route route = new Route(distance, numberOfStops);
            routes.add(route);
            System.out.println("Route added successfully: " + route);
        }
    }

    public void assignDriverToRoute() {
        System.out.println("Available drivers:");
        for (Driver driver : drivers) {
            System.out.println(driver.getMaLX() + ". " + driver.getName());
        }
        sc.nextLine();
        System.out.print("Enter driver ID: ");
        String driverId = sc.nextLine();
        System.out.println("Available routes:");
        for (Route route : routes) {
            System.out.println(route.getMaTuyen() + ". Distance: " + route.getDistance() + " km, Stops: " + route.getNumberOfStops());
        }
        System.out.print("Enter route ID: ");
        String routeId = sc.nextLine();
        System.out.print("Enter number of trips: ");
        int numberOfTrips = sc.nextInt();
        Driver selectedDriver = drivers.stream().filter(d -> d.getMaLX().equals(driverId)).findFirst().orElse(null);
        Route selectedRoute = routes.stream().filter(r -> r.getMaTuyen().equals(routeId)).findFirst().orElse(null);
        if (selectedDriver != null && selectedRoute != null) {
            Pair<Driver, Route> newPair = new Pair<>(selectedDriver, selectedRoute);
            if (!assignedPairs.contains(newPair)) {
                Assignment newAssignment = new Assignment(selectedDriver, selectedRoute, numberOfTrips);
                assignments.add(newAssignment);
                assignedPairs.add(newPair);
                System.out.println("Driver assigned to route successfully.");
            } else {
                System.out.println("This assignment already exists.");
            }
        } else {
            System.out.println("Invalid driver or route ID.");
        }
    }

    public void sortAssignmentsByName() {
        Collections.sort(assignments, Comparator.comparing(a -> a.getDriver().getName()));
        System.out.println("Assignments sorted by name:");
        for (Assignment assignment : assignments) {
            System.out.println(assignment);
        }
    }

    public void sortAssignmentsByTrips() {
        Collections.sort(assignments, (a1, a2) -> Integer.compare(a2.getNumberOfTrips(), a1.getNumberOfTrips()));
        System.out.println("Assignments sorted by number of trips:");
        for (Assignment assignment : assignments) {
            System.out.println(assignment);
        }
    }


    public void generateDistanceReport() {
        Map<Driver, Double> distanceReport = new HashMap<>();
        for (Assignment assignment : assignments) {
            Driver driver = assignment.getDriver();
            double distance = assignment.getNumberOfTrips() * assignment.getRoute().getDistance();
            distanceReport.put(driver, distanceReport.getOrDefault(driver, 0.0) + distance);
        }
        for (Map.Entry<Driver, Double> entry : distanceReport.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue() + " km");
        }
    }
    public void printDrivers() {
        System.out.println("List of Drivers:");
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }

    public void printRoutes() {
        System.out.println("List of Routes:");
        for (Route route : routes) {
            System.out.println(route);
        }
    }

    public void printAssignments() {
        System.out.println("List of Assignments:");
        for (Assignment assignment : assignments) {
            System.out.println(assignment);
        }
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
}
