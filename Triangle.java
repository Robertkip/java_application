import java.util.Scanner;

class Triangle {
    // Instance variables to store base and height
    int base, height; 
    // Instance variable to store the calculated area
    double area; 

    // Constructor to initialize base and height
    public Triangle(int base, int height) {
        // Initialize the instance variable 'base' with the parameter 'base'
        this.base = base; 
        // Initialize the instance variable 'height' with the parameter 'height'
        this.height = height; 
    }

    // Method to calculate the area of the triangle
    public void calculateArea() {
        // Calculate the area using the formula: (base * height) / 2
        area = (base * height) / 2.0; 
    }

    // Method to display the area of the triangle
    public void displayArea() {// Print the calculated area
        System.out.println("The area of the triangle is " + area); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create a Scanner object for user input

        // Prompt the user to enter the base of the triangle
        System.out.println("Enter the base of the triangle: ");
        int base = sc.nextInt(); // Read the base value from the user

        // Prompt the user to enter the height of the triangle
        System.out.println("Enter the height of the triangle: ");
        int height = sc.nextInt(); // Read the height value from the user

        // Create a Triangle object using the constructor and pass the base and height
        Triangle t = new Triangle(base, height);

        // Calculate the area of the triangle
        t.calculateArea();

        // Display the area of the triangle
        t.displayArea();

        sc.close(); // Close the Scanner object to free resources
    }
}