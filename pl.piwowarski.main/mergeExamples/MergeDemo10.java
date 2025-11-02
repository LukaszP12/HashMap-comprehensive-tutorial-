package mergeExamples;

import java.util.HashMap;
import java.util.Map;

class MergeDemo10 {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>(Map.of("apple", 2, "banana", 1, "cherry", 3));
        Map<String, Integer> sold = Map.of("banana", 1, "cherry", 3);

        // in merge() the second parameter always applied to the new value
        sold.forEach((item, count) ->
                inventory.merge(item, -count, (oldVal, newVal) -> {
                    int updated = oldVal + newVal;
                    return updated <= 0 ? null : updated;
                })
        );
    }
}
