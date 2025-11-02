import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DemoHashMap {

    record User(int id, String name) {
    }

    public static void main(String[] args) {
        constructors();
        basics();
        queriesAndViews();
        iterationPatterns();
        java8Defaults();
        countersAndGrouping();
    }


    // 1) Constructors
    static void constructors() {
        System.out.println("\n== Constructors ==");
        Map<String, Integer> a = new HashMap<>();                   // default
        Map<String, Integer> b = new HashMap<>(32);                 // capacity
        Map<String, Integer> c = new HashMap<>(16, 0.5f);           // capacity+load
        Map<String, Integer> seed = Map.of("x", 1, "y", 2);
        Map<String, Integer> d = new HashMap<>(seed);               // copy
        System.out.println("a=" + a + ", b.size=" + b.size() + ", c.size=" + c.size() + ", d=" + d);
    }

    // 2) Core CRUD
    static void basics() {
        System.out.println("\n== Core put/get/remove ==");
        Map<String, Integer> m = new HashMap<>();
        System.out.println("put('a',1) -> " + m.put("a", 1));      // null (new)
        System.out.println("put('a',7) -> " + m.put("a", 7));       // returns old 1
        System.out.println("get('a')    = " + m.get("a"));         // 7
        System.out.println("remove('a') = " + m.remove("a"));      // 7
        System.out.println("remove('a') = " + m.remove("a"));      // null (absent)
        m.put(null, 42);                                           // null key
        m.put("b", null);                                          // null value
        System.out.println("map now     = " + m);
        m.clear();
        System.out.println("cleared, size=" + m.size() + ", isEmpty=" + m.isEmpty());
    }

    // 3) Queries & views
    static void queriesAndViews() {
        System.out.println("\n== Queries & views ==");
        Map<String, Integer> m = new HashMap<>(Map.of("a", 1, "b", 2, "c", 3));
        System.out.println("containsKey('b')  " + m.containsKey("b"));
        System.out.println("containsValue(99) " + m.containsValue(99));
        System.out.println("keySet()          " + m.keySet());
        System.out.println("values()          " + m.values());
        System.out.println("entrySet()        " + m.entrySet());
    }

    // 4) Iteration patterns
    static void iterationPatterns() {
        System.out.println("\n== Iteration patterns ==");
        Map<String, Integer> m = new HashMap<>(Map.of("a", 1, "b", 2, "c", 3));

        System.out.println("-- forEach");
        m.forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("-- entrySet for loop");
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }

        System.out.println("-- iterator remove (fail-fast safe)");
        Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equals("b")) it.remove();
        }
        System.out.println("after removing 'b': " + m);
    }

    // 5) Java 8 default methods on Map
    static void java8Defaults() {
        System.out.println("\n== Java 8 Map defaults ==");
        Map<String, Integer> m = new HashMap<>();
        System.out.println("getOrDefault('x',99) = " + m.getOrDefault("x", 99));

        System.out.println("-- putIfAbsent");
        m.putIfAbsent("x", 1); // inserts 1
        m.putIfAbsent("x", 2); // ignored
        System.out.println("m = " + m);

        System.out.println("-- replace (two-arg and three-arg)");
        m.replace("x", 10); // replaces since key present
        m.replace("x", 10, 20); // CAS-style
        System.out.println("m = " + m);

        System.out.println("-- computeIfAbsent");
        m.computeIfAbsent("y", k -> 100);
        System.out.println("m = " + m);

        System.out.println("-- computeIfPresent");
        m.computeIfPresent("y", (k, v) -> v + 1);
        System.out.println("m = " + m);

        System.out.println("-- compute (always runs)");
        m.compute("z", (k, v) -> v == null ? 5 : v + 5);
        System.out.println("m = " + m);

        System.out.println("-- merge (counters/accumulation)");
        m.merge("z", 1, Integer::sum); // z = 6
        m.merge("z", 4, Integer::sum); // z = 10
        System.out.println("m = " + m);

        System.out.println("-- replaceAll (bulk transform)");
        m.replaceAll((k, v) -> v * 2);
        System.out.println("m = " + m);

        System.out.println("-- forEach (side effects/printing)");
        m.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    // 6) Patterns: counters and grouping
    static void countersAndGrouping() {
        System.out.println("\n== Patterns: counters & grouping ==");
        String text = "to be or not to be";
        Map<String, Integer> freq = new HashMap<>();
        for (String w : text.split("\\s+")) {
            freq.merge(w, 1, Integer::sum); // counting words
        }
        System.out.println("freq: " + freq);

        // Group users by first letter using computeIfAbsent
        List<User> users = List.of(
                new User(1, "Alice"), new User(2, "Bob"),
                new User(3, "Ava"), new User(4, "Ben"));
        Map<Character, List<User>> byInitial = new HashMap<>();
        for (User u : users) {
            char k = u.name().charAt(0);
            byInitial.computeIfAbsent(k, kk -> new ArrayList<>()).add(u);
        }
        System.out.println("grouped: " + byInitial);
    }
}
