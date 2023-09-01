import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String customerName = input.nextLine();

        int money = 0; // Initialize money

        while (true) { // Loop until a valid integer is entered
            System.out.println("Enter the amount of money you have: ");
            try {
                money = input.nextInt();
                break; // Exit loop if money is succesfully read;
            } catch (InputMismatchException e) {
                System.out.println("Please provide valid money amount.");
                input.nextLine(); // Clear the invalid input
            }
        }

        Customer customer = new Customer(customerName, money);
        TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, new FoodMenu(),input);

        // Start the simulator using the instance of TakeOutSimulator
        takeOutSimulator.startTakeOutSimulator();
    }
}