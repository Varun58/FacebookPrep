package problems;

public class BinaryTreeMaximumPathSum_29 {

  int maxPathSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxPathSum;
  }

  private int maxGain(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftGain = Math.max(maxGain(root.left), 0);
    int rightGain = Math.max(maxGain(root.right), 0);

    maxPathSum = Math.max(maxPathSum, leftGain + rightGain + root.val);

    return Math.max(leftGain, rightGain) + root.val;
  }
}
