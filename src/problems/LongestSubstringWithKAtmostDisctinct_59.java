package problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithKAtmostDisctinct_59 {

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int n = s.length();

    if (n * k == 0) {
      return 0;
    }

    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    int left = 0, right = 0, maxLen = 0;

    while (right < n) {

      if (map.containsKey(s.charAt(right))) {
        map.remove(s.charAt(right));
      }
      map.put(s.charAt(right), right++);

      if (map.size() == k + 1) {
        Map.Entry<Character, Integer> leftMost = map.entrySet().iterator().next();
        map.remove(leftMost.getKey());
        left = leftMost.getValue() + 1;
      }

      maxLen = Math.max(maxLen, right - left);
    }

    return maxLen;
  }
}
