package com.problem.salestax.test;

import com.problem.salestax.ProductCatalog;
import com.problem.salestax.ProductType;
import org.junit.Assert;
import org.junit.Test;

public class ProductCatalogTest {

    @Test
    public void check_Category_By_Description() throws Exception {
        String description = "book";
        ProductType productType = ProductCatalog.getProductTypeByName(description);
        Assert.assertEquals(ProductType.BOOK, productType);

        description = "music CD";
        productType = ProductCatalog.getProductTypeByName(description);
        Assert.assertEquals(ProductType.OTHER, productType);

        description = "chocolate bar";
        productType = ProductCatalog.getProductTypeByName(description);
        Assert.assertEquals(ProductType.FOOD, productType);

        description = "box of chocolates";
        productType = ProductCatalog.getProductTypeByName(description);
        Assert.assertEquals(ProductType.FOOD, productType);

        description = "packet of headache pills";
        productType = ProductCatalog.getProductTypeByName(description);
        Assert.assertEquals(ProductType.MEDICAL, productType);
    }
}
