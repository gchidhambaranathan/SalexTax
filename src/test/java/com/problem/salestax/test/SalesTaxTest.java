package com.problem.salestax.test;

import com.problem.salestax.*;
import org.junit.Assert;
import org.junit.Test;

public class SalesTaxTest {

    @Test
    public void is_tax_BasicTax_Exempted_For_Category() {
        Product product = new Product("book", 27.99f, ProductType.BOOK, false);

        SalesTax salesTax = new BasicSalesTax();
        Assert.assertFalse(salesTax.isApplicable(product));
        Assert.assertEquals(0f, salesTax.calculate(product), 0.0);
    }
    @Test
    public void is_tax_BasicTax_Not_Exempted_For_Category() {
        Product product = new Product("music CD", 14.99f, ProductType.OTHER, false);

        SalesTax salesTax = new BasicSalesTax();
        Assert.assertTrue(salesTax.isApplicable(product));
        Assert.assertEquals(1.5f, salesTax.calculate(product), 0.0);
    }

    @Test
    public void is_tax_ImportDutyTax_Considered_And_Charged() {
        Product product = new Product("box of chocolates", 10.00f, ProductType.FOOD, true);

        SalesTax salesTax = new ImportDutySalesTax();
        Assert.assertTrue(salesTax.isApplicable(product));
        Assert.assertEquals(0.5f, salesTax.calculate(product), 0.0);
    }

    @Test
    public void is_tax_ImportDutyTax_Should_Not_Be_Considered() {
        Product product = new Product("music CD", 14.99f, ProductType.OTHER, false);

        SalesTax salesTax = new ImportDutySalesTax();
        Assert.assertFalse(salesTax.isApplicable(product));
        Assert.assertEquals(0f, salesTax.calculate(product), 0.0);
    }
}
