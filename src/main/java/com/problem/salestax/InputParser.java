package com.problem.salestax;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {
    private static final String INPUT_PATTERN_REGEX = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";
    public Optional<ReceiptItem> parseInput(String inputLine) {
        Matcher matcher = getMatcher(inputLine);

        int quantity = Integer.parseInt(matcher.group(1));
        String name = matcher.group(2).trim();
        float price = Float.parseFloat(matcher.group(4).trim());
        boolean isImported = name.contains("imported ");
        String pureName = name.replaceAll("imported ", "").trim();

        try {
            Product product = getProduct(pureName, price, isImported);
            return Optional.of(getReceiptItem(quantity, product));
        } catch (Exception e) {
            System.out.println("Exception in parsing " + e);
            return Optional.empty();
        }
    }

    private ReceiptItem getReceiptItem(int quantity, Product product) {
        return new ReceiptItem(product, quantity, 0f, 0f);
    }

    private Matcher getMatcher(String inputLine) {
        Pattern pattern = Pattern.compile(INPUT_PATTERN_REGEX);
        Matcher matcher = pattern.matcher(inputLine);
        matcher.find();
        return matcher;
    }

    private Product getProduct(String name, float price, boolean isImported) throws Exception {
        ProductType productType = ProductCatalog.getProductTypeByName(name);
        return new Product(name, price, productType, isImported);
    }

}
