package PHAN_CONG_LAI_XE_BUS;

public class Assignment {
    private Driver driver;
    private Route route;
    private int numberOfTrips;

    public Assignment(Driver driver, Route route, int numberOfTrips) {
        this.driver = driver;
        this.route = route;
        this.numberOfTrips = numberOfTrips;
    }

    public Driver getDriver() {
        return driver;
    }

    public Route getRoute() {
        return route;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }
    @Override
    public String toString() {
        return "Assignment{ " +
                "driver = " + driver.getName() +
                ", route = " + route.getMaTuyen() +
                ", numberOfTrips = " + numberOfTrips +
                '}';
    }
}
