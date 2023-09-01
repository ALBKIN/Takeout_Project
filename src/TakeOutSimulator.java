import java.util.Scanner;

public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, FoodMenu menu, Scanner input) {
        this.customer = customer;
        this.menu = menu;
        this.input = input;
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(userInputPrompt);

            if (sc.hasNextInt()) {
                int userInput = sc.nextInt();

                try {
                    return intUserInputRetriever.produceOutputOnIntUserInput(userInput);
                } catch (IllegalArgumentException e) {
                    System.out.println(userInput + " is not a valid input. Try Again!");
                }

            } else {
                System.out.println("Input needs to be an 'int' type");
                sc.next();
            }
        }
    }

    private boolean shouldSimulate() {
        String userPrompt = "Enter 1 to CONTINUE simulation or 0 to EXIT program: ";

        IntUserInputRetriever<Boolean> intUserInputRetriever = selection -> {
            if (selection == 1) {
                Food lowestPriceFood = menu.getLowestCostFood();
                if (customer.getMoney() >= lowestPriceFood.getPrice()) {
                    return true;
                } else {
                    System.out.println("You don't have enough money to continue shopping :( - ending simulation...");
                    return false;
                }
            } else {
                throw new IllegalArgumentException("Invalid selection! Enter 0 or 1.");
            }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    private Food getMenuSelection() {
        String userPrompt = "Enter a NUMBER of a menu position you want to choose: ";

        IntUserInputRetriever<Food> intUserInputRetriever = selection -> {
            Food selectedFood = menu.getFood(selection);
            if (selectedFood != null) {
                return selectedFood;
            } else {
                throw new IllegalArgumentException("Invalid selection! Enter a valid menu NUMBER");
            }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    private boolean isStillOrderingFood() {
        String userPrompt = "Enter 1 to CONTINUE shopping or 0 to CHECKOUT: ";

        IntUserInputRetriever<Boolean> intUserInputRetriever = selection -> {
            if (selection == 1) {
                return true;
            } else if (selection == 0) {
                return false;
            } else {
                throw new IllegalArgumentException("Invalid selection! Enter 0 or 1.");
            }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    private void checkoutCustomer(ShoppingBag<Food> shoppingBag) {
        System.out.println("Processing payment...");

        int totalPrice = shoppingBag.getTotalPrice();
        int currentMoney = customer.getMoney();

        if (currentMoney >= totalPrice) {
            customer.setMoney(currentMoney - totalPrice);
            int remainingMoney = customer.getMoney();
            System.out.println("Your remaining money: $" + remainingMoney);
            System.out.println("Thank you and enjoy your food!");
        } else {
            System.out.println("You don't have enough money to complete this purchase. Please add money to your account first");
        }
    }

    // GETTERS & SETTERS
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FoodMenu getMenu() {
        return menu;
    }

    public void setMenu(FoodMenu menu) {
        this.menu = menu;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
}