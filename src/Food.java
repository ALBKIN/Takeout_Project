// Class representing an PRICED FOOD ITEM in the take-out system

public class Food implements PricedItem<Integer> {
    private String name;
    private String description;
    private int price;

    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
