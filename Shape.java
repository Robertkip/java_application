//Write a program with a class named Shapes and objects named circle and sphere. The program should then prompt for the respective dimensions, compute and output the circumference and volume. Hint: Volume of sphere = 4/3 * radius3.  

import java.util.Scanner;

class Shapes {
    double radius;
    double height;
    double circumference;
    double volume;

    public static void main(String[] arguments) {
        Shapes circle = new Shapes();
        Shapes sphere = new Shapes();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the circle: ");
        circle.radius = sc.nextDouble();
        circle.circumference = 2 * Math.PI * circle.radius;
        System.out.println("The circumference of the circle is " + circle.circumference);

        System.out.println("Enter the radius of the sphere: ");
        sphere.radius = sc.nextDouble();
        sphere.volume = 4.0 / 3.0 * Math.PI * Math.pow(sphere.radius, 3);
        System.out.println("The volume of the sphere is " + sphere.volume);
    }
}