import java.util.Scanner;


class Bill {
    //Initializing the variables
    int units, standing_charges, total_bill;
    double total;
    public static void main(String[] arguments) {
        //Creating an object of the class
        Bill bill = new Bill();
        Scanner sc = new Scanner(System.in);
        //Taking the input from the user
        System.out.println("Enter the number of units consumed: ");
        bill.units = sc.nextInt();
        System.out.println("Enter the previous units: ");
        bill.standing_charges = sc.nextInt();
        bill.total_bill = bill.units - bill.standing_charges;
        int price_by_unit = 55;
        bill.total = bill.total_bill * price_by_unit;
        System.out.println("The total bill is " + bill.total_bill);
        System.out.println("The total payment of the bill is Ksh " + bill.total);
    }
}