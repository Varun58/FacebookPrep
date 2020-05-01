package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StrobogrammaticNumber_35 {

  public static void main(String[] args) {
    System.out.println(new StrobogrammaticNumber_35().isStrobogrammatic("888"));
    System.out.println(new StrobogrammaticNumber_35().isStrobogrammatic("882"));
  }

  public boolean isStrobogrammatic(String num) {
    HashMap<Character, Character> map = new HashMap<>();
    map.put('1', '1');
    map.put('0', '0');
    map.put('8', '8');
    map.put('9', '6');
    map.put('6', '9');

    int i = 0;
    int j = num.length() - 1;

    while (i < j) {
      if (!map.containsKey(num.charAt(i))) {
        return false;
      }

      if (map.get(num.charAt(i)) != map.get(num.charAt(j))) {
        return false;
      }

      i++;
      j--;
    }

    return true;
  }

  //https://tenderleo.gitbooks.io/leetcode-solutions-/GoogleMedium/247.html
  //https://leetcode.com/explore/interview/card/facebook/53/recursion-3/3029/discuss/67280/AC-clean-Java-solution
  public List<String> findStrobogrammaticPart2(int n) {
    return find(n, n);
  }

  public List<String> find(int current, int n) {
    if(current == 0) return new ArrayList<String>(Arrays.asList(""));

    if(current == 1) return new ArrayList<String>(Arrays.asList("0", "1","8"));

    List<String> found = find(current - 2, n);

    List<String> result = new ArrayList<String>();

    for(int i = 0;i< found.size();i++) {
      String s = found.get(i);

      if(current != n) {
        result.add("0" + s + "0");
      }

      result.add("1" + s + "1");
      result.add("6" + s + "9");
      result.add("8" + s + "8");
      result.add("9" + s + "6");

    }

    return result;
  }
}
