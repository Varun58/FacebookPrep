package problems;

public class NumberOfIslands_36 {

  public static void main(String[] args) {
    char[][] grid = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };

    System.out.println(new NumberOfIslands_36().numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int r, int c) {
    int nr = grid.length;
    int nc = grid[0].length;

    if (r < 0 || r >= nr || c < 0 || c >= nc || grid[r][c] == '0') {
      return;
    }

    grid[r][c] = '0';

    dfs(grid, r + 1, c);
    dfs(grid, r, c + 1);
    dfs(grid, r - 1, c);
    dfs(grid, r, c - 1);
  }
}
