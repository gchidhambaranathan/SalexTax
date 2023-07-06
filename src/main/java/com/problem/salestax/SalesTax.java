package com.problem.salestax;

public interface SalesTax {
    boolean isApplicable(Product product);

    float rate();

    default float calculate(Product product) {
        if (isApplicable(product)) {
            float tax = product.price() * rate() / 100;
            return (float) (Math.ceil(tax / 0.05f) * 0.05f);
        }
        return 0;
    }
}
