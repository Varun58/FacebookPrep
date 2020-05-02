package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsPart2_UniquePerm_52 {

  public static void main(String[] args) {
    System.out.println(new PermutationsPart2_UniquePerm_52().permuteUnique(new int[]{1, 1,2 }));
  }

  //https://leetcode.com/explore/interview/card/facebook/53/recursion-3/293/discuss/18648/Share-my-Java-code-with-detailed-explanantion?page=1
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> output = new LinkedList<>();
    ArrayList<Integer> numsList = new ArrayList<>();

    for(int n: nums) {numsList.add(n);}
    int n = nums.length;

    backtrack(n, numsList, output, 0);
    return output;
  }

  private void backtrack(int n, List<Integer> numsList, List<List<Integer>> output, int first) {
    if(first == n) {
      output.add(new ArrayList<>(numsList));
    }

    Set<Integer> set= new HashSet<>();
    for(int i = first;i<n;i++) {
      if(set.add(numsList.get(i))){
        Collections.swap(numsList, first, i);
        backtrack(n, numsList, output, first + 1);
        Collections.swap(numsList, first, i);

      }
    }
  }
}
