package mergeExamples;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MergeDemo6 {
    public static void main(String[] args) {
        Map<String, Set<String>> tags = new HashMap<>();

        String key = "fruit";
        tags.merge(key, new HashSet<>(Set.of("apple", "banana")),
                (oldSet, newSet) -> {
                    oldSet.addAll(newSet);
                    return oldSet;
                });

        tags.merge(key, new HashSet<>(Set.of("orange")),
                (oldSet, newSet) -> {
                    oldSet.addAll(newSet);
                    return oldSet;
                });

        System.out.println(tags);
    }
}
