package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString_2 {

  public static void main(String[] args) {
    System.out.println(findAnagrams("cbaebabacd", "abc"));
    System.out.println(findAnagrams("abab", "ab"));

    System.out.println(findAnagramsArray("cbaebabacd", "abc"));
    System.out.println(findAnagramsArray("abab", "ab"));
  }

  // using hashmap
  public static List<Integer> findAnagrams(String s, String p) {
    int np = p.length();
    int ns = s.length();

    if (ns < np) {
      return new ArrayList<>();
    }

    Map<Character, Integer> sCount = new HashMap<>();
    Map<Character, Integer> pCount = new HashMap<>();

    for (int i = 0; i < np; i++) {
      if (pCount.containsKey(p.charAt(i))) {
        pCount.put(p.charAt(i), pCount.get(p.charAt(i)) + 1);
      } else {
        pCount.put(p.charAt(i), 1);
      }
    }

    List<Integer> output = new ArrayList<>();

    for (int i = 0; i < ns; i++) {
      if (sCount.containsKey(s.charAt(i))) {
        sCount.put(s.charAt(i), sCount.get(s.charAt(i)) + 1);
      } else {
        sCount.put(s.charAt(i), 1);
      }

      if (i >= np) {
        char ch = s.charAt(i - np);
        if (sCount.get(ch) == 1) {
          sCount.remove(ch);
        } else {
          sCount.put(ch, sCount.get(ch) - 1);
        }
      }

      if (sCount.equals(pCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }

  // using array
  public static List<Integer> findAnagramsArray(String s, String p) {
    int np = p.length();
    int ns = s.length();

    if (ns < np) {
      return new ArrayList<>();
    }

    int[] sCount = new int[26];
    int[] pCount = new int[26];

    for (int i = 0; i < np; i++) {
      pCount[(int) (p.charAt(i) - 'a')]++;
    }

    List<Integer> output = new ArrayList<>();

    for (int i = 0; i < ns; i++) {
      sCount[(int) (s.charAt(i) - 'a')]++;

      if (i >= np) {
        char ch = s.charAt(i - np);
        sCount[(int) (ch - 'a')]--;
      }

      if (Arrays.equals(sCount, pCount)) {
        output.add(i - np + 1);
      }
    }
    return output;
  }
}
