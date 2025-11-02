package computeExamples;

//✅ Always invoked (even if the key doesn’t exist)
//✅ You receive both key and current value
//❌ If the remapping function returns null, the key is removed
//✅ Super versatile — useful for key–value dependent computations


//    🧪 Example 1: Increment Counter with Custom Logic

// Track the number of times a user visits pages:

import java.util.HashMap;
import java.util.Map;

class ComputeExample {

    public static void main(String[] args) {
        Map<String, Integer> pageVisits = new HashMap<>();

        String[] pages = {"home", "about", "home", "contact", "home"};

        for (String page : pages) {
            pageVisits.compute(page, (key, count) -> count == null ? 1 : count + 1);
        }
    }
}
