package problems;

public class FlattenBinaryTreeToLinkedList_60
{
  public TreeNode flattenTree(TreeNode root) {
    if(root == null) {
      return null;
    }

    if(root.left == null && root.right == null) {
      return root;
    }

    TreeNode leftTail = flattenTree(root.left);
    TreeNode rightTail = flattenTree(root.right);

    if(leftTail != null) {
      leftTail.right = root.right;
      root.right = root.left;
      root.left = null;
    }

    return rightTail == null ? leftTail : rightTail;
  }

  public void flattenTreeIterative(TreeNode root) {
    if(root == null) {
      return ;
    }

    TreeNode node = root;
    while(node != null) {
      if(node.left != null) {

        TreeNode rightmost = node.left;
        while(rightmost.right != null) {
          rightmost = rightmost.right;
        }

        rightmost.right = node.right;
        node.right = node.left;
        node.left = null;
      }

      node= node.right;
    }
  }
}
