 import java.util.*;

public class Rentalagency {
    private static final List<Car> cars = new ArrayList<>();
    private static final List<Customer> customers = new ArrayList<>();
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        if (!login()) return;

        while (true) {
            System.out.println("\n===== CAR RENTAL MENU =====");
            System.out.println("1. Add Car");
            System.out.println("2. Register Customer");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. View Cars");
            System.out.println("6. Log out");
            System.out.print("Select an option: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> addCar();
                case 2 -> registerCustomer();
                case 3 -> rentCar();
                case 4 -> returnCar();
                case 5 -> viewCars();
                case 6 -> {
                    System.out.println("Logging out...Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.Try again.");
            }
        }
    }
    private static boolean login() {
        System.out.println("=== Login ===");
        System.out.print("Username: ");
        String username = scan.next();
        System.out.print("Password: ");
        String password = scan.next();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Login failed.Try again.");
            return false;
        }
    }
    private static void addCar() {
        System.out.print("Enter Car ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Car Model: ");
        String model = scan.nextLine();

        cars.add(new Car(id, model));
        System.out.println("Car added.");
    }

    private static void registerCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = scan.nextLine();

        customers.add(new Customer(id, name));
        System.out.println("Customer registered.");
    }

    private static void rentCar() {
        System.out.print("Enter Customer ID: ");
        int customerId = scan.nextInt();
        System.out.print("Enter Car ID: ");
        int carId = scan.nextInt();

        Optional<Car> car = cars.stream().filter(c -> c.getCarID() == carId && c.isAvailable()).findFirst();
        Optional<Customer> customer = customers.stream().filter(c -> c.getCustomerID () == customerId).findFirst();

        if (car.isPresent() && customer.isPresent()) {
            car.get().setAvailable(false);
            System.out.println("Car rented to " + customer.get().getName());
        } else {
            System.out.println("Car not available or customer not found.");
        }
    }

    private static void returnCar() {
        System.out.print("Enter Car ID: ");
        int carID = scan.nextInt();

        Optional<Car> car = cars.stream().filter(c -> c.getCarID() == carID).findFirst();
        if (car.isPresent() && !car.get().isAvailable()) {
            car.get().setAvailable(true);
            System.out.println("Car returned.");
        } else {
            System.out.println("Car not found or already available.");
        }
    }

    private static void viewCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars in the system.");
            return;
        }
        System.out.println("\n=== Car List ===");
        for (Car car : cars) {
            String status = car.isAvailable() ? "Available" : "Rented";
            System.out.println("ID: " + car.getCarID() + ", Model: " + car.getModel() + " - " + status);
        }
    }
}
class Car {
    private final int carID;
    private final String model;
    private boolean available = true;

    public Car(int carID, String model) {
        this.carID = carID;
        this.model = model;
    }

    public int getCarID() { return carID; }
    public String getModel() { return model; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

class Customer {
    private final int customerID;
    private final String name;

    public Customer(int customerID, String name) {
        this.customerID = customerID;
        this.name = name;
    }

    public int getCustomerID() { return customerID; }
    public String getName() { return name; }
}