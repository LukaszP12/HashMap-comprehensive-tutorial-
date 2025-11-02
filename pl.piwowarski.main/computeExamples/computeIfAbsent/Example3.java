package computeExamples.computeIfAbsent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Example3 {
    public static void main(String[] args) {
        String[] words = {"java", "code", "stream", "map", "function"};

        Map<Integer, List<String>> byLength = new HashMap<>();

        for (String word : words) {
            byLength.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
        }
        System.out.println(byLength);
    }
}
