package mergeExamples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MergeDemo2 {
    record User(String name, String department) { }

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Alice", "HR"),
                new User("Bob", "IT"),
                new User("Carol", "HR"),
                new User("Dave", "IT")
        );

        Map<String, List<String>> deptToUsers = new HashMap<>();

        for (User user : users) {
            deptToUsers.merge(
                    user.department,
                    new ArrayList<>(List.of(user.name)),
                    (oldList, newList) -> {
                        oldList.addAll(newList);
                        return oldList;
                    }
            );
        }
        System.out.println(deptToUsers);
    }
}
