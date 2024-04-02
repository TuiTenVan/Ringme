package JDBC_Hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SaveDatabase {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/quanlylaixebus";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static void saveDrivers(List<Driver> drivers) {
        String insertQuery = "INSERT INTO drivers (name, address, phonenumber, qualification) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (Driver driver : drivers) {
                if (!isDriverExist(driver)) {
                    preparedStatement.setString(1, driver.getName());
                    preparedStatement.setString(2, driver.getAddress());
                    preparedStatement.setString(3, driver.getPhoneNumber());
                    preparedStatement.setString(4, driver.getQualification());
                    preparedStatement.executeUpdate();
                }
            }
            System.out.println("Drivers data has been written to the database");
        } catch (SQLException e) {
            System.err.println("Error writing drivers data to database: " + e.getMessage());
        }
    }

    public static void saveRoutes(List<Route> routes) {
        String insertQuery = "INSERT INTO routes (distance, numberofstops) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (Route route : routes) {
                if (!isRouteExist(route)) {
                    preparedStatement.setDouble(1, route.getDistance());
                    preparedStatement.setInt(2, route.getNumberOfStops());
                    preparedStatement.executeUpdate();
                }
            }
            System.out.println("Routes data has been written to the database");
        } catch (SQLException e) {
            System.err.println("Error writing routes data to database: " + e.getMessage());
        }
    }

    public static void saveAssignments(List<Assignment> assignments) {
        String insertQuery = "INSERT INTO assignments (driver_id, route_id, numberoftrips) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (Assignment assignment : assignments) {
                if (!isAssignmentExist(assignment)) {
                    preparedStatement.setInt(1, Integer.parseInt(assignment.getDriver().getMaLX()));
                    preparedStatement.setInt(2, Integer.parseInt(assignment.getRoute().getMaTuyen()));
                    preparedStatement.setInt(3, assignment.getNumberOfTrips());
                    preparedStatement.executeUpdate();
                }
            }
            System.out.println("Assignments data has been written to the database");
        } catch (SQLException e) {
            System.err.println("Error writing assignments data to database: " + e.getMessage());
        }
    }

    private static boolean isDriverExist(Driver driver) throws SQLException {
        String selectQuery = "SELECT * FROM drivers WHERE name = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, driver.getName());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    private static boolean isRouteExist(Route route) throws SQLException {
        String selectQuery = "SELECT * FROM routes WHERE distance = ? AND numberofstops = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setDouble(1, route.getDistance());
            preparedStatement.setInt(2, route.getNumberOfStops());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    private static boolean isAssignmentExist(Assignment assignment) throws SQLException {
        String selectQuery = "SELECT * FROM assignments WHERE driver_id = ? AND route_id = ?";
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, Integer.parseInt(assignment.getDriver().getMaLX()));
            preparedStatement.setInt(2, Integer.parseInt(assignment.getRoute().getMaTuyen()));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}

