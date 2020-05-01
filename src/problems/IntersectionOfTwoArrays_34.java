package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays_34 {

  // there are two parts
  public static void main(String[] args) {
    int[] arr1 = {4, 9, 5};
    int[] arr2 = {9, 4, 9, 8, 4};

    System.out.println(
        Arrays.toString(new IntersectionOfTwoArrays_34().intersection(arr1, arr2)));

    int[] arr3 = {4, 9, 4, 5};
    int[] arr4 = {9, 4, 9, 8, 4};

    System.out.println(
        Arrays.toString(new IntersectionOfTwoArrays_34().intersectPartTwo(arr3, arr4)));
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<Integer>();
    HashSet<Integer> set2 = new HashSet<Integer>();

    for(Integer n: nums1){
      set1.add(n);
    }

    for(Integer n: nums2) {
      set2.add(n);
    }

    if(set1.size() < set2.size()) {
      return setIntersection(set1, set2);
    } else {
      return setIntersection(set2, set1);
    }
  }

  public int[] setIntersection(Set<Integer> set1, Set<Integer> set2) {
    int[] output = new int[set1.size()];
    int i = 0;
    for(Integer s: set1) {
      if(set2.contains(s)) {
        output[i++] = s;
      }
    }

    return Arrays.copyOf(output, i);
  }

  public int[] intersectPartTwo(int[] nums1, int[] nums2) {
    if(nums1.length > nums2.length) {
      return intersectPartTwo(nums2, nums1);
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    for(int n: nums1) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    int k = 0;

    for(int n: nums2) {
      int count = map.getOrDefault(n, 0);
      if(count>0) {
        nums1[k++] = n;
        map.put(n, count -1);
      }
    }

    return Arrays.copyOf(nums1, k);
  }
}
