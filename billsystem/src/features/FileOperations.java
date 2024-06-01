package features;

import models.Bill;
import models.Item;

import java.io.*;
import java.util.List;

public class FileOperations {
    public static void saveBill(Bill bill, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Item item : bill.getItems()) {
                writer.println(item.getName() + "," + item.getPrice() + "," + item.getQuantity());
            }
            writer.println("Discount," + bill.getDiscount());
            writer.println("TaxRate," + bill.getTaxRate());
        } catch (IOException e) {
            System.out.println("Error saving bill: " + e.getMessage());
        }
    }
//a save bill, for when you want to make note of what you have added to the list
    public static void loadBill(Bill bill, String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            bill.clearItems();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equalsIgnoreCase("Discount")) {
                    bill.applyDiscount(Double.parseDouble(parts[1]));
                } else if (parts[0].equalsIgnoreCase("TaxRate")) {
                    bill.setTaxRate(Double.parseDouble(parts[1]));
                } else {
                    bill.addItem(new Item(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading bill: " + e.getMessage());
        }
    }
}
// then after saving the current bill, you can load it back and add or remove stuff from it
