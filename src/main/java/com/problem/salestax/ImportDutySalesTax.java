package com.problem.salestax;

public class ImportDutySalesTax implements SalesTax {
    @Override
    public boolean isApplicable(Product product) {
        return product.isImported();
    }

    @Override
    public float rate() {
        return 5f;
    }
}
