import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class DemoHashMap {

    record User(int id, String name) {
    }

    public static void main(String[] args) {
        constructors();
        basics();
        queriesAndViews();
        iterationPatterns();
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
}
