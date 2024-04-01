package PHAN_CONG_LAI_XE_BUS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BusManagementSystem system = new BusManagementSystem();

        while (true) {
            System.out.println("1. Add Driver");
            System.out.println("2. Add Route");
            System.out.println("3. Assign Driver to Route");
            System.out.println("4. Sort Assignments by Name");
            System.out.println("5. Sort Assignments by Number of Trips");
            System.out.println("6. Generate Distance Report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    system.addDriver();
                    system.printDrivers();
                    break;
                case 2:
                    system.addRoute();
                    system.printRoutes();
                    break;
                case 3:
                    system.assignDriverToRoute();
                    system.printAssignments();
                    break;
                case 4:
                    system.sortAssignmentsByName();
                    break;
                case 5:
                    system.sortAssignmentsByTrips();
                    break;
                case 6:
                    system.generateDistanceReport();
                    break;
                case 7:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


