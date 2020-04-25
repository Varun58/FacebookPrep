package problems;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray_10 {

  public static void main(String[] args) {
    int[] range = {5,7,7,8,8,10};
    final int[] searchRange = new FindFirstAndLastPositionOfElementInSortedArray_10().searchRange(range, 8);
    System.out.println(Arrays.toString(searchRange));
  }

  public int[] searchRange(int[] nums, int target) {
    int[] targetRange = {-1, -1};

    int leftIdx = extremeInsertionIndex(nums, target, true);

    if(leftIdx == nums.length || nums[leftIdx] != target) {
      return targetRange;
    }

    targetRange[0] = leftIdx;
    targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

    return targetRange;
  }

  private int extremeInsertionIndex(int[] nums, int target, boolean left) {
    int lo = 0;
    int hi = nums.length;

    while(lo < hi) {
      int mid = (lo + hi)/2;

      if(nums[mid] > target || (left && nums[mid] == target)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }
}
