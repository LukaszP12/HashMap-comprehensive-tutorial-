package mergeExamples;

import java.util.HashMap;
import java.util.Map;

class MergeDemo5 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>(Map.of("a", 1, "b", 2));
        Map<String, Integer> map2 = new HashMap<>(Map.of("b", 3, "c", 4));

        map2.forEach((k, v) -> map1.merge(k, v, Integer::sum));

        System.out.println(map1);
    }
}
