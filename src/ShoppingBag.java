// Class that will allow us to "take" our take-out food home

import java.util.HashMap;
import java.util.Map;
public class ShoppingBag<T extends PricedItem<Integer>> {

    private Map<T, Integer> shoppingBag;

    public ShoppingBag() {
        this.shoppingBag = new HashMap<>();
    }
    public void addItem(T item) {
        if (!shoppingBag.containsKey(item)) {
            shoppingBag.put(item, 1);
        } else {
            int currentCount = shoppingBag.get(item);
            shoppingBag.put(item, currentCount + 1);
        }
    }

    // TODO 1:  add getTotalPrice() method to calculate the total price of each item in shopping bag
}
