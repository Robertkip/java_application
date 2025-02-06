// Import necessary libraries
import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;

// Define the Car class
class Car {
    // Private fields for car details
    // Unique identifier for the car
    private String carId;    
    // Model of the car
    private String model; 
    // Color of the car      
    private String color; 
    // Manufacturer of the car      
    private String make;
    // Rental price per day        
    private double pricePerDay;
    // Availability status of the car
    private boolean isAvailable; 

    // Constructor to initialize car details
    public Car(String carId, String model, String color, String make, double pricePerDay, boolean isAvailable) {
        this.carId = carId;
        this.model = model;
        this.color = color;
        this.make = make;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    // Getter for carId
    public String getCarId() {
        return carId;
    }

    // Getter for model
    public String getModel() {
        return model;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Getter for make
    public String getMake() {
        return make;
    }

    // Method to calculate rental price based on rental days
    public double price(int rentalDays) {
        return pricePerDay * rentalDays;
    }

    // Method to check if the car is available
    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to mark the car as rented
    public void rent() {
        isAvailable = false;
    }

    // Method to mark the car as returned
    public void returnCar() {
        isAvailable = true;
    }

    // Override toString method to display car details
    @Override
    public String toString() {
        return "Car ID: " + carId + ", Model: " + model + ", Color: " + color + ", Make: " + make + ", Price/Day: $" + pricePerDay + ", Available: " + isAvailable;
    }
}

// Define the Customer class
class Customer {
    // Private fields for customer details
    // Name of the customer
    private String name;        
    // Unique identifier for the customer
    private String customerId;  
    // Phone number of the customer
    private String phoneNumber; 
    // Email of the customer
    private String email;       

    // Constructor to initialize customer details
    public Customer(String name, String customerId, String phoneNumber, String email) {
        this.name = name;
        this.customerId = customerId;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for customerId
    public String getCustomerId() {
        return customerId;
    }

    // Getter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Override toString method to display customer details
    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

// Define the Rental class
class Rental {
/*
    Private fields for rental details
    Car being rented
*/
    private Car car;           
     // Customer renting the car
    private Customer customer; 
    // Number of rental days
    private int rentalDays; 
    // Total rental price   
    private double totalPrice;  

    // Constructor to initialize rental details
    public Rental(Car car, Customer customer, int rentalDays) {
        this.car = car;
        this.customer = customer;
        this.rentalDays = rentalDays;
        // Calculate total price
        this.totalPrice = car.price(rentalDays); 
    }

    // Getter for car
    public Car getCar() {
        return car;
    }

    // Getter for customer
    public Customer getCustomer() {
        return customer;
    }

    // Getter for rentalDays
    public int getRentalDays() {
        return rentalDays;
    }

    // Getter for totalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    // Override toString method to display rental details
    @Override
    public String toString() {
        return "Rental Details: Car ID: " + car.getCarId() + ", Customer ID: " + customer.getCustomerId() + ", Rental Days: " + rentalDays + ", Total Price: $" + totalPrice;
    }
}

// Define the CarRentalSystem class
class CarRentalSystem {
    /*
    // Private fields to store cars, rentals, and customers
    // List of cars
    */
    private List<Car> cars; 
     // List of rentals    
    private List<Rental> rentals;
    // List of customers 
    private List<Customer> customers; 

    // Constructor to initialize the lists
    public CarRentalSystem() {
        cars = new ArrayList<>();
        rentals = new ArrayList<>();
        customers = new ArrayList<>();
    }

    // Method to add a car to the system
    public void addCar(Car car) {
        cars.add(car);
    }

    // Method to add a customer to the system
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method to rent a car
    public void rentCar(Car car, Customer customer, int rentalDays) {
        // Check if the car is available
        if (car.isAvailable()) { 
            // Create a rental
            Rental rental = new Rental(car, customer, rentalDays); 
            // Add rental to the list
            rentals.add(rental); 
            // Mark the car as rented
            car.rent(); 
            System.out.println("Car rented successfully. Total price: $" + rental.getTotalPrice());
        } else {
            System.out.println("Car is not available for rent.");
        }
    }

    // Method to return a car
    public void returnCar(Car car) {
        Rental rentalToRemove = null;
        // Find the rental for the car
        for (Rental rental : rentals) {
            if (rental.getCar().getCarId().equals(car.getCarId())) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            // Remove the rental
            rentals.remove(rentalToRemove); 
            // Mark the car as available
            car.returnCar(); 
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Car was not rented.");
        }
    }

    // Method to find a car by its ID
    public Car findCarById(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null; // Return null if car is not found
    }

    // Method to find a customer by their ID
    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null; // Return null if customer is not found
    }

    // Method to display all cars
    public void displayAllCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            System.out.println("List of Cars:");
            for (Car car : cars) {
                System.out.println(car); // Print car details
            }
        }
    }

    // Method to display all customers
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            System.out.println("List of Customers:");
            for (Customer customer : customers) {
                System.out.println(customer); // Print customer details
            }
        }
    }

    // Method to display all rentals
    public void displayAllRentals() {
        if (rentals.isEmpty()) {
            System.out.println("No rentals available.");
        } else {
            System.out.println("List of Rentals:");
            //print rental details
            for (Rental rental : rentals) {
                // Print rental details
                System.out.println(rental); 
            }
        }
    }

    // Method to display the menu and handle user input
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Car Rental System Menu:");
            System.out.println("1. Add Car");
            System.out.println("2. Add Customer");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Display All Cars");
            System.out.println("6. Display All Customers");
            System.out.println("7. Display All Rentals");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                // Add a new car
                System.out.print("Enter Car ID: ");
                String carId = scanner.nextLine();
                System.out.print("Enter Model: ");
                String model = scanner.nextLine();
                System.out.print("Enter Color: ");
                String color = scanner.nextLine();
                System.out.print("Enter Make: ");
                String make = scanner.nextLine();
                System.out.print("Enter Price per Day: ");
                double pricePerDay = scanner.nextDouble();
                //newline character
                scanner.nextLine();
                Car car = new Car(carId, model, color, make, pricePerDay, true);
                addCar(car);
                System.out.println("Car added successfully.");
            } else if (choice == 2) {
                // Add a new customer
                System.out.print("Enter Customer Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Customer ID: ");
                String customerId = scanner.nextLine();
                System.out.print("Enter Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                Customer customer = new Customer(name, customerId, phoneNumber, email);
                addCustomer(customer);
                System.out.println("Customer added successfully.");
            } else if (choice == 3) {
                // Rent a car
                System.out.print("Enter Car ID: ");
                String carId = scanner.nextLine();
                System.out.print("Enter Customer ID: ");
                String customerId = scanner.nextLine();
                System.out.print("Enter Rental Days: ");
                int rentalDays = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                Car car = findCarById(carId);
                Customer customer = findCustomerById(customerId);
                if (car != null && customer != null) {
                    rentCar(car, customer, rentalDays);
                } else {
                    System.out.println("Car or customer not found.");
                }
            } else if (choice == 4) {
                // Return a car
                System.out.print("Enter Car ID: ");
                String carId = scanner.nextLine();
                Car car = findCarById(carId);
                if (car != null) {
                    returnCar(car);
                } else {
                    System.out.println("Car not found.");
                }
            } else if (choice == 5) {
                // Display all cars
                displayAllCars();
            } else if (choice == 6) {
                // Display all customers
                displayAllCustomers();
            } else if (choice == 7) {
                // Display all rentals
                displayAllRentals();
            } else if (choice == 8) {
                // Exit the system
                System.out.println("Exiting the system.");
                break;
            } else {
                // Handle invalid choice
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); // Close the scanner
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();

        // Add sample cars
        Car car1 = new Car("Car1", "Sedan", "Red", "Toyota", 50.0, true);
        Car car2 = new Car("Car2", "SUV", "Blue", "Honda", 60.0, true);
        //Add sample customers
        Customer customer1 = new Customer("John Doe", "C001", "123-456-7890", "john@example.com");
        Customer customer2 = new Customer("Jane Smith", "C002", "987-654-3210", "jane@example.com");
        system.addCar(car1);
        system.addCar(car2);
        system.addCustomer(customer1);
        system.addCustomer(customer2);

        // Start the menu
        system.menu();
    }
}