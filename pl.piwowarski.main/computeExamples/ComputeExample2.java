package computeExamples;

import java.util.HashMap;
import java.util.Map;

class ComputeExample2 {
    public static void main(String[] args) {
        Map<String, String> cache = new HashMap<>();

        String result = cache.compute("user42", (k, v) -> v == null ? expensiveCall(k) : v);
        System.out.println(result);

        String resultAgain = cache.compute("user42", (k, v) -> v == null ? expensiveCall(k) : v);
        System.out.println(resultAgain);
    }

    private static String expensiveCall(String user) {
        System.out.println("Fetching data for " + user + "...");
        return "data_for_" + user;
    }
}
