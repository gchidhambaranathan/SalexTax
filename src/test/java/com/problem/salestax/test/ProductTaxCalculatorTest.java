package com.problem.salestax.test;

import com.problem.salestax.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductTaxCalculatorTest {

    @Test
    public void is_Able_To_Calculate_Tax_TotalCost_For_Non_Imported_Item() {
        Product productOne = new Product("book", 12.49f, ProductType.BOOK, false);
        Product productTwo = new Product("music CD", 14.99f, ProductType.OTHER, false);
        Product productThree = new Product("chocolate bar", 0.85f, ProductType.BOOK, false);
        ReceiptItem receiptItemOne = new ReceiptItem(productOne,1,0f, 0f);
        ReceiptItem receiptItemTwo = new ReceiptItem(productTwo,1,0f, 0f);
        ReceiptItem receiptItemThree = new ReceiptItem(productThree,1,0f, 0f);

        ProductTaxCalculator.calculateItemCost(receiptItemOne);
        ProductTaxCalculator.calculateItemCost(receiptItemTwo);
        ProductTaxCalculator.calculateItemCost(receiptItemThree);

        Assert.assertEquals(0f, receiptItemOne.getItemTax(), 0.0);
        Assert.assertEquals(1.5f, receiptItemTwo.getItemTax(), 0.0);
        Assert.assertEquals(0f, receiptItemOne.getItemTax(), 0.0);

        List<ReceiptItem> receiptItems = new ArrayList<>();
        receiptItems.add(receiptItemOne);
        receiptItems.add(receiptItemTwo);
        receiptItems.add(receiptItemThree);

        Receipt receipt = new Receipt(receiptItems);

        Assert.assertEquals(1.5f, receipt.getTotalSaleTax(), 0.0);
        Assert.assertEquals(29.83f, receipt.getTotalCost(), 0.0);
    }

    @Test
    public void is_Able_To_Calculate_Tax_TotalCost_For_Imported_Item() {
        Product productOne = new Product("box of chocolates", 10.00f, ProductType.FOOD, true);
        Product productTwo = new Product("bottle of perfume", 47.50f, ProductType.OTHER, true);

        ReceiptItem receiptItemOne = new ReceiptItem(productOne,1,0f, 0f);
        ReceiptItem receiptItemTwo = new ReceiptItem(productTwo,1,0f, 0f);

        ProductTaxCalculator.calculateItemCost(receiptItemOne);
        ProductTaxCalculator.calculateItemCost(receiptItemTwo);

        Assert.assertEquals(0.5f, receiptItemOne.getItemTax(), 0.0);
        Assert.assertEquals(7.15f, receiptItemTwo.getItemTax(), 0.0);

        List<ReceiptItem> receiptItems = new ArrayList<>();
        receiptItems.add(receiptItemOne);
        receiptItems.add(receiptItemTwo);

        Receipt receipt = new Receipt(receiptItems);

        Assert.assertEquals(7.65f, receipt.getTotalSaleTax(), 0.0);
        Assert.assertEquals(65.15f, receipt.getTotalCost(), 0.0);
    }

    @Test
    public void is_Able_To_Calculate_Tax_TotalCost_For_Mixed_Item() {
        Product productOne = new Product("bottle of perfume", 27.99f, ProductType.OTHER, true);
        Product productTwo = new Product("bottle of perfume", 18.99f, ProductType.OTHER, false);
        Product productThree = new Product("packet of headache pills", 9.75f, ProductType.MEDICAL, false);
        Product productFour = new Product("box of chocolates", 11.25f, ProductType.FOOD, true);

        ReceiptItem receiptItemOne = new ReceiptItem(productOne,1,0f, 0f);
        ReceiptItem receiptItemTwo = new ReceiptItem(productTwo,1,0f, 0f);
        ReceiptItem receiptItemThree = new ReceiptItem(productThree,1,0f, 0f);
        ReceiptItem receiptItemFour = new ReceiptItem(productFour,1,0f, 0f);

        ProductTaxCalculator.calculateItemCost(receiptItemOne);
        ProductTaxCalculator.calculateItemCost(receiptItemTwo);
        ProductTaxCalculator.calculateItemCost(receiptItemThree);
        ProductTaxCalculator.calculateItemCost(receiptItemFour);


        Assert.assertEquals(4.2f, receiptItemOne.getItemTax(), 0.0);
        Assert.assertEquals(1.9f, receiptItemTwo.getItemTax(), 0.0);
        Assert.assertEquals(0f, receiptItemThree.getItemTax(), 0.0);
        Assert.assertEquals(0.6f, receiptItemFour.getItemTax(), 0.0);

        List<ReceiptItem> receiptItems = new ArrayList<>();
        receiptItems.add(receiptItemOne);
        receiptItems.add(receiptItemTwo);
        receiptItems.add(receiptItemThree);
        receiptItems.add(receiptItemFour);

        Receipt receipt = new Receipt(receiptItems);

        Assert.assertEquals(6.70f, receipt.getTotalSaleTax(), 0.0);
        Assert.assertEquals(74.68f, receipt.getTotalCost(), 0.0);
    }
}
