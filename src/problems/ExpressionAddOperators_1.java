package problems;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators_1 {

  private List<String> answer;
  private String digits;
  private long target;

  public static void main(String[] args) {
    ExpressionAddOperators_1 operators1 = new ExpressionAddOperators_1();
    final List<String> result = operators1.addOperators("123", 6);

    for (int i = 0; i < result.size(); i++) {
      System.out.println(result.get(i));
    }
  }

  public List<String> addOperators(String num, int target) {
    if (num.length() == 0) {
      return new ArrayList<>();
    }

    this.digits = num;
    this.target = target;
    this.answer = new ArrayList<>();
    this.recurse(0, 0, 0, 0, new ArrayList<>());
    return this.answer;
  }

  private void recurse(
      int index,
      long previousOp,
      long currentOp,
      long value,
      List<String> ops
  ) {
    String nums = this.digits;

    if (nums.length() == index) {
      if (value == target && currentOp == 0) {
        StringBuilder sb = new StringBuilder();
        ops.subList(1, ops.size()).forEach(sb::append);
        this.answer.add(sb.toString());
      }
      return;
    }

    currentOp = currentOp * 10 + Character.getNumericValue(nums.charAt(index));
    String current_val_rep = Long.toString(currentOp);

    if (currentOp > 0) {
      // NO OP RECURSION
      recurse(index + 1, previousOp, currentOp, value, ops);
    }

    ops.add("+");
    ops.add(current_val_rep);
    recurse(index + 1, currentOp, 0, value + currentOp, ops);
    ops.remove(ops.size() - 1);
    ops.remove(ops.size() - 1);

    if (ops.size() > 0) {
      // SUBSTRACTION
      ops.add("-");
      ops.add(current_val_rep);
      recurse(index + 1, -currentOp, 0, value - currentOp, ops);
      ops.remove(ops.size() - 1);
      ops.remove(ops.size() - 1);

      // MULTIPLICATION
      ops.add("*");
      ops.add(current_val_rep);
      recurse(index + 1, currentOp * previousOp, 0, value - previousOp + (currentOp * previousOp), ops);
      ops.remove(ops.size() - 1);
      ops.remove(ops.size() - 1);
    }
  }
}
