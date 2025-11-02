package computeExamples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ComputeExample3 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Alice", "Apple", 3),
                new Order("Bob", "Banana", 2),
                new Order("Alice", "Apple", 2),
                new Order("Alice", "Banana", 1)
        );

        Map<String, Map<String, Integer>> invoice = new HashMap<>();
        for (Order o : orders) {
            invoice.compute(o.customer(), (customer, products) -> {
                if (products == null) products = new HashMap<>();
                products.merge(o.product(), o.qty(), Integer::sum);
                return products;
            });
        }
        System.out.println("invoice: ");
        System.out.println(invoice);
    }
}
