package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations_41 {

  public static void main(String[] args) {
    int[] arr  = {1,2, 3};
    System.out.println(new Permutations_41().permute(arr));
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> output = new LinkedList<>();

    if(nums == null || nums.length == 0) {
      return output;
    }
    List<Integer> numsList = new ArrayList<>();
    for(int n: nums) {
      numsList.add(n);
    }

    int n = nums.length;
    backtrack( n, numsList, output, 0);
    return output;
  }

  private void backtrack(int n, List<Integer> nums, List<List<Integer>> output, int first) {
    if(first == n) {
      output.add(new ArrayList<>(nums));
    }

    for(int i = first;i< n;i++) {
      Collections.swap(nums, first, i);
      backtrack(n,nums, output, first+1);
      Collections.swap(nums, first, i);
    }

  }
}
