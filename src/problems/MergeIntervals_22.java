package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals_22 {

  public static void main(String[] args) {
    int[][] intervals = {
        {1, 3},
        {2, 6},
        {8, 10},
        {15, 18}
    };
    Arrays.stream(
        new MergeIntervals_22().merge(intervals)
    ).forEach(x -> System.out.println(Arrays.toString(x)));
  }

  private class IntervalComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] a, int[] b) {
      //a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
      return Integer.compare(a[0], b[0]);
    }
  }

  public int[][] merge(int[][] intervals) {
    Collections.sort(Arrays.asList(intervals), new IntervalComparator());

    LinkedList<int[]> merged = new LinkedList<>();

    for (int[] interval : intervals) {
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      } else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }
}
