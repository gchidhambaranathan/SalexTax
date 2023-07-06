package com.problem.salestax;

import java.util.Objects;

public class ReceiptItem {
    private final Product product;
    private final int quantity;
    private float itemTax;
    private float itemCost;

    public ReceiptItem(Product product, int quantity, float itemTax, float itemCost) {
        this.product = product;
        this.quantity = quantity;
        this.itemTax = itemTax;
        this.itemCost = itemCost;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getItemTax() {
        return itemTax;
    }

    public void setItemTax(float itemTax) {
        this.itemTax = itemTax;
    }

    public float getItemCost() {
        return itemCost;
    }

    public void setItemCost(float itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ReceiptItem) obj;
        return Objects.equals(this.product, that.product) &&
                this.quantity == that.quantity &&
                Float.floatToIntBits(this.itemCost) == Float.floatToIntBits(that.itemCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, itemCost);
    }

    @Override
    public String toString() {
        return "ReceiptItem[" +
                "product=" + product + ", " +
                "quantity=" + quantity + ", " +
                "itemCost=" + itemCost + ']';
    }


}
