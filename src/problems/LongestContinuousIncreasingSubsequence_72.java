package problems;

//subsequence --> subarray
public class LongestContinuousIncreasingSubsequence_72 {

  public static void main(String[] args) {
    System.out.println(new LongestContinuousIncreasingSubsequence_72().findLengthOfLCIS(new int[] {1, 3, 5, 4, 7}));
  }

  //IN PLACE
  // T-> O(N)
  // S -> O(1)
  public void reverseWords(char[] s) {
    reverse(s, 0, s.length - 1);
    reverseEachWord(s);
  }

  public void reverse(char[] s, int l, int r) {
    while (l < r) {
      char tmp = s[l];
      s[l] = s[r];
      s[r] = tmp;

      l++;
      r--;
    }
  }

  public void reverseEachWord(char[] s) {
    int n = s.length;
    int start = 0, end = 0;
    while (start < n) {
      while (end < n && s[end] != ' ') {
        ++end;
      }

      reverse(s, start, end - 1);

      start = end + 1;
      ++end;
    }
  }

  // T O(N)
  // S O(1)
  public int findLengthOfLCIS(int[] nums) {
    int ans = 0, anchor = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i - 1] >= nums[i]) {
        anchor = i;
      }

      ans = Math.max(ans, i - anchor + 1);
    }
    return ans;
  }
}
