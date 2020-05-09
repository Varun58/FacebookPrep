package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST_73 {


  // T-> O(N)
  // S-> O(N)
  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      serialize(root, sb);
      return sb.toString();
    }

    public void serialize(TreeNode node, StringBuilder sb) {
      if(node == null) {
        return;
      }

      sb.append(node.val).append(",");
      serialize(node.left, sb);
      serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if(data.isEmpty()) {
        return null;
      }
      Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(",")));
      return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode deserialize(Queue<String> q, int lower, int higher) {
      if(q.isEmpty()) {
        return null;
      }
      String s = q.peek();
      int val = Integer.parseInt(s);
      if(val < lower || val > higher) {
        return null;
      }
      q.poll();
      TreeNode root = new TreeNode(val);
      root.left = deserialize(q, lower, val);
      root.right = deserialize(q, val, higher);
      return root;
    }
  }
}
