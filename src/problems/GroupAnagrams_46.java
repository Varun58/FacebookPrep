package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_46 {

  public List<List<String>> groupAnagrams(String[] strs) {
    if(strs.length == 0) {
      return new ArrayList<>();
    }

    HashMap<String, List<String>> map = new HashMap<>();

    int[] count = new int[26];
    for (String s: strs) {
      Arrays.fill(count, 0);

      for (int i = 0; i < s.length(); i++) {
        count[s.charAt(i) - 'a']++;
      }

      StringBuilder sb = new StringBuilder("");

      for (int value : count) {
        sb.append("#");
        sb.append(value);
      }

      String key = sb.toString();
      if(!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }

      map.get(key).add(s);
    }

    return new ArrayList<>(map.values());
  }

  public List<List<String>> groupAnagrams2(String[] strs) {
    if(strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> ans = new HashMap<>();
    for(String str: strs) {
      char[] ca = str.toCharArray();
      Arrays.sort(ca);
      String strValue = String.valueOf(ca);
      if(!ans.containsKey(strValue)) {
        ans.put(strValue, new ArrayList<String>());
      }
      ans.get(strValue).add(str);
    }

    return new ArrayList<>(ans.values());
  }
}
