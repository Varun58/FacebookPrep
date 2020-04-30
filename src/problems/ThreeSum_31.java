package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum_31 {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new LinkedList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) {
        int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
        while (lo < hi) {
          if (nums[lo] + nums[hi] == sum) {
            res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
            while (lo < hi && nums[lo] == nums[lo + 1]) {
              lo++;
            }
            while (lo < hi && nums[hi] == nums[hi - 1]) {
              hi--;
            }
            lo++;
            hi--;
          } else if (nums[lo] + nums[hi] < sum) {
            lo++;
          } else {
            hi--;
          }
        }
      }
    }
    return res;
  }

  //http://www.lifeincode.net/programming/leetcode-two-sum-3-sum-3-sum-closest-and-4-sum-java/
  public int threeSumClosest(int[] nums, int target) {
    int closest = nums[0] + nums[1] + nums[2];
    int diff = Math.abs(closest - target);

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {

      int start = i + 1;
      int end = nums.length - 1;

      while (start < end) {
        int sum = nums[i] + nums[start] + nums[end];
        int newDiff = Math.abs(sum - target);
        if (newDiff < diff) {
          diff = newDiff;
          closest = sum;
        }

        if (sum < target) {
          start++;
        } else {
          end--;
        }
      }
    }

    return closest;
  }
}
