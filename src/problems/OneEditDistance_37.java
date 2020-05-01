package problems;

public class OneEditDistance_37 {

  public static void main(String[] args) {
    String s = "abcdef";
    String t = "abcde";
    System.out.println(new OneEditDistance_37().isOneEditDistance(s, t));

    String s1 = "";
    String t1 = "";
    System.out.println(new OneEditDistance_37().isOneEditDistance(s1, t1));
  }

  public boolean isOneEditDistance(String s, String t) {
    int ns = s.length();
    int nt = t.length();

    if(ns > nt) {
      return isOneEditDistance(t, s);
    }

    if(nt - ns > 1) {
      return false;
    }

    for (int i = 0; i < ns; i++) {
      if(s.charAt(i) != t.charAt(i)) {
        if(ns == nt) {
          return s.substring(i+1).equals(t.substring(i+1));
        }
        else {
          return s.substring(i).equals(t.substring(i+1));
        }
      }
    }

    return ns + 1 == nt;
  }

  // https://leetcode.com/problems/edit-distance/
  // https://www.youtube.com/watch?v=We3YDTzNXEk
  // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();

    if(m*n == 0) {
      return n+m;
    }

    int[][] d = new int[m+1][n+1];

    for(int i = 0;i< m+1;i++) {
      d[i][0] = i;
    }

    for(int j = 0;j< n+1;j++) {
      d[0][j] = j;
    }

    for(int i = 1;i <= m;i++) {
      for(int j = 1; j<= n; j ++) {
        int down = d[i][j-1] ;
        int left = d[i - 1][j];
        int diagonalPrev = d[i-1][j-1];
        if(word1.charAt(i-1) == word2.charAt(j-1)) {
          d[i][j] = diagonalPrev;
        } else {
          d[i][j] = 1 + Math.min(left, Math.min(down, diagonalPrev));
        }
      }
    }

    return d[m][n];
  }
}
