package circle;
import java.util.Scanner;

public class Circle {
    
    // Declare the data members
    private static double PI = 3.142;
    private double diameter, radius, volume, circumference;
    
    public static void main(String[] args) {
        
        // Create a new object called sphere
        Circle sphere = new Circle();
        Scanner dimension = new Scanner(System.in);
        
        // Prompt the user to enter a diameter
        System.out.println("Enter the diameter of the sphere");
        sphere.diameter = dimension.nextDouble();
        
        // Calculate the radius
        sphere.radius = sphere.diameter/2;
        
        // Calculate the volume
        sphere.volume = 4/3*(Math.pow(sphere.radius, 3));
        
        // Calculate the circumference
        sphere.circumference = 2 * PI * sphere.radius;
        
        // Display the radius
        System.out.printf("The radius of the sphere = %.2f \n", sphere.radius);
        
        // Display the volume
        System.out.printf("The volume of the sphere = %.2f \n", sphere.volume);
        
        // Display the circumference
        System.out.printf("The circumference of the sphere = %.2f", sphere.circumference);
        
        // Create a new object called circle
        Circle circle = new Circle();
        circle.radius = dimension.nextDouble();
        
        // Calculate the circumference of the circle
        circle.circumference = 2 * PI * circle.radius;
        
        // Display the circumference of the circle
        System.out.printf("The circumference of the circle = %d", circle.circumference);
                       
    }
    
}