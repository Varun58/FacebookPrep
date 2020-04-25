package problems;

import java.util.LinkedList;
import java.util.Queue;

//https://tenderleo.gitbooks.io/leetcode-solutions-/GoogleHard/317.html?q=
public class ShortestDistanceFromAllBuildings_8 {

  public static void main(String[] args) {

  }

  public int shortestDistance(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int row = grid.length;
    int col = grid[0].length;

    int buildingNums = 0;

    int[][] dis = new int[row][col];
    int[][] reach = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1) {
          buildingNums++;
          bfs(grid, dis, reach, i, j);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 0 && dis[i][j] != 0 && reach[i][j] == buildingNums) {
          min = Math.min(dis[i][j], min);
        }
      }
    }

    if (min < Integer.MAX_VALUE) {
      return min;
    }

    return -1;
  }

  private void bfs(
      int[][] grid,
      int[][] distances,
      int[][] reach,
      int x,
      int y
  ) {
    int row = grid.length;
    int col = grid[0].length;

    int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {x, y});

    boolean[][] visited = new boolean[row][col];
    int distance = 0;
    while (!queue.isEmpty()) {
      distance++;
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int[] top = queue.poll();

        for (int j = 0; j < 4; j++) {
          int k = top[0] + neighbors[j][0];
          int l = top[1] + neighbors[j][1];

          if (k >= 0 && k < row && l >= 0 && l < col && grid[k][l] == 0 && !visited[k][l]) {
            visited[k][l] = true;
            distances[k][l] += distance;
            reach[k][l]++;
            queue.add(new int[] {k, l});
          }
        }
      }

    }
  }
}
