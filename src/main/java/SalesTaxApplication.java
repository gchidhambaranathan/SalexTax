import com.problem.salestax.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SalesTaxApplication {

    public static void main(String[] args) {
        /*String[] input1 = {
                "1 book at 12.49",
                "1 music CD at 14.99",
                "1 chocolate bar at 0.85"
        };

        String[] input2 = {
                "1 imported box of chocolates at 10.00",
                "1 imported bottle of perfume at 47.50"
        };*/

        String[] input3 = {
                "1 imported bottle of perfume at 27.99",
                "1 bottle of perfume at 18.99",
                "1 packet of headache pills at 9.75",
                "1 box of imported chocolates at 11.25"
        };

        InputParser parser = new InputParser();
        List<ReceiptItem> receiptItems = new ArrayList<>();

        for (String inputLine : input3) {
            Optional<ReceiptItem> optionalReceiptItem = parser.parseInput(inputLine);
            if (optionalReceiptItem.isEmpty())
                continue;
            receiptItems.add(optionalReceiptItem.get());
        }

        receiptItems.forEach(ProductTaxCalculator::calculateItemCost);

        Receipt receipt = new Receipt(receiptItems);

        PrintReceipt printReceipt = new PrintReceipt(receipt);
        printReceipt.print();

    }
}
