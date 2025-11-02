package mergeExamples;

//🟠 Example 3: Grouping Strings by Length

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MergeDemo7 {
    public static void main(String[] args) {
        String[] words = {"car", "bike", "plane", "bus", "cycle"};

        Map<Integer, List<String>> byLength = new HashMap<>();

        for (String word : words) {
            byLength.merge(word.length(),
                    new ArrayList<>(List.of(word)),
                    (oldList, newList) -> {
                        oldList.addAll(newList);
                        return oldList;
                    });
        }
        System.out.println(byLength);
    }
}
