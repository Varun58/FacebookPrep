package problems;

public class ConvertBinarySearchTreeToDoublyLinkedList_40 {

  private TreeNode first;
  private TreeNode last;

  public TreeNode treeToDoublyList(TreeNode root) {
    if(root == null) {
      return null;
    }

    helper(root);

    last.right = first;
    first.left = last;
    return first;
  }

  private void helper(TreeNode node) {
    if(node!= null) {
      helper(node.left);
      if(last != null) {
        last.right = node;
        node.left = last;
      } else {
        first = node;
      }

      last = node;

      helper(node.right);
    }
  }
}
