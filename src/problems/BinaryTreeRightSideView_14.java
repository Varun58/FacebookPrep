package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.youtube.com/watch?v=jCqIr_tBLKs&list=PLi9RQVmJD2fbrumv-n6l0Vd5g_oU0jLkJ
public class BinaryTreeRightSideView_14 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> visibleValues = new ArrayList<>();

    if (root == null) {
      return visibleValues;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.remove();
        if (i == size - 1) {
          visibleValues.add(current.val);
        }

        if (current.left != null) {
          queue.add(current.left);
        }

        if (current.right != null) {
          queue.add(current.right);
        }
      }
    }

    return visibleValues;
  }
}
