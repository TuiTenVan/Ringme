package JDBC_Hibernate;

import java.io.Serializable;

public class Assignment implements Serializable {
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

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
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
