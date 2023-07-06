package com.problem.salestax;


public record Product(String name, float price, ProductType productType, boolean isImported) {
}
