package problems;

import java.util.Arrays;
import java.util.Stack;

public class IsGraphBipartite_3 {

  public static void main(String[] args) {
    int[][] graph = new int[][] {
        {1, 3},
        {0, 2},
        {1, 3},
        {0, 2}
    };

    System.out.println(isBipartite(graph));
  }

  public static boolean isBipartite(int[][] graph) {

    if(graph == null || graph.length == 0) {
      return true;
    }

    int n = graph.length;
    int[] color = new int[n];
    Arrays.fill(color, -1);

    for(int start = 0; start < n; start++) {
      if(color[start] == -1) {
        Stack<Integer> stack = new Stack();
        stack.push(start);
        color[start] = 1;


        while(!stack.isEmpty()) {
          Integer node = stack.pop();

          for(int neighbor : graph[node]) {
            if(color[neighbor] == -1) {
              stack.push(neighbor);
              color[neighbor] = color[node] ^ 1;
            }
            else if(color[neighbor] == color[node]) {
              return false;
            }
          }
        }
      }
    }

    return true;
  }
}
