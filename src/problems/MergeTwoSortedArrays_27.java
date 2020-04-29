package problems;

import java.util.Arrays;

public final class MergeTwoSortedArrays_27 {

  //https://www.programcreek.com/2012/12/leetcode-merge-sorted-array-java/
  public static void main(String[] args) {
    int[] A = {1, 2, 3, 0, 0, 0};
    int[] B = {2, 5, 6};

    new MergeTwoSortedArrays_27().merge(A, 3, B, 3);
    System.out.println(Arrays.toString(A));

    int[] C = {1, 2, 3, 0, 0, 0};
    int[] D = {2, 5, 6};

    new MergeTwoSortedArrays_27().merge2(C, 3, D, 3);
    System.out.println(Arrays.toString(C));
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    while (m > 0 && n > 0) {
      if (nums1[m - 1] > nums2[n - 1]) {
        nums1[m + n - 1] = nums1[m - 1];
        m--;
      } else {
        nums1[m + n - 1] = nums2[n - 1];
        n--;
      }
    }

    while (n > 0) {
      nums1[m + n - 1] = nums2[n - 1];
      n--;
    }
  }

  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (k >= 0) {
      if (j < 0 || (i >= 0 && nums1[i] > nums2[j])) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
  }
}
