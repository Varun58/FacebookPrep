package problems;


public class ValidateBinarySearchTree_6 {
  public static void main(String[] args) {

  }

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  public boolean helper(TreeNode node, Integer lower, Integer uppper) {
    if (node == null) {
      return true;
    }

    int val = node.val;

    if (lower != null && val <= lower) {
      return false;
    }
    if (uppper != null && val >= uppper) {
      return false;
    }

    if (!helper(node.right, val, uppper)) {
      return false;
    }

    if (!helper(node.left, lower, val)) {
      return false;
    }

    return true;
  }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}