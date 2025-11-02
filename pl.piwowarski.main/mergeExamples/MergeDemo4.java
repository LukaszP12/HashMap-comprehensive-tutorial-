package mergeExamples;

import java.util.HashMap;
import java.util.Map;

class MergeDemo4 {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>(Map.of("apple", 5, "banana", 2));

        stock.merge("apple", -1, (oldVal, newVal) -> oldVal + newVal == 0 ? null : oldVal + newVal);
        stock.merge("banana", -2, (oldVal, newVal) -> oldVal + newVal == 0 ? null : oldVal + newVal);

        System.out.println(stock);
    }
}
