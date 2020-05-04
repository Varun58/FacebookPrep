package problems;

import java.util.Stack;

public class BSTIterator_63 {

  class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
      this.stack = new Stack<>();
      this.leftmostInorder(root);
    }

    private void leftmostInorder(TreeNode root) {
      while(root != null) {
        this.stack.push(root);
        root = root.left;
      }
    }

    /** @return the next smallest number */
    public int next() {
      TreeNode top = stack.pop();

      if(top.right != null) {
        this.leftmostInorder(top.right);
      }
      return top.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return this.stack.size() > 0;
    }
  }
}
