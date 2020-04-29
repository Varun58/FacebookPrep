package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

public class AccountsMerge_26 {

  //accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
  public static void main(String[] args) {
    List<String> account1 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
    List<String> account2 = new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com"));
    List<String> account3 = new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
    List<String> account4 = new ArrayList<>(Arrays.asList("Mary", "mary@mail.com"));
    List<List<String>> accounts = new ArrayList<>();
    accounts.add(account1);
    accounts.add(account2);
    accounts.add(account3);
    accounts.add(account4);

    Stream.of(new AccountsMerge_26().accountsMerge(accounts)).forEach(x -> System.out.println(x));
  }

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, String> emailToName = new HashMap<>();
    Map<String, ArrayList<String>> graph = new HashMap<>();

    for (List<String> account : accounts) {
      String name = "";
      for (String email : account) {
        if (name.equals("")) {
          name = email;
          continue;
        }

        graph
            .computeIfAbsent(email, x -> new ArrayList<>())
            .add(account.get(1));

        graph
            .computeIfAbsent(account.get(1), x -> new ArrayList<>())
            .add(email);

        emailToName.put(email, name);
      }
    }

    Set<String> seen = new HashSet<>();
    List<List<String>> result = new ArrayList<>();

    for (String email : graph.keySet()) {
      if (!seen.contains(email)) {
        seen.add(email);

        Stack<String> stack = new Stack<>();
        stack.push(email);

        List<String> component = new ArrayList<>();
        while (!stack.isEmpty()) {
          String node = stack.pop();
          component.add(node);

          for (String neighbor : graph.get(node)) {
            if (!seen.contains(neighbor)) {
              seen.add(neighbor);
              stack.push(neighbor);
            }
          }
        }
        Collections.sort(component);
        component.add(0, emailToName.get(email));
        result.add(component);
      }
    }
    System.out.println(result.size());
    return result;
  }
}
