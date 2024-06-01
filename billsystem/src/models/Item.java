package models;

public class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    } //the 3 basics of when buying things in the store: What is the item? What is the object's price? and how much of objects are you taking?
// the gets and sets
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    // requires overriding because of the subclasses
    @Override
    public String toString() {
        return String.format("%s - $%.2f x %d = $%.2f", name, price, quantity, getTotalPrice());
    }
}
