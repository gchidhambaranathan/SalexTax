package com.problem.salestax;

import java.util.List;

public class Receipt {

    private final List<ReceiptItem> receiptItems;
    private final float totalCost;
    private final float totalSaleTax;

    public Receipt(List<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
        this.totalCost = calculateTax();
        this.totalSaleTax = calculateSalesTax();
    }

    private float calculateSalesTax() {
        return this.receiptItems.stream()
                .map(ReceiptItem::getItemTax)
                .reduce(Float::sum).orElse(0f);
    }

    private float calculateTax() {
        return this.receiptItems.stream()
                .map(ReceiptItem::getItemCost)
                .reduce(Float::sum).orElse(0f);
    }

    public List<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public float getTotalSaleTax() {
        return totalSaleTax;
    }

}
