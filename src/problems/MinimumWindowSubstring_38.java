package problems;

import java.util.HashMap;

public class MinimumWindowSubstring_38 {
  public static void main(String[] args) {
    String s = "ADOBECODEBANC";
    String t ="ABC";
    System.out.println(new MinimumWindowSubstring_38().minWindow(s, t));
  }

  public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    HashMap<Character, Integer> dict = new HashMap<>();
    for (char c : t.toCharArray()) {
      dict.put(c, dict.getOrDefault(c, 0) + 1);
    }

    int l = 0, r = 0, formed = 0;

    HashMap<Character, Integer> wc = new HashMap<>();

    int[] ans = {-1, 0, 0};
    int required = dict.size();

    while (r < s.length()) {
      char ch = s.charAt(r);
      wc.put(ch, wc.getOrDefault(ch, 0) + 1);

      if(dict.containsKey(ch) && wc.get(ch).intValue() == dict.get(ch).intValue()) {
        formed++;
      }

      while(l <= r && required == formed) {
        if(ans[0] == -1 || r - l + 1 <ans[0]) {
          ans[0] = r - l + 1;
          ans[1] = l;
          ans[2] = r;
        }

        char cl = s.charAt(l);
        wc.put(cl, wc.getOrDefault(cl, 0) - 1);

        if(dict.containsKey(cl) && wc.get(cl) < dict.get(cl)) {
          formed--;
        }
        l++;
      }

      r++;
    }

    return ans[0] == -1 ? "": s.substring(ans[1], ans[2] + 1);
  }

}
