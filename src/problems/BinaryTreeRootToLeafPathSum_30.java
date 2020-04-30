package problems;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRootToLeafPathSum_30 {

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<Integer> pathNodes = new ArrayList<>();
    List<List<Integer>> pathsList = new ArrayList<>();
    recurseTree(root, pathNodes, sum, pathsList);
    return pathsList;
  }

  private void recurseTree(TreeNode root, List<Integer> pathNodes, int remainingSum,List<List<Integer>> pathsList ) {
    if(root == null) {
      return;
    }

    pathNodes.add(root.val);

    if(remainingSum == root.val &&  root.left == null && root.right == null) {
      pathsList.add(new ArrayList<Integer>(pathNodes));
    } else {
      recurseTree(root.left, pathNodes,remainingSum - root.val, pathsList);
      recurseTree(root.right, pathNodes,remainingSum - root.val, pathsList);
    }

    pathNodes.remove(pathNodes.size() - 1);
  }
}
