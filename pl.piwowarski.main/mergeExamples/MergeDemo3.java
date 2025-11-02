package mergeExamples;

import java.util.HashMap;
import java.util.Map;

class MergeDemo3 {
    public static void main(String[] args) {
        Map<String, Integer> highestScores = new HashMap<>();

        String[] players = {"Tom", "Alice", "Tom", "Alice"};
        int[] scores = {10, 5, 20, 15};

        for (int i = 0; i < players.length; i++) {
            highestScores.merge(players[i], scores[i], Math::max);
        }

        System.out.println(highestScores);
    }
}
