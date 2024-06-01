package features;

import models.Bill;
import models.Item;

import java.util.HashMap;
import java.util.Map;

public class SummaryFeature {
    public static void printSummary(Bill bill) {
        Map<String, Integer> summary = new HashMap<>();
        for (Item item : bill.getItems()) {
            summary.put(item.getName(), summary.getOrDefault(item.getName(), 0) + item.getQuantity());
        }

        System.out.println("------ Item Summary ------");
        for (Map.Entry<String, Integer> entry : summary.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("--------------------------");
    }
}
//this will just read back what you just added since i didn't program it to keep showing the user the bill until they click done.

