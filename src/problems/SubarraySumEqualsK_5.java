package problems;

import java.util.HashMap;

public class SubarraySumEqualsK_5 {

  public static void main(String[] args) {
    System.out.println(subArraySum(new int[] {1, 1, 1}, 2));
  }

  public static int subArraySum(int[] nums, int k) {
    int count = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for (int num : nums) {
      sum += num;

      if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
      }

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
