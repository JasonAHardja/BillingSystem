package features;

import models.Bill;

public class DiscountFeature {
    public static void applyDiscount(Bill bill, double discount) {
        bill.applyDiscount(discount);
    } //applies a discount (optional)
}

