package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class BinaryTreeVerticalTraversalOrder_19 {

  public List<List<Integer>> verticalOrder(TreeNode root) {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    int horizontalDistance = 0;
    getVerticalOrder(root, horizontalDistance, map);
    return new ArrayList<>(map.values());
  }

  private void getVerticalOrder(TreeNode root, int horizontalDistance, TreeMap<Integer, List<Integer>> map) {
    if (root == null) {
      return;
    }

    List<Integer> hdList = map.get(horizontalDistance);

    if(hdList == null) {
      hdList = new ArrayList<>();
      hdList.add(root.val);
    } else {
      hdList.add(root.val);
    }

    map.put(horizontalDistance, hdList);

    getVerticalOrder(root.left, horizontalDistance - 1, map);
    getVerticalOrder(root.left, horizontalDistance + 1, map);
  }
}
