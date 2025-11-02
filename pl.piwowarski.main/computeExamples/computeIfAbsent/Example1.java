package computeExamples.computeIfAbsent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Example1 {
    public static void main(String[] args) {
        Map<String, List<String>> citiesByCountry = new HashMap<>();

        citiesByCountry.computeIfAbsent("USA", k -> new ArrayList<>()).add("New York");
        citiesByCountry.computeIfAbsent("USA", k -> new ArrayList<>()).add("Boston");
        citiesByCountry.computeIfAbsent("France", k -> new ArrayList<>()).add("Paris");

        System.out.println(citiesByCountry);
    }
}
