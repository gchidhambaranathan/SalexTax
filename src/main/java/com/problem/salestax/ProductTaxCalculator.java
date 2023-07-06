package com.problem.salestax;

import java.util.List;

public class ProductTaxCalculator {

    private static final List<SalesTax> taxes = List.of(
            new BasicSalesTax(),
            new ImportDutySalesTax()
    );

    public static void calculateItemCost(ReceiptItem receiptItem) {
        float itemTax = taxes.stream().map(tax -> tax.calculate(receiptItem.getProduct()))
                .reduce(0f, Float::sum);
        receiptItem.setItemTax(itemTax);
        receiptItem.setItemCost(receiptItem.getProduct().price() + itemTax);
    }
}
