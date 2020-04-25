package problems;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses_13 {

  public static void main(String[] args) {
    String s = "lee(t(c)o)de";
    System.out.println(new MinimumRemoveToMakeValidParentheses_13().minRemoveToMakeValid(s));
  }

  public String minRemoveToMakeValid(String s) {
    Set<Integer> indexesToRemove = new HashSet();
    Stack<Integer> stack = new Stack();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        stack.push(i);
      } else if (ch == ')') {
        if (stack.isEmpty()) {
          indexesToRemove.add(i);
        } else {
          stack.pop();
        }
      }
    }

    while (!stack.isEmpty()) {
      indexesToRemove.add(stack.pop());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (!indexesToRemove.contains(i)) {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }
}
