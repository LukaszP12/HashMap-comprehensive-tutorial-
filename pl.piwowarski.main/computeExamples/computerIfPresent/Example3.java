package computeExamples.computerIfPresent;

import java.util.HashMap;
import java.util.Map;

class Example3 {
    public static void main(String[] args) {
        Map<String, Integer> cart = new HashMap<>(Map.of(
                "Pen", 3,
                "Notebook", 1
        ));

        // Increase quantity only if item already in cart
        cart.computeIfPresent("Pen", (item, qty) -> qty + 2);
        cart.computeIfPresent("Pencil", (item, qty) -> qty + 1);

        System.out.println(cart);
    }
}
