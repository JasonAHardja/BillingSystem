import models.Bill;
import models.Item;
import features.DiscountFeature;
import features.TaxFeature;
import features.InputValidation;
import features.FileOperations;
import features.SummaryFeature;
import currency.MoneyChanger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bill bill = new Bill();

        while (true) {
            System.out.print("enter command (add, remove, update, discount, tax, save, load, summary, print, convert, done): ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("done")) {
                bill.printBill(); //prints the bill before closing
                break;
            } else if (command.equalsIgnoreCase("add")) {
                System.out.print("enter item name: ");
                String itemName = scanner.nextLine();
                double itemPrice = InputValidation.getValidatedDouble(scanner, "enter item price: ");
                int itemQuantity = InputValidation.getValidatedInt(scanner, "enter item quantity: ");
                bill.addItem(new Item(itemName, itemPrice, itemQuantity));
            } else if (command.equalsIgnoreCase("remove")) {
                System.out.print("enter item name to remove: ");
                String itemName = scanner.nextLine();
                bill.removeItem(itemName);
            } else if (command.equalsIgnoreCase("update")) {
                System.out.print("enter item name to update: ");
                String itemName = scanner.nextLine();
                int newQuantity = InputValidation.getValidatedInt(scanner, "enter new quantity: ");
                bill.updateItemQuantity(itemName, newQuantity);
            } else if (command.equalsIgnoreCase("discount")) {
                double discount = InputValidation.getValidatedDouble(scanner, "enter discount: ");
                DiscountFeature.applyDiscount(bill, discount);
            } else if (command.equalsIgnoreCase("tax")) {
                double taxRate = InputValidation.getValidatedDouble(scanner, "enter tax rate (as decimal): ");
                TaxFeature.setTaxRate(bill, taxRate);
            } else if (command.equalsIgnoreCase("save")) {
                System.out.print("enter filename to save (end the file name with .dat: ");
                String filename = scanner.nextLine();
                FileOperations.saveBill(bill, filename);
            } else if (command.equalsIgnoreCase("load")) {
                System.out.print("enter filename to load: ");
                String filename = scanner.nextLine();
                FileOperations.loadBill(bill, filename);
            } else if (command.equalsIgnoreCase("summary")) {
                SummaryFeature.printSummary(bill);
            } else if (command.equalsIgnoreCase("print")) {
                bill.printBill();
            } else if (command.equalsIgnoreCase("convert")) {
                MoneyChanger.printAvailableCurrencies();
                System.out.print("enter target currency: ");
                String targetCurrency = scanner.nextLine();
                double totalAmount = bill.getTotal();
                try {
                    double convertedAmount = MoneyChanger.convert(totalAmount, "USD", targetCurrency);
                    System.out.printf("total amount in %s: %.2f%n", targetCurrency, convertedAmount);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }
}

//This is mainly where the inputs happen.
//Uses many else ifs for straightforward prompts instead of complicated orders
//To load a bill, you must first save the bill and then run it again and load the bill's name.

