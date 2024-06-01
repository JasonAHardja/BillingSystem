package currency;

import java.util.HashMap;
import java.util.Map;

public class MoneyChanger {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.0);
        exchangeRates.put("JPY", 110.0);
        exchangeRates.put("IDR", 14350.0);
    } // The different money types (so far I only wrote 6 as the common currency).

    public static double convert(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Unsupported currency");
        }
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        return amountInUSD * exchangeRates.get(toCurrency);
    }

    public static void printAvailableCurrencies() {
        System.out.println("Available currencies: " + exchangeRates.keySet());
    }
}


