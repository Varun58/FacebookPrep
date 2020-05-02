package problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LowestCommonAncestorOfBT_49 {

  public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    } else {
      if (root.val == p.val || root.val == q.val) {
        return root;
      }

      TreeNode leftLCA = lca(root.left, p, q);
      TreeNode rightLCA = lca(root.right, p, q);

      if (leftLCA != null && rightLCA != null) {
        return root;
      }

      if (leftLCA != null) {
        return leftLCA;
      } else return rightLCA;
    }
  }

  // Iterative
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    stack.push(root);
    parents.put(root, null);

    while(!parents.containsKey(p) || !parents.containsKey(q)) {
      TreeNode node = stack.pop();

      if(node.left != null) {
        parents.put(node.left, node);
        stack.push(node.left);
      }

      if(node.right != null) {
        parents.put(node.right, node);
        stack.push(node.right);
      }
    }

    Set<TreeNode> ancestors = new HashSet<TreeNode>();

    while(p!= null) {
      ancestors.add(p);
      p = parents.get(p);
    }

    while(!ancestors.contains(q)) {
      q = parents.get(q);
    }
    return q;
  }
}
