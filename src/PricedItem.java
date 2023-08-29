// Interface representing an ITEM WITH A NUMERIC PRICE in the take-out system

public interface PricedItem<T extends Number> {

    public T getPrice();

    public void setPrice(T price);
}
