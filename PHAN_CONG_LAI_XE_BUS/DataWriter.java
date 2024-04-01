package PHAN_CONG_LAI_XE_BUS;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataWriter {
    public static void writeDrivers(List<Driver> drivers, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Driver driver : drivers) {
                writer.write(driver.toString());
                writer.newLine();
            }
            System.out.println("Drivers data has been written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing drivers data to file: " + e.getMessage());
        }
    }

    public static void writeRoutes(List<Route> routes, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Route route : routes) {
                writer.write(route.toString());
                writer.newLine();
            }
            System.out.println("Routes data has been written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing routes data to file: " + e.getMessage());
        }
    }

    public static void writeAssignments(List<Assignment> assignments, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Assignment assignment : assignments) {
                writer.write(assignment.toString());
                writer.newLine();
            }
            System.out.println("Assignments data has been written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing assignments data to file: " + e.getMessage());
        }
    }
}
