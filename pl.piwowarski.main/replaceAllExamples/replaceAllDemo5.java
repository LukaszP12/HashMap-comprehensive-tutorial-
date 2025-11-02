package replaceAllExamples;

import java.util.HashMap;
import java.util.Map;

class replaceAllDemo5 {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>(Map.of(
                "Shirts", 10,
                "Shoes", 5,
                "Socks", 2
        ));

        stock.replaceAll((item, qty) -> qty < 5 ? qty * 2 : qty);
        System.out.println(stock);
    }
}
