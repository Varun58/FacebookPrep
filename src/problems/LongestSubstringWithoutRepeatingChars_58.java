package problems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars_58 {

  public static void main(String[] args) {

  }

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    Set<Character> set = new HashSet<>();
    int n = s.length();

    int i = 0, j = 0, ans = 0;
    while (i < n && j < n) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }

    return ans;
  }
}
