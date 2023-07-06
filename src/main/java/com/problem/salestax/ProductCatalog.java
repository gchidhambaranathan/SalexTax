package com.problem.salestax;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductCatalog {

    private static final Map<ProductType, List<String>> productCatalogs = Map.of(
            ProductType.BOOK, List.of("book"),
            ProductType.FOOD, List.of("box of chocolates", "chocolate bar"),
            ProductType.MEDICAL, List.of("packet of headache pills"),
            ProductType.OTHER, List.of("music CD", "bottle of perfume")
    );


    public static ProductType getProductTypeByName(String name) throws Exception {

        Optional<ProductType> productTypeOptional = productCatalogs.entrySet().stream()
                .filter(entry -> entry.getValue().contains(name))
                .map(Map.Entry::getKey).findFirst();

        if (productTypeOptional.isEmpty())
            throw new Exception("Could not find match any product type for given product");

        return productTypeOptional.get();
    }
}
