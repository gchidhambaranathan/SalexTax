package com.problem.salestax;

public class PrintReceipt {
    private final Receipt receipt;

    public PrintReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public void print() {
        this.receipt.getReceiptItems().forEach(
                receiptItem -> System.out.println(receiptItem.getQuantity() + " " +
                        receiptItem.getProduct().name() +
                        " " + receiptItem.getItemCost())
        );
        System.out.println(receipt.getTotalSaleTax());
        System.out.println(receipt.getTotalCost());
    }
}
