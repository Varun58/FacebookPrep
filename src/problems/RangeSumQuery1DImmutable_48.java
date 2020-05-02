package problems;

public class RangeSumQuery1DImmutable_48 {

  int[] sum;

  public RangeSumQuery1DImmutable_48(int[] nums) {
    if (nums.length == 0) {
      return;
    }

    sum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      sum[i + 1] = sum[i] + nums[i];
    }
  }

  public int sumRange(int i, int j) {
    return sum[j + 1] - sum[i];
  }
}
