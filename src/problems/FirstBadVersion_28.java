package problems;

import java.util.Random;

public class FirstBadVersion_28 {

  public int firstBadVersion(int n) {
    int lo = 1;
    int hi = n;

    while(lo<hi) {
      int mid = lo+ (hi-lo)/2;
      if(isBadVersion(mid)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  // helper function to test
  private boolean isBadVersion(int mid) {
    return new Random().nextBoolean();
  }
}
