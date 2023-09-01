// Menu Class with list of items that can be ordered

import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    public FoodMenu() {
        this.menu = new ArrayList<>();

        menu.add(new Food("Tacos", "Yummy steak tacos", 15));
        menu.add(new Food("Pizza", "Delicious pepperoni pizza", 17));
        menu.add(new Food("Burger", "Juicy beef burger", 10));
        menu.add(new Food("Fries", "Long and crispy fries", 5));
        menu.add(new Food("Salad", "Green and healthy veggie stuff", 20));
    }

    public Food getFood(int index) {
        try {
            return menu.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Food getLowestCostFood() {
        if (menu == null || menu.isEmpty()) {
            return null;
        }
        Food lowestPriceFood = menu.get(0);
        for (Food food : menu) {
            if (food.getPrice() <= lowestPriceFood.getPrice()) {
                lowestPriceFood = food;
            }
        }
        return lowestPriceFood;
    }

    @Override
    public String toString() {
        StringBuilder menuBuilder = new StringBuilder();

        // Find the longest length of menu position in order to later properly format Cost for all position
        int longestName = 0;
        for (Food food : menu) {
            String nameAndDescription = food.toString();
            if (nameAndDescription.length() > longestName) {
                longestName = nameAndDescription.length();
            }
        }

        for (int i = 0; i < menu.size(); i++) {
            Food food = menu.get(i);
            String nameAndDescription = "Enjoy " + food.getName() + ": " + food.getDescription();

            // This line pads the food name and description with spaces to align the prices
            String formattedString = String.format("%d. %-" + longestName + "s Cost: $%d", i + 1, nameAndDescription, food.getPrice());

            menuBuilder.append(formattedString).append("\n");
        }
        return menuBuilder.toString();
    }
}

