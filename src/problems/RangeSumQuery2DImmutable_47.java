package problems;

public class RangeSumQuery2DImmutable_47 {

  int[][] dp;

  //https://www.youtube.com/watch?v=PwDqpOMwg6U
  public RangeSumQuery2DImmutable_47(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    dp = new int[m + 1][n + 1];

    for(int r =0 ;r<m;r++) {
      for(int c =0 ;c<n ;c++) {
        dp[r+1][c+1] = dp[r][c+1] + dp[r+1][c] - dp[r][c] + matrix[r][c];
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2 + 1][col1] + dp[row1][col1];
  }
}
