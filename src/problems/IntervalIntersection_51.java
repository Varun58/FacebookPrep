package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntervalIntersection_51 {

  public static void main(String[] args) {
    int[][] A= {
        {0,2},
        {5, 10},
        {13, 23},
        {24, 25}
    };
    int[][] B = {
        {1, 5 },
        {8, 12},
        {15, 24},
        {25, 26}
    };

    Stream.of(new IntervalIntersection_51().intervalIntersection(A, B)).forEach(x-> System.out.println(Arrays.toString(x)));
  }

  public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> ans = new ArrayList<>();
    int i=0 , j = 0;

    while(i < A.length && j < B.length) {
      int lo = Math.max(A[i][0], B[j][0]);
      int hi = Math.min(A[i][1], B[j][1]);

      if(lo <= hi) {
        ans.add(new int[]{lo,hi});
      }

      if(A[i][1] < B[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return ans.toArray(new int[ans.size()][]);
  }
}
