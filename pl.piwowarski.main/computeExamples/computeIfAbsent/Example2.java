package computeExamples.computeIfAbsent;

import java.util.HashMap;
import java.util.Map;

class Example2 {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> sales = new HashMap<>();

        addSale(sales, "USA", "iPhone", 2);
        addSale(sales, "USA", "MacBook", 1);
        addSale(sales, "Germany", "iPhone", 1);

        System.out.println(sales);
    }

    private static void addSale(Map<String, Map<String, Integer>> sales, String country, String product, int qty) {
        Map<String, Integer> products = sales.computeIfAbsent(country, k -> new HashMap<>());
        products.merge(product, qty, Integer::sum);
    }
}
