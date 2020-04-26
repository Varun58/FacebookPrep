package problems;

import java.util.HashMap;

public class ContinuousSubarraySumMultipleOfK_14 {

  public static void main(String[] args) {
    System.out.println(new ContinuousSubarraySumMultipleOfK_14().checkSubarraySum(new int[] {23, 2, 4, 8, 7}, 6));
  }

  public boolean checkSubarraySum(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (k != 0) {
        sum = sum % k;
      }

      if (map.containsKey(sum)) {
        if (i - map.get(sum) > 1) {
          return true;
        }
      } else {
        map.put(sum, i);
      }
    }

    return false;
  }
}
