package models;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private ArrayList<Item> items; // needs array to group all
    private double discount;
    private double taxRate;

    public Bill() {
        items = new ArrayList<>();
        discount = 0;
        taxRate = 0;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String itemName) {
        items.removeIf(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public void updateItemQuantity(String itemName, int newQuantity) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setQuantity(newQuantity);
                return;
            }
        }
    }
// the gets shows the inputs and it will show the inputs like in a form of a bill or receipt
    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public Item[] getItems() {
        return items.toArray(new Item[0]);
    }

    public void clearItems() {
        items.clear();
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (Item item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public double getTax() {
        return getSubtotal() * taxRate;
    }

    public double getTotal() {
        return getSubtotal() + getTax() - discount;
    }

    //tried to make it look like an actual bill, looks ok enough
    public void printBill() {
        System.out.println("--------- Bill ---------");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("------------------------");
        System.out.printf("Subtotal: $%.2f%n", getSubtotal());
        System.out.printf("Tax: $%.2f%n", getTax());
        System.out.printf("Discount: -$%.2f%n", discount);
        System.out.printf("Total: $%.2f%n", getTotal());
    }
}
