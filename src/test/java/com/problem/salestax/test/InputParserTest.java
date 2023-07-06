package com.problem.salestax.test;

import com.problem.salestax.InputParser;
import com.problem.salestax.Product;
import com.problem.salestax.ProductType;
import com.problem.salestax.ReceiptItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;


public class InputParserTest {
    private final InputParser inputParser = new InputParser();

    @Test
    public void is_Parser_Able_To_Parse_Description_Without_Imported() {
        Optional<ReceiptItem> optionalReceiptItem = inputParser.parseInput("1 book at 12.49");
        Assert.assertTrue(optionalReceiptItem.isPresent());

        ReceiptItem receiptItem = optionalReceiptItem.get();
        Product expectedProduct = new Product("book", 12.49f, ProductType.BOOK, false);
        ReceiptItem receiptItemExpected = new ReceiptItem(expectedProduct,1,0f, 0f);
        Assert.assertEquals(receiptItem , receiptItemExpected);
    }

    @Test
    public void is_Parser_Able_To_Parse_Description_Without_Imported_At_Start() {
        Optional<ReceiptItem> optionalReceiptItem = inputParser.parseInput("1 imported bottle of perfume at 27.99");
        Assert.assertTrue(optionalReceiptItem.isPresent());

        ReceiptItem receiptItem = optionalReceiptItem.get();
        Product expectedProduct = new Product("bottle of perfume", 27.99f, ProductType.OTHER, true);
        ReceiptItem receiptItemExpected = new ReceiptItem(expectedProduct,1,0f, 0f);
        Assert.assertEquals(receiptItem , receiptItemExpected);
    }

    @Test
    public void is_Parser_Able_To_Parse_Description_Without_Imported_At_Anywhere() {
        Optional<ReceiptItem> optionalReceiptItem = inputParser.parseInput("1 box of imported chocolates at 11.25");
        Assert.assertTrue(optionalReceiptItem.isPresent());

        ReceiptItem receiptItem = optionalReceiptItem.get();
        Product expectedProduct = new Product("box of chocolates", 11.25f, ProductType.FOOD, true);
        ReceiptItem receiptItemExpected = new ReceiptItem(expectedProduct,1,0f, 0f);
        Assert.assertEquals(receiptItem , receiptItemExpected);
    }
}
