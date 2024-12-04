import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    static ArrayList<Vehicle> fleet = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        mainMenu();
    }

    // Initialize dummy data
    public static void initializeData() {
        employees.add(new Employee("John", "Smith", "john@smartcar.com", "123 Elm St", 101));
        customers.add(new Customer("Liam", "Mooney", "liam12@gmail.com", "12 LakeView, Killaloe, Clare", 201));
        fleet.add(new SmartCity(1, "212-L-5932", "Nissan", "Micra", LocalDate.now(), "Limerick", 1.2, 120));
    }

    // Main menu
    public static void mainMenu() {
        while (true) {
            String userType = JOptionPane.showInputDialog("Welcome to SmartCars\nThe pay as you go rental service\nAre you a customer(c) or employee(e)?");
            if (userType == null) break;
            if (userType.equalsIgnoreCase("c")) {
                customerMenu();
            } else if (userType.equalsIgnoreCase("e")) {
                employeeMenu();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter 'c' or 'e'.");
            }
        }
    }

    // Customer menu
    public static void customerMenu() {
        while (true) {
            String choice = JOptionPane.showInputDialog("Customer Menu:\n1. Sign up (s)\n2. Book a car (b)\n3. Return to main menu (m)");
            if (choice == null || choice.equalsIgnoreCase("m")) break;

            switch (choice.toLowerCase()) {
                case "s":
                    signUpCustomer();
                    break;
                case "b":
                    bookCar();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

    // Employee menu
    public static void employeeMenu() {
        while (true) {
            String choice = JOptionPane.showInputDialog("Employee Menu:\n1. Add a vehicle (a)\n2. Change rates (r)\n3. List bookings (b)\n4. List customers (c)\n5. List vehicles (v)\n6. List employees (e)\n7. Return to main menu (m)");
            if (choice == null || choice.equalsIgnoreCase("m")) break;

            switch (choice.toLowerCase()) {
                case "a":
                    addVehicle();
                    break;
                case "r":
                    changeRates();
                    break;
                case "b":
                    listBookings();
                    break;
                case "c":
                    listCustomers();
                    break;
                case "v":
                    listVehicles();
                    break;
                case "e":
                    listEmployees();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

    // Method to change rates for vehicle types
    public static void changeRates() {
        String vehicleType = JOptionPane.showInputDialog("Select vehicle type to change rates:\n1. SmartCity (c)\n2. SmartTripper (t)\n3. SmartElectric (e)\n4. SmartVan (v)");

        if (vehicleType == null) return;  // Cancel operation if user presses Cancel

        String hourlyRateStr = JOptionPane.showInputDialog("Enter new hourly rate:");
        double hourlyRate = Double.parseDouble(hourlyRateStr);

        String dailyRateStr = JOptionPane.showInputDialog("Enter new daily rate:");
        double dailyRate = Double.parseDouble(dailyRateStr);

        for (Vehicle vehicle : fleet) {
            switch (vehicleType.toLowerCase()) {
                case "c":
                    if (vehicle instanceof SmartCity) {
                        vehicle.setHourlyRate(hourlyRate);
                        vehicle.setDailyRate(dailyRate);
                    }
                    break;
                case "t":
                    if (vehicle instanceof SmartTripper) {
                        vehicle.setHourlyRate(hourlyRate);
                        vehicle.setDailyRate(dailyRate);
                    }
                    break;
                case "e":
                    if (vehicle instanceof SmartElectric) {
                        vehicle.setHourlyRate(hourlyRate);
                        vehicle.setDailyRate(dailyRate);
                    }
                    break;
                case "v":
                    if (vehicle instanceof SmartVan) {
                        vehicle.setHourlyRate(hourlyRate);
                        vehicle.setDailyRate(dailyRate);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid vehicle type.");
                    return;
            }
        }
        JOptionPane.showMessageDialog(null, "Rates updated successfully!");
    }

    // Customer sign-up
    public static void signUpCustomer() {
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        String email = JOptionPane.showInputDialog("Enter email:");
        String address = JOptionPane.showInputDialog("Enter address:");
        int custNo = customers.size() + 201;
        customers.add(new Customer(firstName, lastName, email, address, custNo));
        JOptionPane.showMessageDialog(null, "Customer signed up successfully! Customer Number: " + custNo);
    }

    // Book a car
    public static void bookCar() {
        String custNoStr = JOptionPane.showInputDialog("Enter customer number:");
        int custNo = Integer.parseInt(custNoStr);
        String location = JOptionPane.showInputDialog("Location? (Limerick, Ennis, Shannon, Nenagh, Foynes)");
        String vehicleType = JOptionPane.showInputDialog("What type of car would you like to book? City(c), Tripper(t), Electric(e) or Van(v)?");
        String pickUpTimeStr = JOptionPane.showInputDialog("Pick up time? (hh:mm)");
        String returnTimeStr = JOptionPane.showInputDialog("Return time? (hh:mm)");

        LocalTime pickUpTime = LocalTime.parse(pickUpTimeStr);
        LocalTime returnTime = LocalTime.parse(returnTimeStr);
        int bookingId = bookings.size() + 1;

        bookings.add(new Booking(bookingId, custNo, location, vehicleType, pickUpTime, returnTime));
        JOptionPane.showMessageDialog(null, "Car booked successfully! Booking ID: " + bookingId);
    }

    // Add a vehicle
    public static void addVehicle() {
        String vehicleType = JOptionPane.showInputDialog("What type of car would you like to add? City(c), Tripper(t), Electric(e), Van(v)");
        String idStr = JOptionPane.showInputDialog("Enter SmartCar ID:");
        int id = Integer.parseInt(idStr);
        String regNo = JOptionPane.showInputDialog("Enter registration no:");
        String manufacturer = JOptionPane.showInputDialog("Enter manufacturer:");
        String model = JOptionPane.showInputDialog("Enter model:");
        String location = JOptionPane.showInputDialog("Location? (Limerick, Ennis, Shannon, Nenagh, Foynes)");
        String engineSizeStr = JOptionPane.showInputDialog("Engine size?");
        double engineSize = Double.parseDouble(engineSizeStr);
        String co2Str = JOptionPane.showInputDialog("CO2 rating?");
        int co2 = Integer.parseInt(co2Str);

        fleet.add(new SmartCity(id, regNo, manufacturer, model, LocalDate.now(), location, engineSize, co2));
        JOptionPane.showMessageDialog(null, "Vehicle added successfully!");
    }

    // Display all bookings
    public static void listBookings() {
        StringBuilder result = new StringBuilder("All Bookings:\n");
        for (Booking b : bookings) {
            result.append(b).append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    // Display all customers
    public static void listCustomers() {
        StringBuilder result = new StringBuilder("All Customers:\n");
        for (Customer c : customers) {
            result.append(c).append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    // Display all vehicles
    public static void listVehicles() {
        StringBuilder result = new StringBuilder("All Vehicles:\n");
        for (Vehicle v : fleet) {
            result.append(v).append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    // Display all employees
    public static void listEmployees() {
        StringBuilder result = new StringBuilder("All Employees:\n");
        for (Employee e : employees) {
            result.append(e).append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }
}
