package replaceAllExamples;

import java.util.HashMap;
import java.util.Map;

class replaceAllDemo6 {
    public static void main(String[] args) {
        Map<String, Integer> lengths = new HashMap<>(Map.of(
                "hello", 0,
                "java", 0,
                "world", 0
        ));

        lengths.replaceAll((word, len) -> word.length());
        System.out.println(lengths);
    }
}
