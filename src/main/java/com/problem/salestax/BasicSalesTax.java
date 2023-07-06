package com.problem.salestax;

import java.util.List;

public class BasicSalesTax implements SalesTax {
    private final List<ProductType> exemptedProducts = List.of(
            ProductType.BOOK, ProductType.FOOD, ProductType.MEDICAL
    );

    @Override
    public boolean isApplicable(Product product) {
        return !exemptedProducts.contains(product.productType());
    }

    @Override
    public float rate() {
        return 10f;
    }
}
