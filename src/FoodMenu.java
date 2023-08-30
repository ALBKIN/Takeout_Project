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
        if (index >= 1 && index <= menu.size()) {
            return menu.get(index - 1);
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder menuBuilder = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            menuBuilder.append(i + 1)
                    .append(". ")
                    .append(menu.get(i).toString()) // Using the already @Overriden toString() method from Food class
                    .append("\n");
        }
        return menuBuilder.toString();
    }
}
