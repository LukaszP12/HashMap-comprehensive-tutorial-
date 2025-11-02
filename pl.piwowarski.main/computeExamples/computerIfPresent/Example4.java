package computeExamples.computerIfPresent;

import java.util.HashMap;
import java.util.Map;

class Example4 {
    public static void main(String[] args) {
        Map<String, Integer> errorCounts = new HashMap<>(Map.of(
                "404", 2,
                "500", 1
        ));

        // Increment count only if error already exists
        errorCounts.computeIfPresent("404", (code, count) -> count + 1);
        errorCounts.computeIfPresent("403", (code, count) -> count + 1);

        System.out.println(errorCounts);
    }
}
