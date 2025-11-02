package replaceAllExamples;

import java.util.HashMap;
import java.util.Map;

class replaceAllDemo3 {
    public static void main(String[] args) {
        Map<String, String> words = new HashMap<>(Map.of(
                "a", "apple",
                "b", "banana",
                "c", "cherry"
        ));

        words.replaceAll((k, v) -> k.toUpperCase() + ": " + v.toUpperCase());
        System.out.println(words);
    }
}
