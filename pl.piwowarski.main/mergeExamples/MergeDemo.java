package mergeExamples;

import java.util.HashMap;
import java.util.Map;

class MergeDemo {
    public static void main(String[] args) {
        String sentence = "hello world hello java java java";
        Map<String, Integer> freq = new HashMap<>();

        for (String word : sentence.split("\\s+")) {
            freq.merge(word, 1, Integer::sum);
        }

        System.out.println(freq);
    }
}
