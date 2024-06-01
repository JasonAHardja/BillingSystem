package features;

import models.Bill;

public class TaxFeature {
    public static void setTaxRate(Bill bill, double taxRate) {
        bill.setTaxRate(taxRate);
    }
}
//Tax is something we cannot escape from
//Note that the tax should be in decimals